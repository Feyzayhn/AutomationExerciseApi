package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

import static base_url.AutomationExerciseBaseUrl.spec;
import static io.restassured.RestAssured.given;

public class A03_ApiGet {

    Response response;
    JsonPath json;
    @Given("C_Url {string}")
    public void c_url(String pathParams) {

        spec.pathParam("1", pathParams);

    }

    @Then("C_Request Method GET")
    public void c_requestMethodGET() {

        response = given().spec(spec).when().get("/{1}");
        json = response.jsonPath();
        json.prettyPrint();
    }

    @Then("C_Response Code {int}")
    public void c_responseCode(int responseCode) {

        Assert.assertEquals(responseCode,json.getInt("responseCode"));

    }

    @And("C_Response JSON All brands list")
    public void c_responseJSONAllBrandsList() {

        List<String> brands = json.getList("products.brand");
        System.out.println("All brands list = " + brands);
    }
}
