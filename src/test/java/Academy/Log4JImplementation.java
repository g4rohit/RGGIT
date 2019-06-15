package Academy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources2.base;
import org.apache.logging.log4j.*;

public class Log4JImplementation extends base {
	
	private static Logger Log= LogManager.getLogger(Log4JImplementation.class.getName());

	public WebDriver driver;

	@BeforeTest
	public void BrowInitialize() throws IOException
	{
		driver = InitializeDriver();
		//driver.get(getURL()); // Calling this method from base class to open URL
		driver.get(prop.getProperty("url"));
		Log.info("Navigated to URL");
	}
	
	@Test
	public void VerifyTitle() throws IOException

	{
		LandingPage LP = new LandingPage(driver);
		String  ExpectedTitle= "FEATURED COURSES";
		Assert.assertEquals(LP.getTitle().getText(), ExpectedTitle);	
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
