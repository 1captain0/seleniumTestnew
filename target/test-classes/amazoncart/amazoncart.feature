#Author: your.email@your.domain.com

Feature: Shooping Cart

Scenario: Successfully add product to cart
Given User is on product page
When User clicks on Add to Cart button
Then Suitable message should be displayed

Scenario: Successfully add product to cart
Given User is on product page
When User clicks on Add to Cart button
And User navigates to Cart Page
Then Added product should be present in cart

Scenario: Successfully remove product from cart
Given User is on product page
When User clicks on Add to Cart button
And User navigates to Cart Page
And User clicks on delete button
Then Suitable message should be displayed

Scenario Outline: Validate quantity of products
Given User is on product page
When User clicks on Add to Cart button
And User navigates to Cart Page
And User selects quantity of product <quantity>
Then Correct quantity should be displayed
Examples:
|quantity|
|2|
|4|
|8|

Scenario Outline: Validate total price
Given User is on product page
When User clicks on Add to Cart button
And User navigates to Cart Page
And User selects quantity of product <quantity>
Then Correct price should be displayed
Examples:
|quantity|
|2|
|4|
|8|


