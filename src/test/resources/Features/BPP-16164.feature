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
Feature: Verify Login
 @BPP-16164
  Scenario Outline: Verify For Baby Products
    Given the user is on sauce demo Home Page
    And the user enters username as "<UserName>"
    And the user enters password as "<Password>" 
    Then the user should verify sauce demo home page
    
    
    Examples:
    |UserName				| Password		|
    |standard_user	| secret_sauce|