package shoppingTest;

import baseTest.BaseTest;
import org.junit.Test;

public class ShoppingTest extends BaseTest {
    final String NUMBER_PRODUCT = "3039229"; // Перед тестом необхідно перевірити NUMBER_PRODUCT на сайті, тому що часто асортимент змінюється

    @Test
    public void addClothesToCart() {
        homePage
                .openHomePage()
                .checkIsRedirectToHomePage()
                .getHeaderElement().clickOnWomenButton();
        productsForWomenPage
                .checkIsRedirectToProductsForWomenPage()
                .clickOnCategoryDresses()
                .selectProductImageUI(NUMBER_PRODUCT);
        mainContentIntoProductPage
                .checkIsRedirectToMainContentPage()
                .checkIsButtonProductSizeSDisplayed()
                .clickOnButtonProductSizeS()
                .checkIsButtonAddToCartActive()
                .clickOnButtonAddToCart()
                .checkTextInAlert("Product successfully added to basket")
                .getHeaderElement().clickOnCartButton();
        cartPage
                .checkIsRedirectToCartPage()
                .checkNumberOfProductWasAddedToCart(NUMBER_PRODUCT);
        cartPage
                .clickOnButtonDeleteProduct()
                .clickOnSubmitButtonInAlert()
        ;
    }

}