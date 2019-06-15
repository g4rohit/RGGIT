package com.primusbank.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrimusLoginPageObj {
	
	public static WebDriver driver;
	//String ExpectedTitle;
	
	By UserName= By.id("txtuId");
	By Password=By.id("txtPword");
	By Loginbutton=By.id("login");
	
	//String ExpectedTitle=driver.getTitle();
	
	
	public PrimusLoginPageObj(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement getPBusername()
	{
		return driver.findElement(UserName);
	}
	public WebElement getPBpassword()
	{
		return driver.findElement(Password);
	}
	public WebElement getPBloginButton()
	{
		return driver.findElement(Loginbutton);
	}
	
	
	
	
	

}
