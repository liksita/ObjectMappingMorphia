package com.haw_hamburg.de.objectMapping.Morphia.app;

import java.util.List;

import org.mongodb.morphia.query.Query;

import com.haw_hamburg.de.objectMapping.Morphia.entities.Comment;
import com.haw_hamburg.de.objectMapping.Morphia.entities.Discussion;
import com.haw_hamburg.de.objectMapping.Morphia.entities.Post;
import com.haw_hamburg.de.objectMapping.Morphia.entities.User;

import org.mongodb.morphia.Datastore;
//import org.mongodb.morphia.dao.BasicDAO;


public class ReadActivity {

	private List<User> users;
	private List<Post> posts;
	private List<Comment> comments;
	private List<Discussion> discussions;

	// private BasicDAO<User, Datastore> daoUser;
	// private BasicDAO<Discussion, Datastore> daoDiscussion;
	private FrameworkTest frTest;

	public ReadActivity(FrameworkTest frTest) {
		this.setFrTest(frTest);
		// this.daoUser = new BasicDAO<>(User.class, frTest.getDatastore());
		// this.daoDiscussion = new BasicDAO<>(Discussion.class, frTest.getDatastore());
	}

	public void readEntities() {
		Datastore datastore = frTest.getDatastore();
		Query<User> queryUsers = datastore.createQuery(com.haw_hamburg.de.objectMapping.Morphia.entities.User.class);
		users = queryUsers.asList();
		Query<Post> queryPosts = datastore.createQuery(com.haw_hamburg.de.objectMapping.Morphia.entities.Post.class);
		posts = queryPosts.asList();
		Query<Comment> queryComments = datastore.createQuery(com.haw_hamburg.de.objectMapping.Morphia.entities.Comment.class);
		comments = queryComments.asList();
		Query<Discussion> queryDiscussions = datastore.createQuery(com.haw_hamburg.de.objectMapping.Morphia.entities.Discussion.class);
		discussions = queryDiscussions.asList();
	}

	// public static void main(String[] args) {
	// readActivity.readEntities();
	// System.out.println("User count: " + readActivity.getUsers().size());
	// System.out.println("Post count: " + readActivity.getPosts().size());
	// System.out.println("Comment count: " + readActivity.getComments().size());
	// System.out.println("Discussion count: " +
	// readActivity.getDiscussions().size());
	// }

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Discussion> getDiscussions() {
		return discussions;
	}

	public void setDiscussions(List<Discussion> discussions) {
		this.discussions = discussions;
	}

	public FrameworkTest getFrTest() {
		return frTest;
	}

	public void setFrTest(FrameworkTest frTest) {
		this.frTest = frTest;
	}

}
