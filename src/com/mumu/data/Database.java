package com.mumu.data;
import java.util.ArrayList;
import java.util.List;


public class Database {

	private int userIndex;
	private int musicIndex;
	private List<User> userList = new ArrayList<User>();
	private List<Music> musicList = new ArrayList<Music>();
	private TodayInfo todayInfo = TodayInfo.crate();
	
	
	private static Database var = new Database();
	private Database(){
	};
	public static Database getInstance(){
		return var;
	}

	
	public void addUser(String name) {
		User newPlayer = User.create(userIndex, name);
		userList.add(newPlayer);
		userIndex++;
	}
	

	public void addMusic(String track, String artist, String album) {
		Music newMusic = Music.create(musicIndex, track, artist, album);
		musicList.add(newMusic);
		musicIndex++; 
	}
	
	public User findUser(int index){
		return userList.get(index);
	}

	public Music findMusic(int index){
		return musicList.get(index);
	}
	
	public List<User> getUserList() {
		return userList;
	}
	
	public List<Music> getMusicList() {
		return musicList;
	}
	public void listenedByWeather(Music music) {
		todayInfo.listenedByWeather(music);
		
	}
	
}
