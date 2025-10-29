Feature: Navigation between pages
  Scenario: Navigate example to wikipedia and check titles
    Given I navigate from "https://example.com" to "https://www.wikipedia.org/"
    Then the page title should contain "Wikipedia"
