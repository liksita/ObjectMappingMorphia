package com.haw_hamburg.de.objectMapping.Morphia.app;

import java.util.Date;

import org.mongodb.morphia.Datastore;
//import org.mongodb.morphia.dao.BasicDAO;

import com.haw_hamburg.de.objectMapping.Morphia.entities.Comment;
import com.haw_hamburg.de.objectMapping.Morphia.entities.Discussion;
import com.haw_hamburg.de.objectMapping.Morphia.entities.LoginData;
import com.haw_hamburg.de.objectMapping.Morphia.entities.Post;
import com.haw_hamburg.de.objectMapping.Morphia.entities.User;

public class StoreActivity {

	// Testkonfig
	public Integer inserts = 1000;

	private static int runCount = 0;
//	private BasicDAO<User, Datastore> daoUser;
//	private BasicDAO<Discussion, Datastore> daoDiscussion;
	private FrameworkTest frTest;

	public StoreActivity(Integer inserts, FrameworkTest frTest) {
		this.inserts = inserts;
		this.setFrTest(frTest);
//		this.daoUser = new BasicDAO<>(User.class, frTest.getDatastore());
//		this.daoDiscussion = new BasicDAO<>(Discussion.class, frTest.getDatastore());

	}

	public void persistEntitiesDataNucleus() {
		Datastore datastore = frTest.getDatastore();

		runCount++;

		for (int j = 0; j < this.inserts; j++) {

			// create a User
			User user1 = new User("user1", "user1" + runCount + j);
			User user2 = new User("user2", "user2" + runCount + j);

			LoginData loginData1 = new LoginData("user1", "password1");
			LoginData loginData2 = new LoginData("user2", "password2");

			user1.setLoginData(loginData1);
			user2.setLoginData(loginData2);

			Discussion discussion1 = new Discussion("discussion1" + runCount + j);
			datastore.save(discussion1);
			Discussion discussion2 = new Discussion("discussion2" + runCount + j);
			datastore.save(discussion2);

			discussion1.getUsers().add(user1);
			discussion1.getUsers().add(user2);
			user1.getDiscussions().add(discussion1);
			user1.getDiscussions().add(discussion2);

			discussion2.getUsers().add(user1);
			discussion2.getUsers().add(user2);
			user2.getDiscussions().add(discussion2);
			user2.getDiscussions().add(discussion1);

			// and three posts
			Post post1 = new Post("Title1 " + runCount + j, new Date());
			datastore.save(post1);
			Post post2 = new Post("Title2 " + runCount + j, new Date());
			datastore.save(post2);
			Post post3 = new Post("Title3 " + runCount + j, new Date());
			datastore.save(post3);

			// and two Comments
			Comment comment1 = new Comment(new Date());
			datastore.save(comment1);
			Comment comment2 = new Comment(new Date());
			datastore.save(comment2);

			// let Bob post two posts
			post1.setAuthor(user1);
			user1.getUserPosts().add(post1);

			comment1.setAuthor(user1);
			user1.getUserComments().add(comment1);

			comment2.setAuthor(user1);
			user1.getUserComments().add(comment2);

			comment1.setPost(post1);
			post1.getUserComments().add(comment1);

			comment2.setPost(post2);
			post2.getUserComments().add(comment2);

			post2.setAuthor(user1);
			user1.getUserPosts().add(post2);

			post3.setAuthor(user2);
			user2.getUserPosts().add(post3);

			datastore.save(user1);
			datastore.save(user2);
			datastore.save(discussion1);
			datastore.save(discussion2);
			datastore.save(post1);
			datastore.save(post2);
			datastore.save(post3);
			datastore.save(comment1);
			datastore.save(comment2);

		}

	}

	public Integer getInserts() {
		return inserts;
	}

	public void setInserts(Integer inserts) {
		this.inserts = inserts;
	}

	public FrameworkTest getFrTest() {
		return frTest;
	}

	public void setFrTest(FrameworkTest frTest) {
		this.frTest = frTest;
	}

}
