package com.haw_hamburg.de.objectMapping.Morphia.entities;

import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity(noClassnameStored = true)
public class User {

	@Id
	private ObjectId id;

	private String firstName;
	private String lastName;

	@Embedded
	private LoginData loginData;

	@Reference (lazy = false)
	private Set<Post> userPosts = new HashSet<>();

	@Reference (lazy = false)
	private Set<Comment> userComments = new HashSet<>();

	@Reference (lazy = false)
	private Set<Discussion> discussions = new HashSet<>();

	// constructors, getters and setters...

	User() {
	}

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Post> getUserPosts() {
		return userPosts;
	}

	public void setUserPosts(Set<Post> userPosts) {
		this.userPosts = userPosts;
	}

	public Set<com.haw_hamburg.de.objectMapping.Morphia.entities.Comment> getUserComments() {
		return userComments;
	}

	public void setUserComments(Set<com.haw_hamburg.de.objectMapping.Morphia.entities.Comment> userComments) {
		this.userComments = userComments;
	}

	public LoginData getLoginData() {
		return loginData;
	}

	public void setLoginData(LoginData loginData) {
		this.loginData = loginData;
	}

	public Set<Discussion> getDiscussions() {
		return discussions;
	}

	public void setDiscussions(Set<Discussion> discussions) {
		this.discussions = discussions;
	}

}
