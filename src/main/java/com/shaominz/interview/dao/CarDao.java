package com.shaominz.interview.dao;

import com.shaominz.interview.db_service.DbService;
import com.shaominz.interview.model.Car;

public class CarDao extends GenericDao<Car>{

	private static final String QUERY_CAR_BY_ID_SQL = "select * from car where id = %d";
	
	public CarDao(DbService dbService, String connectionDetails) {
		super(dbService, connectionDetails, Car.class);
	}

	@Override
	public String getRecordByIdSql(int id) {
		return String.format(QUERY_CAR_BY_ID_SQL, id);
	}

}
