package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsForWomenPage extends ParentPage {
    @FindBy(xpath = ".//h1[text()='Products for women']")
    private WebElement headerTitle;
    @FindBy(xpath = ".//a[@class='product__image']")
    private WebElement productImage;
    @FindBy(xpath = ".//ul[@id='category-list']//a[text()='Dresses']")
    private WebElement menuDressesCategory;

    public ProductsForWomenPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/list/woman";
    }

    public ProductsForWomenPage checkIsRedirectToProductsForWomenPage() {
        checkUrl();
        Assert.assertTrue("Page ProductsForWomen is not loaded", isElementDisplayed(headerTitle));
        return this;
    }

    public ProductsForWomenPage selectProductImageUI(String nameProduct) {
        selectTextInProductImageUI(productImage, nameProduct);
        return new MainContentIntoProductPage(webDriver);
    }

    public ProductsForWomenPage clickOnCategoryDresses() {
        clickOnElement(menuDressesCategory);
        return this;
    }
}