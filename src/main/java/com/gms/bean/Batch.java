package com.gms.bean;

public class Batch {

	private int batchid;
	private String timing;
	private String instructor;
	
	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Batch(int batchid, String timing, String instructor) {
		super();
		this.batchid = batchid;
		this.timing = timing;
	}

	public int getBatchid() {
		return batchid;
	}

	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	
}
