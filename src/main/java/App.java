import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.Map;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("restaurants", Restaurant.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/restaurants/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/new-restaurant-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/restaurants/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Restaurant restaurant = Restaurant.find(Integer.parseInt(request.params(":id")));
      model.put("restaurant", restaurant);
      model.put("template", "templates/restaurant.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/restaurants/:id/reviews", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Restaurant restaurant = Restaurant.find(Integer.parseInt(request.params(":id")));
      model.put("restaurant", restaurant);
      model.put("template", "templates/restaurant-reviews.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/restaurants/:id/reviews", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String newReview = request.queryParams("newReview");
      int newRating = Integer.parseInt(request.queryParams("newRating"));
      Restaurant restaurant = Restaurant.find(Integer.parseInt(request.params(":id")));
      Review review = new Review(newReview, restaurant.getId(), newRating);
      review.save();
      model.put("restaurant", restaurant);
      model.put("review", review);
      model.put("template", "templates/restaurant-reviews.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String restaurantName = request.queryParams("restaurantName");
      String cuisineType = request.queryParams("cuisineType");
      String city = request.queryParams("city");
      Restaurant newRestaurant = new Restaurant(restaurantName, cuisineType, city);
      newRestaurant.save();
      response.redirect("/");
      return null;
    });

    get("/cuisines/:cuisine", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String cuisine = request.params(":cuisine");
      model.put("cuisine", cuisine);
      model.put("restaurants", Restaurant.listRestaurantsByCuisine(cuisine));
      model.put("template", "templates/cuisine.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cuisines", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("cuisines", Restaurant.allCuisines());
      model.put("template", "templates/cuisines.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities/:city", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String city = request.params(":city");
      model.put("city", city);
      model.put("restaurants", Restaurant.listRestaurantsByCity(city));
      model.put("template", "templates/city.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("cities", Restaurant.allCities());
      model.put("template", "templates/cities.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
