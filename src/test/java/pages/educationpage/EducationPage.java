package pages.educationpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class EducationPage extends Page {

  private SubjectsPanel subjectsPanel;

  public EducationPage(WebDriver driver) {
    super(driver);
    subjectsPanel = new SubjectsPanel(driver);
  }

  @FindBy(css = ".wiley-slogan h1:nth-of-type(3)")
  public WebElement header;

  public String headerText() {
    return header.getAttribute("textContent").trim();
  }

  public SubjectsPanel subjectsPanel() {
    return subjectsPanel;
  }
}
