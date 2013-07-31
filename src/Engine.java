import java.util.ArrayList;


public class Engine {
	private ArrayList<ArrayList<ArrayList<Song>>> matrixPlayer = new ArrayList<ArrayList<ArrayList<Song>>>();
	private ArrayList<ArrayList<ArrayList<Player>>> matrixSong  = new ArrayList<ArrayList<ArrayList<Player>>>();
	
	/**
	 *makeMatrixPlayer
	 *목적 : player * player matrix 생성 
	 *필요한 메소드 : Database Class_findPlayer() index값에 위치한 player 반환   
	 *필요한 메소드 : Player Class_comparePlayer() 두 값을 비교해서 공통된 노래 리스트 반환
	 *@param db 인스턴스    
	 */
	public void makeMatrixPlayer(Database db){
		ArrayList<Player> playerList = db.getPlayerList();
		int row =0;
		
		for (Player player : playerList) {
			ArrayList<ArrayList<Song>> matrixRow = new ArrayList<ArrayList<Song>>(); //행 생성 
			matrixPlayer.add(matrixRow); //행 추가 
			
			for(Player target : playerList){
				ArrayList<Song> matrixColumn = player.comparePlayer(target); //행과 열 비교
				matrixPlayer.get(row).add(matrixColumn);
			}
			row++;
		}

	}

	
	/**
	 *makeMatrixPlayer
	 *목적 : (song * song) 생성 
	 *필요한 메소드 : Database Class_findSong() index값에 위치한 player 반환   
	 *필요한 메소드 : Song Class_compareSong () 두 값을 비교해서 공통된 사람 리스트 반환
	 *@param db 인스턴스    
	 */
	public void makeMatrixSong(Database db){
		int length = db.getSongListSize();
		
		for(int row = 0 ; row < length ; row++ ){
			ArrayList<ArrayList<Player>> matrixRow = new ArrayList<ArrayList<Player>>();
			matrixSong.add(matrixRow);
			Song origin = db.findSong(row);
			
			for(int colmun = 0 ; colmun < length ; colmun ++){
				Song target = db.findSong(colmun);
				ArrayList<Player> matrixColumn = origin.compareSong(target);
				matrixSong.get(row).add(matrixColumn);
			}
		}
	}
	


	//test코드 접근용 
	public ArrayList<ArrayList<ArrayList<Song>>> getMatrixPlayer(){
		return this.matrixPlayer;
	}
	
	public ArrayList<ArrayList<ArrayList<Player>>> getMatrixSong(){
		return this.matrixSong;
	}
	


}
