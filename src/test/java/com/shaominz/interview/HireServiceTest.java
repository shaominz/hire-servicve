package com.shaominz.interview;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import com.shaominz.interview.model.IHirable.HirableType;

public class HireServiceTest {
	
	private HireService hireService = new HireService();
	private Date now = new Date();
	
	@Test(expected=IllegalArgumentException.class)
	public void testHireItemIdNegative() {
		hireService.hire(HirableType.CAR, -1, 1, now, 5, 0.9);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testHireItemId0() {
		hireService.hire(HirableType.CAR, 0, 1, now, 5, 0.9);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testHireClientIdNegative() {
		hireService.hire(HirableType.CAR, 1, -1, now, 5, 0.9);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testHireClientId0() {
		hireService.hire(HirableType.CAR, 1, 0, now, 5, 0.9);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testHireRateNegative() {
		hireService.hire(HirableType.CAR, 1, -1, now, 5, -0.9);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testHireRate0() {
		hireService.hire(HirableType.CAR, 1, 0, now, 5, 0.0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testHireStartDateNulls() {
		hireService.hire(HirableType.CAR, 1, 0, null, 5, 1.0);
	}

	//hireItem(HirableType type, int itemId, int clientId, Date startDate, int days, double rate) throws SQLException
	@Test
	public void testhireItem() throws SQLException {
		assertEquals(1, hireService.hireItem(HirableType.CAR, 1, 1, now, 5, 1.0));
	}
}
