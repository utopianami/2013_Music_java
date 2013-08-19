package main;

import junit.framework.TestCase;


public class MumuTest extends TestCase {
	Mumu main;
	
	public void setUp(){
		main = Mumu.getInstance();
		
		main.createUser("영남");
		main.createUser("선협");
		main.createUser("성환");
		main.createUser("세현");
		main.createUser("인재");
		main.createUser("병우");
		main.createUser("지환");
		main.createUser("민혁");
		main.createUser("재혁");
		main.createUser("재관");
		
		main.createMusic("moai", "setaeji", "8");
		main.createMusic("This Love", "Maroon5", "8");
		main.createMusic("Yello", "Coldplay", "8");
		main.createMusic("Sunday Morining", "Maroon5", "8");
		main.createMusic("Move Like Jagger", "Maroon5", "8");
		main.createMusic("HeartBreak", "GD", "8");
		main.createMusic("X&Y", "ColdPlay", "8");
		main.createMusic("MyName", "BoA", "8");
		main.createMusic("2012", "HouseRulez", "8");
		main.createMusic("Gangnam Style", "PSY", "8");
		
		//0번사람 
		main.listenedMusic(0, 0);
		main.listenedMusic(0, 1);
		main.listenedMusic(0, 4);
		main.listenedMusic(0, 6);
		main.listenedMusic(0, 7);
		
		//1번사람 
		main.listenedMusic(0, 1);
		main.listenedMusic(0, 2);
		main.listenedMusic(0, 5);
		main.listenedMusic(0, 0);
		main.listenedMusic(0, 8);
		
		//2번사람
		main.listenedMusic(2, 2);
		main.listenedMusic(2, 3);
		main.listenedMusic(2, 5);
		main.listenedMusic(2, 8);
		main.listenedMusic(2, 9);
		
		//3번사람
		main.listenedMusic(3, 1);
		main.listenedMusic(3, 3);
		main.listenedMusic(3, 5);
		main.listenedMusic(3, 8);
		main.listenedMusic(3, 9);
		
		//4번사람 
		main.listenedMusic(4, 0);
		main.listenedMusic(4, 1);
		main.listenedMusic(4, 3);
		main.listenedMusic(4, 2);
		main.listenedMusic(4, 6);
		main.listenedMusic(4, 7);
		
		//5번사람 
		main.listenedMusic(5, 2);
		main.listenedMusic(5, 3);
		main.listenedMusic(5, 7);
		main.listenedMusic(5, 8);
		main.listenedMusic(5, 9);
		
		//6번사람 
		main.listenedMusic(6, 0);
		main.listenedMusic(6, 2);
		main.listenedMusic(6, 5);
		main.listenedMusic(6, 6);
		main.listenedMusic(6, 8);
		
		//7번사람 
		main.listenedMusic(7, 1);
		main.listenedMusic(7, 3);
		main.listenedMusic(7, 4);
		main.listenedMusic(7, 6);
		main.listenedMusic(7, 8);
		main.listenedMusic(7, 9);
		
		//8번사람 
		main.listenedMusic(8, 0);
		main.listenedMusic(8, 3);
		main.listenedMusic(8, 5);
		main.listenedMusic(8, 7);
		main.listenedMusic(8, 9);
		
		//9번 사람
		main.listenedMusic(9, 0);
		main.listenedMusic(9, 2);
		main.listenedMusic(9, 4);
		main.listenedMusic(9, 5);
		main.listenedMusic(9, 9);
		
		main.makeMusicMatrix();
		main.makeUserMatrix();
	}
	
	public void testCreateUser() throws Exception {
		assertEquals("영남", main.findUser(0).getName());
	}
	
	public void testCreateMusic() throws Exception {
		assertEquals("moai",main.findMusic(0).getTrack());
	}
	
}
