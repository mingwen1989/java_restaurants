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
  // @Override
  // public boolean equals(Object otherRestaurant) {
  //   if (!(otherRestaurant instanceof Restaurant)) {
  //     return false;
  //   } else {
  //     Restaurant newRestaurant = (Restaurant) otherRestaurant;
  //     return this.getName().equals(newRestaurant.getName()) &&
  //            this.getCuisineType() == newRestaurant.getCuisineType() &&
  //            this.getCity() == newRestaurant.getCity();
  //   }
  // }
  public String getName() {
    return name;
  }


  public static List<Restaurant> all() {
  String sql = "SELECT id, name, cuisine_type, city FROM restaurants";
  try(Connection con = DB.sql2o.open()) {
    return con.createQuery(sql).executeAndFetch(Restaurant.class);
  }
}
}
