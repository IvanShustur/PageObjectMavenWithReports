Feature: Buy some item

  Scenario Outline: Add the product to the shopping cart
    Given User opens '<homePage>' page
    And  User search '<name>' product
    When User selects the first product from the list
    And User add item to the shopping cart
    Then User have to have '<number>' of product in the shopping cart


    Examples:
      | homePage               | name        | number |
      | https://rozetka.com.ua | ноутбуки    |   1    |
