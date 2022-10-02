package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyCabinetPage extends ParentPage {

    @FindBy(xpath = ".//h1[@class='layout__header-title' and text()='Personal account']")
    private WebElement titlePersonalAccount;
    @FindBy(xpath = ".//nav[@class='page-submenu']//a[text()='Personal data']")
    private WebElement tabPersonalData;
    @FindBy(xpath = ".//label[@class='form__label' and text()='Birth date']")
    private WebElement fieldBirthDate;
    @FindBy(xpath = ".//input[@id='profileform-birthday']")
    private WebElement inputBirthDate;
    @FindBy(xpath = ".//button[@class='button button_black contacts-data__button']")
    private WebElement buttonSaveChanges;
    @FindBy(xpath = ".//div[@class='form__group field-profileform-birthday form__group_has-error']//div[text()='The format of Birth date is invalid.']")
    private WebElement alertInvalidBirthDate;

    public MyCabinetPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/profile";
    }

    public MyCabinetPage checkIsRedirectToMyCabinetPage() {
        getRelativeUrl();
        Assert.assertTrue("Personal account page is not loaded", isElementDisplayed(titlePersonalAccount));
        return this;
    }

    public MyCabinetPage clickOnTabPersonalData() {
        clickOnElement(tabPersonalData);
        return this;
    }

    public MyCabinetPage checkIsRedirectToTabPersonalDate() {
        Assert.assertTrue("Tab Personal date is not loaded", isElementDisplayed(fieldBirthDate));
        return this;
    }

    public MyCabinetPage enterTextInInputBirthDate(String birthdayData) {
        enterTextIntoElement(inputBirthDate, birthdayData);
        return this;
    }

    public MyCabinetPage clickOnSaveChangesButton() {
        clickOnElement(buttonSaveChanges);
        return this;
    }

    public MyCabinetPage checkInvalidBirthDateAlert() {
        Assert.assertTrue(" Alert 'The format of Birth date is invalid.' is not showed ", isElementDisplayed(alertInvalidBirthDate));
        return this;
    }
}