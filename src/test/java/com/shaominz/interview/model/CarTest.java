package com.shaominz.interview.model;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class CarTest {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private Car car;
	
	@Test
	public void test() {
		Date now = new Date();
		car = new Car(1, "make", "registerNumber", 1, now);
		assertEquals(1, car.getId());
		assertEquals("make", car.getMake());
		assertEquals("registerNumber", car.getRegisterNumber());
		assertEquals(1, car.getCategory());
		assertEquals(1, car.getCategory());
		assertEquals(now.getTime(), car.getFactoryDate());
	}

	@Test
	public void testGetAge() {
		Date now = new Date();
		car = new Car(1, "make", "registerNumber", 1, now);
		assertEquals(0, car.getAge(now));
	}

	@Test
	public void testGetAge1() throws ParseException {
		Date startDate = sdf.parse("2011-01-01 12:00:00");
		car = new Car(1, "make", "registerNumber", 1, startDate);
		assertEquals(5, car.getAge(sdf.parse("2016-01-01 12:00:00")));
	}
	
	@Test
	public void testGetDiscountRateNoDiscount() {
		Date now = new Date();
		car = new Car(1, "make", "registerNumber", 1, now);
		assertTrue(1.0 == car.getDiscountRate(1.0));
	}
	
	@Test
	public void testGetDiscountRate() throws ParseException {
		Date startDate = sdf.parse("2011-01-01 12:00:00");
		car = new Car(1, "make", "registerNumber", 1, startDate);
		assertTrue(0.9 == car.getDiscountRate(1.0));
	}
	
	@Test
	public void testEquals() {
		Date now = new Date();
		car = new Car(1, "make", "registerNumber", 1, now);
		Car car2 = new Car(1, "make", "registerNumber", 1, now);
		Car car3 = new Car(1, "make", "registerNumber", 1, now);
		
		// reflective
		assertEquals(car, car);

		// symmetric
		assertEquals(car, car2);
		assertEquals(car2, car);

		//transitive
		assertEquals(car2, car3);
		assertEquals(car, car3);
		
		//hash code
		assertEquals(car.hashCode(), car2.hashCode());
		assertEquals(car2.hashCode(), car3.hashCode());
		assertEquals(car.hashCode(), car3.hashCode());
	}
}
