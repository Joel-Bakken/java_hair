import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/clients", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      // model.put("stylists" ,Stylist.all());
      model.put("clients", Client.all());
      model.put("template", "templates/clients.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/stylists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("/clients/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Client client = Client.find(Integer.parseInt(request.params(":id")));
      model.put("client", client);
      model.put("template", "templates/client.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
      model.put("stylist", stylist);
      model.put("template", "templates/stylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:stylist_id/clients/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":stylist_id")));
      Client client = Client.find(Integer.parseInt(request.params(":id")));
      model.put("client", client);
      model.put("stylist", stylist);
      model.put("template", "templates/client.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/new-client", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/client-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/clients", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      String detail = request.queryParams("detail");
      Client newClient = new Client(name, detail, 1);
      newClient.save();
      model.put("template", "templates/success-cs.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/clients-stylists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String stylist = request.queryParams("stylist");
      String name = request.queryParams("name");
      String detail = request.queryParams("detail");
      int stylistId = Stylist.findDuplicate(stylist);
      if (stylistId == -1){
        Stylist newStylist = new Stylist(stylist);
        newStylist.save(); // Saves to the stylist database table
        stylistId = newStylist.getId();
      }// check if stylist is duplicate
      Client newClient = new Client(name, detail, stylistId);
      newClient.save(); // Saves client info to the database table
      model.put("template", "templates/success-cs.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/new-client", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/client-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/stylists-setup", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String
    })

    post("/stylists/:stylist_id/clients/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Client Client = Client.find(Integer.parseInt(request.params("id")));
      String details = request.queryParams("details");
      Stylist stylist = Stylist.find(task.getStylistId());
      client.update(details);
      String url = String.format("/stylists/%d/clients/%d", stylists.getId(), client.getId());
      response.redirect(url);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/clients/:client_id/client/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Client client = client.find(Integer.parseInt(request.params("id")));
      String description = request.queryParams("description");
      Category category = Category.find(task.getCategoryId());
      task.update(description);
      String url = String.format("/categories/%d/tasks/%d", category.getId(), task.getId());
      response.redirect(url);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
