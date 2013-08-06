package data;

import java.util.ArrayList;
import java.util.HashMap;

public class UserHistory {
	
	private ArrayList<Music> MyMusic = new ArrayList<Music>();
	private ArrayList<Music> favouriteMusic = new ArrayList<Music>();
	private ArrayList<Music> playHistory = new ArrayList<Music>();
	private HashMap<Music, Integer> musicCount = new HashMap<Music, Integer>(); 
	
		
	public static UserHistory create() {
		return new UserHistory();
	}
			
	public ArrayList<Music> getMyMusic() {
		return MyMusic;
	}
	
	public int getMusicCount(Music music){
		return musicCount.get(music);
	}
	
	public ArrayList<Music> getFavouriteMusic (){
		return favouriteMusic;
	}
	
	public ArrayList<Music> getRecentlyPlayed(int range){
		ArrayList<Music> recentlyPlayed = new ArrayList<Music>();
		
		int mostPlayedIndex = playHistory.size() - 1;
		int leastPlayedIndex = mostPlayedIndex - range; 
		
		for (int index = mostPlayedIndex ; index > leastPlayedIndex ; index--){
			Music recentlyMusic = playHistory.get(index);
			recentlyPlayed.add(recentlyMusic);
		}
		return recentlyPlayed;
	}

	public void listenedMusic(Music music, User user) {
		playHistory.add(music);
		addMusicCount(music);
		
		if (firstListend(music)){
			MyMusic.add(music);
			music.addUserList(user);
		}
	}


	public boolean firstListend(Music music) {
		return !MyMusic.contains(music);
	}

	private void addMusicCount(Music music) {
		if (firstListend(music)){
			musicCount.put(music, 1);
		}
		else{
			int newCount = musicCount.get(music)+1;
			musicCount.put(music, newCount);
		}
	}

	public void addFavouriteMusic(Music music){
		if(isAlreadyAdded(music)){
			System.out.println("이미 등록되어 있습니다 ");
		}
		else{
			favouriteMusic.add(music);
		}
	}

	private boolean isAlreadyAdded(Music music) {
		return favouriteMusic.contains(music);
	}


}
