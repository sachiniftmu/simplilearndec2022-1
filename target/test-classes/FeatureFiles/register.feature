#Author: chandan@simplilearn.com
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


#data table
Feature: Registration Module

@smoke @register @positive @critical
Scenario: Verify registration functionality
 Given The user is on login/register page
 When The user fills registration form with following information
 |username|email|password|
 |simplilearndec2022|simplilearndec2022@yopmail.com|Simplilearndec@2022|
 And clicks on register button
 Then the user registration should be successful