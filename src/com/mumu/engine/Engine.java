package com.mumu.engine;

import com.mumu.data.Database;
import com.mumu.data.Music;
import com.mumu.data.User;

public interface Engine {
	
	Matrix matrix = Matrix.create();
	
	public void makeUserMatrix(Database db);
	public void makeMusicMatrix(Database db);
	public Music recommendMusic(int standardNumber, Database db, User standardUser);
	public Music recommendMusic1(Database db, User standardUser);
	public Music recommnedMusic2(Database db, User standardUser);

}
