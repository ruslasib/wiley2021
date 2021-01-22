package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EducationPage extends Page {
  public EducationPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(css = ".wiley-slogan h1:nth-of-type(3)")
  public WebElement header;

  public String headerText() {
    return header.getAttribute("textContent").trim();
  }
}
