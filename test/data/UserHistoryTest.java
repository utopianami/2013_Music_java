package data;

import junit.framework.TestCase;

public class UserHistoryTest extends TestCase {
	
	User user;

	public void setUp(){
		user = User.create(0, "youngnam");
	}

	
	public void testCreate() throws Exception {
		UserHistory history = UserHistory.create();
		Music music = Music.create(0, "q", "1", "2");
		history.listenedMusic(music, user);
		assertEquals(1, history.getMyMusic().size());
	}
	
	public void testAddMusicCount() throws Exception {
		UserHistory history = UserHistory.create();
		Music music = Music.create(0, "q", "1", "2") ;
		Music music1 = Music.create(1, "q", "1", "2") ;
		Music music2 = Music.create(2, "q", "1", "2") ;
		
		history.listenedMusic(music, user);
		history.listenedMusic(music1,user);
		history.listenedMusic(music2, user);
		history.listenedMusic(music, user);
		
		assertEquals(2, history.getMusicCount(music));
	}
	
	public void testGetRecentlyPlayed() throws Exception {
		UserHistory history = UserHistory.create();
		Music music = Music.create(0, "q", "1", "2") ;
		Music music1 = Music.create(1, "q", "1", "2") ;
		Music music2 = Music.create(2, "q", "1", "2") ;
		
		history.listenedMusic(music, user);
		history.listenedMusic(music1, user);
		history.listenedMusic(music2, user);
		history.listenedMusic(music, user);
		history.listenedMusic(music, user);
		history.listenedMusic(music1, user);
		history.listenedMusic(music1, user);
		history.listenedMusic(music, user);
		
		assertEquals(5, history.getRecentlyPlayed(5).size());
		assertEquals(music1, history.getRecentlyPlayed(2).get(1));
	}
	
	public void testFavouruteMusic() throws Exception {
		UserHistory history = UserHistory.create();
		Music music = Music.create(0, "q", "1", "2") ;
		
		history.addFavouriteMusic(music);
		history.addFavouriteMusic(music);
		assertEquals(music, history.getFavouriteMusic().get(0));
	}
}
