package com.shaominz.interview.model;

public class Client {

	private final int id;
	private final String name;
	private final String licenseNumber;
	
	public Client(final int id, final String name) {
		this.id = id;
		this.name = name;
		this.licenseNumber = "";
	}

	public Client(final int id, final String name, final String licenseNumber) {
		this.id = id;
		this.name = name;
		this.licenseNumber = licenseNumber;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((licenseNumber == null) ? 0 : licenseNumber.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Client other = (Client) obj;
		if (licenseNumber == null) {
			if (other.licenseNumber != null)
				return false;
		} else if (!licenseNumber.equals(other.licenseNumber))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", licenseNumber="
				+ licenseNumber + "]";
	}
	
}
