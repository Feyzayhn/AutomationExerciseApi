@Api4
Feature: PUT To All Brands List

  Scenario: PUT To All Brands List
    Given D_Url "brandsList"
    Then  D_Request Method PUT
    Then  D_Response Code 405
    And   Response Message "This request method is not supported."


