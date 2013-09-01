package main;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import com.mumu.data.Music;
import com.mumu.data.User;
import com.mumu.main.Mumu;

public class MumuTest {

	Mumu mumu;
	
	
	@Before
	public void setUp(){
		mumu = Mumu.getInstance();
		
		mumu.addUser("영남");
		mumu.addUser("선협");
		mumu.addUser("성환");
		mumu.addUser("세현");
		mumu.addUser("인재");
		mumu.addUser("병우");
		mumu.addUser("지환");
		mumu.addUser("민혁");
		mumu.addUser("재혁");
		mumu.addUser("재관");
		
		mumu.addMusic("moai", "setaeji", "8");
		mumu.addMusic("This Love", "Maroon5", "8");
		mumu.addMusic("Yello", "Coldplay", "8");
		mumu.addMusic("Sunday Morining", "Maroon5", "8");
		mumu.addMusic("Move Like Jagger", "Maroon5", "8");
		mumu.addMusic("HeartBreak", "GD", "8");
		mumu.addMusic("X&Y", "ColdPlay", "8");
		mumu.addMusic("MyName", "BoA", "8");
		mumu.addMusic("2012", "HouseRulez", "8");
		mumu.addMusic("Gangnam Style", "PSY", "8");
		
		//0번사람 
		mumu.findUser(0).listenedMusic(mumu.findMusic(0));
		mumu.findUser(0).listenedMusic(mumu.findMusic(1));
		mumu.findUser(0).listenedMusic(mumu.findMusic(4));
		mumu.findUser(0).listenedMusic(mumu.findMusic(6));
		mumu.findUser(0).listenedMusic(mumu.findMusic(7));
		
		//1번사람 
		mumu.findUser(1).listenedMusic(mumu.findMusic(1));
		mumu.findUser(1).listenedMusic(mumu.findMusic(2));
		mumu.findUser(1).listenedMusic(mumu.findMusic(5));
		mumu.findUser(1).listenedMusic(mumu.findMusic(0));
		mumu.findUser(1).listenedMusic(mumu.findMusic(8));
		
		//2번사람
		mumu.findUser(2).listenedMusic(mumu.findMusic(2));
		mumu.findUser(2).listenedMusic(mumu.findMusic(7));
		mumu.findUser(2).listenedMusic(mumu.findMusic(4));
		mumu.findUser(2).listenedMusic(mumu.findMusic(8));
		mumu.findUser(2).listenedMusic(mumu.findMusic(9));
		
		//3번사람
		mumu.findUser(3).listenedMusic(mumu.findMusic(0));
		mumu.findUser(3).listenedMusic(mumu.findMusic(1));
		mumu.findUser(3).listenedMusic(mumu.findMusic(3));
		mumu.findUser(3).listenedMusic(mumu.findMusic(5));
		mumu.findUser(3).listenedMusic(mumu.findMusic(8));
		mumu.findUser(3).listenedMusic(mumu.findMusic(9));
		
		//4번사람 
		mumu.findUser(4).listenedMusic(mumu.findMusic(0));
		mumu.findUser(4).listenedMusic(mumu.findMusic(1));
		mumu.findUser(4).listenedMusic(mumu.findMusic(3));
		mumu.findUser(4).listenedMusic(mumu.findMusic(2));
		mumu.findUser(4).listenedMusic(mumu.findMusic(6));
		mumu.findUser(4).listenedMusic(mumu.findMusic(7));
		
		//5번사람 
		mumu.findUser(5).listenedMusic(mumu.findMusic(0));
		mumu.findUser(5).listenedMusic(mumu.findMusic(2));
		mumu.findUser(5).listenedMusic(mumu.findMusic(3));
		mumu.findUser(5).listenedMusic(mumu.findMusic(7));
		mumu.findUser(5).listenedMusic(mumu.findMusic(8));
		mumu.findUser(5).listenedMusic(mumu.findMusic(9));
		
		//6번사람 
		mumu.findUser(6).listenedMusic(mumu.findMusic(0));
		mumu.findUser(6).listenedMusic(mumu.findMusic(3));
		mumu.findUser(6).listenedMusic(mumu.findMusic(6));
		mumu.findUser(6).listenedMusic(mumu.findMusic(8));
		mumu.findUser(6).listenedMusic(mumu.findMusic(9));
		
		//7번사람 
		mumu.findUser(7).listenedMusic(mumu.findMusic(1));
		mumu.findUser(7).listenedMusic(mumu.findMusic(3));
		mumu.findUser(7).listenedMusic(mumu.findMusic(4));
		mumu.findUser(7).listenedMusic(mumu.findMusic(8));
		mumu.findUser(7).listenedMusic(mumu.findMusic(9));
		mumu.findUser(7).listenedMusic(mumu.findMusic(5));
		
		//8번사람 
		mumu.findUser(8).listenedMusic(mumu.findMusic(0));
		mumu.findUser(8).listenedMusic(mumu.findMusic(3));
		mumu.findUser(8).listenedMusic(mumu.findMusic(5));
		mumu.findUser(8).listenedMusic(mumu.findMusic(7));
		mumu.findUser(8).listenedMusic(mumu.findMusic(9));
		
		//9번 사람
		mumu.findUser(9).listenedMusic(mumu.findMusic(0));
		mumu.findUser(9).listenedMusic(mumu.findMusic(2));
		mumu.findUser(9).listenedMusic(mumu.findMusic(4));
		mumu.findUser(9).listenedMusic(mumu.findMusic(5));
		mumu.findUser(9).listenedMusic(mumu.findMusic(9));
		}
	
	@Before
	public void makeMatrix(){
		mumu.refreshMatrix();
	}
	
	@Test
	public void recommendMusic(){
		User standardUser = mumu.findUser(0);
		mumu.recommendMusic(standardUser);
		Music recommend = standardUser.getRecommendMusic().get(0);
		assertThat(recommend, is(mumu.findMusic(2)));
	}
	
}
