package com.shaominz.interview.dao;

import java.sql.SQLException;

import com.shaominz.interview.model.HireRecord;

public interface IHireRecordDao<T> extends IDao<T> {
	HireRecord getLatestRecordByCarId(int itemId) throws SQLException;
}
