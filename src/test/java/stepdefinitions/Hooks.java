package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.Base;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = Base.getDriver();
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
