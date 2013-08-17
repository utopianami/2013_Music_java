package engine;

import java.util.ArrayList;
import java.util.Collections;

import data.Database;
import data.Music;
import data.User;

public class Engine {
	private ArrayList<Row> userMatrix = new ArrayList<Row>();
	private ArrayList<Row> musicMatrix = new ArrayList<Row>();
	
	private static Engine var = new Engine();
	private Engine(){
	}
	public static Engine getInstance(){
		return var;
	}
	
	public Row getUserMatrix(int index){
		return userMatrix.get(index);
	}

	public Row getMusicMatrix(int index){
		return musicMatrix.get(index);
	}
	
	
	/*
	 * user 곱으로 user간의 관계를 나타내는 matrix 생성
	 * 0. 원리 : 행의 유저와 열의 유저간 공통된 노래 찾기 
	 * 1. rowUser 생성 : RowUser_Class에서 columnUser생성 후 리스트 저장 
	 * 2. columnUser 생성 : ColumnUser Class에서 같은 곡의 리스트. 수, 행, 열 저장 
	 */
	public void makeUserMatrix(Database db){
		ArrayList<User> userList = db.getUserList();
		
		for (User standardUser : userList) {
			Row row = new Row();
			row.makeRowUser(standardUser, userList);
			userMatrix.add(row);
		}
	}

	public void makeMusicMatrix(Database db){
		ArrayList<Music> musicList = db.getMusicList();
		
		for (Music standardMusic : musicList) {
			Row row = new Row();
			row.makeRowMusic(standardMusic, musicList);
			musicMatrix .add(row);
		}
	}

	//나와 유사한 사람 선정 
	public User relationUser(Database db, User standardUser) {
		makeMusicMatrix(db);
		int userIndex = standardUser.getUserIndex();
		Row sortRow = getUserMatrix(userIndex); //satnardUser와 다른 user간의 관계를 나타내는 Row 
		
		ColumnUser sortCompare = new ColumnUser();
		Collections.sort(sortRow.getRowUser(), sortCompare);
		
		User mostRelationUser = sortRow.getMostRelationUser();//자기 자신을 제외한 최상위 index 1 
		return mostRelationUser; 
	}
	
	//추천 기준1 : 나와 유사한 사람 -> 그 사람이 최근들은 곡
	//들었던 곡일 경우 다음 최근 재생목록의 곡 추천 
	public Music recommendMusic1(Database db, User standardUser){
		User mostRelationUser = relationUser(db, standardUser);	
		Music recommendMusic = mostRelationUser.getRecomendMusic1(standardUser);
	
		return recommendMusic;
	}
	
	//유사한 노래 선정 
	public Music relationMusic(Database db, Music standardMusic) {
		makeMusicMatrix(db);
		int musicIndex = standardMusic.getMusicIndex();
		Row sortRow = getMusicMatrix(musicIndex); //standardMusic과 다른 Musci간의 관계를 나타내는 Row
		
		ColumnMusic sortCompare = new ColumnMusic();
		Collections.sort(sortRow.getRowMusic(), sortCompare);
		
		Music mostRelationMusic = sortRow.getMostRelationMusic();  
		return mostRelationMusic;
	}
	
	//추천기준 2 : 최근에 들은 곡 -> 그 곡과 유사한 곡
	//들었던 곡일 경우 나의 다음 최신곡으로 추천 
	public Music recommnedMusic2(Database db, User user){
		Music recommendMusic = user.getRecomendMusic2(user, this, db);
		return recommendMusic;
	}
}
