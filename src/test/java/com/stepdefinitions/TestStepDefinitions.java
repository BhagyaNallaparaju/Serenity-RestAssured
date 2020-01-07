package com.stepdefinitions;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.steps.testStep;
import net.thucydides.core.annotations.Steps;

import org.junit.Assert;

public class TestStepDefinitions {

  @Steps testStep steps;

  @Given("^Load the Get url$")
  public void load_the_Get_url() throws Exception {

    steps.load_the_Get_url();
  }

  @When("^View list of users using Get API$")
  public void view_list_of_users_using_Get_API() throws Exception {
    steps.view_list_of_users_using_Get_API();
  }


  @Then("^Verify status code as (\\d+)$")
  public void verify_status_code_as(int statusCode) throws Exception {
    int actualStatusCode =steps.verify_status_code_as();
    Assert.assertEquals("Statuscode should be",statusCode,actualStatusCode);
  }

  @Then("^validate the response$")
  public void validate_the_response() throws Exception {
    steps.validate_the_response();

  }

  @Given("^load the post url$")
  public void load_the_post_url() throws Exception {
    steps.load_the_post_url();
  }

  @When("^register users using post API$")
  public void register_users_using_post_API() throws Exception {
    steps.register_users_using_post_API();
  }

  @Then("^validate the post response$")
  public void validate_the_post_response() throws Exception {
    steps.validate_the_post_response();
  }


}
