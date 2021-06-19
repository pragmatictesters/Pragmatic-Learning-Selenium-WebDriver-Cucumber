Feature: Checkout feature

  Background: User has logged into the system
    Given User has accessed the login page "https://www.saucedemo.com"
    When User type username "standard_user"
    And User type password "secret_sauce"
    And User click the login button
    And User should be directed to inventory page "https://www.saucedemo.com/inventory.html"

  Scenario: User proceeding to the checkout with a random product
    When User click on an Add to cart button
    And User click on the cart icon on the top of the page
    Then User should be directed to cart page "https://www.saucedemo.com/cart.html"