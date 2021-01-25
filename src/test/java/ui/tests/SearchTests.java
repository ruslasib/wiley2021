package ui.tests;

import ui.models.ProductItem;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTests extends TestBase {

  @Test
  public void testSearchBeforePushingSearchButton() {
    String input = "Java";
    typeIn(wiley.searchPanel().searchInputField, input);
    assertThat(wiley.searchPanel().suggestions(), everyItem(containsString(input.toLowerCase())));
  }

  @Test
  public void testSearchResults() {
    String input = "Java";
    typeIn(wiley.searchPanel().searchInputField, input);
    wiley.searchPanel().searchBtn();
    List<WebElement> products = wiley.searchResultPage().allProducts();
    List<ProductItem> productItems = wiley.searchResultPage().getAllProductItemsOf(products);
    for (ProductItem item : productItems) {
      assertThat(item.searchHighLightText().toLowerCase(), equalTo(input.toLowerCase()));
    }
    assertThat(productItems.size(), equalTo(10));
  }

  @Test
  public void testAvailableTypesOfProducts() {
    String input = "Java";
    wiley.homePage().goToHomePage();
    typeIn(wiley.searchPanel().searchInputField, input);
    wiley.searchPanel().searchBtn();
    List<WebElement> products = wiley.searchResultPage().allProducts();
    for (WebElement product : products) {
      wiley.searchResultPage().checkAddToCartBtnForEbookOf(product);
      wiley.searchResultPage().checkAddToCartBtnForPrintbookOf(product);
      wiley.searchResultPage().checkViewOnWileyOnlineLibraryBtnForObookOf(product);
    }
  }
}
