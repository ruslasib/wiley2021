package pages.search;

import models.ProductItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

import java.util.ArrayList;
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
    List<WebElement> eBookTab = product.findElements(By.xpath(".//a/*[contains(text(),'E-Book')]"));
    if (isElementPresent(eBookTab)) {
      return true;
    } else return false;
  }

  public boolean isPrintTabExistsIn(WebElement product) {
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    List<WebElement> printTab = product.findElements(By.xpath(".//a/*[contains(text(),'Print')]"));
    if (isElementPresent(printTab)) {
      return true;
    } else return false;
  }

  public boolean isObookTabExistsIn(WebElement product) {
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    List<WebElement> oBookTab = product.findElements(By.xpath(".//a/*[contains(text(),'O-Book')]"));
    if (isElementPresent(oBookTab)) {
      return true;
    } else return false;
  }

  public boolean isPrintBookAvailableIn(WebElement product) {
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    List<WebElement> addToCart = product.findElements(By.cssSelector(".add-to-cart-button"));
    if (isElementPresent(addToCart)) {
      return true;
    } else return false;
  }

  public List<ProductItem> getProductItems() {
    List<ProductItem> productItems = new ArrayList<>();
    List<WebElement> products = allProducts();
    for (WebElement product : products) {
      ProductItem item = new ProductItem()
              .withTitle(productTitleOf(product))
              .withSearchHighlightText(searchHighlightTextOf(product))
              .withEbookTab(isEbookTabExistsIn(product))
              .withPrintTab(isPrintTabExistsIn(product))
              .withObookTab(isObookTabExistsIn(product));
      productItems.add(item);
      System.out.println(item.toString());
    }
    return productItems;
  }
}
