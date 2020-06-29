package hepsiburada.DemoHomework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"D:\\Eclipse\\workspacesSelenium\\DemoHomework\\src\\main\\java\\resources\\data.properties");
		//String path =System.getProperty("user.dir")+"\\resources\\data.properties";
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {

			ChromeOptions options = new ChromeOptions();// İzin sorunu İçin eklendi.
			options.addArguments("Mozilla/5.0 (WghrXkuMnF) Chrome/8.0");
			options.setExperimentalOption("useAutomationExtension", false);// İzin sorunu için eklendi.
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);// Normalde burada options olmayacak. Fakat pc izin ile ilgili
			driver.manage().window().maximize();

		} else if (browserName.equals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("Mozilla/5.0 (WghrXkuMnF) Chrome/8.0");

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);// Implicit wait
		driver.manage().deleteAllCookies();
		return driver;
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}

}
