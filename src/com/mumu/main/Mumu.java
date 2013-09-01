package com.mumu.main;

import com.mumu.data.Database;
import com.mumu.data.Music;
import com.mumu.data.User;
import com.mumu.engine.Engine;
import com.mumu.engine.EngineVer1;

public class Mumu {
	
	
	private static Mumu var = new Mumu();
	private Mumu(){
	}
	public static Mumu getInstance(){
		return var;
	}
	
	//engine, db 생성 
	Engine engine = EngineVer1.getInstance();
	Database db = Database.getInstance();
	

	//사용자 시나리오 
	public void addUser(String name){
		db.addUser(name);
	}
	
	public void addMusic(String track, String artist, String album){
		db.addMusic(track, artist, album);
	}
	
	public void listenedMusic(int userIndex, int musicIndex){
		User user = db.findUser(userIndex);
		Music music = db.findMusic(musicIndex);
		listenedMusic(user, music);
	}
	
	public User findUser(int userIndex){
		return db.findUser(userIndex);
	}
	public Music findMusic(int musicIndex){
		return db.findMusic(musicIndex);
	}
	
	private void listenedMusic(User user, Music music){
		user.listenedMusic(music);
	}
	
	public void addFavorite(User user, Music music){
		user.addFavouriteMusic(music);
	}
	
	public void removeFavorite(User user, Music music){
		user.removeFavorite(music);
	}
	
	//matrix생성 
	public void refreshMatrix(){
		engine.makeMusicMatrix(db);
		engine.makeUserMatrix(db);
	}
	
	//노래추천 
	public void recommendMusic(User standardUser){
		int standardNumber = standardUser.getExpectStandard();
		
		Music recommendMusic = engine.recommendMusic(standardNumber, db, standardUser);
		standardUser.takeRecommendMusic(recommendMusic, standardNumber);
	}
}

