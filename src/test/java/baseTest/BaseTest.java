package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pages.*;

import java.time.Duration;

public class BaseTest {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected RegistrationPage registrationPage;
    protected ProductsForWomenPage productsForWomenPage;
    protected MainContentIntoProductPage mainContentIntoProductPage;
    protected CartPage cartPage;
    protected GiftCertificatesPage giftCertificatesPage;
    protected OrderByOneClickPage orderByOneClickPage;
    protected MyCabinetPage myCabinetPage;

    @Before
    public void setUp() {
        logger.info(" --- " + testName.getMethodName() + " was started --- ");
        WebDriverManager.chromedriver().setup();
        webDriver = initDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonActionsWithElements.configProperties.TIME_FOR_DFFAULT_WAIT()));
        logger.info("Browser was opened");
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        productsForWomenPage = new ProductsForWomenPage(webDriver);
        mainContentIntoProductPage = new MainContentIntoProductPage(webDriver);
        cartPage = new CartPage(webDriver);
        giftCertificatesPage = new GiftCertificatesPage(webDriver);
        orderByOneClickPage = new OrderByOneClickPage(webDriver);
        myCabinetPage = new MyCabinetPage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
        logger.info("Browser was closed");
        logger.info(" --- " + testName.getMethodName() + " was ended --- ");
    }

    @Rule
    public TestName testName = new TestName();

    private WebDriver initDriver() {
        String browser = System.getProperty("browser");
        if ((browser == null) || "chrome".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if ("ie".equalsIgnoreCase(browser)) {
            WebDriverManager.iedriver().arch32().setup();
            return new InternetExplorerDriver();
        }
        return webDriver;
    }
}
