package pageObjects.hero;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how=How.ID, using = "username")
    private WebElement userNameField;

    @FindBy(how=How.ID, using = "password")
    private WebElement passwordField;

    @FindBy(how=How.CSS, using = "button > i")
    private WebElement submitButton;

    @FindBy(how=How.ID, using = "flash")
    private WebElement successMessage;

    public void loginToApplication(String userName, String password) {
        this.enterUserName(userName);
        this.enterPassword(password);
        this.clickSubmit();
    }

    public void enterUserName(String userName) {
        userNameField.sendKeys(userName);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public Boolean isSuccessMessage() {
        return successMessage.isDisplayed();
    }
}
