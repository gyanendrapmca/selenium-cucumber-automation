package managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.hero.LoginPage;
import pageObjects.shopping.CartPage;
import pageObjects.shopping.CheckOutPage;
import pageObjects.shopping.HomePage;
import pageObjects.shopping.ProductListingPage;

public class Base {
	private static WebDriver driver;
	private static HomePage homePage;
	private static CartPage cartPage;
	private static ProductListingPage productList;
	private static CheckOutPage checkOutPage;
	private static LoginPage loginPage;

	public static WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		return (driver==null) ? driver = new ChromeDriver(): driver;
	}

	public static HomePage getInstanceOfHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public static CartPage getInstanceOfCartPage() {
		return (cartPage == null) ? cartPage = new CartPage(driver) : cartPage;
	}

	public static ProductListingPage getInstanceOfProductListing() {
		return (productList == null) ? productList = new ProductListingPage(driver) : productList;
	}

	public static CheckOutPage getInstanceOfCheckOutPage() {
		return (checkOutPage == null) ? checkOutPage = new CheckOutPage(driver) : checkOutPage;
	}

	public static LoginPage getInstanceOfLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}
}