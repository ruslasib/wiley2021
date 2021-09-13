package api.tests;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ImageTests {

  @Test
  public void testImage() {
    String url = "https://httpbin.org/image/png";
    RequestSpecification request = given();
    Response response = request.get(url);
    String actual = encodeImageToBASE64(response.getBody());
    String expected = "aW8ucmVzdGFzc3VyZWQuaW50ZXJuYWwuUmVzdEFzc3VyZWRSZXNwb25zZUltcGxA";

    expect().
            statusCode(200).
            and().
            header("Content-Type", equalTo("image/png")).
            header("Content-Length", equalTo("8090")).
            and().
            when().
            get(url);
    assertThat(actual, containsString(expected));
  }

  private String encodeImageToBASE64(ResponseBody body) {
    return Base64.getEncoder().encodeToString(body.toString().getBytes(StandardCharsets.UTF_8));
  }
}
