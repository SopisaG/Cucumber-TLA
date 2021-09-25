Feature: User Management page scenarios

  Scenario: Verify title of the page
    Given I navigate to homepage
    When I open User-Mgt page
    Then Title of the page should be Register New User

  Scenario: Verify Login button is present
    Given I navigate to homepage
    When I open User-Mgt page
    Then I should see Login button

  Scenario: Verify Access DB button is present
    Given I navigate to homepage
    When I open User-Mgt page
    Then I should see Access DB button

    Scenario: Verify title of the page is User DB
      Given I navigate to homepage
      When I open User-Mgt page
      When I open Access DB page
      Then Title of the page should be User DB

  Scenario: Verify title of the page is Login Page
    Given I navigate to homepage
    When I open User-Mgt page
    When I open Login page
    Then Title of the page should be Login Page

  Scenario: Verify tla image is loaded
    Given I navigate to homepage
    When I open User-Mgt page
    When I open Login page
    Then I should see TLA image
