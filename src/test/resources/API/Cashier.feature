Feature: As a admin i want to login so i can add membership

  @CashierAddMembership
  Scenario: Create New Membership with valid data
    Given the user has cashier access rights
    When cashier sends a POST request to the membership endpoint with alid data for adding membership
    Then cashier user should receive a response with a status code of 201 Created
    And a new membership with the provided information has been successfully created by cashier

  @GetCategory
  Scenario: Get all category with valid data
    Given the user has cashier access rights
    When cashier sends a GET request to the category endpoint
    Then cashier should receive a response with a status code of 200 OK
    And the response should contain a list of all category data

#  @GetCategoryandItems
#  Scenario: Get category and items with valid data
#    Given the user has cashier access rights
#    When cashier sends a GET request to the category endpoint wih category and items valid
#    Then cashier should receive a response with a status code of 200 OK
#    And the response should contain a list of category and items


  @SearchItemById
  Scenario: GET - Search itm by Id
    Given the user has cashier access rights
    When cashier sends a GET request to the category endpoint with id valid for search item
    Then cashier should receive a response with a status code of 200 OK
    And the item with the given ID has been successfully displayed

  @SearchItemByName
  Scenario: GET - Search itm by name
    Given the user has cashier access rights
    When cashier sends a GET request to the category endpoint with name item valid for search item
    Then cashier should receive a response with a status code of 200 OK
    And the item with the given name has been successfully displayed

  @AddTransaction
  Scenario: Create New transaction with valid data
    Given the user has cashier access rights
    When cashier sends a POST request to the membership endpoint with valid data for adding transaction
    Then cashier user should receive a response with a status code of 201 Created for adding transaction
    And a new transaction with the provided information has been successfully created by cashier