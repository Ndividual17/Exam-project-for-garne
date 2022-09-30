package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElement;

public class MainContentIntoProductPage extends ProductsForWomenPage {
    private final HeaderElement headerElement = new HeaderElement(webDriver);
    @FindBy(xpath = ".//h3[@class='comments__title' and text()='Product reviews']")
    private WebElement titleProductReviews;
    @FindBy(xpath = ".//button[@data-product-size='s/m']")
    private WebElement buttonProductSizeSM;
    @FindBy(xpath = ".//button[@value='add_to_cart']")
    private WebElement buttonAddToCart;
    @FindBy(xpath = ".//div[@class='alert alert_success']")
    private WebElement alertSuccess;
    @FindBy(xpath = ".//button[@id='buttonOneClickOrder']")
    private WebElement buttonBuyInOneClick;

    public MainContentIntoProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/";
    }

    public MainContentIntoProductPage checkIsRedirectToMainContentPage() {
        checkUrlWithPattern();
        Assert.assertTrue("MainContent page is not loaded", isElementDisplayed(titleProductReviews));
        return this;
    }

    public MainContentIntoProductPage checkIsButtonProductSizeSMDisplayed() {
        checkUrlWithPattern();
        Assert.assertTrue("Product doesn't have size s/m", isElementDisplayed(buttonProductSizeSM));
        return this;
    }

    public MainContentIntoProductPage clickOnButtonProductSizeSM() {
        checkUrlWithPattern();
        clickOnElement(buttonProductSizeSM);
        return this;
    }

    public MainContentIntoProductPage checkIsButtonAddToCartActive() {
        checkUrlWithPattern();
        Assert.assertTrue("Button Add to cart disabled", isElementDisplayed(buttonAddToCart));
        return this;
    }

    public MainContentIntoProductPage clickOnButtonAddToCart() {
        clickOnElement(buttonAddToCart);
        return this;
    }

    public MainContentIntoProductPage checkTextInAlert(String text) {
        Assert.assertEquals("Text in alert", text, alertSuccess.getText());
        return this;
    }

    public HeaderElement getHeaderElement() {
        return headerElement;
    }

    public MainContentIntoProductPage checkIsButtonBuyInOneClickActive() {
        checkUrlWithPattern();
        Assert.assertTrue("Button Buy in one click is not active", isElementDisplayed(buttonBuyInOneClick));
        return this;
    }

    public OrderByOneClickPage clickOnButtonBuyInOneClick() {
        clickOnElement(buttonBuyInOneClick);
        return new OrderByOneClickPage(webDriver);
    }
}