package ui.pages.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.Page;

public class HomePage extends Page {
  private SubjectsSubmenu subjectsSubmenu;

  public HomePage(WebDriver driver) {
    super(driver);
    subjectsSubmenu = new SubjectsSubmenu(driver);
  }


  @FindBy(css = ".navigation-menu-items > li:nth-child(1)")
  private WebElement whoWeServe;

  @FindBy(id = "wileyLogo")
  private WebElement logo;

  public void clickWhoWeServe() {
    click(whoWeServe);
  }

  public void goToHomePage() {
    click(logo);
  }

  public SubjectsSubmenu subjectsSubmenu() {
    return subjectsSubmenu;
  }
}
