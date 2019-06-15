package Academy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources2.base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;


public class HomePage extends base {

	public WebDriver driver;
	
	/*
	 * @BeforeTest public void BrowInitialize() throws IOException { driver =
	 * InitializeDriver(); //driver.get(getURL()); // Calling this method from base
	 * class to open URL
	 * 
	 * }
	 */
	

	@Test(dataProvider = "getData")
	public void QAClickAcademyLogin(String username, String password, String text) throws IOException

	{
		driver = InitializeDriver();
		//driver.get(getURL()); // Calling this method from base class to open URL
		driver.get(prop.getProperty("url"));
		LandingPage LP = new LandingPage(driver);
		LP.getLogin().click(); // This is similar to driver.findelement(By.css()), but here we're invoking it
								// from PageObject class
		LoginPage LP2 = new LoginPage(driver);
		LP2.getEmail().sendKeys(username);
		LP2.getPassword().sendKeys(password);
		System.out.println(text);
		LP2.getLoginButton().click();
		//takeScreenshot();
	}
	
	@AfterTest
	
	public void teardown()
	{
		driver.close();
		driver=null;
	}

	@DataProvider
	public Object[][] getData() {
		// Row stands for how many different types of test should run
		// Column stands for how many values per each test
		Object[][] data = new Object[2][3]; // Here array size is considered from 1 not from 0. Here 2 is number of rows, 3 is number of columns
		// 0th row
		data[0][0] = "NonrestrictedUser@xyz.com";
		data[0][1] = "xyzz";
		data[0][2] = "This is valid user test";

		// 1st row
		data[1][0] = "RestrictedUser@xyz.com";
		data[1][1] = "abcd";
		data[1][2] = "This is Invalid user test";
		return data;
	}
	
}
