package tests;

import models.ProductItem;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
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
    List<ProductItem> productItems = new ArrayList<>();
    List<WebElement> products = wiley.searchResultPage().allProducts();
    int count = 0;
    for (WebElement product : products) {
      count = count + 1;
      ProductItem item = new ProductItem()
              .withTitle(wiley.searchResultPage().productTitleOf(product))
              .withSearchHighlightText(wiley.searchResultPage().searchHighlightTextOf(product))
              .withEbookTab(wiley.searchResultPage().isEbookTabExistsIn(product))
              .withPrintTab(wiley.searchResultPage().isPrintTabExistsIn(product))
              .withObookTab(wiley.searchResultPage().isObookTabExistsIn(product));
      productItems.add(item);
      System.out.println("Count: " + count + "\n" + item.toString());
    }
    for (ProductItem item : productItems) {
      assertThat(item.searchHighLightText().toLowerCase(), equalTo(input.toLowerCase()));
    }
    assertThat(productItems.size(), equalTo(10));
  }
}
