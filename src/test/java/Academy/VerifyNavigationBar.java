package Academy;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources2.base;

public class VerifyNavigationBar extends base {

	public static WebDriver driver;

	@BeforeTest
	public void BrowInitialize() throws IOException {
		driver = InitializeDriver();
		// driver.get(getURL()); // Calling this method from base class to open URL
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void VerNavBar() throws IOException {

		driver = InitializeDriver();
		driver.get(prop.getProperty("url"));
		LandingPage LP3 = new LandingPage(driver);
		Assert.assertTrue(LP3.GetNavigationBar().isDisplayed());
		System.out.println("Navigation Bar is displayed as expected");
	}

	@AfterTest

	public void teardown() {
		driver.close();
		driver=null;
	}

}
