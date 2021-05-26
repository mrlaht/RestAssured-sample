package Request;

import resources.Utils;

import static io.restassured.RestAssured.given;

public class GetUsers extends Utils {

    String path = "/users";
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public GetUsers(String baseURI) {
        super(baseURI);
    }

    @Override
    protected void generateRequest() {
        requestSpecBuilder.setBaseUri(baseURI);
        requestSpecBuilder.setBasePath(path);
        requestSpecification = requestSpecBuilder.build();
    }

    @Override
    protected void sendRequest() {
        response = given().spec(requestSpecification).param("username", username).get();
    }

    @Override
    protected void validateResponse() {
        responseSpecBuilder.expectStatusCode(StatusCode);
        responseSpecification = responseSpecBuilder.build();
        response.then().spec(responseSpecification);
    }

}
