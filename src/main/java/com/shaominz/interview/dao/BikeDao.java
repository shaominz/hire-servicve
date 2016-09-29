package com.shaominz.interview.dao;

import com.shaominz.interview.db_service.DbService;
import com.shaominz.interview.model.Bike;

public class BikeDao extends GenericDao<Bike>{

	private static final String QUERY_BIKE_BY_ID_SQL = "select * from bike where id = %d";
	
	public BikeDao(DbService dbService, String connectionDetails) {
		super(dbService, connectionDetails, Bike.class);
	}

	@Override
	public String getRecordByIdSql(int id) {
		return String.format(QUERY_BIKE_BY_ID_SQL, id);
	}

}
