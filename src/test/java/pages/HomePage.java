package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {
  public HomePage(WebDriver driver) {
    super(driver);
  }

  @FindBy(css = ".navigation-menu-items > li:nth-child(1)")
  public WebElement whoWeServe;

  @FindBy(id = "wileyLogo")
  public WebElement logo;

  public void clickWhoWeServe() {
    click(whoWeServe);
  }

  public void goToHomePage() {
    click(logo);
  }
}
