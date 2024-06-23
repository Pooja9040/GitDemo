
@tag
Feature: Error Validation
  I want to use this template for my feature file


  @ErrorValidation
  Scenario Outline: Negetive scenario
    Given Land on eCommerce Web Application
    When Login with <UserName> and <Password>
    When I check for the <value> in step
    Then Error Massage is displyed "Incorrect email or password."

    Examples: 
      | UserName  								| Password 		| 
      | poojajprabhuraj@gmail.com |JPpoo@9040   | 
