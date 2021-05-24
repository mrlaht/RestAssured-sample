package MobiTest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;

public class MobiquityTest {

    @BeforeSuite
    public void url() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

    }

    @Test
    public static void searchForUser() {
        String response = given().log().all()
                .when().get("/users")
                .then().assertThat().statusCode(200).extract().response().asString();

        JsonPath js = new JsonPath(response);
        int userCount = js.getInt("object.size()");
        System.out.println(userCount+ " number of post");
        String userId = null;
        for (int i = 0; i < userCount; i++) {

            if (js.getString("[" + i + "].username").equalsIgnoreCase("Delphine")) {
                userId = js.getString("[" + i + "].id");
                String username = js.getString("[" + i + "].username");
                System.out.println(userId);
                System.out.println(username);

            }
        }
    }
}
