package shoppingTest;

import baseTest.BaseTest;
import org.junit.Test;

public class OrderCertificateTest extends BaseTest {
    @Test
    public void TC1_orderCertificateByOneClick() {
        homePage
                .openHomePage()
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