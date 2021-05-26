package Request;


import resources.Utils;

import static io.restassured.RestAssured.given;

public class GetComments extends Utils {

    String path = "/comments";
    int postId;



    public GetComments(String baseURI) {
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

                response = given().spec(requestSpecification).param("postId", postId).get();
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }




    @Override
    protected void validateResponse() {
        responseSpecBuilder.expectStatusCode(StatusCode);
        responseSpecification = responseSpecBuilder.build();
        response.then().spec(responseSpecification);

    }
}
