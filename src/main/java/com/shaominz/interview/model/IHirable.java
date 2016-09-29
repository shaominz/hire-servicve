package com.shaominz.interview.model;

public interface IHirable {
	
	public enum HirableType {CAR, BIKE}
	
	double getDiscountRate(double rate);
}
