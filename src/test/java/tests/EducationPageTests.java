package tests;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EducationPageTests extends TestBase {

  @Test
  public void testEducationPage() {
   wiley.homePage().subjectsSubmenu().expand();
   wiley.homePage().subjectsSubmenu().education();
   assertThat(wiley.educationPage().headerText(), equalTo("Education"));
  }

  @Test
  public void testSubjectsPanel() {
    wiley.homePage().goToHomePage();
    wiley.homePage().subjectsSubmenu().expand();
    wiley.homePage().subjectsSubmenu().education();
    List<String> expected = Arrays.asList("Information & Library Science", "Education & Public Policy", "K-12 General", "Higher Education General", "Vocational Technology"
            , "Conflict Resolution & Mediation (School settings)", "Curriculum Tools- General", "Special Educational Needs", "Theory of Education", "Education Special Topics"
            , "Educational Research & Statistics", "Literacy & Reading", "Classroom Management");
    assertThat(wiley.educationPage().subjectsPanel().items().toString(), equalTo(expected.toString()));
  }
}
