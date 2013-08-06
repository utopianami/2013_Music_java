package engine;

import java.util.ArrayList;

import data.Music;
import data.User;
public class Row {

	//matrixUser
	public ArrayList<ColumnUser> makeRowUser(User standardUser, 
			ArrayList<User> userList) {
		
		ArrayList<ColumnUser> rowList = new ArrayList<ColumnUser>();
		
		for (User compareUser : userList) {
			ColumnUser columnUser = new ColumnUser();
			columnUser.makeColumn(standardUser, compareUser);
			rowList.add(columnUser);
		}
		return rowList;
	}
	
	//matrixMusic 
	public ArrayList<ColumnMusic> makeRowMusic(Music standardMusic, 
			ArrayList<Music> musicList) {

		ArrayList<ColumnMusic> rowList = new ArrayList<ColumnMusic>();
		
		for (Music compareMusic : musicList) {
			ColumnMusic columnMusic = new ColumnMusic();
			columnMusic.makeColumn(standardMusic, compareMusic);
			rowList.add(columnMusic);
		}
		return rowList;
	}


}
