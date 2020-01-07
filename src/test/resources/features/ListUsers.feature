@report:get
Feature: list users using Get request

  @listUsers
  Scenario: Get the total list of user details
    Given Load the Get request "listUsersUrlValid"
    When Get the list of user details using Get API
    Then Verify users status code as 200
    And validate the users response

  @listUsers
  Scenario: Verify with invalid url request
    Given Load the Get request "listUsersUrlInValid"
    When Get the list of user details using Get API
    Then Verify users status code as 404

