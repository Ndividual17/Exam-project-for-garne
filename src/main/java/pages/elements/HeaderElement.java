package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.*;

public class HeaderElement extends CommonActionsWithElements {
    @FindBy(xpath = ".//a[@id='logoutLink']")
    private WebElement buttonLogout;
    @FindBy(xpath = "*//header//*/a[text()='Women']")
    private WebElement buttonWomanOnHeader;
    @FindBy(xpath = ".//a[@id='cart']")
    private WebElement buttonCart;
    @FindBy(xpath = ".//a[text()='My Cabinet']")
    private WebElement buttonMyCabinet;

    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isButtonLogoutDisplayed() {
        return isElementDisplayed(buttonLogout);
    }

    public ProductsForWomenPage clickOnWomenButton() {
        clickOnElement(buttonWomanOnHeader);
        return new ProductsForWomenPage(webDriver);
    }

    public CartPage clickOnCartButton() {
        clickOnElement(buttonCart);
        return new CartPage(webDriver);
    }

    public MyCabinetPage clickOnMyCabinetButton(){
        clickOnElement(buttonMyCabinet);
        return new MyCabinetPage(webDriver);
    }
}
