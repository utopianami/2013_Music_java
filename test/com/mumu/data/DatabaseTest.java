package com.mumu.data;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;


public class DatabaseTest {
	
	Database db;
	
	@Before
	public void setUp(){
		db = Database.getInstance();
	}
	
	
	@Test
	public void addUser() {
		db.addUser("youngnam");
		User testUser = db.findUser(0);
		
		assertThat(testUser.getName(), is("youngnam"));
		assertThat(testUser.getUserIndex(), is(0));
		assertThat(db.getUserList().get(0), is(testUser));
	}
	
	@Test
	public void addMusic(){
		db.addMusic("모아이", "서태지", "moai");
		Music testMusic = db.findMusic(0);
		
		assertThat(testMusic.getTrack(), is("모아이"));
	}

}
