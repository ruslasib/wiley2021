package pages.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class SubjectsSubmenu extends Page {

  private WebDriver driver;

  public SubjectsSubmenu(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  @FindBy(css = ".dropdown-submenu [href*=subjects]")
  public WebElement subjectsHeader;

  @FindBy(css = "#Level1NavNode2 > ul > li > [href*=Education]")
  public WebElement education;

  public void expand() {
    Actions actions = new Actions(driver);
    actions.moveToElement(subjectsHeader).perform();
  }

  public void education() {
    click(education);
  }
}
