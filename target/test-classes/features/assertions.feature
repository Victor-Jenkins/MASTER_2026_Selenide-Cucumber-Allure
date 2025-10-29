Feature: Assertions examples
  Scenario: Page contains specific text
    Given I open Google
    Then the page should contain text "Git"
