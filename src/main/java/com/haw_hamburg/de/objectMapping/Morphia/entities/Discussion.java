package com.haw_hamburg.de.objectMapping.Morphia.entities;

import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity(noClassnameStored = true)
public class Discussion {

	@Id
	private ObjectId id;

	private String topic;

	@Reference
	private Set<User> users = new HashSet<>();

	public Discussion(String topic) {
		this.topic = topic;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
