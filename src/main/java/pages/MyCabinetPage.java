package pages;

import org.openqa.selenium.WebDriver;

public class MyCabinetPage extends ParentPage {
    public MyCabinetPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/profile";
    }
}