package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ui.tests.manager.ParametersHolder;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public abstract class Page {

  private WebDriver driver;

  public Page(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void click(WebElement element) {
    element.click();
  }

  public boolean isElementPresent(List<WebElement> elements) {
    try {
      driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
      return elements.size() > 0;
    } finally {
      driver.manage().timeouts().implicitlyWait(ParametersHolder.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }
  }

  public boolean isElementPresent(By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (InvalidSelectorException ex) {
        throw ex;
    } catch (NoSuchElementException ex) {
        throw ex;
    }
  }
}
