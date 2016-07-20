import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class convertToIntTest {

	@Test
	public void convertToInttest() {
		MainPanel m= new MainPanel(15);
		int num = m.convertToInt(6);
		int testnum = 6;
		try{
			  assertEquals(num , testnum);
		  	} catch (NoSuchElementException nseex) {
				fail();
			}	
		}

	@Test
	public void convertToInttest2() {
		MainPanel m= new MainPanel(15);
		int num = m.convertToInt(8);
		int testnum = 8;
		try{
			  assertEquals(num , testnum);
		  	} catch (NoSuchElementException nseex) {
				fail();
			}	
		}
	
	@Test
	public void convertToInttest3() {
		MainPanel m= new MainPanel(15);
		int num = m.convertToInt(0);
		int testnum = 0;
		try{
			  assertEquals(num , testnum);
		  	} catch (NoSuchElementException nseex) {
				fail();
			}	
		}
}
