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
			System.out.println("야호 ");
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
	public User relationUser(Database db, int index) {
		makeMusicMatrix(db);
		ArrayList<ColumnUser> filterList = getUserMatrix(index).getRowUser();
		
		ColumnUser sortCompare = new ColumnUser();
		Collections.sort(filterList, sortCompare);
		return filterList.get(1).getCompareUser(); //자기 자신을 제외한 최상위 index 1 
	}
	
	//추천 기준1 : 나와 유사한 사람 -> 그 사람이 최근들은 곡  
	public Music recommendByRecently(Database db, int index){
		User user = db.findUser(index);
		User mostRelationUser = relationUser(db, index);
		ArrayList<Music> recentlyPlayed = mostRelationUser.getRecentlyPlayed(5);
		Music recommendMusic = null;
		 
		for (Music guessMusic : recentlyPlayed) {
			if(user.isListened(guessMusic)){ //들었던 곡이라면 
				continue;
			}
			
			else{
				recommendMusic = guessMusic;
				break;
			}
		}
		return recommendMusic;
	}
}
