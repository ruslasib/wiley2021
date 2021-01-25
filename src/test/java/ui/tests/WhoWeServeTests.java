package ui.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhoWeServeTests extends TestBase {

  @BeforeClass
  public void precondition() {
    wiley.homePage().clickWhoWeServe();
  }

  @Test
  public void testWhoWeServeItemsQuantity() {
    assertThat(wiley.whoWeServeSubMenu().itemsQuantity(), equalTo(12));
  }

  @Test
  public void testWhoWeServeItemsNames() {
    List<String> expectedNames = Arrays.asList("Students", "Instructors", "Book Authors", "Professionals", "Researchers", "Institutions"
            , "Librarians", "Corporations", "Societies", "Journal Editors", "Bookstores", "Government");
    assertThat(wiley.whoWeServeSubMenu().itemsNames(), equalTo(expectedNames));
  }
}
