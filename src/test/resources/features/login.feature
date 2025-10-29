Feature: Login scenarios
  Scenario: Successful login
    Given I open the login page
    When I login with username "Victor" and password "SuperSecretPassword!"
    Then I should see a success message

  Scenario: Failed login
    Given I open the login page
    When I login with username "wrong" and password "wrong"
    Then I should see an error message
