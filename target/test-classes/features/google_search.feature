Feature: Git search and navigation
  Scenario: Search for a term and open first result
    Given I open Google
    When I search for "Github"
    Then I open the first result
    Then the current url should not contain google
