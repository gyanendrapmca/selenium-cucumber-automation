package stepdefinitions;

import managers.Base;
import org.testng.Assert;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pageObjects.hero.LoginPage;
import testrunners.TestRunner;

public class LoginStepDefinitions extends TestRunner {
    private WebDriver driver;
    private LoginPage loginPage;
    @Given("^User is on login page$")
    public void userIsOnLoginPage() {
        driver = Base.getDriver();
        loginPage = Base.getInstanceOfLoginPage();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("^User enter user name \"([^\"]*)\"$")
    public void userEnterUserName(String userName) {
        loginPage.enterUserName(userName);
    }

    @And("^User enter password \"([^\"]*)\"$")
    public void userEnterPassword(String password) throws Throwable {
        loginPage.enterPassword(password);
    }

    @And("^User click on Login button$")
    public void userClickOnLoginButton() {
        loginPage.clickSubmit();
    }

    @Then("^User is able to see successful login message$")
    public void userIsAbleToSeeSuccessfulLoginMessage() {
        Assert.assertEquals(loginPage.isSuccessMessage(), true);
        driver.quit();
    }
}
