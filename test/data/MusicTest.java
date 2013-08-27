package data;

import com.mumu.data.Music;
import com.mumu.data.User;

import junit.framework.TestCase;


public class MusicTest extends TestCase {
	
	public void testCreate() throws Exception {
		Music music = Music.create(0, "제목1", "가수1", "앨범1");
		
		assertEquals(0, music.getMusicIndex());
		assertEquals("제목1", music.getTrack());
		assertEquals("가수1", music.getArtist());
		assertEquals("앨범1", music.getAlbum());
	}
	
	public void testAddUserList() throws Exception {
		User user = User.create(0, "youngnam");
		Music music = Music.create(0, "제목1", "가수1", "앨범1");
		user.listenedMusic(music);
		
		assertEquals(1, music.getUserList().size());
	}
	
	public void testCompareMusic() throws Exception {
		User user1 = User.create(1, "youngnam");
		User user2 = User.create(2, "youngnam");
		User user3 = User.create(3, "youngnam");
		User user4 = User.create(4, "youngnam");

		Music music1 = Music.create(1, "제목1", "가수1", "앨범1");
		Music music2 = Music.create(2, "제목1", "가수1", "앨범1");
		
		user1.listenedMusic(music1);
		user2.listenedMusic(music1);
		user4.listenedMusic(music1);

		user1.listenedMusic(music2);
		user3.listenedMusic(music2);
		user4.listenedMusic(music2);
		
		assertEquals(2, music1.compareUser(music2).size());
		
	}
	
}