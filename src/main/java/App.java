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
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/restaurants/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/new-restaurant-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // get("/reviews/new", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   model.put("restaurants", Restauanr.all());
    //   model.put("template", "templates/new-patient-form.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

    post("/restaurants", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String restaurantName = request.queryParams("restaurantName");
      String cuisineType = request.queryParams("cuisineType");
      String city = request.queryParams("city");

      Restaurant newRestaurant = new Restaurant(restaurantName, cuisineType, city);
      newRestaurant.save();
      model.put("template", "templates/restaurant-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/restaurants", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("restaurants", Restaurant.all());
      model.put("template", "templates/restaurants.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // post("/patients", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   String patientName = request.queryParams("patientName");
    //   String birthdate = request.queryParams("birthdate");
    //   int restaurant = Integer.parseInt(request.queryParams("doctor"));
    //   Patient newPatient = new Patient(patientName, birthdate, doctor);
    //   newPatient.save();
    //   model.put("template", "templates/patient-success.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // get("/patients", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   model.put("patients", Patient.all());
    //   model.put("template", "templates/patients.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // get("/restaurants/:id", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   Doctor doctor = Doctor.find(Integer.parseInt(request.params(":id")));
    //   model.put("doctor", doctor);
    //   model.put("template", "templates/doctor.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
  }
}
