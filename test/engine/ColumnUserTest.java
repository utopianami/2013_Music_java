package engine;


import com.mumu.data.Music;
import com.mumu.data.User;
import com.mumu.engine.ColumnUser;

import junit.framework.TestCase;

public class ColumnUserTest extends TestCase {
	
	User user1;
	User user2;
	Music music1;
	Music music2;
	Music music3;
	Music music4;
	Music music5;
	
	
	public void setUp(){
		user1 = User.create(0, "youngnam");
		user2 = User.create(1, "youngnam2");
		music1 = Music.create(0, "제목1", "가수1", "앨범1");
		music2 = Music.create(0, "제목2", "가수2", "앨범2");
		music3 = Music.create(0, "제목3", "가수3", "앨범3");
		music4 = Music.create(0, "제목4", "가수4", "앨범4");
	}
	
	public void testCreate() throws Exception {
		ColumnUser colmunUser = new ColumnUser();
		
		user1.listenedMusic(music1);
		user1.listenedMusic(music2);
		user1.listenedMusic(music3);
		
		user2.listenedMusic(music1);
		user2.listenedMusic(music2);
		
	
		colmunUser.makeColumn(user1, user2);
		assertEquals(2, colmunUser.getSameMusicCount());
		assertEquals(user1, colmunUser.getStandardUser());
	}

}
