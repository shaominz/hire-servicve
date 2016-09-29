package com.shaominz.interview.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BikeDaoTest {

	private BikeDao bikeDao = new BikeDao(null, "");

	@Test
	public void testGetRecordByIdSql() {
		assertEquals("select * from bike where id = 100", bikeDao.getRecordByIdSql(100));
	}
	
}
