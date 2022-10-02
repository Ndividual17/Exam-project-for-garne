package shoppingTest;

import baseTest.BaseTest;
import org.junit.Test;

public class OrderCertificateTest extends BaseTest {
    @Test
    public void orderCertificateByOneClick() {
        homePage
                .openHomePage()
                .checkIsRedirectToHomePage()
                .checkIsButtonOrderCertificateDisplayed()
                .clickOnButtonOrderCertificate();
        giftCertificatesPage
                .checkIsRedirectToGiftCertificatesPage()
                .selectGiftCertificate("Gift certificate");
        mainContentIntoProductPage
                .checkIsRedirectToMainContentPage()
                .checkIsButtonBuyInOneClickActive()
                .clickOnButtonBuyInOneClick();
        orderByOneClickPage
                .checkIsRedirectToOrderByOneClickPage()
        ;
    }
}