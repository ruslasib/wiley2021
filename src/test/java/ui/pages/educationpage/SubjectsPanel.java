package ui.pages.educationpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.Page;

import java.util.ArrayList;
import java.util.List;

public class SubjectsPanel extends Page {

  public SubjectsPanel(WebDriver driver) {
    super(driver);
  }

  @FindBy(css = ".side-panel li")
  private List<WebElement> items;

  public List<String> items() {
    List<String> itemsNames = new ArrayList<>();
    items.stream().forEach(i -> itemsNames.add(i.getAttribute("textContent")));
    return itemsNames;
  }
}
