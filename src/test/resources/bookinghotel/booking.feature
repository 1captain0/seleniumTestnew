#Author: your.email@your.domain.com

Feature: HotelBooking

Background: User has successfully logged in with valid credentials and he is navigated to the Hotel Booking page
Scenario: Check the title
Given User is on Hotel Booking page
Then Validate page title

Scenario: Successfull Hotel Booking with all valid data
Given User is on Hotel Booking page
When User enters all valid data 
And clicks on confirm booking button
Then Booking Successfull page should be displayed

Scenario: Failure in Hotel Booking due to blank First Name
Given User is on Hotel Booking page
When User leaves First Name blank 
And clicks on confirm booking button
Then Display suitable alert message

Scenario: Failure in Hotel Booking due to blank Last Name
Given User is on Hotel Booking page
When User enters all valid data to previous fields and leaves Last Name blank 
And clicks on confirm booking button
Then Display suitable alert message

Scenario: Failure in Hotel Booking due to invalid Email Id
Given User is on Hotel Booking page
When User enters all valid data
But User enters invalid Email Id 
And clicks on confirm booking button
Then Display suitable alert message

Scenario: Failure in Hotel Booking due to invalid Phone Number
Given User is on Hotel Booking page
When User enters all valid data
But User enters invalid Phone Number 
|0523654785|
|989564|
|458523652145| 
And clicks on confirm booking button
Then Display suitable alert message

Scenario: Failure in Hotel Booking on not selecting city
Given User is on Hotel Booking page
When User enters all valid data
But User does not select city
And clicks on confirm booking button
Then Display suitable alert message

Scenario: Failure in Hotel Booking on not selecting state
Given User is on Hotel Booking page
When User enters all valid data
But User does not select state
And clicks on confirm booking button
Then Display suitable alert message

Scenario Outline: Validate the number of rooms allocated
Given User is on Hotel Booking page
When User selects count of Persons <personcount>
Then Allocate suitable no. of rooms as per no. of persons <personcount>
Examples:
|personcount|
|2|
|5|
|9|

Scenario: Failure in Hotel Booking due to blank Expiry Year
Given User is on Hotel Booking page
When User enters all valid data and leaves expiry year blank
And clicks on confirm booking button
Then Display suitable alert message

Scenario Outline: Failure in Hotel Booking due to invalid card number
Given User is on Hotel Booking page
When User enters all valid data and gives invalid card number <cn>
And clicks on confirm booking button
Then Display suitable alert message
Examples:
|cn|
|"12345"|
|"226786545678975647"|

Scenario Outline: Failure in Hotel Booking due to invalid cvv
Given User is on Hotel Booking page
When User enters all valid data and gives invalid cvv number <cvv>
And clicks on confirm booking button
Then Display suitable alert message
Examples:
|cvv|
|"7"|
|"4332"|

Scenario Outline: Failure in Hotel Booking due to invalid expiry month
Given User is on Hotel Booking page
When User enters all valid data and gives invalid expiry month <em>
And clicks on confirm booking button
Then Display suitable alert message
Examples:
|em|
|"00"|
|"13"|




