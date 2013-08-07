package main;

import data.Database;
import data.Music;
import data.User;
import engine.Engine;

public class Mumu {
	
	
	private static Mumu var = new Mumu();
	private Mumu(){
	}
	public static Mumu getInstance(){
		return var;
	}
	
	//engine, db 생성 
	Engine engine = Engine.getInstance();
	Database db = Database.getInstance();
	
	
	//사용자 시나리오 
	public void createUser(String name){
		db.addUser(name);
	}
	
	public void createMusic(String track, String artist, String album){
		db.addMusic(track, artist, album);
	}
	
	public void listenedMusic(User user, Music music){
		user.listenedMusic(music);
	}
	
	public void addFavorite(User user, Music music){
		user.addFavouriteMusic(music);
	}
	
	//추천 기준1 : 나와 유사한 사람 -> 그 사람이 최근들은 곡
	//들었던 곡일 경우 다음 최근 재생목록의 곡 추천 
	public  Music recommendMusic(int userIndex){
		User standardUser = db.findUser(userIndex);
		return engine.recommendMusic1(db, standardUser);
	}
	
	//추천기준 2 : 최근에 들은 곡 -> 그 곡과 유사한 곡
	//들었던 곡일 경우 나의 다음 최신곡으로 추천 
	public Music recommendMusic2(int userIndex){
		User standardUser = db.findUser(userIndex);
		return engine.recommnedMusic2(db, standardUser);
	}
	
	
}