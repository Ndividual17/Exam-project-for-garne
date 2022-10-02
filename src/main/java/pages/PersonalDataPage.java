package pages;

import org.openqa.selenium.WebDriver;

public class PersonalDataPage extends ParentPage{
    public PersonalDataPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/profile/edit";
    }
}
