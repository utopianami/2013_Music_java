package engine;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.mumu.data.Music;
import com.mumu.data.User;
import com.mumu.engine.Row;


public class RowTest {

	Row row;
	
	User user1;
	User user2;
	User user3;
	User user4;
	Music music1;
	Music music2;
	Music music3;
	Music music4;
	Music music5;
	
	@Before
	public void setUp() {
		row = new Row();
		user1 = User.create(0, "youngnam");
		user2 = User.create(1, "youngnam2");
		user3 = User.create(2, "youngnam3");
		user4 = User.create(3, "youngnam4");
		music1 = Music.create(0, "제목1", "가수1", "앨범1");
		music2 = Music.create(1, "제목2", "가수2", "앨범2");
		music3 = Music.create(2, "제목3", "가수3", "앨범3");
		music4 = Music.create(3, "제목4", "가수4", "앨범4");
		
		// user1 : music1, music2, music3
		user1.listenedMusic(music1);
		user1.listenedMusic(music2);
		user1.listenedMusic(music3);
		//user2 : music1, music2, music4
		user2.listenedMusic(music1);
		user2.listenedMusic(music2);
		user2.listenedMusic(music4);
		//user3 : music2, music3, music4
		user3.listenedMusic(music1);
		user3.listenedMusic(music4);
		
		//user4 : music1, music2, music3
		user4.listenedMusic(music1);
		user4.listenedMusic(music2);
		user4.listenedMusic(music3);
	}
	
	@Test
	public void makeRowUser(){
		List<User> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		
		row.makeRowUser(user1, userList);
		assertThat(row.getRowUser().size(), is(4));
		assertThat(row.getRowUser().get(0).getCompareUser(), is(user1));
		assertThat(row.getRowUser().get(0).getSameMusicCount(), is(3));
		assertThat(row.getRowUser().get(1).getCompareUser(), is(user2));
		assertThat(row.getRowUser().get(1).getSameMusicCount(), is(2));
		assertThat(row.getRowUser().get(3).getSameMusicCount(), is(3));
		
		assertThat(row.getMostRelationUser(), is(user4));
	}
	
	@Test
	public void makeRowMusic(){
		List<Music> musicList = new ArrayList<>();
		musicList.add(music1);
		musicList.add(music2);
		musicList.add(music3);
		musicList.add(music4);
		
		row.makeRowMusic(music1, musicList);
		assertThat(row.getRowMusic().size(), is(4));
		assertThat(row.getRowMusic().get(0).getCompareMusic(), is(music1));
		assertThat(row.getRowMusic().get(0).getSamrUserCount(), is(4));
		assertThat(row.getRowMusic().get(1).getCompareMusic(), is(music2));
		assertThat(row.getRowMusic().get(1).getSamrUserCount(), is(3));
		
		assertThat(row.getMostRelationMusic(), is(music2));
	}

}
