package com.mumu.engine;

import java.util.ArrayList;

import com.mumu.data.Music;
import com.mumu.data.User;

public class Row {
	private ArrayList<ColumnUser> rowUser = new ArrayList<ColumnUser>();
	private ArrayList<ColumnMusic> rowMusic = new ArrayList<ColumnMusic>();

	
	public ArrayList<ColumnUser> getRowUser(){
		return rowUser;
	}

	public ArrayList<ColumnMusic> getRowMusic(){
		return rowMusic;
	}
	
	//matrixUser
	public void makeRowUser(User standardUser, 
			ArrayList<User> userList) {
		
		
		for (User compareUser : userList) {
			ColumnUser columnUser = new ColumnUser();
			columnUser.makeColumn(standardUser, compareUser);
			rowUser.add(columnUser);
		}
	}
	
	//matrixMusic 
	public void makeRowMusic(Music standardMusic, 
			ArrayList<Music> musicList) {

		
		for (Music compareMusic : musicList) {
			ColumnMusic columnMusic = new ColumnMusic();
			columnMusic.makeColumn(standardMusic, compareMusic);
			rowMusic.add(columnMusic);
		}
	}

	public Music getMostRelationMusic() {
		return rowMusic.get(1).getCompareMusic(); //자기 자신을 제외한 최상위 index 1
	}
	
	public User getMostRelationUser() {
		return rowUser.get(1).getCompareUser(); //자기 자신을 제외한 최상위 index 1
	}
	
	

}
