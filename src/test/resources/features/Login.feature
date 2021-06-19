@login
Feature: Login to sauce store

  Background: User has accessed the login page
    Given User has accessed the login page

  @smoke
  Scenario: User login as a standard user
    When  User type the username "standard_user"
    And User type the password "secret_sauce"
    And User click the login button
    Then User should be directed to the inventory page "https://www.saucedemo.com/inventory.html"

  Scenario: User login as a performance_glitch_user user
    When  User type the username "performance_glitch_user"
    And User type the password "secret_sauce"
    And User click the login button
    Then User should be directed to the inventory page "https://www.saucedemo.com/inventory.html"

  Scenario: User logout from the store
    And  User type the username "standard_user"
    And User type the password "secret_sauce"
    And User click the login button
    When User clicked on the left top icon
    And User click the logout link
    Then User should be directed to the login page "https://www.saucedemo.com"
    And User should see the login panel

  Scenario: Standard user login with invalid password
    When  User type the username "standard_user"
    And User type the password "secret_invalid"
    And User click the login button
    Then User should see error message "Epic sadface: Username and password do not match any user in this service"


  Scenario Outline: User login with invalid credentials 1
    When  User type the username "<username>"
    And User type the password "<password>"
    And User click the login button
    Then User should see error message "<expected_error>"
    Examples:
      | username        | password       | expected_error                                                            |
      |                 |                | Epic sadface: Username is required                                        |
      |                 | secret_sauce   | Epic sadface: Username is required                                        |
      | standard_user   |                | Epic sadface: Password is required                                        |
      | standard_user   | secret_invalid | Epic sadface: Username and password do not match any user in this service |
      | locked_out_user | secret_sauce   | Epic sadface: Sorry, this user has been locked out.                       |


  Scenario Template: User login with invalid credentials 2
    When  User type the username "<username>"
    And User type the password "<password>"
    And User click the login button
    Then User should see error message "<expected_error>"
    Scenarios:
      | username        | password       | expected_error                                                            |
      |                 |                | Epic sadface: Username is required                                        |
      |                 | secret_sauce   | Epic sadface: Username is required                                        |
      | standard_user   |                | Epic sadface: Password is required                                        |
      | standard_user   | secret_invalid | Epic sadface: Username and password do not match any user in this service |
      | locked_out_user | secret_sauce   | Epic sadface: Sorry, this user has been locked out.                       |
