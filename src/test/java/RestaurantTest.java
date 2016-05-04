import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class RestaurantTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/restaurant_test", null, null);
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
  @Test
  public void Restaurant_instantiatesCorrectly_true() {
    Restaurant testRestaurant = new Restaurant("Matador", "Mexican", "Portland");
    assertEquals(true, testRestaurant instanceof Restaurant);
  }
  @Test
  public void getName_restaurantInstantiatesWithName_name() {
    Restaurant testRestaurant = new Restaurant("Matador", "Mexican", "Portland");
    assertEquals("Matador", testRestaurant.getName());
  }
  @Test
  public void all_emptyAtFirst() {
    assertEquals(Restaurant.all().size(), 0);
  }
  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Restaurant firstRestaurant = new Restaurant("Matador", "Mexican", "Portland");
    Restaurant secondRestaurant = new Restaurant("Matador", "Mexican", "Portland");
    assertTrue(firstRestaurant.equals(secondRestaurant));
  }
  @Test
  public void save_returnsTrueIfSaved_true() {
    Restaurant testRestaurant = new Restaurant("Matador", "Mexican", "Portland");
    testRestaurant.save();
    assertEquals(Restaurant.all().get(0).getName(),testRestaurant.getName());
  }
  @Test
    public void save_assignsIdToObject() {
    Restaurant testRestaurant = new Restaurant("Matador", "Mexican", "Portland");
    testRestaurant.save();
    Restaurant savedRestaurant = Restaurant.all().get(0);
    assertEquals(testRestaurant.getId(), savedRestaurant.getId());
  }
  // @Test
  //   public void find_findDoctorInDatabase_true() {
  //   Doctor testDoctor = new Doctor("John Smith", "Endocrinologist");
  //   testDoctor.save();
  //   Doctor savedDoctor = Doctor.find(testDoctor.getId());
  //   assertEquals(savedDoctor.getName(), testDoctor.getName());
  // }
  // @Test
  // public void getPatients_retrievesAllPatientsFromDatabase_patientsList() {
  //   Doctor testDoctor = new Doctor("John Smith",  "Endocrinologist");
  //   testDoctor.save();
  //   Patient firstPatient = new Patient("Jane Doe", "12-14-1980", testDoctor.getId());
  //   firstPatient.save();
  //   Patient secondPatient = new Patient("Susan Summers", "11-13-1970", testDoctor.getId());
  //   secondPatient.save();
  //   Patient[] patients = new Patient[] { firstPatient, secondPatient };
  //   System.out.println(testDoctor.getPatients().size());
  //   assertEquals(testDoctor.getPatients().size(), 2);
  // }
}
