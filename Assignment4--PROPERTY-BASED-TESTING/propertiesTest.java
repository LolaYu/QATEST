import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.NoSuchElementException;
import org.junit.Test;

public class propertiesTest {

    
   // Property 1
   // If the input array has n elements, then the output array should 
   // have n+1 elements.
	
	@Test
	public void ElementsNumTest() {
		for ( int i= 0; i< 200; i ++){
		  properties a = new properties();
		  int[] originalarr = a.randomarr();
		  int elenum = originalarr.length;
		  int[] newarr = a.billify(originalarr);
		  int elenum2 = newarr.length;
		  System.out.println(" -> "+ Arrays.toString(newarr));
		  try{
			  assertEquals(elenum+1 , elenum2);
		  	} catch (NoSuchElementException nseex) {
				fail();
			}	
		}
	}	

	// Property 2	
	// The function is pure; running it two times on the same
	// input array should always produce the same output array.
	
	@Test
	public void PureFunctionTest() {
		for ( int i= 0; i< 200; i ++){
			properties a = new properties();
			properties b = new properties();
		
			int[] originalarr = a.randomarr();
			//Create a same original array and name it as originalarr2	
			int[] originalarr2 = new int[originalarr.length];
			for ( int j = 0; j < originalarr2.length; j++ ) {
				originalarr2[j] = originalarr[j];
			}
	
			int[] newarr = a.billify(originalarr);
			int[] newarr2 = b.billify(originalarr2);
		
			try{
				assertTrue(Arrays.equals(newarr, newarr2));
			} catch (NoSuchElementException nseex) {
				fail();
			}	
		}	
	}
	
	// Property 3
	// If the input array has n elements, then the first n elements of output array should 
	// equal the square of first n elements of input array
	
	@Test
	public void SquareElementTest() {
		for ( int i= 0; i< 200; i ++){
			properties a = new properties();
		
			int[] originalarr = a.randomarr();
			int[] originalarr2 = new int[originalarr.length];
			for ( int j = 0; j < originalarr2.length; j++ ) {
				originalarr2[j] = originalarr[j];
			}
			
			int[] newarr = a.billify(originalarr);
				for (int m = 0; m< originalarr2.length; m++ ){
					try{
						int originalelem = originalarr2[m];
						int newelem = newarr[m];
						assertEquals(originalelem *originalelem, newelem);
					} catch (NoSuchElementException nseex) {
						fail();
					}	
				}
		}
	}
}
	
