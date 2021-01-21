package tests.manager;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.UndetectedLocationModalWindow;
import pages.WhoWeServeSubMenu;

public class Wiley {

    private WebDriver driver;
    private HomePage homePage;
    private UndetectedLocationModalWindow undetectedLocationModalWindow;
    private WhoWeServeSubMenu whoWeServeSubMenu;

    public Wiley(WebDriver driver) {
        this.driver = driver;
    }

    public void start() {
        homePage = new HomePage(driver);
        undetectedLocationModalWindow = new UndetectedLocationModalWindow(driver);
        whoWeServeSubMenu = new WhoWeServeSubMenu(driver);
    }

    public UndetectedLocationModalWindow undetectedLocationModalWindow() {
        return undetectedLocationModalWindow;
    }

    public HomePage homePage() {
        return homePage;
    }

    public WhoWeServeSubMenu whoWeServeSubMenu() {
        return whoWeServeSubMenu;
    }
}
