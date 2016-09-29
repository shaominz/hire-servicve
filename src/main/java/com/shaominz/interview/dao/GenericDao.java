package com.shaominz.interview.dao;

import java.sql.SQLException;

import com.shaominz.interview.db_service.DbService;

public abstract class GenericDao<T> implements IDao<T> {

	protected DbService dbService;
	protected String connectionDetails;
	protected Class<?> clazz;
	
	public abstract String getRecordByIdSql(int id);
	
	public GenericDao(DbService dbService, String connectionDetails, Class<?> clazz) {
		this.dbService = dbService;
		this.connectionDetails = connectionDetails;
		this.clazz = clazz;
	}
	
	/* IDao interface start */
	@SuppressWarnings("unchecked")
	public T getById(int id) throws SQLException {
		return (T)dbService.loadFromDb(connectionDetails, getRecordByIdSql(id), clazz);
	}

	public void save(T record) throws SQLException {
		dbService.saveToDatabase(record, connectionDetails);
	}
	/* IDao interface end*/

	public DbService getDbService() {
		return dbService;
	}

	public void setDbService(DbService dbService) {
		this.dbService = dbService;
	}
	
	public String getConnectionDetails() {
		return connectionDetails;
	}
	
	public void setConnectionDetails(String connectionDetails) {
		this.connectionDetails = connectionDetails;
	}
	
	public Class<?> getType() {
		return clazz;
	}
}
