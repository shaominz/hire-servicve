package com.shaominz.interview.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.shaominz.interview.db_service.DbService;
import com.shaominz.interview.model.Car;

public class GenericDaoTest {

	private GenericDao<Car> carDao = new GenericDao<Car>(null, "", Car.class) {

		@Override
		public String getRecordByIdSql(int id) {
			return "abcd";
		}
		
	};
	
	private Date now = new Date();
	private String connectionDetails = "connectionDetails";
	private Car car = new Car(100, "Ford", "AB16CDE", 1, now);
	
	private DbService mockDbService;

	@Before
	public void setUp() {
		mockDbService = Mockito.mock(DbService.class);
		carDao.setDbService(mockDbService);
		carDao.setConnectionDetails(connectionDetails);
	}
	
	@Test
	public void testGetRecordByIdSql() {
		assertEquals("abcd", carDao.getRecordByIdSql(100));
	}
	
	@Test
	public void testGetById() throws SQLException {
		when(mockDbService.loadFromDb(connectionDetails, carDao.getRecordByIdSql(100), Car.class)).thenReturn(car);
		Car carFromDb = carDao.getById(100);

		assertEquals(carFromDb, car);
		verify(mockDbService, times(1)).loadFromDb(connectionDetails, carDao.getRecordByIdSql(100), Car.class);
	}
	
	@Test
	public void testSave() throws SQLException {
		carDao.save(car);

		verify(mockDbService, times(1)).saveToDatabase(car, connectionDetails);
	}
}
