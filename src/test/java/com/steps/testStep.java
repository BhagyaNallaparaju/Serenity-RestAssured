package com.steps;



import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;
import net.thucydides.core.annotations.Step;

import org.json.simple.JSONObject;
import org.junit.Assert;

public class testStep {
  private Response res = null;
  String baseUrl="https://reqres.in";
  private String url;
  private RequestSpecification requestSpec;

  @Step
  public void load_the_Get_url(){
    url=baseUrl+ "/api/users/2";
    System.out.println("url >> "+url);
  }

  @Step
  public void load_the_post_url(){
    url=baseUrl+ "/api/users";
    System.out.println("url >> "+url);
  }

  @Step
  public void view_list_of_users_using_Get_API(){

    res= RestAssured.given().when().get(url);
    System.out.println("res"+res.asString());

  }

  @Step
  public int verify_status_code_as(){

    int statusCode=res.getStatusCode();
    return statusCode;
  }

  @Step
  public void validate_the_response(){
    JsonPath responseBody = res.jsonPath();
    System.out.println("jsonpath "+responseBody);
    Map<String, String> data = responseBody.getMap("data");
    System.out.println("data "+data);
    String firstName=data.get("first_name");
    System.out.println("data "+firstName);
    Assert.assertEquals("Correct first Name received in the Response", "Janet",firstName);
  }

  @Step
  public void register_users_using_post_API(){
    JSONObject requestParams = new JSONObject();
    requestParams.put("name", "morpheus");
    requestParams.put("job", "leader");
    res=
        RestAssured
            .given()
            .header("Content-Type","application/json")
            .body(requestParams.toJSONString())
            .when()
            .post(url);
    System.out.println("res"+res.asString());

  }

  @Step
  public void validate_the_post_response(){
    System.out.println("res "+res.body().asString());
    JsonPath responseBody = res.jsonPath();
    System.out.println("jsonpath "+responseBody);

    String name=responseBody.get("name");
    System.out.println("name "+name);
    Assert.assertEquals("Correct Name received in the Response", "morpheus",name);

    String job=responseBody.get("job");
    System.out.println("job "+job);
    Assert.assertEquals("Correct job received in the Response", "leader",job);
  }
}
