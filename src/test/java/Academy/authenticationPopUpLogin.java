package Academy;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import resources2.base;

public class authenticationPopUpLogin extends base {

	public WebDriver driver;

	@Test
	public void authenticationLogin() throws IOException {

		driver = InitializeDriver();

		// Syntax to login to any website with authentication popup -
		// http://username:password@xyz.com
		driver.get("http:admin:admin@the-internet.herokuapp.com/basic_auth");

		String ExpectedText = driver.findElement(By.cssSelector("p")).getText();

		System.out.println(ExpectedText);

		String ActualText = "Congratulations! You must have the proper credentials.";

		if (ActualText.equals(ExpectedText)) {
			System.out.println("Header is as expected");
		} else {
			System.out.println("Header is not as expected");
		}

	}
	
	@AfterTest
	
	public void teardown()
	{
		driver.close();
		driver=null;
	}

}
