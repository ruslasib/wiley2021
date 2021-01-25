package ui.tests.manager;

import org.openqa.selenium.WebDriver;
import ui.pages.educationpage.EducationPage;
import ui.pages.UndetectedLocationModalWindow;
import ui.pages.WhoWeServeSubMenu;
import ui.pages.homepage.HomePage;
import ui.pages.search.SearchPanel;
import ui.pages.search.SearchResultPage;

public class Wiley {

    private WebDriver driver;
    private HomePage homePage;
    private UndetectedLocationModalWindow undetectedLocationModalWindow;
    private WhoWeServeSubMenu whoWeServeSubMenu;
    private SearchPanel searchPanel;
    private SearchResultPage searchResultPage;
    private EducationPage educationPage;

    public Wiley(WebDriver driver) {
        this.driver = driver;
    }

    public void start() {
        homePage = new HomePage(driver);
        undetectedLocationModalWindow = new UndetectedLocationModalWindow(driver);
        whoWeServeSubMenu = new WhoWeServeSubMenu(driver);
        searchPanel = new SearchPanel(driver);
        searchResultPage = new SearchResultPage(driver);
        educationPage = new EducationPage(driver);
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

    public SearchPanel searchPanel() {
        return searchPanel;
    }

    public SearchResultPage searchResultPage() {
        return searchResultPage;
    }

    public EducationPage educationPage() {
        return educationPage;
    }
}
