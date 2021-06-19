@checkout
Feature: Checkout items from sauce store


  Background: User has logged into the system
    Given User has accessed the login page
    And  User type the username "standard_user"
    And User type the password "secret_sauce"
    And User click the login button

  Scenario: User clicking an Add To Cart button
    When User click the Add To Cart Button
    Then The button label should be changed to "REMOVE"
    And Items in the shopping cart should be "1"
    And User reset the application state


    Scenario: Checking the item count in the checkout page
      When User click the Add To Cart Button
      And Click on the cart icon
      Then User should be directed to the cart page "https://www.saucedemo.com/cart.html"
      And Item count in the cart page should be "1"
      And User reset the application state



  Scenario: Checking the item details in the checkout page
    When User click the Add To Cart Button
    And User take a note of the item price
    And User take a note of the item name
    And User take a note of the item description
    And Click on the cart icon
    Then User should be directed to the cart page "https://www.saucedemo.com/cart.html"
    And Item count in the cart page should be "1"
    And Item price in the cart should match
    And Item name in the cart should match
    And Item description in the cart should match
    And User reset the application state
