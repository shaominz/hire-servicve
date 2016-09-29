package com.shaominz.interview.model;

import java.util.Date;

public class HireRecord {
	
	public enum HireState {HIRE_OUT, RETURNED}
	
	private int id;
	
	private int hireItemId;
	private int clientId;
	
	private Date startDate;
	private Date endDate;
	private double rate;

	public HireRecord(int id, int hireItemId, int clientId,  Date startDate, Date endDate, double rate) {
		this.id = id;
		this.hireItemId = hireItemId;
		this.clientId = clientId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rate = rate;
	}
	
	public int getHireItemId() {
		return hireItemId;
	}

	public int getClientId() {
		return clientId;
	}

	public Date getStartDate() {
		return new Date(startDate.getTime());
	}

	public Date getEndDate() {
		return new Date(endDate.getTime());
	}

	public void setEndDate(Date endDate) {
		this.endDate = new Date(endDate.getTime());
	}

	public HireState getState() {
		return (endDate == null) ? HireState.HIRE_OUT : HireState.RETURNED;
	}

	public int getId() {
		return id;
	}

	public double getRate() {
		return rate;
	}

}
