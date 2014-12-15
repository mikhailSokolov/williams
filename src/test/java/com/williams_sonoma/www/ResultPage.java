package com.williams_sonoma.www;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage {
	WebDriver driver;
	
	public ResultPage(WebDriver dr){
		driver=dr;
	}
	public void cooseItemToCart(String itemName){
		driver.findElement(By.linkText(itemName)).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#pip .btn_addtobasket_add")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("anchor-btn-checkout")).click();
	}
	public boolean quickView(){
		WebElement itemElement = driver.findElement(By.cssSelector("#searchresults ul.product-list li:first-child"));
		String element = itemElement.findElement(By.cssSelector(".shop-list>li .product-name")).getText().toString();
		String price = itemElement.findElement(By.xpath("//ul/li[1]/span/span[2]/span[2]/span[2]")).getText().toString();
		itemElement.findElement(By.cssSelector(".quicklook-link")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String priceExp=driver.findElement(By.xpath("//ul[2]/li[1]/div/section/section/div/div/div/div[2]/span/span[2]/span[2]/span[2]")).getText().toString();
		String elementExp=driver.findElement(By.xpath("//div/div[2]/div/h1")).getText().toString();
		if(element.equals(elementExp) || price.equals(priceExp)){
			return true;
		}else{
			return false;
		}
	}

}
