package com.mumu.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mumu.engine.Engine;

public class User {

	private int userIndex;
	private String name;
	private UserHistory userHistory;
	private Recommend recommend;
	
	
	private User(int index, String name) {
		this.userIndex = index;
		this.name = name;
		this.userHistory = UserHistory.create();
		this.recommend = Recommend.create();
	}
	
	public static User create(int index, String name){
		return new User(index, name);
	}

	public String getName() {
		return this.name;
	}
	
	public int getUserIndex() {
		return this.userIndex;
	}
	
	//노래를 듣게 되면 History관리를  userHistory Class에 위임 
	public void listenedMusic(Music music){
		userHistory.listenedMusic(music, this);
	}

	public void addFavouriteMusic(Music music){
		userHistory.addFavouriteMusic(music);
	}
	
	public void removeFavorite(Music music) {
		userHistory.removeFavouriteMusic(music);
	}
	
	public boolean isAddedFavorite(Music music) {
		if (userHistory.isAlreadyAdded(music)){
			return true;
		}
		return false;
	}
	
	public boolean isListened(Music music){
		return !userHistory.firstListend(music);
	}
	
	//userHistory Data에 접근 
	public List<Music> getMyMusic(){
		return userHistory.getMyMusic();
	}
	
	public List<Music> getRecentlyPlayed(int range){
		return userHistory.getRecentlyPlayed(range);
	}
	
	public Set<Music> getFavouriteMusic(){
		return userHistory.getFavouriteMusic();
	}
	
	public int getMusicCount(Music music){
		return userHistory.getMusicCount(music);
	}
	
	//recommend에 접근
	public void takeRecommendMusic(Music recommendMusic, int standardNumber) {
		if (recommend.isOverRecommendLength()){ //추천을 7번 해줬다면 
			recommend.checkRecommendResult(this); //이전 추천에 대한 결과확인 
			recommend.resetExpectStandard(); // 기준 재설정 
			recommend.reset(); //추천받은 기준 리스트 + 추천해준 노래 리스트 초기화(0)
		}
		recommend.takeRecommendMusic(recommendMusic, standardNumber);
	}
	
	public int getExpectStandard() {
		return recommend.getExpectStandard();
	}
	
	public boolean isListenRecently(Music music) {
		List<Music> recentlyPlayed = new ArrayList<Music>();
		
		if (isBeginnerUser()){ // 초보유저(이때까지 재생한 곡이 20곡 이하)라면 노래재생 목록을 그대로 사용 
			recentlyPlayed = userHistory.getPlayHistory();
		}
		else{
			recentlyPlayed = getRecentlyPlayed(20);
		}
		
		int playCount = getCountRecently(recentlyPlayed, music);
		if( playCount >=3 ){
			return true;
		}

		return false;
	}
	
	private boolean isBeginnerUser() {
		return userHistory.getPlayHistory().size() < 20;
	}

	private int getCountRecently(List<Music> recentlyPlayed,
			Music music) {
		int playCount = 0;
		
		for (Music playMusic: recentlyPlayed){//최근 20번동안 들은 곡
			if (music == playMusic){
				playCount++;
			}
		}
		
		return playCount;
	}

	//engine
	public ArrayList<Music> compareMusic(User compareUser) {
		ArrayList<Music> sameMusic = new ArrayList<Music>();
		
		for (Music music : compareUser.getMyMusic()) {
			if(this.isListened(music)){
				sameMusic.add(music);
			}
		}
		return sameMusic;
	}
	
	public Music getRecomendMusic1(User standardUser) {
		Music recommendMusic = null;
		
		for (Music guessMusic : getRecentlyPlayed(5)) {
			if(!standardUser.isListened(guessMusic)){ //들었던 곡이 아니라면 
				recommendMusic = guessMusic;
				break;
			}
		}
		return recommendMusic;
	}

	public Music getRecomendMusic2(User user, Engine engine, Database db) {
		Music recommendMusic = null;
		for (Music music : user.getRecentlyPlayed(5)) {
			Music mostRelationMusic = engine.relationMusic(db, music);
			
			if(!user.isListened(mostRelationMusic)){
				recommendMusic = mostRelationMusic;
				break;
			}
		}
		return recommendMusic;
	}


}