package com.primusbank.selenium.tests;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.primusbank.selenium.pages.PrimusLoginPageObj;

import excelDataDriven.DataDriven;
import resources2.base;

public class PrimusLoginExcelDrivenTest extends base{
	
	public static WebDriver driver;
	
	@BeforeTest
	public void StartBrowser() throws IOException
	{
		driver= InitializeDriver();
	}
	
	
	@Test
	public void PBLoginExcelDriver() throws IOException
	{
		driver.get(prop.getProperty("PBurl"));
		PrimusLoginPageObj PBLP = new PrimusLoginPageObj(driver);
		DataDriven DD=new DataDriven();
		ArrayList<String> ExcelData=DD.ExcelDataDriven("Login1");
		PBLP.getPBusername().sendKeys(ExcelData.get(1));
		PBLP.getPBpassword().sendKeys(ExcelData.get(2));
		PBLP.getPBloginButton().click();
		
		
	}
	
	@AfterTest
	public void QuitBrowser() {
		driver.quit();
		driver = null;
	}
	
}
