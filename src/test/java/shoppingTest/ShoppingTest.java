package shoppingTest;

import baseTest.BaseTest;
import org.junit.Test;

public class ShoppingTest extends BaseTest {
    final String NUMBER_PRODUCT = "3039281";
    final String NUMBER_PRODUCT1 = "3039007";

    @Test
    public void TC1_addClothesToCart() {
        homePage
                .openHomePage()
                .getHeaderElement().clickOnButtonWomen();
        productsForWomenPage
                .checkIsRedirectToProductsForWomenPage()
//                .selectProductImageUI("Panties");
                .selectProductImageUI(NUMBER_PRODUCT);
        mainContentIntoProductPage
                .checkIsRedirectToMainContentPage()
                .checkIsButtonProductSizeSMDisplayed()
                .clickOnButtonProductSizeSM()
                .checkIsButtonAddToCartActive()
                .clickOnButtonAddToCart()
                .checkTextInAlert("Product successfully added to basket")
                .getHeaderElement().clickOnCartButton();
        cartPage
                .checkIsRedirectToCartPage()
                .checkNumberOfProductWasAddedToCart(NUMBER_PRODUCT)
//                .checkNumberOfProductWasAddedToCart("8048752")
        ;
    }

}