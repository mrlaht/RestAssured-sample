package Request;

import resources.Utils;

import static io.restassured.RestAssured.given;

public class GetPosts extends Utils{

    String path = "/posts";
    Integer userId;

     public GetPosts(String baseURI) {
        super(baseURI);
        }

    public int getUserId() {
        return userId;
        }

public void setUserId(int userId) {
        this.userId = userId;
        }

    @Override
    protected void generateRequest() {
        requestSpecBuilder.setBaseUri(baseURI);
        requestSpecBuilder.setBasePath(path);
        requestSpecification = requestSpecBuilder.build();
    }

    @Override
    protected void sendRequest() {
        response = given().spec(requestSpecification).param("userId", userId).get();
    }




@Override
protected void validateResponse() {
        responseSpecBuilder.expectStatusCode(StatusCode);
        responseSpecification = responseSpecBuilder.build();
        response.then().spec(responseSpecification);

        }
        }
