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



      model.put("template", "templates/new-patient-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/restaurants/:id/reviews/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("restaurants", Restaurant.all());
      model.put("template", "templates/new-patient-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String restaurantName = request.queryParams("restaurantName");
      String cuisineType = request.queryParams("cuisineType");
      String city = request.queryParams("city");

      Restaurant newRestaurant = new Restaurant(restaurantName, cuisineType, city);
      newRestaurant.save();
      model.put("template", "templates/restaurant-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
