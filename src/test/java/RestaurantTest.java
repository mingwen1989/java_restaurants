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
  @Test
    public void find_findRestaurantInDatabase_true() {
    Restaurant testRestaurant = new Restaurant("Matador", "Mexican", "Portland");
    testRestaurant.save();
    Restaurant savedRestaurant = Restaurant.find(testRestaurant.getId());
    assertEquals(savedRestaurant.getName(), testRestaurant.getName());
  }
  @Test
  public void getReviews_retrievesAllReviewsFromDatabase_reviewsList() {
    Restaurant testRestaurant = new Restaurant("Matador", "Mexican", "Portland");
    testRestaurant.save();
    Review firstReview = new Review("This is a good restaurant.", testRestaurant.getId(), 4);
    firstReview.save();
    Review secondReview = new Review("This is a terrible restaurant.", testRestaurant.getId(), 1);
    secondReview.save();
    Review[] reviews = new Review[] { firstReview, secondReview };
    assertEquals(testRestaurant.getReviews().size(), 2);
  }
}
