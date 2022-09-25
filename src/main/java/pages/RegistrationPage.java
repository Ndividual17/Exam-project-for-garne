package pages;

import libs.Util;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class RegistrationPage extends LoginPage {
    @FindBy(xpath = ".//input[@id='signupform-login']")
    private WebElement inputRegistrationFormLogin;
    @FindBy(xpath = ".//input[@id='signupform-password']")
    private WebElement inputRegistrationFormPassword;
    @FindBy(xpath = ".//button[@name='signup-button']")
    private WebElement buttonSignup;
    private String listOfErrorsLocator = ".//div[contains(@class,'error')]//div[@class='form__help-block']";
    @FindBy(xpath = ".//div[contains(@class,'error')]//div[@class='form__help-block']")
    private List<WebElement> listOfErrors;

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/users/signup";
    }

    public RegistrationPage enterLoginIntoRegistrationForm(String login) {
        enterTextIntoElement(inputRegistrationFormLogin, login);
        return this;
    }

    public RegistrationPage enterPasswordIntoRegistrationForm(String password) {
        enterTextIntoElement(inputRegistrationFormPassword, password);
        return this;
    }

    public RegistrationPage clickOnSignupButton() {
        clickOnElement(buttonSignup);
        return this;
    }

    public RegistrationPage checkErrorsMessagesIntoRegistrationForm(String expectedErrors) {
        String[] expectedErrorsArray = expectedErrors.split(";");
        webDriverWaitLow
                .withMessage("Number of messages should be " + expectedErrorsArray.length)
                .until(ExpectedConditions.numberOfElementsToBe
                        (By.xpath(listOfErrorsLocator), expectedErrorsArray.length));
        Util.waitABit(1);
        Assert.assertEquals(expectedErrorsArray.length, listOfErrors.size());
        ArrayList<String> actualTextFromErrors = new ArrayList<>();
        for (WebElement element : listOfErrors) {
            actualTextFromErrors.add(element.getText());
        }
        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 0; i < expectedErrorsArray.length; i++) {
            softAssertions.assertThat(expectedErrorsArray[i]).isIn(actualTextFromErrors);
        }

        softAssertions.assertAll();
        return this;
    }
}
