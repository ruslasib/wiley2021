package pages.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

import java.util.ArrayList;
import java.util.List;

public class SearchPanel extends Page {
  public SearchPanel(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "js-site-search-input")
  public WebElement searchInputField;

  @FindBy(css = "button[type=submit]")
  public WebElement searchBtn;

  @FindBy(xpath = "//h3[contains(text(),'Suggestions')]/..//*[@class='searchresults-item ui-menu-item']")
  public List<WebElement> suggestions;

  public List<String> suggestions() {
    List<String> searchResult = new ArrayList<>();
    suggestions.stream().forEach(s -> searchResult.add(s.getAttribute("textContent")));
    return searchResult;
  }

  public void searchBtn() {
    click(searchBtn);
  }
}
