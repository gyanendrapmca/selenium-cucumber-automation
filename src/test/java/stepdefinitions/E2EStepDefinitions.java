package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import dataProvider.ConfigFileReader;
import managers.Base;
import testrunners.TestRunner;
import pageObjects.shopping.CartPage;
import pageObjects.shopping.CheckOutPage;
import pageObjects.shopping.HomePage;
import pageObjects.shopping.ProductListingPage;
import io.cucumber.java.en.*;

public class E2EStepDefinitions extends TestRunner {
	private WebDriver driver;
	private HomePage homePage;
	private ProductListingPage plist;
	private CheckOutPage chk;
	private CartPage cartPage;
	private ConfigFileReader config;

	@Given("^user is on Home Page$")
	public void user_is_on_home_page() throws IOException {
		config = new ConfigFileReader();
		driver = Base.getDriver();
		homePage = Base.getInstanceOfHomePage();
		homePage.navigateToHomePage(config.getUrl());
	}

	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for_dress(String dress) {
		homePage.performSearch(dress);
	}

	@And("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() throws InterruptedException {
		plist = Base.getInstanceOfProductListing();
		plist.selectProduct(1);

		Thread.sleep(10000);
		Select color = plist.productColor();
		color.selectByIndex(1);
		Select size = plist.productSize();
		size.selectByIndex(2);

		plist.clickQuantityIncrease();
		Thread.sleep(10000);

		plist.clickAddToCart();
	}

	@And("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart() {
		cartPage = Base.getInstanceOfCartPage();

		cartPage.clickOnCartButton();
		cartPage.clickOnContinueToCheckOut();
	}

	@And("^enter personal details on checkout page$")
	public void enter_personal_details_on_checkout_page() throws InterruptedException {
		chk = Base.getInstanceOfCheckOutPage();
		Thread.sleep(5000);

		chk.enterFirstName("Lakshay");
		chk.enterLastName("Sharma");
		chk.enterCompanyName("QA TOOLS");

		chk.clickOnCountryDropDown();
		chk.selectCountryStateOption("India");

		chk.enterHouseNo("BLOCK A-11");
		chk.enterAppartment("Crown Plaza");
		chk.enterCityName("New Delhi");

		chk.clickOnStateDropDown();
		chk.selectCountryStateOption("Bihar");
		Thread.sleep(3000);

		chk.enterPostCode("122244");
		chk.enterPhone("+91-8965336569");
		chk.enterEmail("lksharma@gmail.com");
		Thread.sleep(3000);
	}

	@And("^select same delivery address$")
	public void select_same_delivery_address() {
		System.out.println("Select same delivery address");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-50)");
	}

	@And("^select payment method as \"([^\"]*)\" payment$")
	public void select_payment_method_as_check_payment(String check) {
		System.out.println("Select payment method as " + check + " payment.");
	}

	@And("^place the order$")
	public void place_the_order() throws InterruptedException {
		Thread.sleep(3000);
		chk.clickOnAcceptTerm();
		chk.clickOnPlaceOrder();
		Thread.sleep(3000);
	}

}