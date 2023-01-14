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

Feature: Login Module

@smoke @login @positive @critical
Scenario: Verify that login is working with correct credentials
 Given The user is on login/register page
 When The user enter the "simplilearnaug2022" in username field and "simplilearnaug2022" in password file and clicks login button
 Then Login should be successful and user is on profile page with profile name as "simplilearnaug2022"