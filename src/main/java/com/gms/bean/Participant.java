package com.gms.bean;

public class Participant {
	private int id;
	private String name;
	private String email;
	private int mobile;
	private int batchid;
	
	public Participant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Participant(int id, String name, String email, int mobile, int batchid) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.batchid = batchid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public int getBatchid() {
		return batchid;
	}

	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}
	
}
