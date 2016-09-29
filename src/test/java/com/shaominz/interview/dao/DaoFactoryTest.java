package com.shaominz.interview.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.shaominz.interview.model.IHirable.HirableType;

public class DaoFactoryTest {

	@Test
	public void test() {
		assertTrue(DaoFactory.getInstance().getDao(HirableType.BIKE) instanceof BikeDao);
		assertTrue(DaoFactory.getInstance().getDao(HirableType.CAR) instanceof CarDao);
		assertTrue(DaoFactory.getInstance().getHireRecordDao(HirableType.BIKE) instanceof BikeHireRecordDao);
		assertTrue(DaoFactory.getInstance().getHireRecordDao(HirableType.CAR) instanceof CarHireRecordDao);
	}

}
