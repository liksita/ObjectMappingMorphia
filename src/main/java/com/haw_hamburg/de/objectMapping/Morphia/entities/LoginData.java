package com.haw_hamburg.de.objectMapping.Morphia.entities;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class LoginData {

	private ObjectId id;

	private String username;
	private String password;

	private User user;

	// constructors, getters and setters...

	LoginData() {
	}

	public LoginData(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
