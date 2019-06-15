package com.primusbank.selenium.tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.primusbank.selenium.pages.PrimusLoginPageObj;
import resources2.base;

public class PrimusLoginPageTest extends base {
	public static WebDriver driver;

	@BeforeTest
	public void StartBrowser() throws IOException {
		driver = InitializeDriver();

	}

	@Test(priority = 0, description = "Valid Login Scenario with credentials from Properties file")
	public void PBValidUserLogin() {
		driver.get(prop.getProperty("PBurl"));
		PrimusLoginPageObj PBLP = new PrimusLoginPageObj(driver);
		PBLP.getPBusername().sendKeys(prop.getProperty("PBusername"));
		PBLP.getPBpassword().sendKeys(prop.getProperty("PBpassword"));
		PBLP.getPBloginButton().click();
		// driver.switchTo().alert().accept();
		// System.out.println(PBLP.getPBExpectedTitle());

	}

	@Test(dataProvider = "PBTestData", priority = 2, description = "Valid Login Scenario with credentials from DataProvider annotation")
	public void PBLoginWithDataProvider(String username, String password) {
		PrimusLoginPageObj PBLP = new PrimusLoginPageObj(driver);
		driver.get(prop.getProperty("PBurl"));

		PBLP.getPBusername().sendKeys(username);
		PBLP.getPBpassword().sendKeys(password);
		PBLP.getPBloginButton().click();
		//driver.switchTo().alert().accept();

	}

	@Test(priority = 1, description = "Valid Login Scenario with credentials from DataProvider annotation")
	public void PBTitleVerification() {

		driver.get(prop.getProperty("PBurl"));
		String ExceptedTitle = "Primus BANK";
		String PBActualTitle = driver.getTitle();
		System.out.println("Primus Bank Title: " + PBActualTitle);
		Assert.assertEquals(driver.getTitle(), ExceptedTitle);
		
	}

	@DataProvider
	public Object[][] PBTestData() {
		Object[][] TD = new Object[2][2]; // Here array size is considered from 1 not from 0. Here 2 is number of rows,
											// 3 is number of columns
		// 0th row
		TD[0][0] = "Admin";
		TD[0][1] = "Admin";
		// 1st row
		TD[1][0] = "Admin";
		TD[1][1] = "Admin";
		/*
		 * //2nd row TD[2][0] = "Adminn"; // Incorrect username TD[2][2] = "Admin";
		 */

		return TD;

	}

	@AfterTest
	public void QuitBrowser() {
		driver.quit();
		driver = null;
	}

}
