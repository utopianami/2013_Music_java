package com.mumu.data;

import java.util.HashMap;
import java.util.List;

public class TodayInfo {

	private HashMap<String, List<Music>> weather = new HashMap<String, List<Music>>(); 
	private String todayWeather;
	
	static public TodayInfo crate(){
		return new TodayInfo();
	}
	
	
	public void getTodayWeather(String weather) {
		todayWeather = weather;
	}
	
	public void listenedByWeather(Music music) {
		weather.get(todayWeather).add(music);
	}
}
