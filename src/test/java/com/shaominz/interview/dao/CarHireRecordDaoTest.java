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
import com.shaominz.interview.model.HireRecord;

public class CarHireRecordDaoTest {

	private CarHireRecordDao carHireRecordDao = new CarHireRecordDao(null, "");
	
	private String connectionDetails = "connectionDetails";
	private Date now = new Date();
	private HireRecord hireRecord = new HireRecord(100, 200, 10,  now, null, 1.0);
	
	private DbService mockDbService;

	@Before
	public void setUp() {
		mockDbService = Mockito.mock(DbService.class);
		carHireRecordDao.setDbService(mockDbService);
		carHireRecordDao.setConnectionDetails(connectionDetails);
	}
	
	@Test
	public void testGetRecordByIdSql() {
		assertEquals("select * from car_hire where id = 100", carHireRecordDao.getRecordByIdSql(100));
	}

	@Test
	public void testGetLatestRecordByCarId() throws SQLException {
		when(mockDbService.loadFromDb(Mockito.anyString(), Mockito.anyString(), Mockito.any(Class.class))).thenReturn(hireRecord);
		HireRecord recordFromDb = carHireRecordDao.getLatestRecordByCarId(100);

		assertEquals(recordFromDb, hireRecord);
		verify(mockDbService, times(1)).loadFromDb(Mockito.anyString(), Mockito.anyString(), Mockito.any(Class.class));
	}

}
