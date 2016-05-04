import org.fluentlenium.adapter.FluentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.junit.*;
import java.util.List;
import org.sql2o.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/restaurant", null, null);
  }
  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteReviewQuery = "DELETE FROM reviews *;";
      String deleteRestaurantQuery = "DELETE FROM restaurants *;";
      con.createQuery(deleteReviewQuery).executeUpdate();
      con.createQuery(deleteRestaurantQuery).executeUpdate();
    }
  }
  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }
  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Restaurant");
  }
  @Test
  public void restaurantIsCreatedTest(){
    goTo("http://localhost:4567/");
    click("a", withText("Add a Restaurant"));
    fill("#restaurantName").with("Matador");
    fill("#cuisineType").with("Mexican");
    fill("#city").with("Portland");
    submit(".btn");
    assertThat(pageSource()).contains("Your restaurant has been saved.");
  }
  // @Test
  // public void doctorIsSavedTest(){
  //   Doctor myDoctor = new Doctor("John Smith", "Endocrinologist");
  //   myDoctor.save();
  //   System.out.println(myDoctor.getId());
  //   String doctorPath = String.format("http://localhost:4567/doctors/%d", myDoctor.getId());
  //   goTo(doctorPath);
  //   assertThat(pageSource()).contains("John Smith");
  // }
}
