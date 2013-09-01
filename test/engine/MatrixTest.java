package engine;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mumu.data.Database;
import com.mumu.engine.ColumnMusic;
import com.mumu.engine.ColumnUser;
import com.mumu.engine.Matrix;
import com.mumu.engine.Row;

public class MatrixTest {

	Database db;
	Matrix matrix;
	
	
	@Before
	public void setUp(){
		matrix = Matrix.create();
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
	
	@Test
	public void makeMusicMatrix(){
		matrix.makeMusicMatrix(db);
		Row firstMusicResult = matrix.getMusicMatrix(0);
		List<ColumnMusic> fisrtMusicRow = matrix.getMusicMatrix(0).getRowMusic();
		
		assertThat(fisrtMusicRow.get(3).getSamrUserCount(), is(5));
		assertThat(fisrtMusicRow.get(5).getSamrUserCount(), is(4));
		assertThat(firstMusicResult.getMostRelationMusic(), is(db.findMusic(3)));
	}
	
	@Test
	public void makeUserMatrix(){
		matrix.makeUserMatrix(db);
		Row fisrtUserResult = matrix.getUserMatrix(0);
		List<ColumnUser> fisrtUserRow = matrix.getUserMatrix(0).getRowUser();
		
		assertThat(fisrtUserRow.get(0).getStandardUser(), is(db.findUser(0)));
		assertThat(fisrtUserRow.get(0).getSameMusicCount(), is(5));
		assertThat(fisrtUserRow.get(1).getSameMusicCount(), is(2));
		assertThat(fisrtUserResult.getMostRelationUser(), is(db.findUser(4)));
	}

}
