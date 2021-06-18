Feature: Login to sauce store


  @login
  Scenario: User login as a standard user
    Given User has accessed the login page
    When  User type the username "standard_user"
    And User type the password "secret_sauce"
    And User click the login button
    Then User should be directed to the inventory page "https://www.saucedemo.com/inventory.html"


  Scenario: Standard user login with invalid password
    Given User has accessed the login page
    When  User type the username "standard_user"
    And User type the password "secret_invalid"
    And User click the login button
    Then User should see error message "Epic sadface: Username and password do not match any user in this service"


  Scenario Outline: User login with invalid credentials
    Given User has accessed the login page
    When  User type the username "<username>"
    And User type the password "<password>"
    And User click the login button
    Then User should see error message "<expected_error>"
    Examples:
      | username      | password       | expected_error                                                            |
      |               |                | Epic sadface: Username is required                                        |
      |               | secret_sauce   | Epic sadface: Username is required                                        |
      | standard_user |                | Epic sadface: Password is required                                        |
      | standard_user | secret_invalid | Epic sadface: Username and password do not match any user in this service |
