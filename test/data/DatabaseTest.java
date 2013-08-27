package data;

import com.mumu.data.Database;

import junit.framework.TestCase;



public class DatabaseTest extends TestCase {
	Database db;
	
	
	public void setUp(){
		db = Database.getInstance();
	}
	
	public void testAddUser() throws Exception {
		db.addUser("YoungNam");
		assertEquals("YoungNam", db.findUser(0).getName());
	}
	
	public void testAddSong() throws Exception {
		db.addMusic("모아이", "서태지", "moai");
		assertEquals(0, db.findMusic(0).getMusicIndex());
	}
	
	public void testGetPlayerListSize() throws Exception {
		db.addUser("YoungNam");
		db.addUser("YoungNam");
		db.addUser("YoungNam");
		assertEquals(4, db.getUserList().size());
	}
	
	public void testGetSongListSize() throws Exception {
		db.addMusic("모아이", "서태지", "moai");
		db.addMusic("모아이", "서태지", "moai");
		db.addMusic("모아이", "서태지", "moai");
		assertEquals(4, db.getMusicList().size());
	}


	
}
