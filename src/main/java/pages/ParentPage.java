package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;

abstract class ParentPage extends CommonActionsWithElements {
    protected String baseUrl;

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
        baseUrl = configProperties.base_url();
    }

    abstract String getRelativeUrl();

    protected void checkUrl() {
        Assert.assertEquals("Invalid page "
                , baseUrl + getRelativeUrl()
                , webDriver.getCurrentUrl());
    }

    protected void checkUrlWithPattern() {
        logger.debug(webDriver.getCurrentUrl());
        Assert.assertThat("Invalid page"
                , webDriver.getCurrentUrl()
                , containsString(baseUrl + getRelativeUrl()));
    }
}
