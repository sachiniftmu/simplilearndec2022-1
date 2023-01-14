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

@login @negative @medium @smoke
Scenario Outline: Verify User Login With Invalid Credentials
Given The user is on login/register page
 When The user enter the "<username>" in username field and "<password>" in password file and clicks login button
Then The user should see an error message "ERROR: The username or password you entered is incorrect. Lost your password?"

Examples:

|username|password|
|Chandan|fodoidfnodnf|
|fofineofni|chandan@123|
|fofineofni|fodoidfnodnf|

