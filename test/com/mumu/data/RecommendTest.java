package com.mumu.data;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

public class RecommendTest {
	
	Recommend recommend;
	Music recommendMusic;
	Music recommendMusic2;
	User user;
	int standardNumber;
	int standardNumber2;
	
	@Before
	public void setUp(){
		recommend = Recommend.create();
		user = User.create(0, "younnam");

		recommendMusic = Music.create(0, "geek in the pink", "jason Mraz", "Mr.A-z");
		recommendMusic2 = Music.create(1, "speed of sound", "coldplay", "x&y");
		standardNumber = 1;
		standardNumber2 = 2;
	}

	@Test
	public void takeRecommendMusic() {
		recommend.takeRecommendMusic(recommendMusic, standardNumber);
		recommend.takeRecommendMusic(recommendMusic, standardNumber);
		
		assertThat(recommend.getFinishRecommendMusic(0), is(recommendMusic));
		assertThat(recommend.getFinishStandard(0), is(1));
		assertThat(recommend.getStandardMap(standardNumber), is(2));
	}
	
	@Test
	public void isOverRecommendLength(){
		recommend.takeRecommendMusic(recommendMusic, standardNumber);
		recommend.takeRecommendMusic(recommendMusic, standardNumber);
		recommend.takeRecommendMusic(recommendMusic, standardNumber);
		recommend.takeRecommendMusic(recommendMusic, standardNumber);
		recommend.takeRecommendMusic(recommendMusic, standardNumber);
		recommend.takeRecommendMusic(recommendMusic, standardNumber);
		recommend.takeRecommendMusic(recommendMusic, standardNumber);
		
		boolean actual = recommend.isOverRecommendLength();
		assertThat(actual, is(true));
	}
	
	@Test
	public void checkRecommendResult(){
		//2회 추천 
		recommend.takeRecommendMusic(recommendMusic, standardNumber);
		recommend.takeRecommendMusic(recommendMusic2, standardNumber2);
		
		//추천해준 노래가 좋다고  피드백
		user.addFavouriteMusic(recommendMusic); //추천성공 조건 1 : favourite추가 
		user.listenedMusic(recommendMusic2); //추천 성공 조건 2 : 최근 3회이상 듣기 
		user.listenedMusic(recommendMusic2);
		user.listenedMusic(recommendMusic2);
		recommend.checkRecommendResult(user); //추천 성공여부 확인 
		assertThat(recommend.getStandardMap(standardNumber), is(2));
		assertThat(recommend.getStandardMap(standardNumber2), is(2));
	}
	
	@Test
	public void getExpextStandard(){
		assertThat(recommend.getExpectStandard(), is(1));
		recommend.takeRecommendMusic(recommendMusic2, standardNumber2);
		assertThat(recommend.getExpectStandard(), is(2));
	}
	
	@Test
	public void checkProbability(){
		recommend.takeRecommendMusic(recommendMusic, standardNumber);
		recommend.takeRecommendMusic(recommendMusic2, standardNumber2);
		user.addFavouriteMusic(recommendMusic); //추천성공 조건 1 : favourite추가 
		recommend.checkRecommendResult(user); // 추천 성공 여부 확인 
		
		Double actual = recommend.checkProbability().get(standardNumber);
		System.out.println(actual);
	}
	
	@Test
	public void resetExpectStandard(){
		//checkProbabilty() 확률 조정 
		recommend.takeRecommendMusic(recommendMusic, standardNumber);
		recommend.takeRecommendMusic(recommendMusic2, standardNumber2);
		user.addFavouriteMusic(recommendMusic); //추천성공 조건 1 : favourite추가 
		recommend.checkRecommendResult(user); // 추천 성공 여부 확인 
		
		//조정된 확률을 토대로 추천할 기준 재설정  
		recommend.resetExpectStandard();
		recommend.reset(); // 모든 리스트 초기화 
		
		//결과 값이 랜덤하기 때문에 1 혹은 2가 번갈아가면서 나와야 함 
		System.out.println(recommend.getExpectStandard());
	}

}
