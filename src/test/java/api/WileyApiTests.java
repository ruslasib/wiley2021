package api;

import io.restassured.response.Response;
import org.junit.Before;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Part 2. API - task 1
 */
public class WileyApiTests {

  private String url = "https://www.wiley.com/en-us/search/autocomplete/comp_00001H9J?term=Java";

  @Before
  public void precondition() {
    url = "https://www.wiley.com/en-us/search/autocomplete/comp_00001H9J?term=Java";
  }

  @Test
  public void testSuggestionsInGetRs() {
    Response response = get(url);
    List<String> terms = response.jsonPath().getList("suggestions.term");
    assertThat(terms.size(), equalTo(4));
    assertThat(terms, everyItem(startsWith("<span class=\"search-highlight\">java</span>")));
  }

  @Test
  public void testTitleAttributeInGetRs() {
    Response response = get(url);
    List<String> titles = response.jsonPath().getList("pages.title");
    assertThat(titles.size(), equalTo(4));
    assertThat(titles, everyItem(containsString("Wiley")));
  }
}
