import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;

public class HerokuappTest {
static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for herokuapp for each test
	@Before
	public void setUp() throws Exception {
		driver.get("http://lit-bayou-7912.herokuapp.com/");
	}
	
	
    
	/** First user story
	   As a user
	   I want to see the main page of herokuapp
	   So that I can start using this page.
	*/
   
	// Scenario 1
	// Given that I am on the main page
	// When I view the title
	// Then I see that it contains the word "Hoodpopper"
	
	@Test
	public void testShowsCorrectTitle() {
		
		// Simply check that the title contains the word "Hoodpopper"
		
		String title = driver.getTitle();
		assertTrue(title.contains("Hoodpopper"));
	}
	
	
	// Scenario 2
	// Given that I am on the main page
	// When I view the page
	// Then I should see that a code textbox appears
	
	@Test 
	public void testShowTextArea(){
		try{
			WebElement textarea=driver.findElement(By.id("code_code"));
			assertNotNull(textarea);
			} catch (NoSuchElementException nseex) {
				fail();
			}		
	}
	
	
	// Scenario 3
	// Given that I am on the main page
	// When I view the page
	// Then I see a submit button called "Tokenize" links to a new page
	
	@Test 
	public void testShowTokenizeButton(){
		WebElement Tokenize=driver.findElement(By.xpath("//form/p[2]/input[1]"));
		Tokenize.click();
		WebElement head=driver.findElement(By.tagName("h1"));
		String headtext=head.getText();
		try{
			assertTrue(headtext.contains("Tokenize Operation"));
			} catch (NoSuchElementException nseex) {
				fail();
			}	
						
	}
	
	
	/**Second user story
	   As a user
	   I want to know whether tokenization step works well
	   So that I can use herokuapp 
	*/

	
	// Scenario 1
	// Given that I am on the main page
	// When I type "a = 5" in textarea and click the button tokenize
	// Then I should see identifiers show up as:on_ident and spaces 
	// show up at :on_sp on Tokenize Operation page.
	
	@Test 
	public void testTokenizeIdent(){
		driver.findElement(By.id("code_code")).sendKeys("a = 5");
		driver.findElement(By.xpath("//form/p[2]/input[1]")).click();
		try{
			WebElement ident=driver.findElement(By.tagName("code"));
			String ident1=ident.getText();
			assertTrue(ident1.contains("[[1, 0], :on_ident"));
			} catch (NoSuchElementException nseex) {
				fail();
			}	
	}
	
	
	// Scenario 2
	// Given that I am on the main page
	// When I type "a = 100", "b = 100" and "c = a * b + 1" in textarea and click the button tokenize
	// Then I should see newlines show up as :on_nl, and 
	// operators( such as + and *) are identified with :on_op on Tokenize Operation page.
	
	@Test 
	public void testTokenizeOp(){
		driver.findElement(By.id("code_code")).sendKeys("a = 100");
		driver.findElement(By.id("code_code")).sendKeys("\n");
		driver.findElement(By.id("code_code")).sendKeys("b = 100");
		driver.findElement(By.id("code_code")).sendKeys("\n");
		driver.findElement(By.id("code_code")).sendKeys("c = a * b + 1");
		driver.findElement(By.xpath("//form/p[2]/input[1]")).click();
		try{
			WebElement sp=driver.findElement(By.tagName("code"));
			String sp1=sp.getText();
			assertTrue(sp1.contains("[1, 7], :on_nl"));
			assertTrue(sp1.contains("[2, 7], :on_nl"));
			assertTrue(sp1.contains("[3, 6], :on_op"));
			assertTrue(sp1.contains("[1, 2], :on_op"));
			assertTrue(sp1.contains("[2, 2], :on_op"));
			assertTrue(sp1.contains("[3, 2], :on_op"));
			assertTrue(sp1.contains("[3, 6], :on_op"));
			assertTrue(sp1.contains("[3, 10], :on_op"));
			} catch (NoSuchElementException nseex) {
				fail();
			}	
	}
	
	
	// Scenario 3
	// Given that I am on the main page
	// When I type " puts "Hello, QIY19!" " in textarea and click the button tokenize
	// Then I should see strings show up at :on_tstring_beg,  :on_tstring_content and
	//  :on_tstring_beg on Tokenize Operation page
	
	@Test 
	public void testTokenizeString(){
		driver.findElement(By.id("code_code")).sendKeys("puts \"Hello, QIY19!\" ");
		driver.findElement(By.xpath("//form/p[2]/input[1]")).click();
		try{
			WebElement tstring=driver.findElement(By.tagName("code"));
			String tstring1=tstring.getText();
			assertTrue(tstring1.contains("[1, 5], :on_tstring_beg"));
			assertTrue(tstring1.contains("[1, 5], :on_tstring_beg"));
			assertTrue(tstring1.contains("[1, 19], :on_tstring_end"));
			} catch (NoSuchElementException nseex) {
				fail();
			}	
	}
	
	
    /**Third user story
	   As a user
	   I can see "Back" link on Tokenize Operation page, 
	   Parse Operation page and Compile Operation page
	   So that I can return to previous page
	*/
    
	
	// Scenario 1
	// Given that I am on the main page
	// When I click on the "Tokenize" button and redirect to the Tokenize Operation page
	// Then I should see a hyperlink "Back".
	
	@Test
	public void testTokenizeBack(){
		driver.findElement(By.xpath("//form/p[2]/input[1]")).click();
		String back= driver.findElement(By.cssSelector("a[href*='#']")).getText();
		String head=driver.findElement(By.tagName("h1")).getText();
    	try{		
    		assertTrue(head.contains("Tokenize Operation"));
    		assertTrue(back.contains("Back"));
			} catch (NoSuchElementException nseex) {
				fail();
			}	
	}
	
	
	// Scenario 2
	// Given that I am on the main page
	// When I click on the "Parse" button and redirect to the Parse Operation page
	// Then I should see a hyperlink "Back".
	
	@Test
	public void testParseBack(){
		driver.findElement(By.xpath("//form/p[2]/input[2]")).click();
		String back= driver.findElement(By.cssSelector("a[href*='#']")).getText();
		String head=driver.findElement(By.tagName("h1")).getText();
    	try{		
    		assertTrue(head.contains("Parse Operation"));
    		assertTrue(back.contains("Back"));
			} catch (NoSuchElementException nseex) {
				fail();
			}	
	}
	
	
	// Scenario 3
	// Given that I am on the main page
	// When I click on the "Complie" button and redirect to the Parse Operation page
	// Then I should see a hyperlink "Back".
	@Test
	public void testComplieBack(){
		driver.findElement(By.xpath("//form/p[2]/input[3]")).click();
		String back= driver.findElement(By.cssSelector("a[href*='#']")).getText();
		String head=driver.findElement(By.tagName("h1")).getText();
    	try{		
    		assertTrue(head.contains("Compile Operation"));
    		assertTrue(back.contains("Back"));
			} catch (NoSuchElementException nseex) {
				fail();
			}	
	}
}