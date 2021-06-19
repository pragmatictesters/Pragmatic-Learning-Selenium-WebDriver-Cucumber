@products
Feature: Check the details in the inventory page


  Background: User has logged into the system
    Given User has accessed the login page
    And  User type the username "standard_user"
    And User type the password "secret_sauce"
    And User click the login button

  Scenario: Verify details of a given product
    When User has clicked product "Sauce Labs Backpack"
    Then User should be directed to the product details page "https://www.saucedemo.com/inventory-item.html"
    And  Price of the item should be "$29.99"
    And Item name should be "Sauce Labs Backpack"
    And Product description should be "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."
    And User reset the application state

  Scenario Outline: Verify details of a given list of products
    When User has clicked product "<product_name>"
    Then  Price of the item should be "<product_price>"
    And Item name should be "<product_name>"
    And Product description should be "<product_description>"
    And User reset the application state
    Examples:
      | product_name            | product_price | product_description                                                                                                                             |
      | Sauce Labs Backpack     | $29.99        | carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.          |
      | Sauce Labs Bolt T-Shirt | $15.99        | Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt. |
