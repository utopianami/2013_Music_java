package engine;


import data.Database;
import data.Music;
import data.User;
import junit.framework.TestCase;


public class EngineTest extends TestCase {
	
	Database db;
	Engine engine;
	
	
	public void setUp(){
		engine = Engine.getInstance();
		db = Database.getInstance();
		
		db.addUser("영남");
		db.addUser("선협");
		db.addUser("성환");
		db.addUser("세현");
		db.addUser("인재");
		db.addUser("병우");
		db.addUser("지환");
		db.addUser("민혁");
		db.addUser("재혁");
		db.addUser("재관");
		
		db.addMusic("moai", "setaeji", "8");
		db.addMusic("This Love", "Maroon5", "8");
		db.addMusic("Yello", "Coldplay", "8");
		db.addMusic("Sunday Morining", "Maroon5", "8");
		db.addMusic("Move Like Jagger", "Maroon5", "8");
		db.addMusic("HeartBreak", "GD", "8");
		db.addMusic("X&Y", "ColdPlay", "8");
		db.addMusic("MyName", "BoA", "8");
		db.addMusic("2012", "HouseRulez", "8");
		db.addMusic("Gangnam Style", "PSY", "8");
		
		//0번사람 
		db.findUser(0).listenedMusic(db.findMusic(0));
		db.findUser(0).listenedMusic(db.findMusic(1));
		db.findUser(0).listenedMusic(db.findMusic(4));
		db.findUser(0).listenedMusic(db.findMusic(6));
		db.findUser(0).listenedMusic(db.findMusic(7));
		
		//1번사람 
		db.findUser(1).listenedMusic(db.findMusic(1));
		db.findUser(1).listenedMusic(db.findMusic(2));
		db.findUser(1).listenedMusic(db.findMusic(5));
		db.findUser(1).listenedMusic(db.findMusic(0));
		db.findUser(1).listenedMusic(db.findMusic(8));
		
		//2번사람
		db.findUser(2).listenedMusic(db.findMusic(2));
		db.findUser(2).listenedMusic(db.findMusic(7));
		db.findUser(2).listenedMusic(db.findMusic(4));
		db.findUser(2).listenedMusic(db.findMusic(8));
		db.findUser(2).listenedMusic(db.findMusic(9));
		
		//3번사람
		db.findUser(3).listenedMusic(db.findMusic(1));
		db.findUser(3).listenedMusic(db.findMusic(3));
		db.findUser(3).listenedMusic(db.findMusic(5));
		db.findUser(3).listenedMusic(db.findMusic(8));
		db.findUser(3).listenedMusic(db.findMusic(9));
		
		//4번사람 
		db.findUser(4).listenedMusic(db.findMusic(0));
		db.findUser(4).listenedMusic(db.findMusic(1));
		db.findUser(4).listenedMusic(db.findMusic(3));
		db.findUser(4).listenedMusic(db.findMusic(2));
		db.findUser(4).listenedMusic(db.findMusic(6));
		db.findUser(4).listenedMusic(db.findMusic(7));
		//db.findUser(4).listenedMusic(db.findMusic(9));
		
		//5번사람 
		db.findUser(5).listenedMusic(db.findMusic(2));
		db.findUser(5).listenedMusic(db.findMusic(3));
		db.findUser(5).listenedMusic(db.findMusic(7));
		db.findUser(5).listenedMusic(db.findMusic(8));
		db.findUser(5).listenedMusic(db.findMusic(9));
		
		//6번사람 
		db.findUser(6).listenedMusic(db.findMusic(0));
		db.findUser(6).listenedMusic(db.findMusic(3));
		db.findUser(6).listenedMusic(db.findMusic(5));
		db.findUser(6).listenedMusic(db.findMusic(6));
		db.findUser(6).listenedMusic(db.findMusic(8));
		db.findUser(6).listenedMusic(db.findMusic(9));
		
		//7번사람 
		db.findUser(7).listenedMusic(db.findMusic(1));
		db.findUser(7).listenedMusic(db.findMusic(3));
		db.findUser(7).listenedMusic(db.findMusic(4));
		db.findUser(7).listenedMusic(db.findMusic(6));
		db.findUser(7).listenedMusic(db.findMusic(8));
		db.findUser(7).listenedMusic(db.findMusic(9));
		
		//8번사람 
		db.findUser(8).listenedMusic(db.findMusic(0));
		db.findUser(8).listenedMusic(db.findMusic(3));
		db.findUser(8).listenedMusic(db.findMusic(5));
		db.findUser(8).listenedMusic(db.findMusic(7));
		db.findUser(8).listenedMusic(db.findMusic(9));
		
		//9번 사람
		db.findUser(9).listenedMusic(db.findMusic(0));
		db.findUser(9).listenedMusic(db.findMusic(2));
		db.findUser(9).listenedMusic(db.findMusic(4));
		db.findUser(9).listenedMusic(db.findMusic(5));
		db.findUser(9).listenedMusic(db.findMusic(9));

	}
	
	public void testMakeUserMatrix() throws Exception {
		
		//makeUserMatrix
		assertEquals(10, db.getUserList().size());
		engine.makeUserMatrix(db);
		assertEquals(10, engine.getUserMatrix(0).getRowUser().size());
		assertEquals(5, engine.getUserMatrix(0).getRowUser().get(0).getSameMusicCount());
		
		//makeMusicMatrix()
		engine.makeMusicMatrix(db);
		assertEquals(10, engine.getMusicMatrix(0).getRowMusic().size());
		assertEquals(6, engine.getMusicMatrix(0).getRowMusic().get(0).getSameUser().size());
		
		//relationUser()
		User mostRelation= engine.relationUser(db, db.findUser(0));
		assertEquals(4, mostRelation.getUserIndex());
		
		//recommendMusic1()
		Music recommendMusic = engine.recommendMusic1(db, db.findUser(0));
		assertEquals("Yello", recommendMusic.getTrack());
		
		//relationMusic()
		Music mostRelationMusic = engine.relationMusic(db, db.findMusic(9));
		assertEquals(3, mostRelationMusic.getMusicIndex());
		
		//recommendMusic2()
		Music recommendMusic2 = engine.recommnedMusic2(db, db.findUser(2));
		assertEquals(3, recommendMusic2.getMusicIndex());
	}
	

	
}
