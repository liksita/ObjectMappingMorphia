package com.haw_hamburg.de.objectMapping.Morphia.app;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.haw_hamburg.de.objectMapping.Morphia.utils.Result;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ReadPreference;

public class FrameworkTest {

	// Testkonfig
	private Integer inserts = 100000;
	private Integer runs = 5;

	private MongoHibernate mh;
	private String databaseName;
	private Morphia morphia;
	private Datastore datastore;
	private Result result;
	private DB db;
	private MongoClient mongoClient;

	public FrameworkTest() {

	}

	public FrameworkTest(Integer inserts, Integer runs) {
		this.inserts = inserts;
		this.runs = runs;
		morphia = new Morphia();
		this.mongoClient = new MongoClient("127.0.0.1:27017");
		// Set Read Preference
		this.mongoClient.setReadPreference(ReadPreference.secondary());
		this.databaseName = "UserPostsMorphia";
//		morphia.mapPackage("com.haw_hamburg.de.objectMapping.Morphia.entities.User");
//		morphia.mapPackage("com.haw_hamburg.de.objectMapping.Morphia.entities.Post");
//		morphia.mapPackage("com.haw_hamburg.de.objectMapping.Morphia.entities.Comment");
//		morphia.mapPackage("com.haw_hamburg.de.objectMapping.Morphia.entities.Activity");
//		morphia.mapPackage("com.haw_hamburg.de.objectMapping.Morphia.entities.LoginData");
//		morphia.mapPackage("com.haw_hamburg.de.objectMapping.Morphia.entities.Discussion");
		datastore = morphia.createDatastore(mongoClient, databaseName);
		mh = new MongoHibernate(inserts, this);
	}

	// Collection
	private String collection_user_name = "User";
	private DBCollection collection_user = null;

	// Collection
	private String collection_post_name = "Post";
	private DBCollection collection_post = null;

	// Collection
	private String collection_comment_name = "Comment";
	private DBCollection collection_comment = null;

	// Collection
	private String collection_discussion_name = "Discussion";
	private DBCollection collection_discussion = null;

	public Integer getInserts() {
		return inserts;
	}

	public void setInserts(Integer inserts) {
		this.inserts = inserts;
	}

	public Integer getRuns() {
		return runs;
	}

	public void setRuns(Integer runs) {
		this.runs = runs;
	}

	//
	//// private ServerAddress initialise() throws UnknownHostException {
	//// ServerAddress addrs = new ServerAddress(this.node, this.port);
	//// return addrs;
	//// }
	//
	public Result performWriteTest() throws Exception {

		// Intialize Variables
		this.result = new Result();

		// Create Test Environment
		createTestEnvironment();

		// Execute Runs
		for (Integer i = 0; i < this.runs; i++) {

			// Record Start Time
			long startTime = System.nanoTime();

			// Insert Documents
			// mh.persistEntities();
			mh.persistEntitiesDataNucleus();

			// Print Count
			printCount();

			// Record End Time and calculate Run Time
			long estimatedTime = System.nanoTime() - startTime;
			double seconds = (double) estimatedTime / 1000000000.0;

			result.addMeasureResult("Run" + (i), seconds, this.inserts);
			System.out.println("Run" + (i) + " finished");

		}

		// Delete Test Environment
		// deleteTestEnvironment();

		// Print Result
		return this.result;

	}

	private void createTestEnvironment() throws Exception {

		this.db = this.mongoClient.getDB(this.databaseName);

		// Create and Connect to Collection
		this.db.createCollection(this.collection_user_name, null);
		this.db.createCollection(this.collection_post_name, null);
		this.db.createCollection(this.collection_comment_name, null);
		this.db.createCollection(this.collection_discussion_name, null);
		this.collection_user = this.db.getCollection(this.collection_user_name);
		this.collection_post = this.db.getCollection(this.collection_post_name);
		this.collection_comment = this.db.getCollection(this.collection_comment_name);
		this.collection_discussion = this.db.getCollection(this.collection_discussion_name);

	}

	private void deleteTestEnvironment() {

		// Delete Connection
		this.db.getCollection(this.collection_user_name).drop();
		this.db.getCollection(this.collection_post_name).drop();
		this.db.getCollection(this.collection_comment_name).drop();
		this.db.getCollection(this.collection_discussion_name).drop();

	}

	private void printCount() {
		System.out.println("Count users " + this.collection_user.find().count());
		System.out.println("Count posts " + this.collection_post.find().count());
		System.out.println("Count comments " + this.collection_comment.find().count());
		System.out.println("Count discussions " + this.collection_discussion.find().count());
	}

	public Morphia getMorphia() {
		return morphia;
	}

	public void setMorphia(Morphia morphia) {
		this.morphia = morphia;
	}

	public Datastore getDatastore() {
		return datastore;
	}

	public void setDatastore(Datastore datastore) {
		this.datastore = datastore;
	}
}
