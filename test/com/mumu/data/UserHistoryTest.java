package com.mumu.data;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class UserHistoryTest {
	
	UserHistory userHistory;
	User user;
	Music music;
	Music music2;
	
	
	@Before
	public void setUp(){
		userHistory = UserHistory.create();
		user = User.create(0, "youngnam");
		music = Music.create(0, "난알아요", "서태지", "난알아요");
		music2 = Music.create(1, "교실이데아", "서태지", "교실이데아");
	}

	@Test
	public void firstListened() {
		boolean actual = userHistory.firstListend(music);
		assertThat(actual, is(true));
	}
	
	@Test
	public void favouriteMusic(){
		userHistory.addFavouriteMusic(music);
		int actual = userHistory.getFavouriteMusic().size();
		assertThat(actual, is(1));
		
		boolean actual2 = userHistory.isAlreadyAdded(music);
		assertThat(actual2, is(true));
		
		userHistory.removeFavouriteMusic(music);
		int actual3 = userHistory.getFavouriteMusic().size();
		assertThat(actual3, is(0));
	}
	
	@Test
	public void listenedMusic(){
		userHistory.listenedMusic(music, user);
		userHistory.listenedMusic(music, user);
		userHistory.listenedMusic(music2, user);
		
		assertThat(userHistory.getPlayHistory().size(), is(3)); // 최근재생항목 
		assertThat(userHistory.getMusicCount(music), is(2)); // music 재생횟수 
		assertThat(userHistory.getMusicCount(music2), is(1)); //music2 재생횟수 
		assertThat(userHistory.getMyMusic().size(), is(2)); // 내가 들은 노래 수(횟수 중복 없이 )
	}
	
	@Test
	public void getRecentlyPlayed(){
		userHistory.listenedMusic(music2, user);
		userHistory.listenedMusic(music, user);
		userHistory.listenedMusic(music, user);
		userHistory.listenedMusic(music2, user);
		
		List<Music> list = userHistory.getRecentlyPlayed(3); //최근 들었던 3곡(music2 -> music -> music ) 
		assertThat(list.get(0), is(music2));
		assertThat(list.get(1), is(music));
		
	}

}
