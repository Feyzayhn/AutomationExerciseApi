@Api9
  Feature: DELETE To Verify Login
    Scenario: DELETE To Verify Login
      Given H_Url "verifyLogin"
      Then  H_Request Method DELETE
      Then  H_Response Code 405
      And   H_Response Message "This request method is not supported."


















