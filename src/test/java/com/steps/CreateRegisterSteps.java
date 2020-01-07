package com.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import com.restAssured.constants.Constants;
import com.reusableMethods.Utilities;

import net.thucydides.core.annotations.Step;

import org.json.JSONObject;
import org.junit.Assert;

public class CreateRegisterSteps {
  private Response res = null;
  private String url;
  private RequestSpecification requestSpec;

  @Step
  public void load_the_Post_request(String url1){
    url= Constants.baseUrl+ Utilities.setValue(url1) ;
  }

  @Step
  public Response users_register_using_post_API(Map<String, String> entry){
    res=
        RestAssured
            .given()
            .header("Content-Type","application/json")
            .body(entry)
            .when()
            .post(url);
    return res;
  }

  @Step
  public void verify_registers_status_code_as(Response res, int expectedStatusCode){
    int actualStatusCode=res.getStatusCode();
    Assert.assertEquals("Expected status code to be",expectedStatusCode,actualStatusCode);
  }
  @Step
  public void validate_the_response_as(Response res, String id,String token){
    String response=res.body().asString();
    JSONObject actualResonse=new JSONObject(response);
    Assert.assertTrue("id key should be present",actualResonse.has("id"));
    Assert.assertTrue("token key should be present",actualResonse.has("token"));
    Assert.assertEquals("id value should match ",Integer.parseInt(id),actualResonse.get("id"));
    Assert.assertEquals("token value should match ",token,actualResonse.get("token"));

  }

  @Step
  public void validate_the_invalid_response(Response res){
    String response=res.body().asString();
    JSONObject actualResonse=new JSONObject(response);
    Assert.assertTrue("error key should be present",actualResonse.has("error"));
    Assert.assertEquals("error value should match ",Constants.error,actualResonse.get("error"));


  }
}
