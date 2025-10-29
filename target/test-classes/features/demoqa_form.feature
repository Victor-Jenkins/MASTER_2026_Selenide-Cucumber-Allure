Feature: DemoQA contact form
  Scenario: Fill and submit contact form
    Given I open the demoqa form page
    When I fill the contact form with name "Juan Pérez" and email "juan.perez@example.com"
    Then the output should contain the name "Juan Pérez"
