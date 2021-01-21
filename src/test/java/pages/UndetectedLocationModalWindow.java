package pages;

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

  @FindBy(className = "changeLocationConfirmBtn")
  private WebElement yesBtn;

  public void close() {
    if(exists()) click(closeBtn);
  }

  public void yes() {
    if(exists()) click(yesBtn);
  }

  public boolean exists() {
    return isElementPresent(modalDialog);
  }
}
