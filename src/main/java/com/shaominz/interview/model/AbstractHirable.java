package com.shaominz.interview.model;


public abstract class AbstractHirable implements IHirable {
	
	private final int id;
	private final String make;
	private final String registerNumber;
	private int category;

	public AbstractHirable(final int id, final String make, final String registerNumber, final int category) {
		if (id <= 0) throw new IllegalArgumentException(String.format("id must be positive: %d", id));
		if (category < 0) throw new IllegalArgumentException(String.format("category can't be negative: %d", id));
		
		this.id = id;
		this.make = make;
		this.registerNumber = registerNumber;
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + category;
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((registerNumber == null) ? 0 : registerNumber.hashCode());
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
		AbstractHirable other = (AbstractHirable) obj;
		if (category != other.category)
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (registerNumber == null) {
			if (other.registerNumber != null)
				return false;
		} else if (!registerNumber.equals(other.registerNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BaseHirable [id=" + id + ", make=" + make + ", registerNumber=" + registerNumber
				+ ", category=" + category + "]";
	}

	public int getId() {
		return id;
	}

	public String getMake() {
		return make;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public int getCategory() {
		return category;
	}

}
