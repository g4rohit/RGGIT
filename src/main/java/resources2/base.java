package resources2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import java.io.File;


public class base {

	public static WebDriver driver;
	public Properties prop; // Here we are defining Properties object in public view, so it can be accessed from HomePage, because HomePage is inheriting Base class
	

	public WebDriver InitializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"G:\\Selenium base folder\\Eclipse projects\\E2EProject\\src\\main\\java\\resources2\\data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");

		// Executing in Chrome
		// if(prop.getProperty("browser").equalsIgnoreCase("chrome")) // if
		// (browserName.equals("chrome"))
		if (browserName.equalsIgnoreCase("chrome"))

		{
			System.setProperty("webdriver.chrome.driver",
					"G:\\Selenium base folder\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "G:\\FirefoxDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		// Executing in IE
		else if (prop.getProperty("browser").equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "G:\\IE Driver\\MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;

	}

	public String getURL() throws IOException {
		Properties prop1 = new Properties();
		FileInputStream fis1 = new FileInputStream(
				"G:\\Selenium base folder\\Eclipse projects\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop1.load(fis1);
		String QAClickAcademy = prop1.getProperty("url");

		return QAClickAcademy;
	}

	public WebDriver takeScreenshot() throws IOException {
		// By writing "(TakesScreenshot)driver)", we're casting driver object to
		// "TakesScreenshot" object
		// "getScreenshotAs" is a method which take screenshot and saves it as a file
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Initially screenshot will be stored in "src" object
		// By using "FileUtils" method we copy/move screenshot file from "src" object to
		// our local system
		// While giving the location details, make sure to include \\ (double slash)
		// only, Java won't accept \(single slash)

		//File dstn = new File("G:\\Selenium base folder\\Eclipse projects\\E2EProject\\src\\main\\java\\testScreenshots\\1.png");

		FileUtils.copyFile(src, new File("G:\\SeleniumScreenshots\\1.png"));
		return driver;
		
		
	}

}
