package com.mumu.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserHistory {
	
	private List<Music> MyMusic = new ArrayList<Music>();
	private Set<Music> favouriteMusic = new HashSet<Music>();
	private List<Music> playHistory = new ArrayList<Music>();
	private HashMap<Music, Integer> musicCount = new HashMap<Music, Integer>();
		
	public static UserHistory create() {
		return new UserHistory();
	}
		
	//user class 데이터 전송 
	public List<Music> getMyMusic() {
		return MyMusic;
	}
	
	public int getMusicCount(Music music){
		return musicCount.get(music);
	}
	
	public Set<Music> getFavouriteMusic(){
		return favouriteMusic;
	}
	
	public List<Music> getPlayHistory(){
		return playHistory;
	}
	
	//range 범위만큼 최신곡 리스트 전달 
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
	

	public void removeFavouriteMusic(Music music) {
		favouriteMusic.remove(music);
	}


	public boolean isAlreadyAdded(Music music) {
		return favouriteMusic.contains(music);
	}

}
