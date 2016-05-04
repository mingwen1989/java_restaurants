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

  //   get("/", (request, response) -> {
  //     HashMap<String, Object> model = new HashMap<String, Object>();
  //     model.put("template", "templates/index.vtl");
  //     return new ModelAndView(model, layout);
  //   }, new VelocityTemplateEngine());
  //
  //   get("/doctors/new", (request, response) -> {
  //     HashMap<String, Object> model = new HashMap<String, Object>();
  //     model.put("template", "templates/new-doctor-form.vtl");
  //     return new ModelAndView(model, layout);
  //   }, new VelocityTemplateEngine());
  //
  //   get("/patients/new", (request, response) -> {
  //     HashMap<String, Object> model = new HashMap<String, Object>();
  //     model.put("doctors", Doctor.all());
  //     model.put("template", "templates/new-patient-form.vtl");
  //     return new ModelAndView(model, layout);
  //   }, new VelocityTemplateEngine());
  //
  //   post("/doctors", (request, response) -> {
  //     HashMap<String, Object> model = new HashMap<String, Object>();
  //     String doctorName = request.queryParams("doctorName");
  //     String specialty = request.queryParams("specialty");
  //
  //     Doctor newDoctor = new Doctor(doctorName, specialty);
  //     newDoctor.save();
  //     model.put("template", "templates/doctor-success.vtl");
  //     return new ModelAndView(model, layout);
  //   }, new VelocityTemplateEngine());
  //
  //   get("/doctors", (request, response) -> {
  //     HashMap<String, Object> model = new HashMap<String, Object>();
  //     model.put("doctors", Doctor.all());
  //     model.put("template", "templates/doctors.vtl");
  //     return new ModelAndView(model, layout);
  //   }, new VelocityTemplateEngine());
  //
  //   post("/patients", (request, response) -> {
  //     HashMap<String, Object> model = new HashMap<String, Object>();
  //     String patientName = request.queryParams("patientName");
  //     String birthdate = request.queryParams("birthdate");
  //     int doctor = Integer.parseInt(request.queryParams("doctor"));
  //     Patient newPatient = new Patient(patientName, birthdate, doctor);
  //     newPatient.save();
  //     model.put("template", "templates/patient-success.vtl");
  //     return new ModelAndView(model, layout);
  //   }, new VelocityTemplateEngine());
  //
  //   get("/patients", (request, response) -> {
  //     HashMap<String, Object> model = new HashMap<String, Object>();
  //     model.put("patients", Patient.all());
  //     model.put("template", "templates/patients.vtl");
  //     return new ModelAndView(model, layout);
  //   }, new VelocityTemplateEngine());
  //
  //   get("/doctors/:id", (request, response) -> {
  //     HashMap<String, Object> model = new HashMap<String, Object>();
  //     Doctor doctor = Doctor.find(Integer.parseInt(request.params(":id")));
  //     model.put("doctor", doctor);
  //     model.put("template", "templates/doctor.vtl");
  //     return new ModelAndView(model, layout);
  //   }, new VelocityTemplateEngine());
  }
}
