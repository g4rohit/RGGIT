package com.primusbank.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrimusNewBranchCreationPageObj {
	
public static WebDriver driver;



By BranchName=By.cssSelector("#txtbName");
By Address1=By.cssSelector("#txtAdd1");
By Address2=By.cssSelector("#Txtadd2");
By Address3=By.cssSelector("##txtadd3");
By Area=By.cssSelector("#txtArea");
By Zipcode=By.cssSelector("#txtZip");
By Country=By.cssSelector("#txtbName");
By State=By.cssSelector("#txtbName");
By City=By.cssSelector("#txtbName");


public PrimusNewBranchCreationPageObj(WebDriver driver) {
	this.driver=driver;
}
public WebElement GetBranchName()
{
	return driver.findElement(BranchName);	
}
public WebElement GetAddress1()
{
	return driver.findElement(Address1);	
}
public WebElement GetAddress2()
{
	return driver.findElement(Address2);	
}
public WebElement GetAddress3()
{
	return driver.findElement(Address3);	
}
public WebElement GetArea()
{
	return driver.findElement(Area);	
}
public WebElement GetZipcode()
{
	return driver.findElement(Zipcode);	
}
public WebElement GetCountry()
{
	return driver.findElement(Country);	
}
public WebElement GetState()
{
	return driver.findElement(State);	
}
public WebElement GetCity()
{
	return driver.findElement(City);	
}

}
