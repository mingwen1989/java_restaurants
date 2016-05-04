import java.util.List;
import org.sql2o.*;
import java.util.Arrays;

public class Review {

  private int id;
  private String review_text;
  private int restaurant_id;
  private int rating;

  public Review(String review_text, int restaurant_id, int rating) {
      this.review_text = review_text;
      this.restaurant_id = restaurant_id;
      this.rating = rating;
  }
  public String getReview() {
    return review_text;
  }
  public int getId() {
    return id;
  }
  public int getRestaurantId() {
    return restaurant_id;
  }
  public int getRating() {
    return rating;
  }
  @Override
  public boolean equals(Object otherReview){
    if (!(otherReview instanceof Review)) {
      return false;
    } else {
      Review newReview = (Review) otherReview;
      return this.getReview().equals(newReview.getReview()) &&
             this.getId() == newReview.getId() &&
             this.getRestaurantId() == newReview.getRestaurantId() &&
             this.getRating() == newReview.getRating();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO reviews(review_text, restaurant_id, rating) VALUES (:review_text, :restaurant_id, :rating)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("review_text", this.review_text)
        .addParameter("restaurant_id", this.restaurant_id)
        .addParameter("rating", this.rating)
        .executeUpdate()
        .getKey();
    }
  }
  public static List<Review> all() {
  String sql = "SELECT id, review_text, restaurant_id, rating FROM reviews";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Review.class);
      }
  }
  public static Review find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM reviews where id=:id";
      Review review = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Review.class);
      return review;
    }
  }
}
