package tests.manager;

import org.openqa.selenium.WebDriver;
import pages.UndetectedLocationModalWindow;

public class Wiley {

    private WebDriver driver;
    private UndetectedLocationModalWindow undetectedLocationModalWindow;

    public Wiley(WebDriver driver) {
        this.driver = driver;
    }

    public void start() {
        undetectedLocationModalWindow = new UndetectedLocationModalWindow(driver);
    }

    public UndetectedLocationModalWindow undetectedLocationModalWindow() {
        return undetectedLocationModalWindow;
    }
}
