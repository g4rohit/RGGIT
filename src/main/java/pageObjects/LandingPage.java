package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By signIn = By.cssSelector("a[href*='sign_in']");
	By EmailAddress=By.id("user_email");
	By Password=By.id("user_password");
	By title = By.cssSelector(".text-center>h2");
	By NavigationBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	public WebElement getLogin() { // Return type is WebElement because from here are returning an element

		return driver.findElement(signIn);
	}
	public WebElement getEmail() { // Return type is WebElement because from here are returning an element

		return driver.findElement(EmailAddress);
	}
	
	public WebElement getTitle() { // Return type is WebElement because from here are returning an element

		return driver.findElement(title);
	}

	public WebElement GetNavigationBar() { // Return type is WebElement because from here are returning an element

		return driver.findElement(NavigationBar);
	}
}
