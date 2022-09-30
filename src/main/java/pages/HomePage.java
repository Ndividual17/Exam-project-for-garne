package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElement;

public class HomePage extends ParentPage {
    private HeaderElement headerElement = new HeaderElement(webDriver);
    @FindBy(xpath = ".//span[@class='certificate__link button']")
    private WebElement buttonOrderCertificate;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/";
    }

    public HomePage checkIsRedirectToHomePage() {
        checkUrlWithPattern();
        Assert.assertTrue("HomePage is not loaded", getHeaderElement().isButtonLogoutDisplayed());
        return this;
    }

    public HomePage openHomePage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        if (!headerElement.isButtonLogoutDisplayed()) {
            loginPage.loginWithValidCredWithOutOpenPage();
        }
        checkIsRedirectToHomePage();
        return this;
    }

    public HeaderElement getHeaderElement() {
        return headerElement;
    }

    public HomePage checkIsButtonOrderCertificateDisplayed() {
        Assert.assertTrue("The button Order Certificate is not displayed", isElementDisplayed(buttonOrderCertificate));
        return this;
    }

    public HomePage clickOnButtonOrderCertificate() {
        clickOnElement(buttonOrderCertificate);
        return new GiftCertificatesPage(webDriver);
    }
}
