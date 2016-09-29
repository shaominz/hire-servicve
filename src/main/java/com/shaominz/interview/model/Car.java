package com.shaominz.interview.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;


public class Car extends AbstractHirable {
	
	private static final int DISCOUNT_AGE = 3;
	private static final double DISCOUNT_RATE = 0.9;
	
	private final long factoryDate;

	public Car(final int id, final String make, final String reg, final int category, final Date factoryDate) {
		super(id, make, reg, category);
		this.factoryDate = factoryDate.getTime();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + super.hashCode();
		result = prime * result + (int) (factoryDate ^ (factoryDate >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (!super.equals(other))
			return false;
		if (factoryDate != other.factoryDate)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [" + super.toString() + ", factoryDate=" + factoryDate
				+ "]";
	}

	public long getFactoryDate() {
		return factoryDate;
	}

	/* for test purpose, if we unable to pass the endDate, it will use the default value, now(), making the test
	    code break the next year. */
	int getAge(Date endDate) {
		Date startDate = new Date(this.getFactoryDate());
		LocalDate fromDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		long year = ChronoUnit.YEARS.between(fromDate, endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

		return (int)year;
	}
	
	private int getAge() {
		return getAge(new Date());
	}
	
	/*** IHirable interface ***/
	public double getDiscountRate(double rate) {
		return getAge() > DISCOUNT_AGE ? rate * DISCOUNT_RATE : rate;  //discount for older cars
	}

}
