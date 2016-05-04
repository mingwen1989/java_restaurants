import java.util.List;
import org.sql2o.*;
import java.util.Arrays;

public class Review {

  private int id;
  private String review_text;
  private String restaurants_id;
  private String rating;

  public Review(String review_text, String restaurants_id, String rating) {
      this.review_text = review_text;
      this.restaurants_id = restaurants_id;
      this.rating = rating;
  }
  // public String getName() {
  //   return name;
  // }
  // public int getId() {
  //   return id;
  // }
}
