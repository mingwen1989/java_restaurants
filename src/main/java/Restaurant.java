import java.util.List;
import java.util.Arrays;
import org.sql2o.*;

public class Restaurant {

  private int id;
  private String name;
  private String cuisine_type;
  private String city;

  public Restaurant(String name, String cuisine_type, String city) {
    this.name = name;
    this.cuisine_type = cuisine_type;
    this.city = city;
  }
  @Override
  public boolean equals(Object otherRestaurant) {
    if (!(otherRestaurant instanceof Restaurant)) {
      return false;
    } else {
      Restaurant newRestaurant = (Restaurant) otherRestaurant;
      return this.getName().equals(newRestaurant.getName()) &&
             this.getCuisine() == newRestaurant.getCuisine() &&
             this.getCity() == newRestaurant.getCity();
    }
  }
  public String getName() {
    return name;
  }
  public String getCuisine() {
    return cuisine_type;
  }
  public String getCity() {
    return city;
  }

  public int getId() {
    return id;
  }

  public static List<Restaurant> all() {
  String sql = "SELECT id, name, cuisine_type, city FROM restaurants";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Restaurant.class);
    }
  }
  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO restaurants(name, cuisine_type, city) VALUES (:name, :cuisine_type, :city)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("cuisine_type", this.cuisine_type)
        .addParameter("city", this.city)
        .executeUpdate()
        .getKey();
    }
  }
  public static Restaurant find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM restaurants where id=:id";
      Restaurant restaurant = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Restaurant.class);
      return restaurant;
    }
  }
  public List<Review> getReviews() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM reviews where restaurant_id=:id";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Review.class);
    }
  }
}
