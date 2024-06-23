
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
<<<<<<< HEAD
      
   ************dmwfbwef*******************
    When Login with <UserName> and <Password>
    When I check for the <value> in step
   
=======

      Given Land on eCommerce Web Application
>>>>>>> 952870f7ba8d294c5f6970bb4a27cb93fb66364c
