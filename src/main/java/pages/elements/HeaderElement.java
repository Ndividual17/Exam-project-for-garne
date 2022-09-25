package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;

public class HeaderElement extends CommonActionsWithElements {
    @FindBy(xpath = ".//a[@id='logoutLink']")
    private WebElement buttonLogout;

    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isButtonLogoutDisplayed() {
        return isElementDisplayed(buttonLogout);
    }
}
