package data;

import java.util.ArrayList;

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
	

}