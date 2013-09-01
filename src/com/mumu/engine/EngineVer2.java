package com.mumu.engine;

import com.mumu.data.Database;
import com.mumu.data.Music;
import com.mumu.data.User;

public class EngineVer2 implements Engine {
	
	private Matrix matrix = Matrix.create();

	@Override
	public void makeUserMatrix(Database db) {
		matrix.makeUserMatrix(db);
	}

	@Override
	public void makeMusicMatrix(Database db) {
		matrix.makeMusicMatrix(db);
		
	}

	
	
	//추천방법 : 오늘의 날씨정보를 받는다 -> 날씨에서 가장 많이 들었던 곡 리스트업 -> 듣지 않은 곡 추천 
	@Override
	public Music recommendMusic(int standardNumber, Database db,
			User standardUser) {
		return null;
	}

}
