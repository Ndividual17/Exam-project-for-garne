package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.elements.HeaderElement;

public class HomePage extends ParentPage {
    private HeaderElement headerElement = new HeaderElement(webDriver);

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

}
