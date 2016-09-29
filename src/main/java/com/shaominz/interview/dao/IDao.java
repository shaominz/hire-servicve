package com.shaominz.interview.dao;

import java.sql.SQLException;

public interface IDao<T> {
	T getById(int id) throws SQLException;
	void save(T record) throws SQLException;
}
