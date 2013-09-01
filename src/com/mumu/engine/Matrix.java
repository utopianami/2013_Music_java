package com.mumu.engine;

import java.util.ArrayList;
import java.util.List;

import com.mumu.data.Database;
import com.mumu.data.Music;
import com.mumu.data.User;

public class Matrix {
	
	private ArrayList<Row> userMatrix = new ArrayList<Row>();
	private ArrayList<Row> musicMatrix = new ArrayList<Row>();

	public static Matrix create() {
		return new Matrix();
	}
	
	public Row getUserMatrix(int index){
		return userMatrix.get(index);
	}

	public Row getMusicMatrix(int index){
		return musicMatrix.get(index);
	}
	
	public User relationUser(int userIndex){
		return userMatrix.get(userIndex).getMostRelationUser();
	}
	
	public Music relationMusic(int musicIndex){
		return musicMatrix.get(musicIndex).getMostRelationMusic();
	}

	/*
	 * user 곱으로 user간의 관계를 나타내는 matrix 생성
	 * 0. 원리 : 행의 유저와 열의 유저간 공통된 노래 찾기 
	 * 1. rowUser 생성 : RowUser_Class에서 columnUser생성 후 리스트 저장 
	 * 2. columnUser 생성 : ColumnUser Class에서 같은 곡의 리스트. 수, 행, 열 저장 
	 */
	public void makeUserMatrix(Database db) {
		List<User> userList = db.getUserList();
		
		for (User standardUser : userList) {
			Row row = new Row();
			row.makeRowUser(standardUser, userList);
			userMatrix.add(row);
		}
	}
	
	public void makeMusicMatrix(Database db){
		List<Music> musicList = db.getMusicList();
		
		for (Music standardMusic : musicList) {
			Row row = new Row();
			row.makeRowMusic(standardMusic, musicList);
			musicMatrix .add(row);
		}
	}

}
