package hepsiburada.DemoHomework;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Landingpage;
import pageObjects.Loginpage;
import pageObjects.Products;

public class Homepage extends Base {

	public String generalUrl;

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("pageUrl"));

	}

	@Test
	public void goAccount() throws IOException, InterruptedException {

		Landingpage l = new Landingpage(driver);
		Loginpage lp = new Loginpage(driver);
		l.openAccountTab();
		l.clickLogin().click();

		generalUrl = driver.getCurrentUrl();
		Assert.assertEquals(generalUrl, prop.getProperty("loginExpectedUrl"));

		lp.getUsername().sendKeys(prop.getProperty("username"));
		lp.getPassword().sendKeys(prop.getProperty("password"));
		lp.accessAccount().click();

	}

	@Test
	public void goAraundOnProducts() throws IOException {

		Products pr = new Products(driver);
		pr.seeProduct();
		pr.getProductInfo();
	}

	@Test
	public void verifyEachProductPage() {
		Products pr = new Products(driver);
		Assert.assertTrue(pr.verifyProductDetailPage());
	}

	@Test
	public void goBasket() {
		Products pr = new Products(driver);
		pr.goToBasket().click();
		generalUrl = driver.getCurrentUrl();
		Assert.assertEquals(generalUrl, prop.getProperty("myBasketUrl"));
		//pr.checkHomeProducts();
	}

	@Test
	public void verifyProductsOnBasket() {
		Products pr = new Products(driver);
		pr.checkHomeProducts();
		Assert.assertTrue(pr.verifyProducts());

	}

	@AfterTest
	public void teardown() {
		// driver.quit();
	}

}