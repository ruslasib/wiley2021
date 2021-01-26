package ui.pages.search;

import ui.models.ProductItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchResultPage extends Page {

  private WebDriver driver;

  public SearchResultPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  By addToCartBtnLocator = By.className("add-to-cart-button");
  By eBookTabLocator = By.xpath(".//a/*[contains(text(),'E-Book')]");
  By productTitleLocator = By.cssSelector(".product-title");
  By searchHighlightTextLocator = By.cssSelector(".search-highlight");
  By printBookTabLocator = By.xpath(".//a/*[contains(text(),'Print')]");
  By oBookTabLocator = By.xpath(".//a/*[contains(text(),'O-Book')]");
  By viewOnWileyOnlineLibraryLocator = By.className("learn-more-button");
  By productNotAvailableForPurchaseLocator = By.className("pr-not-available");

  @FindBy(className = "product-item")
  private List<WebElement> allProducts;

  public List<WebElement> allProducts() {
    return allProducts;
  }

  public String productTitleOf(WebElement product) {
    return product.findElement(productTitleLocator).getAttribute("textContent").trim();
  }

  public String searchHighlightTextOf(WebElement product) {
    return product.findElement(searchHighlightTextLocator).getAttribute("textContent");
  }

  public boolean isEbookTabExistsIn(WebElement product) {
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    List<WebElement> eBookTab = product.findElements(eBookTabLocator);
    if (isElementPresent(eBookTab)) {
      return true;
    } else return false;
  }

  public boolean isPrintTabExistsIn(WebElement product) {
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    List<WebElement> printTab = product.findElements(printBookTabLocator);
    if (isElementPresent(printTab)) {
      return true;
    } else return false;
  }

  public boolean isObookTabExistsIn(WebElement product) {
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    List<WebElement> oBookTab = product.findElements(oBookTabLocator);
    if (isElementPresent(oBookTab)) {
      return true;
    } else return false;
  }

  public boolean isPrintBookAvailableIn(WebElement product) {
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    List<WebElement> addToCart = product.findElements(addToCartBtnLocator);
    if (isElementPresent(addToCart)) {
      return true;
    } else return false;
  }

  public List<ProductItem> getAllProductItemsOf(List<WebElement> products) {
    List<ProductItem> productItems = new ArrayList<>();
    for (WebElement product : products) {
      ProductItem item = fillProductItem(product);
      productItems.add(item);
      System.out.println(item.toString());
    }
    return productItems;
  }

  public ProductItem getSingleProductItemOf(WebElement product) {
    ProductItem item = fillProductItem(product);
    return item;
  }

  public void checkAddToCartBtnForEbookOf(WebElement product) {
    ProductItem productItem = getSingleProductItemOf(product);
    System.out.println("Checking E-Book...\n" + productItem.toString());
    if(productItem.isEbookTabExists()) {
      WebElement eBookTab = product.findElement(eBookTabLocator);
      click(eBookTab);
      List<WebElement> addToCartOfEbookBtn = product.findElements(addToCartBtnLocator);
      assertThat(isElementPresent(addToCartOfEbookBtn), equalTo(true));
    }
  }

  public void checkAddToCartBtnForPrintbookOf(WebElement product) {
    ProductItem productItem = getSingleProductItemOf(product);
    boolean exists = false;
    System.out.println("Checking Printbook...\n" + productItem.toString());
    if(productItem.isPrintTabExists()) {
      WebElement printBookTab = product.findElement(printBookTabLocator);
      click(printBookTab);
      List<WebElement> addToCartOfPrintbookBtn = product.findElements(addToCartBtnLocator);
      List<WebElement> productNotAvailableForPurchase = product.findElements(productNotAvailableForPurchaseLocator);
      if (isElementPresent(addToCartOfPrintbookBtn) || isElementPresent(productNotAvailableForPurchase)) {
        exists = true;
        assertThat(exists, equalTo(true));
      }
    }
  }

  public void checkViewOnWileyOnlineLibraryBtnForObookOf(WebElement product) {
    ProductItem productItem = getSingleProductItemOf(product);
    System.out.println("Checking O-Book...\n" + productItem.toString());
    if(productItem.isObookTabExists()) {
      WebElement oBookTab = product.findElement(oBookTabLocator);
      click(oBookTab);
      List<WebElement> viewOnWileyOnlineLibraryBtn = product.findElements(viewOnWileyOnlineLibraryLocator);
      assertThat(isElementPresent(viewOnWileyOnlineLibraryBtn), equalTo(true));}
  }

  private ProductItem fillProductItem(WebElement product) {
    return new ProductItem()
            .withTitle(productTitleOf(product))
            .withSearchHighlightText(searchHighlightTextOf(product))
            .withEbookTab(isEbookTabExistsIn(product))
            .withPrintTab(isPrintTabExistsIn(product))
            .withObookTab(isObookTabExistsIn(product));
  }
}
