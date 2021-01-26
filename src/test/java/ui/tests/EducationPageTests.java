package ui.tests;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 4.	Go to Subjects top menu, select Education
 * •	Check “Education” header is displayed
 * •	13 items are displayed under “Subjects” on the left side of the screen and the texts are: "Information & Library Science","Education & Public Policy",
 * "K-12 General", "Higher Education General","Vocational Technology","Conflict Resolution & Mediation (School settings)","Curriculum Tools- General",
 * "Special Educational Needs","Theory of Education", "Education Special Topics", "Educational Research & Statistics", "Literacy & Reading", "Classroom Management"
 */
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
