package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	By Email = By.cssSelector("[type='email']");
	By Password = By.cssSelector("[type='password']");
	By LoginButton = By.cssSelector("[value='Log In']");

	public LoginPage(WebDriver driver2) { // This is a constructor which accepts argument from HomePage driver and gives
											// life to driver in this class
		this.driver = driver2;
	}

	public WebElement getEmail() {
		return driver.findElement(Email);
	}

	public WebElement getPassword() {
		return driver.findElement(Password);
	}

	public WebElement getLoginButton() {
		return driver.findElement(LoginButton);
	}

}
