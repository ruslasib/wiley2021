package tests;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EducationPageTests extends TestBase {

  @Test
  public void testEducationPage() {
   wiley.homePage().subjectsSubmenu().expand();
   wiley.homePage().subjectsSubmenu().education();
   assertThat(wiley.educationPage().headerText(), equalTo("Education"));
  }
}
