Feature: As a admin i want to login so i can manage membership feature

  @GetMembership
  Scenario: Get all membership with valid data
    Given the user has admin access rights
    When the user sends a GET request to the membership endpoint
    Then the user should receive a response with a status code of 200 OK
    And the response should contain a list of all membership data
  @GetMembershipInvEndpoint
  Scenario: Get all membership with invalid endpoint
    Given the user has admin access invalid
    When the user sends a GET request to the invalid membership endpoint
    Then the user should receive a response with a status code of 400
    And the response should contain a error message required parameter page
  @GetMembershipInvMethod
  Scenario: Get all membership with invalid method
    Given the user has admin access rights
    When the user sends a PUT request to the membership endpoint
    Then the user should receive a response with a status code of 404
    And the response should contain a error message not found
  @GetMembershipWithoutToken
  Scenario: Get all membership without bearer token
    Given the user has admin access rights without token
    When the user sends a GET request to the membership endpoint without token
    Then the user should receive a response with a status code of 401 for get membership
    And the response should contain a Unauthorized: Missing token

  @AddMembershipWithoutToken
  Scenario: Create New Membership without bearer token
    Given the user has admin access without token
    When the user sends a POST request to the membership endpoint without token for add memb
    Then the user should receive a response with a status code of 401 for add memb without token
    And the response should contain a Unauthorized: Missing token for add memb
  @AddMembershipInvMethod
  Scenario: Create New Membership with invalid method
    Given the user has admin access rights
    When the user sends a GET request to the membership endpoint with post valid data
    Then the user should receive a response with a status code of 400 Bad Req
    And the response should contain a error message bad request
  @AddMembershipInvEmail
  Scenario: Create New Membership without name
    Given the user has admin access rights for invalid email
    When the user sends a POST request to the membership endpoint for invalid email
    Then the user should receive a response with a status code of 400 for invalid email
    And the response should contain a error message bad request for invalid email
  @AddMembershipInvBirthDate
  Scenario: Create New Membership with invalid birthdate
    Given the user has admin access rights for invalid birthdate
    When the user sends a POST request to the membership endpoint for invalid birthdate
    Then the user should receive a response with a status code of 400 for invalid birthdate
    And the response should contain a error message bad request for invalid birthdate
#  @AddMembershipWithoutName
#  Scenario: Create New Membership without name
#    Given the user has admin access rights for without name
#    When the user sends a POST request to the membership endpoint for without name
#    Then the user should receive a response with a status code of 400 for without name
#    And the response should contain a error message bad request for without name

#  @AddMembershipSameEmail
#  Scenario: Create New Membership with same email
#    Given the user has admin access rights for same email
#    When the user sends a POST request to the membership endpoint with same email
#    Then the user should receive a response with a status code of 201 Created for same email
#    And a new membership with the provided information has been successfully created for same email

  @AddPoint
  Scenario: Create New Membership with valid data
    Given the user has admin access rights for add point
    When The user sends a POST request to the membership endpoint with valid data for adding points
    Then the user should receive a response with a status code of 201 Created for adding point valid
    And The points for the member with that ID have been successfully added by the specified amount

  @UpdateMembership
  Scenario: Create New Membership with valid data
    Given the user has admin access rights
    When The user sends a POST request to the membership endpoint with valid data for edit membership
    Then the user should receive a response with a status code of 200 OK
    And The membership with that ID has been successfully updated with the provided information
  @UpdateMembershipInvEndpoint
  Scenario: Create New Membership with valid data
    Given the user has admin access rights for update membership invalid endpoint
    When The user sends a POST request to the membership endpoint with valid data for edit membership invalid endpoint
    Then the user should receive a response with a status code of 404 for edit membership invalid endpoint
    And the response should contain a error message not found for edit membership invalid endpoint
  @UpdateMembershipInvMethod
  Scenario: Create New Membership with invalid method
    Given the user has admin access rights for update membership invalid method
    When The user sends a POST request to the membership endpoint with valid data for edit membership invalid method
    Then the user should receive a response with a status code of 404 for edit membership invalid method
    And the response should contain a error message not found for edit membership invalid method
  @UpdateMembershipWithoutToken
  Scenario: Create New Membership without token
    Given the user has admin access rights for update membership without token
    When The user sends a POST request to the membership endpoint with valid data for edit without token
    Then the user should receive a response with a status code of 401 for edit membership without token
    And the response should contain a error message not found for edit membership without token
  @UpdateMembershipInvEmail
  Scenario: Update Membership with invalid format email
    Given the user has admin access rights for update membership invalid email
    When The user sends a POST request to the membership endpoint with invalid email
    Then the user should receive a response with a status code of 400 for edit membership invalid email
    And the response should contain a error message invalid email format for edit membership invalid email
  @UpdateMembershipInvBirthDate
  Scenario: Update Membership with invalid birthdate
    Given the user has admin access rights for update invalid birthdate
    When the user sends a POST request to the membership endpoint for update invalid birthdate
    Then the user should receive a response with a status code of 400 for update invalid birthdate
    And the response should contain a error message bad request for update invalid birthdate
  @DeleteMembership
  Scenario: Delete Membership
    Given the user has admin access rights
    When the user sends a DELETE request to the membership endpoint with valid id
    Then the user should receive a response with a status code of 200 OK
    And the membership with that ID has been successfully deleted
