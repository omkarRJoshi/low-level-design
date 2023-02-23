package com.models;

public class User {
	public static int totalUser;
	private int id;
	private String name;
	
	public User(String  name) {
		this.id = totalUser++;
		this.setName(name);
	}
	
	public int getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
