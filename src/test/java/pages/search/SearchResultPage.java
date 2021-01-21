package pages.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchResultPage extends Page {

  private WebDriver driver;

  public SearchResultPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  @FindBy(className = "product-item")
  public List<WebElement> allProducts;

  @FindBy(className = "product-item")
  public WebElement productItem;

  @FindBy(className = "product-title")
  public WebElement productTitle;

  @FindBy(className = "search-highlight")
  public WebElement searchHighlightText;

  @FindBy(xpath = "//a/*[contains(text(),'E-Book')]")
  public WebElement eBookTab;

  @FindBy(xpath = "//a/*[contains(text(),'Print')]")
  public WebElement printTab;

  @FindBy(xpath = "//a/*[contains(text(),'O-Book')]")
  public WebElement oBookTab;

  @FindBy(className = "add-to-cart-button")
  public WebElement addToCartBtn;

  public List<WebElement> allProducts() {
    return allProducts;
  }

  public String productTitleOf(WebElement product) {
    return product.findElement(By.cssSelector(".product-title")).getAttribute("textContent").trim();
  }

  public String searchHighlightTextOf(WebElement product) {
    return product.findElement(By.cssSelector(".search-highlight")).getAttribute("textContent");
  }

  public boolean isEbookTabExistsIn(WebElement product) {
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    if (product.findElements(By.xpath(".//a/*[contains(text(),'E-Book')]")).size() > 0) {
      return true;
    } else return false;
  }

  public boolean isPrintTabExistsIn(WebElement product) {
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    if (product.findElements(By.xpath(".//a/*[contains(text(),'Print')]")).size() > 0) {
      return true;
    } else return false;
  }

  public boolean isObookTabExistsIn(WebElement product) {
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    if (product.findElements(By.xpath(".//a/*[contains(text(),'O-Book')]")).size() > 0) {
      return true;
    } else return false;
  }

  public boolean isPrintBookAvailableIn(WebElement product) {
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    if (product.findElements(By.cssSelector(".add-to-cart-button")).size() > 0) {
      return true;
    } else return false;
  }
}
