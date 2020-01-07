@report:getandpost
Feature: Verify Users API

  @tag
  Scenario: Get User details
    Given Load the Get url
    When View list of users using Get API
    Then Verify status code as 200
    And validate the response

  @tag
  Scenario: register User details
    Given load the post url
    When register users using post API
    Then Verify status code as 201
    And validate the post response