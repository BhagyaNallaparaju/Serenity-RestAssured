package com.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import com.restAssured.constants.Constants;
import com.reusableMethods.Utilities;

import net.thucydides.core.annotations.Step;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

public class ListUsersSteps {
  private Response res = null;
  private String url;
  private RequestSpecification requestSpec;

  @Step
  public void load_the_Get_request(String url1){
    url=Constants.baseUrl+ Utilities.setValue(url1) ;
  }

  @Step
  public Response get_the_list_of_user_details_using_Get_API(){
    res= RestAssured.given().when().get(url);
    return res;
  }

  @Step
  public void verify_users_status_code_as(Response res,int actualStatusCode){
    int expectedStatusCode=res.getStatusCode();
    Assert.assertEquals("Expected status code to be",expectedStatusCode,actualStatusCode);
  }

  @Step
  public void validate_the_users_response(Response res){

    String response=res.body().asString();
    JSONObject jsonObjRes=new JSONObject(response);
    JSONArray dataDetails = jsonObjRes.getJSONArray("data");
    for(int i=0;i<dataDetails.length();i++)
    {
      JSONObject data=dataDetails.getJSONObject(i);
      Assert.assertTrue("Id should be present",data.has("id"));
    }
  }
}
