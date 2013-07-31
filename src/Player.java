import java.util.ArrayList;

public class Player {

	private int index;
	private String name;
	public ArrayList<Song> myMusicList = new ArrayList<Song>();

	public Player(int index, String name) {
		this.index = index;
		this.name = name;

	}

	/**
	 * getName
	 * @return this.name Player의 이름을 반환 
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * getIndex
	 * @return this.index
	 */
	public int getIndex() {
		return this.index;
	}

	
	/**
	 * listenedMusic
	 * 목적 : 들었던 노래를 추가 
	 * 활용 : Song Class_playerList() 노래를 추가하면서 동시에 노래에도 들었던 사람리스트에 추가 
	 * @param song : 들었던 노래
	 */
	public void listenedMusic(Song song) {
		myMusicList.add(song); 
		song.playerList(this);
	}


	/**
	 * comparePlayer 
	 * 목적 : 두 대상간 공통된 노래 확인 
	 * 활용 : Engine Class_makeMatrixPlayer()
	 * 필요한 메소드 : Player Class_isListened()
	 * @param target 비교하교자 하는 대상 
	 * @return 공통된 노래를 저장한 리스트 반환 
	 */
	public ArrayList<Song> comparePlayer(Player target) {
		ArrayList<Song> sameList = new ArrayList<Song>();
		
		for (Song song : myMusicList) {
			if(target.isListened(song)){
				sameList.add(song);
			}
		}
		return sameList;
	}
			
	/**
	 * isListened
	 * 활용 : Player_comparePlayer() 들었던 노래 리스트에 노래가 있는지 확인 
	 * @param song
	 * @return true or false
	 */
	private boolean isListened(Song song) {
		return this.myMusicList.contains(song);
	}

}