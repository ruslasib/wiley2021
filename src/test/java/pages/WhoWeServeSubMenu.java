package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WhoWeServeSubMenu extends Page {
  public WhoWeServeSubMenu(WebDriver driver) {
    super(driver);
  }

  @FindBy(css = "#Level1NavNode1 > ul > li > a")
  public List<WebElement> whoWeServeItems;

  public int itemsQuantity() {
    return whoWeServeItems.size();
  }

  public List<String> itemsNames() {
    List<String> names = new ArrayList<>();
    whoWeServeItems.stream().forEach(i -> names.add(i.getAttribute("textContent").trim()));
    return names;
  }
}
