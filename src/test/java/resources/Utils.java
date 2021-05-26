package resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;

public abstract class Utils {
    protected String baseURI;
    protected RequestSpecBuilder requestSpecBuilder;
    protected RequestSpecification requestSpecification;
    protected ResponseSpecBuilder responseSpecBuilder;
    protected ResponseSpecification responseSpecification;
    protected Response response;
    protected int StatusCode;

    public Utils(String baseURI) {
        this.baseURI = baseURI;
        requestSpecBuilder = new RequestSpecBuilder();
        responseSpecBuilder = new ResponseSpecBuilder();
    }


    public String getResponseAsString() {
        return response.asString();
    }

    public <T> T getResponseAsClass(Class<T> type) throws IOException {
        return new ObjectMapper().readValue(getResponseAsString(), type);
    }


    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    protected abstract void generateRequest();

    protected abstract void sendRequest();

    protected abstract void validateResponse();

    public void setup() {
        generateRequest();
        sendRequest();
        validateResponse();
    }

}