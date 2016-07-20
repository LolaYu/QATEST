import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;
import org.mockito.Mockito;
public class getNumNeighborsTest {
	
	
	// Set a cell itself alive and all it neighbors are dead. 
	@Test
	public void getNumNeighborstest() {
		MainPanel m = new MainPanel(15);
     	Cell[][] _cells= new Cell[15][15];
     	_cells[5][5] = new Cell(true);// cell itself is alive
     	_cells[4][4] = new Cell(false);
		_cells[4][5] = new Cell(false);
		_cells[4][6] = new Cell(false);
		_cells[5][4] = new Cell(false);
		_cells[5][6] = new Cell(false);
		_cells[6][4] = new Cell(false);
		_cells[6][5] = new Cell(false);
		_cells[6][6] = new Cell(false);
		
		int num = m.getNumNeighborsForTest(5, 5, _cells);
		int testnum = 0;
		try{
			  assertEquals(num , testnum);
		  	} catch (NoSuchElementException nseex) {
				fail();
			}	
		}
	
	  // Set a cell itself alive and all it neighbors are alive. 
	@Test
	public void getNumNeighborstest2() {
		MainPanel m = new MainPanel(15);
			
	     Cell[][] _cells= new Cell[15][15];
	     _cells[5][5] = new Cell(true);// cell itself is alive
	     _cells[4][4] = new Cell(true);
		 _cells[4][5] = new Cell(true);
		 _cells[4][6] = new Cell(true);
		 _cells[5][4] = new Cell(true);
		 _cells[5][6] = new Cell(true);
		 _cells[6][4] = new Cell(true);
		 _cells[6][5] = new Cell(true);
		 _cells[6][6] = new Cell(true);
		
		int num = m.getNumNeighborsForTest(5, 5, _cells);	
		int testnum = 8;
			
		try{
				  assertEquals(num , testnum);
			  	} catch (NoSuchElementException nseex) {
					fail();
				}	
			}
		
	 // Set a cell itself dead and three of it neighbors are alive. 
	@Test
	public void getNumNeighborstest3() {
		MainPanel m = new MainPanel(15);
			
	     Cell[][] _cells= new Cell[15][15];
	     _cells[5][5] = new Cell(false);// cell itself is alive
	     _cells[4][4] = new Cell(true);
		 _cells[4][5] = new Cell(true);
		 _cells[4][6] = new Cell(true);
		 _cells[5][4] = new Cell(false);
		 _cells[5][6] = new Cell(false);
		 _cells[6][4] = new Cell(false);
		 _cells[6][5] = new Cell(false);
		 _cells[6][6] = new Cell(false);
			
		int num = m.getNumNeighborsForTest(5, 5, _cells);	
		int testnum = 3;
			
		try{
				  assertEquals(num , testnum);
			  	} catch (NoSuchElementException nseex) {
					fail();
				}	
			}
}
