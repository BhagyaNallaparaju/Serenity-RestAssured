@report:post
Feature: Register user with post

  @listUsers
  Scenario: Register the user with valid details
    Given Load the Post request "registerUser"
    When Users register using post API
    | email    | eve.holt@reqres.in |
    | password | pistol             |
    Then Verify registers status code as 200
    And validate the response as
    | id  | token             |
    | 4   | QpwL5tke4Pnpja7X4 |

  @listUsers
  Scenario: Verify request with empty password
    Given Load the Post request "registerUser"
    When Users register using post API
      | email    |eve.holt@reqres.in|
      | password |                  |
    Then Verify registers status code as 400
    And validate the invalid response
