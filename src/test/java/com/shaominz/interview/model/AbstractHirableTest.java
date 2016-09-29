package com.shaominz.interview.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class AbstractHirableTest {

	private AbstractHirable baseHirable;
	
	@Test(expected=IllegalArgumentException.class)
	public void testZeroId() {
		baseHirable = new TestHirable(0, "make", "registerNumber", 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNegativeId() {
		baseHirable = new TestHirable(-1, "make", "registerNumber", 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNegativeCategory() {
		baseHirable = new TestHirable(1, "make", "registerNumber", -1);
	}
	
	@Test
	public void testZeroCategoty() {
		baseHirable = new TestHirable(1, "make", "registerNumber", 0);
	}
	
	@Test
	public void test() {
		baseHirable = new TestHirable(1, "make", "registerNumber", 1);
		assertEquals(1, baseHirable.getId());
		assertEquals("make", baseHirable.getMake());
		assertEquals("registerNumber", baseHirable.getRegisterNumber());
		assertEquals(1, baseHirable.getCategory());
	}

	@Test
	public void testToString() {
		baseHirable = new TestHirable(1, "make", "registerNumber", 1);
		assertEquals("BaseHirable [id=1, make=make, registerNumber=registerNumber, category=1]", baseHirable.toString());
	}

	static class TestHirable extends AbstractHirable {

		public TestHirable(int id, String make, String registerNumber, int category) {
			super(id, make, registerNumber, category);
		}

		public double getDiscountRate(double rate) {
			return 0;
		}
		
	}
}
