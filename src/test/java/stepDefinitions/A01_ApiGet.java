package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

import static base_url.AutomationExerciseBaseUrl.spec;
import static io.restassured.RestAssured.*;

public class A01_ApiGet {

    Response response;
    JsonPath json;

    @Then("Url {string}")
    public void url(String pathParams) {

        spec.pathParam("1",pathParams);

    }

    @Then("Request Method GET")
    public void requestMethodGET() {

     response  = given().spec(spec).when().get("/{1}");

     json = response.jsonPath();
     json.prettyPrint();

    }

    @Then("Response Code {int}")
    public void responseCode(int responseCode) {

        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(responseCode,json.getInt("responseCode"));

    }

    @And("Response JSON All products list")
    public void responseJSONAllProductsList() {

        List<String> name = json.getList("products.name");
        System.out.println("name = " + name);

        List<String>  userType = json.getList("products.category.usertype.usertype");
        System.out.println("userType = " + userType);

        List<String> category = json.getList("products.category.findAll{it.category}.category");
        System.out.println("category = " + category);

        List<Integer> products = json.getList("products.id");
        System.out.println("products = " + products);
        System.out.println("Products list" + " " + products.size());

        List<String> price = json.getList("products.price");
        System.out.println("price = " + price);

        List<String> brand = json.getList("products.findAll{it.id>35}.brand");
        System.out.println("brand = " + brand);


    }
}
