import java.util.ArrayList;
import java.util.HashMap;


public class Database {

	private int playerIndex;
	private int songIndex;
	private ArrayList<Player> playerList = new ArrayList<Player>();
	private ArrayList<Song> songList = new ArrayList<Song>();
	public HashMap<Integer, Song> relationSongMap;

	
	/**
	 * addPlayer
	 * 목적 : Player 객체를 생성하고, PlayerList에 Player를 추가 
	 * @param name
	 */
	public void addPlayer(String name) {
		playerList.add(new Player(playerIndex, name));
		playerIndex++; //생성할때마다 +1된 index부여
	}

	/**
	 * addSong
	 * 목적 : Song 객체를 생성하고, SongList에 Player를 추가 
	 * @param songName, singer
	 */
	public void addSong(String songName, String singer) {
		songList.add(new Song(songIndex, songName, singer));
		songIndex++;; //생성할때마다 +1된 index부여
	}
	
	/**
	 * findPlayer
	 * 목적 : index값으로 player를 확인
	 * 활용 : Database Class_makeMatrixPlayer()  
	 * @param 찾고자하는 player의 index
	 * @return player의 인스턴스 
	 */
	public Player findPlayer(int index){
		return playerList.get(index);
	}

	/**
	 * findSong
	 * 목적 : index값으로 Song를 확인 
	 * * 활용 : Database Class_makeMatrixSong()
	 * @param 찾고자하는 Song의 index
	 * @return Song의 인스턴스 
	 */
	public Song findSong(int index){
		return songList.get(index);
	}
	
	/**
	 * linkedData
	 * 목적 : player가 song을 들은 경우 각각의 리스트에 추가
	 * 필요한 메소드 : Player Class_listenedMusic() 역할 위임 
	 * @param : player, song
	 */
	public void linkedData(int playerIndex, int songIndex){
		Player player = this.findPlayer(playerIndex);
		Song song = this.findSong(songIndex);
		player.listenedMusic(song);
	}
	
	/**
	 * getPlayerList
	 * 활용 : Engine Class_MakeMatrixPlayer() 행과 열의 길이 
	 * @return playerList.size()
	 */
	public int getPlayerListSize() {
		return playerList.size();
	}
	
	/**
	 * getSongList
	 * 활용 : Engine Class_MakeMatrixSong() 행과 열의 길이 
	 * @return songList.size()
	 */
	public int getSongListSize() {
		return songList.size();
	}
	

	
	//test 코드 확인을 위한 리스트 접근 
	public ArrayList<Player> getPlayerList() {
		return this.playerList;
	}
	
	public ArrayList<Song> getSongList() {
		return this.songList;
	}

	public void setRelationSongMap(HashMap<Integer, Song> relationSong) {
		this.relationSongMap  = relationSong;
	}
}
