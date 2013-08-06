package engine;

import data.Database;
import junit.framework.TestCase;


public class EngineTest extends TestCase {
	
	Database db;
	Engine engine;
	
	
	public void setUp(){
		engine = Engine.getInstance();
		db = Database.getInstance();
	}
	
	public void testCreate() throws Exception {
		
	}
	
}
