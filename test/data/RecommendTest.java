package data;

import com.mumu.data.Music;
import com.mumu.data.Recommend;

import junit.framework.TestCase;

public class RecommendTest extends TestCase {
	
	Recommend rem;
	
	public void setUp(){
		rem = Recommend.create();
	}

	public void testSetForwardRecommend() throws Exception {
		Music music1 = Music.create(1, "q", "1", "2") ;
		
		rem.addRecommendMusic(music1, 1);
		rem.addRecommendMusic(music1, 1);
		rem.addRecommendMusic(music1, 2);
		rem.addRecommendMusic(music1, 2);
		rem.addRecommendMusic(music1, 2);
		
		rem.setForwardRecommend();
		
		assertEquals(5, rem.getForwardRecommend().size());
	}

}
