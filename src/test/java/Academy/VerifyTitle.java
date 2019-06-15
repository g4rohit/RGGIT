package Academy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources2.base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;


public class VerifyTitle extends base {

	public static WebDriver driver;
	//private static Logger Log= LogManager.getLogger(Log4JImplementation.class.getName());

	@BeforeTest
	public void BrowInitialize() throws IOException
	{
		driver = InitializeDriver();
		//driver.get(getURL()); // Calling this method from base class to open URL
		driver.get(prop.getProperty("url"));
		//Log.info("Navigated to URL");
	}
	
	@Test
	public void VerifyTitle() throws IOException

	{
		LandingPage LP = new LandingPage(driver);
		String  ExpectedTitle= "FEATURED COURSES";
		Assert.assertEquals(LP.getTitle().getText(),ExpectedTitle);	
		driver=takeScreenshot();
		//Assert.assertTrue("Tit
		System.out.println("Title matched");
	}


@AfterTest
public void teardown()
{
	driver.close();
	driver=null;
}
	
}
