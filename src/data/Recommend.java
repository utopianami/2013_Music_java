package data;

import java.util.ArrayList;
import java.util.HashMap;

public class Recommend {
	
	private HashMap<Integer, Integer> standardMap = new HashMap<Integer, Integer>();
	private ArrayList<Integer> forwardRecommend = new ArrayList<Integer>();//앞으로 추천할 리스트 만들기  
	private ArrayList<Integer> recommendStandardList = new ArrayList<Integer>();//노래 추천 기준 리스트 
	private ArrayList<Music> recommendMusicList = new ArrayList<Music>(); //최근에 추천한 노래리스트
	int totalRecommend;
	int recommendNumber;
	
	public static Recommend create(){
		return new Recommend();
	}
	
	public ArrayList<Integer> getForwardRecommend(){
		return forwardRecommend;
	}
	
	public void addRecommendMusic(Music recommendMusic, int standardNumber) {		
		recommendMusicList.add(recommendMusic);
		recommendStandardList.add(standardNumber);
		addRecommendStandard(standardNumber);

	}

	public boolean isOverRecommendLength() { //추천한 노래와 추천기준은 7개만 저장
		return recommendNumber == 7;
	}
	
	public void reset(){
		recommendNumber = 0;
		recommendMusicList = new ArrayList<Music>();
		recommendStandardList = new ArrayList<Integer>();
	}
	
	private void addRecommendStandard(int standardNumber){
		if (standardMap.containsKey(standardNumber)){
			int newVar = standardMap.get(standardNumber) + 1;
			standardMap.put(standardNumber, newVar);
		}
		else{
			standardMap.put(standardNumber, 1);
		}
		recommendNumber++;
		totalRecommend++;
	}
	
	//추천에 대한 user의 반응에 따라 추천 확률 조정 
	public void setStandardMap(ArrayList<Music> favouriteMusic, ArrayList<Music> recentlyPlayed){
		for (int listNumber = 0 ; listNumber < recommendNumber; listNumber++){
			if (isCheckRecoomendMusic(listNumber, favouriteMusic, recentlyPlayed)){ //노래 추천에 참이라면 
				int standardNumber = recommendStandardList.get(listNumber);
				addRecommendStandard(standardNumber);
			}
		}
		setForwardRecommend();//추천 기준 리스트 새롭게 구성 
	}

	private boolean isCheckRecoomendMusic(int listNumber, ArrayList<Music> favouriteMusic, ArrayList<Music> recentlyPlayed) {
		Music recommendMusic = recommendMusicList.get(listNumber);
		if(isRecentlyPlayed(recommendMusic, recentlyPlayed)){ //최근 20번동 3번이상 들었는가? 
			return true;
		}
		
		if(isAddedFavorite(recommendMusic, favouriteMusic)){//좋아하는 곡에 추가했다면 
			return true;
		}
		
		return false;
	}

	private boolean isAddedFavorite(Music recommendMusic, ArrayList<Music> favouriteMusic) {// 좋아하는 노래에 등록여부 
		return favouriteMusic.contains(recommendMusic);
	}

	private boolean isRecentlyPlayed(Music recommendMusic, ArrayList<Music> recentlyPlayed) {
		int playCount = 0;
		for (Music playMusic: recentlyPlayed){//최근 20번동안 들은 곡
			if (recommendMusic == playMusic){
				playCount++;
			}
		}
		if (playCount >= 3){
			return true;
		}
		return false;
	}
	
	public void setForwardRecommend(){
		forwardRecommend = new ArrayList<Integer>();
		HashMap<Integer, Double> statsTable = new HashMap<Integer, Double>();
		
		for(Integer standardNumber : standardMap.keySet()){
			Double stats = (double) (standardMap.get(standardNumber))/(double)(totalRecommend);
			System.out.println(stats);
			statsTable.put(standardNumber, stats);
		}
		addForwardRecommend(statsTable);
	}

	private void addForwardRecommend(HashMap<Integer, Double> statsTable) {
		double a = 3/5;
		System.out.println(a);
		for (int count = 0 ; count < recommendNumber ; count ++) {
			double randomVar = Math.random();
			System.out.println(randomVar);
			if (isFirstStandard(statsTable, randomVar)){
				forwardRecommend.add(1);
			}
			
			if ( isSecondStandard(statsTable, randomVar) ){
				forwardRecommend.add(2);
			}		
		}
	}

	private boolean isSecondStandard(HashMap<Integer, Double> statsTable,
			double randomVar) {
		return randomVar > statsTable.get(1) && randomVar <= statsTable.get(1) + statsTable.get(2);
	}

	private boolean isFirstStandard(HashMap<Integer, Double> statsTable,
			double randomVar) {
		return randomVar <= statsTable.get(1);
	}

}
