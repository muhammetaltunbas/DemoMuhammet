package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Landingpage {

	public WebDriver driver;
	

	By openLoginArea = By.id("myAccount");
	By logIn = By.id("login");

	public Landingpage(WebDriver driver) {// Constructor
		this.driver = driver;
	}

	public void openAccountTab() {
		driver.findElement(By.id("myAccount")).click();
		WebDriverWait w = new WebDriverWait(driver, 6);
		w.until(ExpectedConditions.visibilityOfElementLocated(logIn));

	}

	public WebElement clickLogin() {
		return driver.findElement(logIn);
	}

}
