package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftCertificatesPage extends HomePage {
    @FindBy(xpath = ".//h1[@class='layout__header-title']")
    private WebElement titleGiftCertificates;
    @FindBy(xpath = ".//div[@class='product']")
    private WebElement giftCertificateImage;

    @Override
    String getRelativeUrl() {
        return "/p/gift-card";
    }

    public GiftCertificatesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public GiftCertificatesPage checkIsRedirectToGiftCertificatesPage() {
        checkUrlWithPattern();
        Assert.assertTrue("Gift Certificates page is not loaded", isElementDisplayed(titleGiftCertificates));
        return this;
    }

    public GiftCertificatesPage selectGiftCertificate(String nameProduct) {
        selectTextInProductImageUI(giftCertificateImage, nameProduct);
        return this;
    }
}