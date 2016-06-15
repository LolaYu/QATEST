import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class CitySim9002Test {

	@Test
	// FUN-VISITOR. Each Visitor shall be of one of four types: a Student, a Professor, a Business Person, or a Blogger.
    // Mock a Choose class and mock visitor() method to return a list.
	// If list length == 4, this method is correct.
	public void testvisitortype() {
		CitySim9002 test= new CitySim9002();
		Choose mockarr= Mockito.mock(Choose.class);
		String[] list=mockarr.visitor();
		int n =list.length;
		assertEquals(4, n);
	}
	
	@Test
	// FUN-VISITOR. Each Visitor shall be of one of four types: a Student, a Professor, a Business Person, or a Blogger.
    // Mock a Choose class and mock visitor() method to return a list.
	// list length should not be 5.
	public void testvisitortype2() {
			CitySim9002 test= new CitySim9002();
			Choose mockarr= Mockito.mock(Choose.class);
			String[] list=mockarr.visitor();
			int n =list.length;
			assertFalse(5 ==n);
	}
	
	//FUN-FIRST-VISIT. For the first visit for a given Visitor, the Visitor cannot leave the City.  The Visitor must visit at least one Location.
	// The first visit for a given Visitor only concludes 4 choices
	//-"The Cathedral of Learning", "Squirrel Hill", "The Point", "Downtown" 
	// Mock a Choose class and mock firstplace() method to return a firstplace list.
	// If list length == 4, this method is correct.
	@Test
	public void testfirstplace() {
		CitySim9002 test= new CitySim9002();
		Choose mockarr= Mockito.mock(Choose.class);
		String[] list=mockarr.firstplace();
		int n =list.length;
		assertEquals(4, n);
	}
	
	//FUN-FIRST-VISIT. For the first visit for a given Visitor, the Visitor cannot leave the City.  The Visitor must visit at least one Location.
	//The first visit for a given Visitor only concludes 4 choices
	//-"The Cathedral of Learning", "Squirrel Hill", "The Point", "Downtown" 
	// Mock a Choose class and mock firstplace() method to return a firstplace list.
	// list length should not be 5.
	@Test
	public void testfirstplace2() {
		CitySim9002 test= new CitySim9002();
		Choose mockarr= Mockito.mock(Choose.class);
		String[] list=mockarr.firstplace();
		int n =list.length;
		assertFalse(5 ==n);
	}
	
	//FUN-ITERATIONS. For each iteration, the program shall randomly select a location for the visitor to visit. 
    //The choices specified in FUN-CITY-LOCS as well as the option to leave the City shall all have equal weight 
	//- that is, there is an equal chance that a visitor will have a 20% chance of visiting any location specified 
	//in FUN-CITY-LOCS and a 20% chance of leaving the City (except in cases covered under FUN-FIRST-VISIT).
	//The second to fifth visits for a given Visitor concludes 5 choices
	//-"The Cathedral of Learning", "Squirrel Hill", "The Point", "Downtown" ,"leave"
	// Mock a Choose class and mock otherplace() method to return a otherplace list.
	// If list length == 5, this method is correct.
	@Test
	public void testotherplace() {
		CitySim9002 test= new CitySim9002();
		Choose mockarr= Mockito.mock(Choose.class);
		String[] list=mockarr.otherplace();
		int n =list.length;
		assertEquals(5, n);
	}
	
	//FUN-ITERATIONS. For each iteration, the program shall randomly select a location for the visitor to visit. 
	//The choices specified in FUN-CITY-LOCS as well as the option to leave the City shall all have equal weight 
	//- that is, there is an equal chance that a visitor will have a 20% chance of visiting any location specified 
	//in FUN-CITY-LOCS and a 20% chance of leaving the City (except in cases covered under FUN-FIRST-VISIT).
	//The second to fifth visits for a given Visitor concludes 5 choices
	//-"The Cathedral of Learning", "Squirrel Hill", "The Point", "Downtown" ,"leave"
	// Mock a Choose class and mock otherplace() method to return a otherplace list.
	// list length should not be 4.
	@Test
	public void testotherplace2() {
		CitySim9002 test= new CitySim9002();
		Choose mockarr= Mockito.mock(Choose.class);
		String[] list=mockarr.otherplace();
		int n =list.length;
		assertFalse(4== n);
	}
	
	//FUN-PREFERENCES. A Student shall like Squirrel Hill, Downtown, and The Point, and dislike The Cathedral of Learning. 
	//A Business Person shall like Squirrel Hill and Downtown, and dislike all other locations.
	//A Professor shall like all locations.  
	//A Blogger shall dislike all locations.
	//In this test, visitor type is "student" and place is "The Cathedral of Learning".
    // Student should dislike this place.
	@Test
	public void testpreference() {
		CitySim9002 test= new CitySim9002();
		String visitor="Student";
		String place="The Cathedral of Learning";
		boolean like=test.preference(visitor, place);
		assertFalse(like== true);
	}
	
	//FUN-PREFERENCES. A Student shall like Squirrel Hill, Downtown, and The Point, and dislike The Cathedral of Learning. 
	//A Business Person shall like Squirrel Hill and Downtown, and dislike all other locations.
	//A Professor shall like all locations.  
	//A Blogger shall dislike all locations.
	//In this test, visitor type is "Professor"and place is "The Cathedral of Learning".
    // Professor should like this place.
	
	@Test
	public void testpreference2() {
		CitySim9002 test= new CitySim9002();
		String visitor="Professor";
		String place="The Cathedral of Learning";
		boolean like=test.preference(visitor, place);
		assertTrue(like== true);
	}

}
