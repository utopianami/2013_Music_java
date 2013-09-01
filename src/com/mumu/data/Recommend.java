package com.mumu.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Recommend {
	
	private HashMap<Integer, Integer> standardMap = new HashMap<Integer, Integer>(); //기준들에 대한 값 정리
	private List<Integer> expectRecommend = new ArrayList<Integer>();//앞으로 추천할 리스트 만들기  
	private List<Integer> finishStandard = new ArrayList<Integer>();//추천받은 기준리스트 
	private List<Music> finishRecommendMusic = new ArrayList<Music>(); //추천받은 노래리스트
	private int totalRecommend; //총 추천한 횟수 + 추천 성공 수 
	
	public Recommend(){  
		startRecommend();
	}
	
	public static Recommend create(){
		return new Recommend();
	}
	
	public void startRecommend(){ //최초 추천 기준 설정
		expectRecommend.add(1);
		expectRecommend.add(2);
		expectRecommend.add(1);
		expectRecommend.add(2);
		expectRecommend.add(1);
		expectRecommend.add(2);
		expectRecommend.add(1);
	}
	
	public void takeRecommendMusic(Music recommendMusic, int standardNumber) {		
		finishRecommendMusic.add(recommendMusic);
		finishStandard.add(standardNumber);
		addStandardMap(standardNumber);
	}
	
	public Music getFinishRecommendMusic(int index){
		return finishRecommendMusic.get(index);
	}
	
	public int getFinishStandard(int index){
		return finishStandard.get(index);
	}
	
	public int getExpectStandard() {
		return expectRecommend.get(recommendTurn());
	}
	
	public int getStandardMap(int standardNumber){
		return standardMap.get(standardNumber);
	}

	private int recommendTurn() { // 추천 횟수 카운트(최대 7번)
		return finishRecommendMusic.size();
	}
	
	public boolean isOverRecommendLength() { //추천한 노래와 추천기준은 7개만 저장
		return recommendTurn() == 7;
	}
	

	public void reset(){
		finishRecommendMusic = new ArrayList<Music>();
		finishStandard = new ArrayList<Integer>();
	}
	
	private void addStandardMap(int standardNumber){
		if (standardMap.containsKey(standardNumber)){
			int newVar = standardMap.get(standardNumber) + 1;
			standardMap.put(standardNumber, newVar);
		}
		else{
			standardMap.put(standardNumber, 1);
		}
		totalRecommend++;
	}
	
	//추천에 대한 user의 반응에 따라 추천 확률 조정 
	public void checkRecommendResult(User user){
		for (int listTrun = 0 ; listTrun < recommendTurn(); listTrun++){
			if (isRecommendGood(listTrun, user)){ //노래 추천에 참이라면 
				int standardNumber = finishStandard.get(listTrun);
				addStandardMap(standardNumber); //기준에 대해서 점수1점 부여 
			}
		}
	}

	private boolean isRecommendGood(int listTurn, User user) {
		Music recommendMusic = finishRecommendMusic.get(listTurn);
		
		if(user.isListenRecently(recommendMusic)){ //최근 20번동 3번이상 들었는가? 
			return true;
		}
		
		if(user.isAddedFavorite(recommendMusic)){//좋아하는 곡에 추가했다면 
			return true;
		}
		return false;
	}
	
	

	public void resetExpectStandard() {
		expectRecommend = new ArrayList<Integer>();
		HashMap<Integer, Double> probabilityTable = checkProbability();

		for (int count = 0 ; count < recommendTurn() ; count ++) {
			double randomVar = Math.random();
			if (isFirstStandard(probabilityTable, randomVar)){
				expectRecommend.add(1);
			}
			
			if (isSecondStandard(probabilityTable, randomVar) ){
				expectRecommend.add(2);
			}		
		}
	}
	
	public HashMap<Integer, Double> checkProbability(){
		HashMap<Integer, Double> probabilityTable = new HashMap<Integer, Double>();
		
		for(Integer standardNumber : standardMap.keySet()){
			Double probability = (double) (standardMap.get(standardNumber))/(double)(totalRecommend);
			probabilityTable.put(standardNumber, probability);
		}
		
		return probabilityTable;
	}

	private boolean isSecondStandard(HashMap<Integer, Double> probabilityTable,
			double randomVar) {
		return randomVar > probabilityTable.get(1) && randomVar <= probabilityTable.get(1) + probabilityTable.get(2);
	}

	private boolean isFirstStandard(HashMap<Integer, Double> probabilityTable,
			double randomVar) {
		return randomVar <= probabilityTable.get(1);
	}

	public List<Music> getRecommendMusic() {
		return finishRecommendMusic;
	}



}
