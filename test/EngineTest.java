import java.util.ArrayList;

import junit.framework.TestCase;


public class EngineTest extends TestCase {
	Database db;
	Engine engine;
	
	
	public void setUp(){
		db = new Database();
		engine = new Engine(); 
		
		//사람 
		db.addPlayer("youngnam");
		db.addPlayer("nami");
		db.addPlayer("soo");
		db.addPlayer("soojung");
		db.addPlayer("sungyup");
		db.addPlayer("jeehwan");
		db.addPlayer("byungwoo");
		db.addPlayer("injae");
		db.addPlayer("sunghwan");
		db.addPlayer("jangin");
		

		//music
		db.addSong("moai", "서태지"); 
		db.addSong("ThisLove", "maroon5"); 
		db.addSong("Sunday Morning", "marron5"); 
		db.addSong("Rolling in the deep", "adel"); 
		db.addSong("Spped of sound", "Coldplay"); 
		db.addSong("trouble", "Coldplay"); 
		db.addSong("yellow", "Coldplay"); 
		db.addSong("happy ending", "MIKA"); 
		db.addSong("Grace Kelly", "MIKA"); 
		db.addSong("LolliPop", "MIKA"); 

		//youngnam (index = 0)
		db.linkedData(0, 0);
		db.linkedData(0, 1);
		db.linkedData(0, 4);
		db.linkedData(0, 5);
		db.linkedData(0, 7);
		
		//nami (index = 1)
		db.linkedData(1, 1);
		db.linkedData(1, 4);
		db.linkedData(1, 5);
		db.linkedData(1, 8);

		//soo(index = 2)
		db.linkedData(2, 2);
		db.linkedData(2, 3);
		db.linkedData(2, 6);
		db.linkedData(2, 7);
		db.linkedData(2, 8);
				
		//soojung (index = 3) 
		db.linkedData(3, 0);
		db.linkedData(3, 1);
		db.linkedData(3, 4);
		db.linkedData(3, 8);
		db.linkedData(3, 9);
		
		//sunhyup(index = 4)
		db.linkedData(4, 2);
		db.linkedData(4, 4);
		db.linkedData(4, 5);
		db.linkedData(4, 7);
		
		//jeehwan(index = 5)
		db.linkedData(5, 1);
		db.linkedData(5, 5);
		db.linkedData(5, 6);
		db.linkedData(5, 8);
		db.linkedData(5, 9);

		//byungwoo(index = 6)
		db.linkedData(6, 0);
		db.linkedData(6, 3);
		db.linkedData(6, 6);
		db.linkedData(6, 8);
		db.linkedData(6, 9);
		
		//injae(index = 7)
		db.linkedData(7, 5);
		db.linkedData(7, 6);
		db.linkedData(7, 7);
		db.linkedData(7, 8);
		db.linkedData(7, 9);
		
		//sungwhan(index = 8)
		db.linkedData(8, 1);
		db.linkedData(8, 3);
		db.linkedData(8, 7);
		db.linkedData(8, 8);
		db.linkedData(8, 9);
		
		//jangin(index = 9)
		db.linkedData(9, 0);
		db.linkedData(9, 3);
		db.linkedData(9, 6);
		db.linkedData(9, 7);
		db.linkedData(9, 9);
	}
	
	//matrixPlayer
	public void testMakeMatrixPlayer() throws Exception {
		engine.makeMatrixPlayer(db);
		assertEquals(3, engine.getMatrixPlayer().get(0).get(1).size());
	}
	
	public void testMakeMatrixSong() throws Exception {
		engine.makeMatrixSong(db);
		assertEquals(4, engine.getMatrixSong().get(0).get(0).size());
	}
}
