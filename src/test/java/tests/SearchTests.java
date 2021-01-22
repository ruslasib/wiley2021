package tests;

import models.ProductItem;
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
    List<ProductItem> productItems = wiley.searchResultPage().getProductItems();
    for (ProductItem item : productItems) {
      assertThat(item.searchHighLightText().toLowerCase(), equalTo(input.toLowerCase()));
    }
    assertThat(productItems.size(), equalTo(10));
  }
}
