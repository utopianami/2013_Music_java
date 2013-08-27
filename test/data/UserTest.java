package data;

import java.util.ArrayList;

import com.mumu.data.Music;
import com.mumu.data.User;

import junit.framework.TestCase;


public class UserTest extends TestCase {
	
	User user1;
	User user2;
	
	Music music1;
	Music music2;
	Music music3;
	Music music4;
	Music music5;
	
	
	public void setUp(){
		user1 = User.create(0, "youngnam");
		user2 = User.create(1, "youngnam");
		music1 = Music.create(1, "제목1", "가수1", "앨범1");
		music2 = Music.create(2, "제목2", "가수2", "앨범2");
		music3 = Music.create(3, "제목3", "가수3", "앨범3");
		music4 = Music.create(4, "제목4", "가수4", "앨범4");
	}
	
	
	public void testCreatePlayer() throws Exception {
		assertEquals("youngnam", user1.getName());
		assertEquals(0, user1.getUserIndex());
	}
	
	public void testListenedMusic() throws Exception {
		user1.listenedMusic(music1);
		user1.listenedMusic(music2);
		user1.listenedMusic(music3);
		user1.listenedMusic(music3);
		
		assertEquals(3, user1.getMyMusic().size());
	}
	
	
	public void testFavouriteMusic() throws Exception {
		user1.addFavouriteMusic(music1);
		user1.addFavouriteMusic(music2);
		
		assertEquals(2, user1.getFavouriteMusic().size());
	}
	
	public void testIsListened() throws Exception {
		user1.listenedMusic(music3);
		assertFalse(user1.isListened(music1));
		assertTrue(user1.isListened(music3));
	}
	
	public void testGetFacouriteMusicAndGetMusicCount() throws Exception {
		user1.listenedMusic(music1);
		user1.listenedMusic(music2);
		user1.listenedMusic(music3);
		user1.listenedMusic(music3);
		
		assertEquals(music3, user1.getRecentlyPlayed(2).get(0));
		assertEquals(2, user1.getMusicCount(music3));
	}
	
	public void testCompareMusic() throws Exception {
		user1.listenedMusic(music1);
		user1.listenedMusic(music2);
		user1.listenedMusic(music3);
		
		user2.listenedMusic(music1);
		user2.listenedMusic(music2);
		
		ArrayList<Music> list = user1.compareMusic(user2);
		assertEquals(2, list.size());
	}

	
	

}
