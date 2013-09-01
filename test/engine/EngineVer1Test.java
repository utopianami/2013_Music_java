package engine;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import com.mumu.data.Database;
import com.mumu.data.Music;
import com.mumu.data.User;
import com.mumu.engine.EngineVer1;

public class EngineVer1Test {

	Database db;
	EngineVer1 engine;
	
	
	@Before
	public void setUp(){
		engine = EngineVer1.getInstance();
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
		db.findUser(3).listenedMusic(db.findMusic(0));
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
		
		//5번사람 
		db.findUser(5).listenedMusic(db.findMusic(0));
		db.findUser(5).listenedMusic(db.findMusic(2));
		db.findUser(5).listenedMusic(db.findMusic(3));
		db.findUser(5).listenedMusic(db.findMusic(7));
		db.findUser(5).listenedMusic(db.findMusic(8));
		db.findUser(5).listenedMusic(db.findMusic(9));
		
		//6번사람 
		db.findUser(6).listenedMusic(db.findMusic(0));
		db.findUser(6).listenedMusic(db.findMusic(3));
		db.findUser(6).listenedMusic(db.findMusic(6));
		db.findUser(6).listenedMusic(db.findMusic(8));
		db.findUser(6).listenedMusic(db.findMusic(9));
		
		//7번사람 
		db.findUser(7).listenedMusic(db.findMusic(1));
		db.findUser(7).listenedMusic(db.findMusic(3));
		db.findUser(7).listenedMusic(db.findMusic(4));
		db.findUser(7).listenedMusic(db.findMusic(8));
		db.findUser(7).listenedMusic(db.findMusic(9));
		db.findUser(7).listenedMusic(db.findMusic(5));
		
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
	
	@Before
	public void makeMatrix(){
		engine.makeMusicMatrix(db);
		engine.makeUserMatrix(db);
	}

	@Test
	public void recommendMusic1(){
		//MatrixTest 결과를 참고. 0번과 유사한 사람은 4번 
		User standardUser = db.findUser(0);
		User targetUser = db.findUser(4);
		Music music = engine.recommendMusic1(db, standardUser);
		assertThat(targetUser.getMyMusic().contains(music), is(true));
		assertThat(music, is(db.findMusic(2)));
	}
	
	@Test
	public void recommendMusic2(){
		//MatrixTest 결과를 참고. 0번 노래와 유사한 노래는은 3번 노래 
		User standardUser = db.findUser(2);
		Music mostListenedMusic = db.findMusic(0);
		standardUser.listenedMusic(mostListenedMusic);

		Music music = engine.recommnedMusic2(db, standardUser);
		assertThat(music, is(db.findMusic(1)));
	}
	
	@Test
	public void recommendMusic(){
		//위의 두 테스틑 토대로
		User standardUser1 = db.findUser(0);
		User standardUser2 = db.findUser(2);
		Music mostListenedMusic = db.findMusic(0);
		
		Music resultMusic = engine.recommendMusic(1, db, standardUser1);
		assertThat(resultMusic, is(db.findMusic(2)));

		standardUser2.listenedMusic(mostListenedMusic);
		Music resultMusic2 = engine.recommendMusic(2, db, standardUser2);
		assertThat(resultMusic2, is(db.findMusic(1)));
	}
}