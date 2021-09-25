Feature: User Management page scenarios
  Background:
    Given I navigate to homepage
    When I open User-Mgt page

  Scenario: Verify title of the page
    Then Title of the page should be "Register New User"

  @smoke
  Scenario: Verify Login button is present
    Then I should see Login button

  @regression
  Scenario: Verify Access DB button is present
    Then I should see Access DB button

    Scenario: Verify user registration form
      Then I input "firstname" as "Jane"
      And I input "lastname" as "Doe"
      And I input "phone number" as "1234567890"
      And I input "email" as "jane.doe@tla.com"
      And I input "role" as "student"
      And I click on "Submit" button
      Then I should see all fields displayed on user table