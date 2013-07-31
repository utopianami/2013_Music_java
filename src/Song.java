import java.util.ArrayList;


public class Song {

	private int index;
	private String songName;
	private ArrayList<Player> playerList = new ArrayList<Player>();
	private ArrayList<Song> relationSongList = new ArrayList<Song>();
	private String singer;

	//생성자 
	public Song(int index, String songName, String singer) {
		this.index = index;
		this.songName = songName;
		this.singer = singer;

	}
	
	/**
	 * playerList
	 * 목적 : 노래를 들은 사람들을 추가 
	 */
	public void playerList(Player player) {
		this.playerList.add(player);
	}

	/**
	 * getSongName
	 * @return this.songName 노래 제목 반환 
	 */
	public String getSongName() {
		return this.songName;
	}

	/**
	 * getIndex
	 * @return this.index 노래의 index값 반환 
	 */
	public int getIndex() {
		return this.index;
	}
	
	/**
	 * getSinger
	 * @return this.singer 노래의 가수 반환 
	 */
	public String getSinger(){
		return this.singer;
	}

	/**
	 * compareSong
	 * 목적 : this와 target을 공통적으로 들은 사람의 수 
	 * 활용 : Engine Class_makeMatrixSong의 각 열의 값
	 * 필요한 메소드 : Song Class_isListened() 들었던 곡인지 확인 
	 * @param target 비교하교자 하는 대상 
	 * @return sameList 같은 사람(객체)을 저장한 리스트 반환 
	 */
	public ArrayList<Player> compareSong(Song target) {
		ArrayList<Player> sameList = new ArrayList<Player>();
		
		for (Player player : playerList) {
			if(target.isListened(player)){
				sameList.add(player);
			}
		}
		return sameList;
		
	}
	
	/**
	 * isListened 
	 * 목적 : 들었던 곡인지 확인 (포함되어 있는지 확인, contains)
	 * 활용 : Song Class_compareSong() 
	 * @param Player
	 * @return true or false
	 */
	private boolean isListened(Player player) {
		return this.playerList.contains(player);
	}
	
	/**
	 * addRelation
	 * 목적 : 나와 유사한 song들을 relationSong리스트에 추가
	 * @param song
	 */
	public void addRelationSong(Song song){
		this.relationSongList.add(song);
	}
	
	
	//테스트 코드를 위해서 
	public ArrayList<Song> getRealationSong(){
		return this.relationSongList;
	}

}
