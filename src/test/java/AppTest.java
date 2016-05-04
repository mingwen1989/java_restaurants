import org.fluentlenium.adapter.FluentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.junit.*;
import java.util.List;
import org.sql2o.*;

public class AppTest extends FluentTest {
  // public WebDriver webDriver = new HtmlUnitDriver();
  // @Before
  // public void setUp() {
  //   DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/office", null, null);
  // }
  //
  // @After
  // public void tearDown() {
  //   try(Connection con = DB.sql2o.open()) {
  //     String deletePatientsQuery = "DELETE FROM patients *;";
  //     String deleteDoctorsQuery = "DELETE FROM doctors *;";
  //     con.createQuery(deletePatientsQuery).executeUpdate();
  //     con.createQuery(deleteDoctorsQuery).executeUpdate();
  //   }
  // }
  //
  // @Override
  // public WebDriver getDefaultDriver() {
  //   return webDriver;
  // }
  //
  // @ClassRule
  // public static ServerRule server = new ServerRule();
  //
  // @Test
  // public void rootTest() {
  //   goTo("http://localhost:4567/");
  //   assertThat(pageSource()).contains("Welcome");
  // }
  // @Test
  // public void doctorIsCreatedTest(){
  //   goTo("http://localhost:4567/");
  //   click("a", withText("Add a Doctor"));
  //   fill("#doctorName").with("John Smith");
  //   fill("#specialty").with("Endocrinologist");
  //   submit(".btn");
  //   assertThat(pageSource()).contains("Your doctor has been saved.");
  // }
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
