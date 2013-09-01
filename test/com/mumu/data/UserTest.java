package com.mumu.data;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	User user;
	Music music;
	Music music2;
	

	@Before
	public void setUp(){
		user = User.create(0, "youngnam");
		music = Music.create(0, "난알아요", "서태지", "난알아요");
		music2 = Music.create(1, "교실이데아", "서태지", "교실이데아");
	}
	
	@Test
	public void getInfo(){
		assertThat(user.getName(), is("youngnam"));
		assertThat(user.getUserIndex(), is(0));
	}
	
	@Test
	public void getInfoUserHistory(){
		user.listenedMusic(music);
		user.listenedMusic(music2);
		
		assertThat(user.getMusicCount(music), is(1));
		assertThat(user.getMyMusic().size(), is(2));
		assertThat(user.isListened(music), is(true)); //music 노래를 들었는가? 
		
		user.addFavouriteMusic(music);
		assertThat(user.isAddedFavorite(music), is(true)); // 즐겨찾기 추가여부
		
		user.removeFavorite(music);
		assertThat(user.isAddedFavorite(music), is(false)); // 즐겨찾기 삭제 
	}
	
	@Test
	public void isListendRecently(){
		user.listenedMusic(music);
		user.listenedMusic(music2);
		user.listenedMusic(music);
		user.listenedMusic(music);
		
		assertThat(user.isListenRecently(music), is(true));
		assertThat(user.isListenRecently(music2), is(false));
	}
	
	@Test
	public void getExpectStandard(){
		assertThat(user.getExpectStandard(), is(1)); //처음 기준은 1
		
		user.takeRecommendMusic(music, 0);
		assertThat(user.getExpectStandard(), is(2)); //두번째 기준은 2
	}
	
	@Test
	public void takeRecommendMusic(){
		user.takeRecommendMusic(music, 1);
		user.takeRecommendMusic(music, 1);
		user.takeRecommendMusic(music, 2);
		user.takeRecommendMusic(music, 2);
		user.takeRecommendMusic(music, 1);
		user.takeRecommendMusic(music, 1);
		user.takeRecommendMusic(music, 1);
		user.takeRecommendMusic(music, 1);
		
		//계속 값이 달라져야 됨
		System.out.println(user.getExpectStandard());
	}
}
