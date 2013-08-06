package data;
import java.util.ArrayList;


public class Database {

	private int userIndex;
	private int musicIndex;
	private ArrayList<User> userList = new ArrayList<User>();
	private ArrayList<Music> musicList = new ArrayList<Music>();
	
	
	private static Database var = new Database();
	private Database(){
	};
	public static Database getInstance(){
		return var;
	}

	
	public void addUser(String name) {
		User newPlayer = User.create(userIndex, name);
		userList.add(newPlayer);
		userIndex++;
	}

	public void addMusic(String track, String artist, String album) {
		Music newMusic = Music.create(musicIndex, track, artist, album);
		musicList.add(newMusic);
		musicIndex++; 
	}
	
	public User findUser(int index){
		return userList.get(index);
	}

	public Music findMusic(int index){
		return musicList.get(index);
	}
	
	public ArrayList<User> getUserList() {
		return userList;
	}
	
	public ArrayList<Music> getMusicList() {
		return musicList;
	}
}
