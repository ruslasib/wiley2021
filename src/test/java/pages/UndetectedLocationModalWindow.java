package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UndetectedLocationModalWindow extends Page {

  public UndetectedLocationModalWindow(WebDriver driver) {
    super(driver);
  }

  @FindBy(className = "modal-content")
  private List<WebElement> modalDialog;

  @FindBy(className = "close")
  private WebElement closeBtn;

  public void close() {
    if(isElementPresent(modalDialog)) {
      click(closeBtn);
    }
  }
}
