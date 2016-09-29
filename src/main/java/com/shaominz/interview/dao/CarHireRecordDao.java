package com.shaominz.interview.dao;

import java.sql.SQLException;

import com.shaominz.interview.db_service.DbService;
import com.shaominz.interview.model.HireRecord;

public class CarHireRecordDao extends GenericDao<HireRecord> implements IHireRecordDao<HireRecord> {

	private static final String QUERY_CAR_HIRE_BY_HIRE_ID_SQL = "select * from car_hire where id = %d";
	private static final String QUERY_CAR_HIRE_BY_CAR_ID_SQL = "select top 1 * from car_hire where car_id = %d order by start_date desc";
	
	public CarHireRecordDao(DbService dbService, String connectionDetails) {
		super(dbService, connectionDetails, HireRecord.class);
	}
	
	public HireRecord getLatestRecordByCarId(int carId) throws SQLException {
		return (HireRecord)this.dbService.loadFromDb(connectionDetails, 
				String.format(QUERY_CAR_HIRE_BY_CAR_ID_SQL, carId), clazz);
	}
	
	@Override
	public String getRecordByIdSql(int id) {
		return String.format(QUERY_CAR_HIRE_BY_HIRE_ID_SQL, id);
	}

}
