package pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import hepsiburada.DemoHomework.Base;

public class Products {

	public WebDriver driver;

	static List<String> productsHome = new ArrayList<String>();
	static List<String> productsBasket = new ArrayList<String>();
	List<String> productActualPage = new ArrayList<String>();
	List<String> productExpectedPage = new ArrayList<String>();
	By goBack = By.cssSelector("a[title='Hepsiburada']");
	By dealOfDay = By.xpath("//div[contains(@class,'DealOfTheDay')] //div[contains(@class,'slick-active')]/div/div/a");// incele
	By goBasket = By.id("shoppingCart");
	By productsOnBasket = By.xpath("//div[@id='recommended-products']/div[2]/ul/div/div/li/li/div/figure/a");// incele

	public Products(WebDriver driver) {// Constructor
		this.driver = driver;
	}

	public void seeProduct() {
		List<WebElement> products = driver.findElements(dealOfDay);
		for (int i = 1; i < products.size(); i++) {
			productExpectedPage.add(driver.findElements(dealOfDay).get(i).getAttribute("href"));
			driver.findElements(dealOfDay).get(i).click();
			productActualPage.add(driver.getCurrentUrl());
			driver.findElement(goBack).click();
			// driver.navigate().back();
			if (i == 3)
				break;
		}

	}

	public boolean verifyProductDetailPage() {
		boolean result = true;
		if (!productActualPage.equals(productExpectedPage)) {
			result = false;
		}

		return result;
	}

	public void getProductInfo() {
		List<WebElement> products = driver.findElements(dealOfDay);
		for (int i = 1; i < products.size(); i++) {
			productsHome.add(driver.findElements(dealOfDay).get(i).getAttribute("href").toLowerCase());

			if (i == 3)
				break;
		}
	}

	public WebElement goToBasket() {
		return driver.findElement(goBasket);
	}

	public void checkHomeProducts() {
		List<WebElement> onBasket = driver.findElements(productsOnBasket);
		for (int i = 0; i < onBasket.size(); i++) {
			productsBasket.add(driver.findElements(productsOnBasket).get(i).getAttribute("href").toLowerCase());

		}
	}

	public boolean verifyProducts() {

		boolean isEqualAllValues = productsBasket.containsAll(productsHome);
		return isEqualAllValues;

	}

}
