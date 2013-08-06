package engine;

import java.util.ArrayList;

import data.Database;
import data.Music;
import data.User;

public class Engine {
	private ArrayList<Row> matrixUser = new ArrayList<Row>();
	private ArrayList<Row> matrixMusic = new ArrayList<Row>();
	
	private static Engine var = new Engine();
	private Engine(){
	}
	public static Engine getInstance(){
		return var;
	}
	
	
	/*
	 * user 곱으로 user간의 관계를 나타내는 matrix 생성
	 * 0. 원리 : 행의 유저와 열의 유저간 공통된 노래 찾기 
	 * 1. rowUser 생성 : RowUser_Class에서 columnUser생성 후 리스트 저장 
	 * 2. columnUser 생성 : ColumnUser Class에서 같은 곡의 리스트. 수, 행, 열 저장 
	 */
	public void makeMatrixUser(Database db){
		ArrayList<User> userList = db.getUserList();
		
		for (User standardUser : userList) {
			Row row = new Row();
			row.makeRowUser(standardUser, userList);
			matrixUser.add(row);
		}
	}

	public void makeMatrixMusic(Database db){
		ArrayList<Music> musicList = db.getMusicList();
		
		for (Music standardMusic : musicList) {
			Row row = new Row();
			row.makeRowMusic(standardMusic, musicList);
			matrixMusic .add(row);
		}
	}
	

}
