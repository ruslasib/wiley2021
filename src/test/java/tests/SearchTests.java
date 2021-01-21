package tests;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTests extends TestBase {

  @Test
  public void testSearch() {
    String input = "Java";
    typeIn(wiley.searchPanel().searchInputField, input);
    assertThat(wiley.searchPanel().suggestions(), everyItem(containsString(input.toLowerCase())));
  }
}
