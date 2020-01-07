package com.stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import com.steps.CreateRegisterSteps;

import net.thucydides.core.annotations.Steps;

public class CreateRegisterSD {
  private Response registerResponse = null;

  @Steps CreateRegisterSteps steps;


  @Given("^Load the Post request \"([^\"]*)\"$")
  public void load_the_Post_request(String url) throws Exception {
    steps.load_the_Post_request(url);
  }

  @When("^Users register using post API$")
  public void users_register_using_post_API(Map<String, String> entry) throws Exception {
    registerResponse= steps.users_register_using_post_API(entry);
  }

  @Then("^Verify registers status code as (\\d+)$")
  public void verify_registers_status_code_as(int statusCode) throws Exception {
    steps.verify_registers_status_code_as(registerResponse,statusCode);
  }

  @Then("^validate the response as$")
  public void validate_the_response_as(DataTable dataTable) throws Exception {
    List<Map<String,String>> list = dataTable.asMaps(String.class,String.class);
    String id=list.get(0).get("id");
    String token=list.get(0).get("token");
    System.out.println("list  >  "+list);
    steps.validate_the_response_as(registerResponse,id,token);
  }

  @Then("^validate the invalid response$")
  public void validate_the_invalid_response() throws Exception {
    steps.validate_the_invalid_response(registerResponse);
  }
}
