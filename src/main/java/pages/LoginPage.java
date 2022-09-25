package pages;

import libs.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(xpath = ".//input[@id='loginform-login']")
    private WebElement inputLoginFormLogin;
    @FindBy(xpath = ".//input[@id='loginform-password']")
    private WebElement inputLoginFormPassword;
    @FindBy(xpath = ".//button[@name='login-button']")
    private WebElement buttonLogin;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/users/login";
    }

    /**
     * The method which open LoginPage
     *
     * @return
     */
    public LoginPage openLoginPage() {
        try {
            webDriver.get(baseUrl + getRelativeUrl());
            logger.info("Login page was opened");
            logger.info(baseUrl + getRelativeUrl());
        } catch (Exception e) {
            logger.error("Can not work with site");
            Assert.fail("Can not work with site");
        }
        return this;
    }

    public LoginPage enterLoginIntoLoginFormInput(String login) {
        enterTextIntoElement(inputLoginFormLogin, login);
        return this;
    }

    public LoginPage enterPasswordIntoLoginFormInput(String password) {
        enterTextIntoElement(inputLoginFormPassword, password);
        return this;
    }

    public LoginPage clickOnLoginButton() {
        clickOnElement(buttonLogin);
        return this;
    }

    public HomePage loginWithValidCredWithOutOpenPage() {
        enterLoginIntoLoginFormInput(TestData.VALID_LOGIN);
        enterPasswordIntoLoginFormInput(TestData.VALID_PASSWORD);
        clickOnLoginButton();
        return new HomePage(webDriver);
    }

}
