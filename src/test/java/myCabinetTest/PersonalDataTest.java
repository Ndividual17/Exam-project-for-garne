package myCabinetTest;

import baseTest.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class PersonalDataTest extends BaseTest {
    @Test
    public void checkValidationInputBirthDateInPersonalData() {
        homePage
                .openHomePage()
                .checkIsRedirectToHomePage()
                .getHeaderElement().clickOnMyCabinetButton();
        myCabinetPage
                .checkIsRedirectToMyCabinetPage()
                .clickOnTabPersonalData()
                .checkIsRedirectToTabPersonalDate()
                .enterTextInInputBirthDate("23-03-1993")
                .clickOnSaveChangesButton()
                .checkInvalidBirthDateAlert()
        ;
    }
}
