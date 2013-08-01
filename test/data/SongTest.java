package data;
import java.util.ArrayList;

import data.Song;
import junit.framework.TestCase;


public class SongTest extends TestCase {
	
	Song moai;
	Song testSong;
	
	public void setUp(){
		moai = new Song(0, "moai", "서태지");
		testSong = new Song(1, "난 알아요 ", "서태지");
	}
	
	
	//생성자 확인 
	public void testCreate() throws Exception {
		assertEquals("moai", moai.getSongName());
	}
	
	public void testAddRelationSong() throws Exception {
		moai.addRelationSong(testSong);
		ArrayList<Song> relationSong = moai.getRealationSong();
		Song actual = relationSong.get(0);
		assertEquals(testSong, actual);
	}

}
