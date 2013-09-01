package engine;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;
import com.mumu.data.Music;
import com.mumu.data.User;
import com.mumu.engine.ColumnUser;

public class ColmunUserTest {
	ColumnUser columnUser;
	
	User user1;
	User user2;
	Music music1;
	Music music2;
	Music music3;
	Music music4;
	Music music5;
	
	@Before
	public void setUp(){
		columnUser = new ColumnUser();
		
		user1 = User.create(0, "youngnam");
		user2 = User.create(1, "youngnam2");
		music1 = Music.create(0, "제목1", "가수1", "앨범1");
		music2 = Music.create(0, "제목2", "가수2", "앨범2");
		music3 = Music.create(0, "제목3", "가수3", "앨범3");
		music4 = Music.create(0, "제목4", "가수4", "앨범4");
	}
	
	@Test
	public void makeColumn(){
		user1.listenedMusic(music1);
		user1.listenedMusic(music2);
		user2.listenedMusic(music1);
		
		columnUser.makeColumn(user1, user2);
		assertThat(columnUser.getStandardUser(), is(user1));
		assertThat(columnUser.getCompareUser(), is(user2));
		assertThat(columnUser.getSameMusic().get(0), is(music1));
		assertThat(columnUser.getSameMusicCount(), is(1));
	}
	
}
