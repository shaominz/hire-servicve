package com.shaominz.interview.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class IdGeneratorTest {

	private IdGenerator generator = IdGenerator.hireIdGenerator;
	
	@Test
	public void test() {
		assertEquals(1, generator.getNextId());
		assertEquals(2, generator.getNextId());
	}

}
