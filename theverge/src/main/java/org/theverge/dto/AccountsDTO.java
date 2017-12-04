package org.theverge.dto;

public class AccountsDTO {
	String id;
	String password;
	long randkey;

	public long getRandkey() {
		return randkey;
	}

	public void setRandkey(long randkey) {
		this.randkey = randkey;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
