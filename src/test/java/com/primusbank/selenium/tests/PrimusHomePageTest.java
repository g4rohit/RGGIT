package com.primusbank.selenium.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.primusbank.selenium.pages.PrimusHomePageObj;
import com.primusbank.selenium.pages.PrimusLoginPageObj;

import resources2.base;

public class PrimusHomePageTest extends base {
	
	public static WebDriver driver;
	
	
	
	@BeforeTest
	public void StartBrowser() throws IOException
	{
		driver= InitializeDriver();
	}
	@Test(priority = 0, description="Navigate to HomePage and click on Branches button")
	public  void ClickBranchesButton()
	{
		driver.get(prop.getProperty("PBurl"));
		PrimusLoginPageObj PBLP=new PrimusLoginPageObj(driver);
		PBLP.getPBusername().sendKeys(prop.getProperty("PBusername"));
		PBLP.getPBpassword().sendKeys(prop.getProperty("PBpassword"));
		PBLP.getPBloginButton().click();
		PrimusHomePageObj PHP=new PrimusHomePageObj(driver);
		PHP.getBranchesButton().click();
	}
	@Test
	
public void newTest()
{
		System.out.println("This is modified again from GITHUBB");
}
	
	@AfterTest(description="Close Browser and delete memory")
    public void QuitBrowser()
    {
    	driver.quit();
    	driver=null;
    }
	
	

}
