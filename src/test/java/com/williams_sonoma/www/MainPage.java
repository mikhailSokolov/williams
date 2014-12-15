package com.williams_sonoma.www;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class MainPage {
	WebDriver driver;
	Actions action; 
	
	public MainPage(WebDriver dr, Actions act){
		driver = dr;
		action = act;
	}
	public void closePopUp(){
		driver.findElement(By.cssSelector("#adEmailPopup #ad_email_btn-close")).click();
	}
	public boolean checkTitle(String a){
		if(driver.getTitle().toString().equals(a)){
			return true;
		}else{
			return false;
		}
	}
	public void clickButton(String type, String itemType){
		//WebElement any = driver.findElement(By.cssSelector(".nav-menu li.dropDown>a"));
		WebElement any = driver.findElement(By.linkText(type));
		action.moveToElement(any).build().perform();
		driver.findElement(By.linkText(itemType)).click();
	}
	public void search(String searchItemType){
		driver.findElement(By.id("search-field")).sendKeys(searchItemType);
		driver.findElement(By.id("btnSearch")).click();
	}
	

}
