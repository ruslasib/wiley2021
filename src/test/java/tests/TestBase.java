package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import tests.manager.Wiley;

public class TestBase {

    private WebDriver driver;
    protected Wiley wiley;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wiley.com/en-us");
        wiley = new Wiley(driver);
        wiley.start();
        wiley.undetectedLocationModalWindow().close();
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
