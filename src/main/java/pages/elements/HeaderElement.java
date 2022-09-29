package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CartPage;
import pages.CommonActionsWithElements;
import pages.ProductsForWomenPage;

public class HeaderElement extends CommonActionsWithElements {
    @FindBy(xpath = ".//a[@id='logoutLink']")
    private WebElement buttonLogout;
    @FindBy(xpath = "*//header//*/a[text()='Women']")
    private WebElement buttonWomanOnHeader;
    @FindBy(xpath = ".//a[@id='cart']")
    private WebElement buttonCart;

    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isButtonLogoutDisplayed() {
        return isElementDisplayed(buttonLogout);
    }

    public ProductsForWomenPage clickOnButtonWomen() {
        clickOnElement(buttonWomanOnHeader);
        return new ProductsForWomenPage(webDriver);
    }

    public CartPage clickOnCartButton() {
        clickOnElement(buttonCart);
        return new CartPage(webDriver);
    }
}
