package com.shaominz.interview.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
	
	public static final IdGenerator carIdGenerator = new IdGenerator();
	public static final IdGenerator bikeIdGenerator = new IdGenerator();
	public static final IdGenerator hireIdGenerator = new IdGenerator();
	
	
	private final AtomicInteger id = new AtomicInteger(0);
	
	private IdGenerator() {
	}
	
	public int getNextId() {
		return id.incrementAndGet();
	}
}
