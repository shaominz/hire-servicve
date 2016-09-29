package com.shaominz.interview.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CarDaoTest {

	private CarDao carDao = new CarDao(null, "");

	@Test
	public void testGetRecordByIdSql() {
		assertEquals("select * from car where id = 100", carDao.getRecordByIdSql(100));
	}
	
}
