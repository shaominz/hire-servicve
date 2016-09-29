package com.shaominz.interview.model;

/*
 * Andyr request want to hire bikes too 
 */
public class Bike extends AbstractHirable {
	
	private final int cc;

	public Bike(final int id, final String make, final String reg, final int category, final int cc) {
		super(id, make, reg, category);
		this.cc = cc;
	}

	
	/*** IHirable interface ***/
	public double getDiscountRate(double rate) {
		// there is no discount for bikes
		return rate;
	}


	public int getCc() {
		return cc;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + cc;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bike other = (Bike) obj;
		if (!super.equals(other))
			return false;
		if (cc != other.cc)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bike [" + super.toString() + ", cc=" + cc + "]";
	}

	
}
