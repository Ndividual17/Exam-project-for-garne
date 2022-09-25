package loginTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Assert;
import org.junit.Test;

public class LoginTestWithPageObject extends BaseTest {
    @Test
    public void validLogin() {
        loginPage
                .openLoginPage()
                .enterLoginIntoLoginFormInput(TestData.VALID_LOGIN)
                .enterPasswordIntoLoginFormInput(TestData.VALID_PASSWORD)
                .clickOnLoginButton()
        ;
        Assert.assertTrue("Button Logout is not displayed", homePage.getHeaderElement().isButtonLogoutDisplayed());
    }
}
