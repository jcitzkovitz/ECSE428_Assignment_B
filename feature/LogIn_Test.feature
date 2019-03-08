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
Feature: Send an email on Outlook with an image attachment to a Recipient
	
	Background:
		Given  User navigates to outlook.live.com
		And jcitzko@hotmail.com logs into a valid Outlook account with brodeur30
		And User selects to send an email
		

	Scenario Outline: Succesfully send an email on Outlook with a valid Image attachment to a valid Recipient 		
		Given User selects an <image>
		And User enters a <recipient> into the To field
		And User fills Subject line with a <subject>
		When User clicks Send
		Then Email shall be sent to the <recipient> succesfully
		
		Examples:
		| image | recipient | subject |
		|		C:\Users\jcitz\Desktop\test.jpg		| jordan.itzkovitz@mail.mcgill.ca | Test |
		|		C:\Users\jcitz\Desktop\test.jpg		| jcitzkovitz@gmail.com | Test |
	
	
#	@multiple
#	Scenario: Unsuccesfully send an email on Outlook with a valid Image attachment to an invalid Recipient 		
#		Given User selects an Image
#			| image |
#			|				|
#		And User enters a Recipient into the To field
#			| recipient |
#			| jcitzkovitz@g.com |
#			| jordan.itzkovitz |
#		And User fills Subject line
#			| subject |
#			|		Test	|
#		When User clicks Send
#		Then Email shall not be sent to the Recipient
#		And Invalid Email address shall be displayed
#		
#	Scenario: Warn User that the subject field is empty when sending an email on Outlook with a valid Image attachment to a valid Recipient 		
#		Given User selects an Image
#			| image |
#			|				|
#		And User enters a Recipient into the To field
#			| recipient |
#			| jcitzkovitz@gmail.com |
#			| jordan.itzkovitz@mail.mcgill.ca |
#		When User clicks Send
#		Then No Subject Warning message shall appear
#		
#	Scenario: Unsuccesfully load an oversized image to an email	
#		Given User selects an Image
#			| image |
#			|				|
#		Then Image Capacity Error message shall be displayed
#		
#	Scenario: Unsuccesfully load an invalid image to an email	
#		Given User selects an Image
#			| file  |
#			|				|
#		Then Invalid File error message shall be displayed
