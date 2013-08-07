package engine;

import java.util.ArrayList;
import java.util.Comparator;

import data.Music;
import data.User;

public class ColumnMusic implements Comparator<ColumnMusic> {

	private ArrayList<User> sameUser = new ArrayList<User>();
	private Music standardMusic; // 행 
	private Music compareMusic; // 열 
	private int sameUserCount;

	public void makeColumn(Music standardMusic, Music compareMusic) {
		this.sameUser  = standardMusic.compareUser(compareMusic); //두 유저간의 공통된 노래 리스트 
		this.sameUserCount = sameUser.size();
		this.standardMusic = standardMusic;
		this.compareMusic = compareMusic;
	}
	
	public Music getStandardMusic(){
		return standardMusic;
	}
	
	public Music getCompareMusic(){
		return compareMusic;
	}
	
	public ArrayList<User> getSameUser(){
		return sameUser;
	}
	
	public int getSameMusicCount(){
		return sameUserCount;
	}


	@Override
	public int compare(ColumnMusic o1, ColumnMusic o2) {
		return o2.sameUserCount - o1.sameUserCount;
	}

}
