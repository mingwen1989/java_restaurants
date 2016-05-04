import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.List;

public class ReviewTest {

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
// //   @Test
// //   public void patient_instantiatesCorrectly_true() {
// //     Patient testPatient = new Patient("Jane Doe", "12-14-1980", 1);
// //     assertEquals(true, testPatient instanceof Patient);
// //   }
// //   @Test
// //   public void getName_instantiatesWithName_String() {
// //     Patient testPatient = new Patient("Jane Doe", "12-14-1980", 1);
// //     assertEquals("Jane Doe", testPatient.getName());
// //   }
// //   @Test
// //   public void getBirthdate_instantiatesWithBirthdate_String() {
// //     Patient testPatient = new Patient("Jane Doe", "12-14-1980", 1);
// //     assertEquals("12-14-1980", testPatient.getBirthdate());
// //   }
// //   @Test
// //   public void getId_patientsInstantiateWithAnID_1() {
// //     Patient testPatient = new Patient("Jane Doe", "12-14-1980", 1);
// //     testPatient.save();
// //     assertEquals(1, testPatient.getDoctorId());
// //   }
// //   @Test
// //   public void all_emptyAtFirst() {
// //     assertEquals(Patient.all().size(), 0);
// //   }
// //
// //   @Test
// //   public void equals_returnsTrueIfNamesAretheSame() {
// //     Patient firstPatient = new Patient("Jane Doe", "12-14-1980", 1);
// //     Patient secondPatient = new Patient("Jane Doe", "12-14-1980", 1);
// //     assertTrue(firstPatient.equals(secondPatient));
// //   }
// //   @Test
// //   public void find_findsPatientInDatabase_true() {
// //     Patient testPatient = new Patient("Jane Doe", "12-14-1980", 1);
// //     testPatient.save();
// //     Patient savedPatient = Patient.find(testPatient.getId());
// //     assertTrue(testPatient.getName().equals(savedPatient.getName()));
// //   }
// //   @Test
// //   public void save_assignsIdToObject() {
// //     Patient testPatient = new Patient("Jane Doe", "12-14-1980", 1);
// //     testPatient.save();
// //     Patient savedPatient = Patient.all().get(0);
// //     assertEquals(testPatient.getId(), savedPatient.getId());
// //   }
// //
// //   @Test
// //   public void save_returnsTrueIfNamesAretheSame() {
// //     Patient testPatient = new Patient("Jane Doe", "12-14-1980", 1);
// //     testPatient.save();
// //     assertTrue(Patient.all().get(0).getName().equals(testPatient.getName()));
// //   }
// //
// //   @Test
// //   public void save_savesDoctorIdIntoDB_true() {
// //     Doctor testDoctor = new Doctor("John Smith",  "Endocrinologist");
// //     testDoctor.save();
// //     Patient testPatient = new Patient("Jane Doe", "12-14-1980", testDoctor.getId());
// //     testPatient.save();
// //     Patient savedPatient = Patient.find(testPatient.getId());
// //     assertEquals(savedPatient.getDoctorId(), testDoctor.getId());
// //   }
// //   @Test
// //   public void find_returnsNullWhenNoPatientFound_null() {
// //     assertTrue(Patient.find(999) == null);
// //   }
}
