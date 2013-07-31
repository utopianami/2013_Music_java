
public class Mumu {
	
	
	private Database database;	
	private Engine engine;	
	
	//생성자
	public Mumu() {
		database = new Database();
		engine = new Engine();
	}
	
	//test코드 접근
	public Database getDatabase(){
		return database;
	}
	public Engine getEngine(){
		return engine;
	}
	
	
	//database_Class 관련 
	/**
	 * createPlayer
	 * 목적 : 사용자 생성 
	 * 필요한 메소드 : Database Class_addPlayer
	 * @param name
	 */
	public void createPlayer(String name){
		database.addPlayer(name);
	}

	/**
	 * createSong
	 * 목적 : 음악 생성 
	 * 필요한 메소드 : Database Class_addSong
	 * @param songName, singer
	 */
	public void createSong(String songName, String singer){
		database.addSong(songName, singer);
	}
	
	/**
	 * linkedData
	 * 목적 : 들었던 song과 들은 player를 연결 
	 * 필요한 메소드 : Database Class_linkedData
	 * @param player, song
	 */
	public void linkedData(int playerIndex, int songIndex ){
		database.linkedData(playerIndex, songIndex);
	}
	
	//engine 관련
	/**
	 * makeMatrixPlayer
	 * 목적 : 이전 
	 */
	public void makeMatrixPlayer(){
		engine.makeMatrixPlayer(database);
	}

	public void makeMatrixSong(){
		engine.makeMatrixSong(database);
	}

}




