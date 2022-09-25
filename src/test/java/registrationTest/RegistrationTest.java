package registrationTest;

import baseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class RegistrationTest extends BaseTest {
    final static String ERROR_EMAIL = "Invalid email";
    final static String ERROR_PHONE_NUMBER = "Invalid phone number. The phone must be in the format: +38 (073) 226-76-56";
    final static String ERROR_EMPTY_LOGIN = "Enter email or mobile number";
    final static String ERROR_SHORT_PASSWORD = "Create a password should contain at least 6 characters.";
    final static String ERROR_LONG_PASSWORD = "Create a password should contain at most 50 characters.";
    final static String ERROR_EMPTY_PASSWORD = "Password required";
    final static String ERROR_CHECKBOX = "You have not checked the permission to process your personal data";
    final static String SEMICOLON = ";";
    final static String COMMA = ",";
    final static String INCORRECT_FORMAT_PHONE = "0631234567";
    final static String INCORRECT_FORMAT_EMAIL = "@ukr.net";
    final static String SHORT_PASSWORD = "12345";
    final static String LONG_PASSWORD = "123456789012345678901234567890123456789012345678901";

    @Test
    @Parameters({
            INCORRECT_FORMAT_PHONE + COMMA + SHORT_PASSWORD + COMMA + (ERROR_PHONE_NUMBER + SEMICOLON + ERROR_SHORT_PASSWORD + SEMICOLON + ERROR_CHECKBOX),
            INCORRECT_FORMAT_EMAIL + COMMA + SHORT_PASSWORD + COMMA + (ERROR_EMAIL + SEMICOLON + ERROR_SHORT_PASSWORD + SEMICOLON + ERROR_CHECKBOX),
            "" + COMMA + SHORT_PASSWORD + COMMA + (ERROR_EMPTY_LOGIN + SEMICOLON + ERROR_SHORT_PASSWORD + SEMICOLON + ERROR_CHECKBOX),
            "" + COMMA + LONG_PASSWORD + COMMA + (ERROR_EMPTY_LOGIN + SEMICOLON + ERROR_LONG_PASSWORD + SEMICOLON + ERROR_CHECKBOX),
            INCORRECT_FORMAT_EMAIL + COMMA + "" + COMMA + (ERROR_EMAIL + SEMICOLON + ERROR_EMPTY_PASSWORD + SEMICOLON + ERROR_CHECKBOX)
    })
    @TestCaseName("registrationsErrors : login = {0}, password = {1}")
    public void registrationErrors(String login, String password, String expectedErrors) {
        loginPage
                .openLoginPage()
                .clickOnRegisterButton();
        registrationPage.enterLoginIntoRegistrationForm(login)
                .enterPasswordIntoRegistrationForm(password)
                .clickOnSignupButton()
                .checkErrorsMessagesIntoRegistrationForm(expectedErrors)
        ;
    }
}
