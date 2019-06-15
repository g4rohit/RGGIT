package com.primusbank.selenium.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.primusbank.selenium.pages.PrimusHomePageObj;
import com.primusbank.selenium.pages.PrimusLoginPageObj;
import com.primusbank.selenium.pages.PrimusNewBranchCreationPageObj;

import resources2.base;

public class PrimusNewBranchCreation extends base {

	public static WebDriver driver;
@BeforeTest
	public void StartBrowser() throws IOException {
		driver = InitializeDriver();

	}

	@Test(description="Creating a new branch - Data from properties file")
	public void CreateNewBranch() {
		
		PrimusHomePageTest PH = new PrimusHomePageTest();
		driver.get(prop.getProperty("PBurl"));
		PrimusLoginPageObj PBLP=new PrimusLoginPageObj(driver);
		PBLP.getPBusername().sendKeys(prop.getProperty("PBusername"));
		PBLP.getPBpassword().sendKeys(prop.getProperty("PBpassword"));
		PBLP.getPBloginButton().click();
		PrimusHomePageObj PHP=new PrimusHomePageObj(driver);
		PHP.getBranchesButton().click();
		PHP.getNewBranchCreationButton().click();
		PrimusNewBranchCreationPageObj PNBCO = new PrimusNewBranchCreationPageObj(driver);
		PNBCO.GetBranchName().sendKeys(prop.getProperty("branchName"));
		PNBCO.GetAddress1().sendKeys(prop.getProperty("Address1"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	
	  @AfterTest public void CloseBrowser() { 
		  driver.quit(); 
		  driver=null; }
	 
}
