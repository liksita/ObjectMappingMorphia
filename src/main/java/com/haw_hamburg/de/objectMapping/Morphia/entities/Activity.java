package com.haw_hamburg.de.objectMapping.Morphia.entities;

import java.util.Date;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

public abstract class Activity {

	@Id
	protected ObjectId id;

	Date date;
	
	@Reference
	User author;

	// constructors, getters and setters...
	
	Activity() {
	}

	public Activity(Date date) {
		this.date = date;
	}

	public abstract ObjectId getId();

	public abstract void setId(ObjectId id);

	public abstract Date getDate();

	public abstract void setDate(Date date);

	public abstract User getAuthor();

	public abstract void setAuthor(User author);


}
