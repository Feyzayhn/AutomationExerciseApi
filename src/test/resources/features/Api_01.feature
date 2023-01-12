@Api1
Feature: Get All Products List

  Scenario: Get All Products List
    Then Url "productsList"
    Then Request Method GET
    Then Response Code 200
    And  Response JSON All products list









