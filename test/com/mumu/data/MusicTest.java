package com.mumu.data;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MusicTest {

	Music music;
	User user;
	
	@Before
	public void setUp(){
		music = Music.create(0, "moai", "서태지", "모아이");
		user = User.create(0, "youngnam");
	}
	
	
	@Test
	public void getInfo(){
		assertThat(music.getMusicIndex(), is(0));
		assertThat(music.getTrack(), is("moai"));
		assertThat(music.getArtist(), is("서태지"));
		assertThat(music.getAlbum(), is("모아이"));
	}
	
	@Test
	public void addUserList(){
		music.addUserList(user);
		User testUser = music.getUserList().get(0);
		
		assertThat(testUser, is(user));
	}
	
	@Test
	public void compareUser(){
		Music compareMusic = Music.create(3, "빠빠빠", "크레용팝", "mini");
		compareMusic.addUserList(user);
		
		music.addUserList(user);
		List<User> sameUser = music.compareUser(music);
		
		assertThat(sameUser.get(0), is(user));
	}

}
