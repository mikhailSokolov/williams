package com.williams_sonoma.www;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class WilliamsJTest {
static WebDriver driver = new FirefoxDriver();
Actions act = new Actions(driver); 
MainPage maiP = new MainPage(driver,act);
ResultPage resP = new ResultPage(driver);
ShoppingCart shoP=new ShoppingCart(driver);

String baseUrl= null;
String title = null;
String type = null;
String itemType=null;
String itemName=null;
String searchItemType=null;

public WilliamsJTest() throws FileNotFoundException, IOException {
	Properties properties = new Properties();

	properties.load(new FileInputStream("./src/main/resources/WStest1.properties"));
	baseUrl = properties.getProperty("url");
	title=properties.getProperty("Title");
	type=properties.getProperty("type");
	itemType=properties.getProperty("itemType");
	itemName=properties.getProperty("itemName");
	searchItemType=properties.getProperty("searchItemType");
}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		
		
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		driver.quit();
		driver=null;
	}
	
	@Before
	public void setUp() throws Exception{
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	@After
	public void tearDown() throws Exception{
		
	}

	@Test
	public void testOfTheCart() {
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		maiP.closePopUp();
		assertTrue(maiP.checkTitle(title));
		maiP.clickButton(type, itemType);
		resP.cooseItemToCart(itemName);
		assertTrue(shoP.chedkTheItem(itemName));
		}

	
	@Test
	public void testQuickView(){
		maiP.search(searchItemType);
		assertTrue(resP.quickView());
		
		
	}

}
