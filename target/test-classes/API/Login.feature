Feature: POST - Login

  @LoginAdmin
  Scenario: POST - As admin I can login
    Given I set the api POST endpoint
    When I send HTTP POST request
    Then I receive valid HTTP response code 200
    And I received the token

#  @InvalidLoginAdminByEndpoint
#  Scenario: POST - As admin I can login
#    Given Cashier set the api POST with invalid endpoint
#    When Cashier send HTTP POST request
#    Then Cashier receive valid HTTP response code 401 unauth
#    And Cashier received error message

  @LoginCashier
  Scenario: POST - As cashier I can login
    Given cashier set the api POST endpoint
    When cashier send HTTP POST request
    Then cashier receive valid HTTP response code 200
    And cashier received the token