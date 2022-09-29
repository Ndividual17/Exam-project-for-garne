package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends ParentPage {
    @FindBy(xpath = ".//h1[@class='layout__header-title']")
    private WebElement title;
    @FindBy(xpath = ".//a[contains(text(),'Код')]/strong")
    private WebElement itemNumberOfProduct;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/cart";
    }

    public CartPage checkIsRedirectToCartPage() {
        checkUrlWithPattern();
        Assert.assertTrue("Cart page is not loaded", isElementDisplayed(title));
        return this;
    }

    public void checkNumberOfProductWasAddedToCart(String itemNumber) {
        checkUrlWithPattern();
        Assert.assertEquals(itemNumber, itemNumberOfProduct.getText());
        logger.info("Item number of product in shopping cart is: " + itemNumberOfProduct.getText());
    }
}
