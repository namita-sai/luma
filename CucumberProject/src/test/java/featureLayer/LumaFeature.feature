#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Create a new account and sign in with the same details on the Luma Project

   Scenario Outline: Sign up with valid credentials and log in
    Given the user is on the sign-up page
    When the user enters valid data: "<FirstName>", "<LastName>", "<Password>", "<ConfirmPassword>"
    And clicks on the Create an Account button
    Then the user should be registered successfully and redirected to the dashboard    
       

    Examples: 
      | FirstName | LastName | Password   | ConfirmPassword |
      | Namita     | Patil     | Namita5737$$  | Namita5737$$       |
    
    Scenario Outline: login with registerd data
    Given the user navigates to the login page  
    When enters the valid credentials used for sign-up which is register now using email "<Password>"
    And clicks on the Sign In button
    Then the user should be logged in successfully and redirected to the user dashboard
     
     Examples: 
     | Password   |
     | Namita5737$$  |

    Scenario Outline: Sign up with invalid data 
    Given the user is on the sign-up page
    When the user enters an invalid email format and valid data for other fields: "<FirstName>", "<LastName>", "<Email>", "<Password>"," <ConfirmPassword>"
    And clicks on the Create an Account button
    Then an error message should be displayed for invalid email format

    Examples: 
      | FirstName | LastName | Email                | Password   | ConfirmPassword |
      | nnnn      | ppppp     | invalidemail.com     | password1  | password1      |
      
      
      

    