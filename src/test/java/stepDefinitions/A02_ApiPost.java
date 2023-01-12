package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Category;
import pojos.Products;
import pojos.UserType;

import static base_url.AutomationExerciseBaseUrl.spec;
import static io.restassured.RestAssured.given;


public class A02_ApiPost {

    /*
     "responseCode": 200,
        "products": [
            {
                "id": 1,
                "name": "Blue Top",
                "price": "Rs. 500",
                "brand": "Polo",
                "category": {
                    "usertype": {
                        "usertype": "Women"
                    },
                    "category": "Tops"
                }
            },
     */

    Response response;
    JsonPath json;


    @Given("B_Url {string}")
    public void b_url(String pathparams) {

        spec.pathParam("1",pathparams);

    }

    @Then("B_Request Method POST")
    public void b_requestMethodPOST() {

        UserType userType = new UserType("Women");
        Category category = new Category(userType, "bag");
        Products expectedData = new Products(100, "Red Top", "Rs.200", "Mavi", category);
        System.out.println("expectedData = " + expectedData);

        response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{1}");



    }

    @Then("B_Response Code {int}")
    public void b_responseCode(int responseCode) {

        json = response.jsonPath();
        json.prettyPrint();
        Assert.assertEquals(responseCode,json.getInt("responseCode"));

    }

    @And("B_Response Message {string}")
    public void b_responseMessage(String message) {


        Assert.assertEquals(message,json.getString("message"));

    }
}
