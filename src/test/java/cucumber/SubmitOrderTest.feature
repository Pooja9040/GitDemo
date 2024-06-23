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
@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file
  
  Background:
  Given Land on eCommerce Web Application
  

  @Regression
  Scenario Outline: Positive Test of Submitting the Order
    Given Login with <UserName> and <Password>
    When Add the product <ProductName> to cart
    And Chechout <ProductName> and Submit the Order
    Then "THANKYOU FOR THE ORDER." message is displayed in ConfirmationPage

    Examples: 
      | UserName  								| Password 		| ProductName |
      | poojajprabhuraj@gmail.com |JPpooja@9040 | ZARA COAT 3 |
