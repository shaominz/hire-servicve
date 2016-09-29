package com.shaominz.interview.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

public class BikeTest {

	private Bike bike;
	
	@Test
	public void test() {
		bike = new Bike(1, "make", "registerNumber", 1, 100);
		assertEquals(1, bike.getId());
		assertEquals("make", bike.getMake());
		assertEquals("registerNumber", bike.getRegisterNumber());
		assertEquals(1, bike.getCategory());
		assertEquals(100, bike.getCc());
	}

	@Test
	public void testGetDiscountRateNoDiscount() {
		bike = new Bike(1, "make", "registerNumber", 1, 100);
		assertTrue(1.0 == bike.getDiscountRate(1.0));
	}
	
	@Test
	public void testEquals() {
		bike = new Bike(1, "make", "registerNumber", 1, 100);
		Bike bike2 = new Bike(1, "make", "registerNumber", 1, 100);
		Bike bike3 = new Bike(1, "make", "registerNumber", 1, 100);
		
		// reflective
		assertEquals(bike, bike);

		// symmetric
		assertEquals(bike, bike2);
		assertEquals(bike2, bike);

		//transitive
		assertEquals(bike2, bike3);
		assertEquals(bike, bike3);
		
		//hash code
		assertEquals(bike.hashCode(), bike2.hashCode());
		assertEquals(bike2.hashCode(), bike3.hashCode());
		assertEquals(bike.hashCode(), bike3.hashCode());
	}
}
