package engine;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import data.Database;
import data.Player;
import data.Song;


public class Engine {
	private ArrayList<ArrayList<ArrayList<Song>>> matrixPlayer = new ArrayList<ArrayList<ArrayList<Song>>>();
	private ArrayList<ArrayList<SongColmun>> matrixSong  = new ArrayList<ArrayList<SongColmun>>();
	
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
	 *필요한 메소드 : SongColmun Class_createSongColmun() 열 객체 생성 
	 *@param db 인스턴스    
	 */
	public void makeMatrixSong(Database db){
		int length = db.getSongListSize();
		
		for(int row = 0 ; row < length ; row++ ){
			ArrayList<SongColmun> matrixRow = new ArrayList<SongColmun>();
			matrixSong.add(matrixRow);
			Song origin = db.findSong(row);
			
			for(int colmun = 0 ; colmun < length ; colmun ++){
				Song target = db.findSong(colmun);
				SongColmun matrixColmun = origin.compareSong(origin, target);
				matrixSong.get(row).add(matrixColmun);
			}
		}
	}
	
	/**
	 * getRelationSong
	 * 목적 : 유사한  노래 3곡 뽑기 
	 * @return
	 */
	public void getRelationSong(int songIndex){
		ArrayList<SongColmun> rowList = matrixSong.get(songIndex);

		Collections.sort(rowList); 
	}
	


	//test코드 접근용 
	public ArrayList<ArrayList<ArrayList<Song>>> getMatrixPlayer(){
		return this.matrixPlayer;
	}
	
	public ArrayList<ArrayList<SongColmun>> getMatrixSong(){
		return this.matrixSong;
	}
	


}
