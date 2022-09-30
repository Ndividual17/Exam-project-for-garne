package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderByOneClickPage extends ParentPage {
    @FindBy(xpath = ".//h1[@class='layout__header-title']")
    private WebElement titleOrderInOneClick;

    @Override
    String getRelativeUrl() {
        return "/orders/create-one-click";
    }

    public OrderByOneClickPage(WebDriver webDriver) {
        super(webDriver);
    }

    public OrderByOneClickPage checkIsRedirectToOrderByOneClickPage() {
        checkUrlWithPattern();
        Assert.assertTrue("Title Order in 1 click is not displayed", isElementDisplayed(titleOrderInOneClick));
        return this;
    }
}