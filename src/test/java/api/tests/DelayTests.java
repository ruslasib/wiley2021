package api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;


public class DelayTests {

  private Response response;
  private RequestSpecification request;
  String testData = "";

  @BeforeTest
  public void precondition() {
    RestAssured.baseURI = "https://httpbin.org/";
    request = given();
    request.header("accept", "application/json");
  }

  @Test
  public void testDelay1() {
    testData = "1";
    response = request.post("/delay");
    expect().
            statusCode(200).
            and().
            body("headers.Content-Type", equalTo("application/x-www-form-urlencoded; charset=ISO-8859-1")).
            body("origin", equalTo("90.154.70.114")).
            body("url", equalTo("https://httpbin.org/delay/" + testData)).
            and().
            header("content-type", "application/json").
            when().
            post("/delay/" + testData);
  }

  @Test
  public void testDelay5() {
    testData = "5";
    response = request.post("/delay");
    expect().
            statusCode(200).
            and().
            body("origin", equalTo("90.154.70.114")).
            body("url", equalTo("https://httpbin.org/delay/" + testData)).
            and().
            when().
            post("/delay/" + testData);
  }

  @Test
  public void testDelay10() {
    testData = "10";
    response = request.post("/delay");
    expect().
            statusCode(200).
            and().
            body("origin", equalTo("90.154.70.114")).
            body("url", equalTo("https://httpbin.org/delay/" + testData)).
            and().
            when().
            post("/delay/" + testData);
  }

  @Test
  public void testDelay11() {
    testData = "11";
    response = request.post("/delay");
    expect().
            statusCode(200).
            and().
            body("origin", equalTo("90.154.70.114")).
            body("url", equalTo("https://httpbin.org/delay/" + testData)).
            and().
            when().
            post("/delay/" + testData);
  }

  @Test
  public void testDelay0() {
    testData = "0";
    response = request.post("/delay");
    expect().
            statusCode(200).
            and().
            body("origin", equalTo("90.154.70.114")).
            body("url", equalTo("https://httpbin.org/delay/" + testData)).
            and().
            when().
            post("/delay/" + testData);
  }

  @Test
  public void testDelayIsDecimal() {
    testData = "0.1";
    response = request.post("/delay");
    expect().
            statusCode(200).
            and().
            body("origin", equalTo("90.154.70.114")).
            body("url", equalTo("https://httpbin.org/delay/" + testData)).
            and().
            when().
            post("/delay/" + testData);
  }

  @Test
  public void testDelayIsEmpty() {
    testData = "";
    response = request.post("/delay");
    expect().
            statusCode(404).
            when().
            post("/delay/" + testData);
  }

  @Test
  public void testDelayIsNotNumber() {
    testData = "0,1";
    response = request.post("/delay");
    expect().
            statusCode(500).
            when().
            post("/delay/" + testData);
  }

  @Test
  public void testDelayIsLetter() {
    testData = "a";
    response = request.post("/delay");
    expect().
            statusCode(500).
            when().
            post("/delay/" + testData);
  }

  @Test
  public void testDelayIsSymbol() {
    testData = "#";
    response = request.post("/delay");
    expect().
            statusCode(500).
            when().
            post("/delay/" + testData);
  }

  @Test
  public void testDelayIsSQLIngection() {
    testData = "1'--'";
    response = request.post("/delay");
    expect().
            statusCode(500).
            when().
            post("/delay/" + testData);
  }
}
