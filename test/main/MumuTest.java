package main;
import main.Mumu;
import data.Database;
import data.Player;
import data.Song;
import engine.Engine;
import junit.framework.TestCase;


public class MumuTest extends TestCase {
	Mumu mumu;
	Database database;
	Engine engine;
	
	
	public void setUp(){
		mumu = new Mumu();
		database = mumu.getDatabase();
		engine = mumu.getEngine();
		
		database.addPlayer("youngnam");
		database.addPlayer("nami");
		database.addPlayer("soo");
		database.addPlayer("soojung");
		database.addPlayer("sungyup");
		database.addPlayer("jeehwan");
		database.addPlayer("byungwoo");
		database.addPlayer("injae");
		database.addPlayer("sunghwan");
		database.addPlayer("jangin");
		

		//music
		database.addSong("moai", "서태지"); 
		database.addSong("ThisLove", "maroon5"); 
		database.addSong("Sunday Morning", "marron5"); 
		database.addSong("Rolling in the deep", "adel"); 
		database.addSong("Spped of sound", "Coldplay"); 
		database.addSong("trouble", "Coldplay"); 
		database.addSong("yellow", "Coldplay"); 
		database.addSong("happy ending", "MIKA"); 
		database.addSong("Grace Kelly", "MIKA"); 
		database.addSong("LolliPop", "MIKA"); 

		//youngnam (index = 0)
		database.linkedData(0, 0);
		database.linkedData(0, 1);
		database.linkedData(0, 4);
		database.linkedData(0, 5);
		database.linkedData(0, 7);
		
		//nami (index = 1)
		database.linkedData(1, 1);
		database.linkedData(1, 4);
		database.linkedData(1, 5);
		database.linkedData(1, 8);

		//soo(index = 2)
		database.linkedData(2, 2);
		database.linkedData(2, 3);
		database.linkedData(2, 6);
		database.linkedData(2, 7);
		database.linkedData(2, 8);
				
		//soojung (index = 3) 
		database.linkedData(3, 0);
		database.linkedData(3, 1);
		database.linkedData(3, 4);
		database.linkedData(3, 8);
		database.linkedData(3, 9);
		
		//sunhyup(index = 4)
		database.linkedData(4, 2);
		database.linkedData(4, 4);
		database.linkedData(4, 5);
		database.linkedData(4, 7);
		
		//jeehwan(index = 5)
		database.linkedData(5, 1);
		database.linkedData(5, 5);
		database.linkedData(5, 6);
		database.linkedData(5, 8);
		database.linkedData(5, 9);

		//byungwoo(index = 6)
		database.linkedData(6, 0);
		database.linkedData(6, 3);
		database.linkedData(6, 6);
		database.linkedData(6, 8);
		database.linkedData(6, 9);
		
		//injae(index = 7)
		database.linkedData(7, 5);
		database.linkedData(7, 6);
		database.linkedData(7, 7);
		database.linkedData(7, 8);
		database.linkedData(7, 9);
		
		//sungwhan(index = 8)
		database.linkedData(8, 1);
		database.linkedData(8, 3);
		database.linkedData(8, 7);
		database.linkedData(8, 8);
		database.linkedData(8, 9);
		
		//jangin(index = 9)
		database.linkedData(9, 0);
		database.linkedData(9, 3);
		database.linkedData(9, 6);
		database.linkedData(9, 7);
		database.linkedData(9, 9);
	}
	
	//database_Class관련 
	
	public void testCreatePlayer() throws Exception {
		mumu.createPlayer("youngnam");
		String actual = database.findPlayer(10).getName();
		assertEquals("youngnam", actual);
	}
	
	public void testCreateSong() throws Exception {
		mumu.createSong("교실이데아", "SeoTaiji");
		String actual = mumu.getDatabase().findSong(10).getSongName();
		assertEquals("교실이데아", actual);
	}
	
	public void testLinkedData() throws Exception {
		mumu.createSong("moai", "SeoTaiji");
		mumu.createPlayer("youngnam");
		mumu.linkedData(0, 0);
		
		Player player = database.findPlayer(0);
		Song song = player.myMusicList.get(0);
		Song target = database.findSong(0);
		
		assertEquals(song, target);
	}
	
	//engine
	public void testMakeMatrixPlayer() throws Exception {
		engine.makeMatrixPlayer(database);
		assertEquals(3, engine.getMatrixPlayer().get(0).get(1).size());
	}
	
	public void testMakeMatrixSong() throws Exception {
		engine.makeMatrixSong(database);
	//	assertEquals(4, engine.getMatrixSong().get(0).get(0).size());
	}
		
	
}
