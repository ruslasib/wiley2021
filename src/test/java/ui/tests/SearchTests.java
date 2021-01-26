package ui.tests;

import ui.models.ProductItem;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Part 1 Task 2
 */
public class SearchTests extends TestBase {

  /**
   * Part 1 Task 2
   * 2.	Search functionality. Test should enter “Java” in the search input box and do not press the search button (with magnifying glass icon)
   * •	check area with related content is displayed right under the search header
   */
  @Test
  public void testSearchBeforePushingSearchButton() {
    String input = "Java";
    typeIn(wiley.searchPanel().searchInputField, input);
    assertThat(wiley.searchPanel().suggestions(), everyItem(containsString(input.toLowerCase())));
  }

  /**
   * Part 1 Task 2
   * 3.	Enter “Java” in the search input, press the search buttonand apply checks to verify that
   * •	only titles containing “Java” are displayed
   * •	there are 10 titleson the page
   */
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

  /**
   * Part 1 Task 2
   * 3.	Enter “Java” in the search input, press the search buttonand apply checks to verify that
   * •	each title has at least one “Add to Cart” buttonfor E-Book/Print version and “VIEW ON WILEY ONLINE LIBRARY” for O-BOOK version
   */
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
