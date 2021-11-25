@BDD
Feature: User login
  @Login @Wordpress @Userpanel
  Scenario: Login
    Given User starts on main page
    When user logs to the user panel
    Then user can modify user profile