@Api3
Feature:Get All Brands List
  Scenario:Get All Brands List
    Given C_Url "brandsList"
    Then C_Request Method GET
    Then C_Response Code 200
    And C_Response JSON All brands list





