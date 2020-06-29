package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Loginpage {

	public WebDriver driver;

	By username= By.id("txtUserName");
	By password= By.id("txtPassword");
	By loginBtn= By.id("btnLogin");

	public Loginpage(WebDriver driver) {//Constructor
		this.driver = driver;
	}


	public WebElement getUsername() {
		return driver.findElement(username);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement accessAccount() {
		return driver.findElement(loginBtn);
	}


}
