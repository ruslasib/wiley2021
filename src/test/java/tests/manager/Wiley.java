package tests.manager;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.UndetectedLocationModalWindow;

public class Wiley {

    private WebDriver driver;
    private HomePage homePage;
    private UndetectedLocationModalWindow undetectedLocationModalWindow;

    public Wiley(WebDriver driver) {
        this.driver = driver;
    }

    public void start() {
        homePage = new HomePage(driver);
        undetectedLocationModalWindow = new UndetectedLocationModalWindow(driver);
    }

    public UndetectedLocationModalWindow undetectedLocationModalWindow() {
        return undetectedLocationModalWindow;
    }

    public HomePage homePage() {
        return homePage;
    }
}
