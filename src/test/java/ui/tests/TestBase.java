package ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ui.tests.manager.ParametersHolder;
import ui.tests.manager.Wiley;

import java.util.concurrent.TimeUnit;

public class TestBase {

    private EventFiringWebDriver driver;
    protected Wiley wiley;

    public class MyListener extends AbstractWebDriverEventListener {

        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by + " found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            System.out.println(throwable);
        }
    }

    @BeforeClass
    public void setUp() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new MyListener());
        driver.manage().timeouts().implicitlyWait(ParametersHolder.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.wiley.com/en-us");
        wiley = new Wiley(driver);
        wiley.start();
        wiley.undetectedLocationModalWindow().yes();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    public void typeIn(By locator, String input) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(input);
    }

    public void typeIn(WebElement element, String input) {
        element.clear();
        element.sendKeys(input);
    }
}
