package data;

import data.Player;
import data.Song;
import junit.framework.TestCase;


public class PlayerTest extends TestCase {
	
	Player youngnam;
	Song thislove;
	
	public void setUp(){
		youngnam = new Player(0, "youngnam");
		thislove = new Song(0, "ThisLove", "maroon5");
	}

	
	//생성 
	public void testCreate() throws Exception {
		String actual = youngnam.getName();
		assertEquals("youngnam", actual);	
	}
	
	
	//들었던 음악 리스트 
	public void testListenedMusic() throws Exception {
		youngnam.listenedMusic(thislove);
		Song actual = youngnam.myMusicList.get(0);
		assertEquals(thislove, actual);
	}
	
}
