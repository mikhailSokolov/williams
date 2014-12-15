package com.williams_sonoma.www;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCart {
	WebDriver driver;
	
	public ShoppingCart(WebDriver dr){
		driver=dr;
	}
	public boolean chedkTheItem(String expectedName){
		WebElement er = driver.findElement(By.cssSelector(".checkout-table .order-item.first-row"));
		if(er.getText().toString().contains(expectedName)){
			return true;
		}else{
			return false;
		}
	}
}
