package com.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import com.steps.ListUsersSteps;

import net.thucydides.core.annotations.Steps;

public class ListUsersSD {
  private Response usersResponse = null;
  @Steps ListUsersSteps steps;

  @Given("^Load the Get request \"([^\"]*)\"$")
  public void load_the_Get_request(String url) throws Exception {
    steps.load_the_Get_request(url);
  }

  @When("^Get the list of user details using Get API$")
  public void get_the_list_of_user_details_using_Get_API() throws Exception {
    usersResponse=steps.get_the_list_of_user_details_using_Get_API();
  }

  @Then("^Verify users status code as (\\d+)$")
  public void verify_users_status_code_as(int statusCode) throws Exception {
    steps.verify_users_status_code_as(usersResponse,statusCode);
  }

  @Then("^validate the users response$")
  public void validate_the_users_response() throws Exception {
    steps.validate_the_users_response(usersResponse);
  }
}
