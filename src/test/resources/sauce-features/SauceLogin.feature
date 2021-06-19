Feature: Login feature


  Scenario: Login as a standard user
    Given User has accessed the login page "https://www.saucedemo.com"
    When User type username "standard_user"
    And User type password "secret_sauce"
    And User click the login button
    Then User should be directed to inventory page "https://www.saucedemo.com/inventory.html"


  Scenario: Standard user login with invalid password
    Given User has accessed the login page "https://www.saucedemo.com"
    When User type username "standard_user"
    And User type password "secret_invalid"
    And User click the login button
    Then User should see error "Epic sadface: Username and password do not match any user in this service"


  Scenario Outline: User login with invalid inputs
    Given User has accessed the login page "https://www.saucedemo.com"
    When User type username "<user_name>"
    And User type password "<password>"
    And User click the login button
    Then User should see error "<expected_error>"
    Examples:
      | user_name     | password       | expected_error                                                            |
      | standard_user | secret_invalid | Epic sadface: Username and password do not match any user in this service |
      | standard_user |                | Epic sadface: Password is required                                        |



