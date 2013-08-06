package engine;

import java.util.ArrayList;

import data.Music;
import data.User;

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

}
