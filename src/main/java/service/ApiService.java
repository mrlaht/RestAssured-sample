package service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiService {
    public static Response doGetRequest(String endpoint) {
        RestAssured.defaultParser = Parser.JSON;
        return given().when().get(endpoint).
                then().assertThat().statusCode(200).contentType(ContentType.JSON).extract().response();
    }
    public static Response doGetRequestWithParam(String endpoint, String pName, Integer pValue) {
        RestAssured.defaultParser = Parser.JSON;
        return given().queryParam(pName, pValue).when().get(endpoint).
                then().assertThat().statusCode(200).contentType(ContentType.JSON).extract().response();
    }
}
