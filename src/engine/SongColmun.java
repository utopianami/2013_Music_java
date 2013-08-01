package engine;
import java.util.ArrayList;
import java.util.Comparator;

import data.Player;
import data.Song;

public class SongColmun implements Comparable<SongColmun> {
	private Song origin;
	private Song target;
	private int commonPlayerCount;
	private ArrayList<Player> commonPlayerList;
	
	
	
	private SongColmun(Song origin, Song target, ArrayList<Player> commonPlayerList ){
		this.origin = origin;
		this.target = target;
		this.commonPlayerCount = commonPlayerList.size();
		this.commonPlayerList = commonPlayerList;
	}
	
	private SongColmun(){
		String test;
	}
	
	public static SongColmun createSongColmun(Song origin, Song target, ArrayList<Player> playerList){
		return new SongColmun(origin, target, playerList);
	}
	public static SongColmun createSongColmunEmpty(){
		return new SongColmun();
	}

	public int getCommonPlayerCount() {
		return commonPlayerCount;
	}

	public  ArrayList<Player> getCommonPlayerList() {
		return commonPlayerList;
	}
	
	public Song getTarget(){
		return this.target;
	}
/*
	@Override
	public int compare(SongColmun o1, SongColmun o2) {
		int result = o1.getCommonPlayerCount().compareTo(o2.getCommonPlayerCount());
		return result;
	}
*/
	@Override
	public int compareTo(SongColmun o) {
		return this.getCommonPlayerCount() - o.getCommonPlayerCount();
	}
}
