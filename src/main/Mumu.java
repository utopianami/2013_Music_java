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
	
	public  Music recommendByRecently(int index){
		return engine.recommendByRecently(db, index);
	}
	
}