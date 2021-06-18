Feature: Checkout items from sauce store


  Background: User has logged into the system
    Given User has accessed the login page
    And  User type the username "standard_user"
    And User type the password "secret_sauce"
    And User click the login button

  Scenario: User clicking an Add To Cart button
    When User click an Add To Cart Button
    Then The button label should be changed to "REMOVE"
    And Items in the shopping cart should be "1"


    Scenario: Checking the item details in the checkout page
      When User click the Add To Cart Button
      And Click on the cart icon
      Then User should be directed to the cart page "https://www.saucedemo.com/cart.html"
      And Item count in the cart page should be "1"