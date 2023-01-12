@Api2
Feature: POST To All Products List
  Scenario: POST To All Products List
    Given B_Url "productsList"
    Then  B_Request Method POST
    Then  B_Response Code 405
    And   B_Response Message "This request method is not supported."















