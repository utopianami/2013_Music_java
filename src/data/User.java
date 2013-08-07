package data;

import java.util.ArrayList;

import engine.Engine;

public class User {

	private int userIndex;
	private String name;
	private UserHistory userHistory;
	
	
	private User(int index, String name) {
		this.userIndex = index;
		this.name = name;
		this.userHistory = UserHistory.create();
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
	
	public boolean isListened(Music music){
		return !userHistory.firstListend(music);
	}
	
	//userHistory Data에 접근 
	public ArrayList<Music> getMyMusic(){
		return userHistory.getMyMusic();
	}
	
	public ArrayList<Music> getRecentlyPlayed(int range){
		return userHistory.getRecentlyPlayed(range);
	}
	
	public ArrayList<Music> getFavouriteMusic(){
		return userHistory.getFavouriteMusic();
	}
	
	public int getMusicCount(Music music){
		return userHistory.getMusicCount(music);
	}

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
			if(!standardUser.isListened(guessMusic)){ //들었던 곡이라면 
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