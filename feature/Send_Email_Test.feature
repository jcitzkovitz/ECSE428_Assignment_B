Feature: Send an email on Outlook with an image attachment to a Recipient
	
	Background:
		Given  User navigates to outlook.live.com
		And ecse428test@outlook.com logs into a valid Outlook account with Testecse428
		And Sent folder shall be initially empty

	Scenario Outline: Succesfully send an email on Outlook with a valid Image attachment to a valid Recipient 
		Given User selects to send an email		
		And User selects an <image>
		And User enters a <recipient> into the To field
		And User fills Subject line with a <subject>
		When User clicks Send
		Then Email shall be sent to the Recipient succesfully
		
		Examples:
		| image | recipient | subject |
		|		C:\Users\jcitz\Desktop\TestImages\test1.jpg		| jordan.itzkovitz@mail.mcgill.ca | Test_428_B |
		|		C:\Users\jcitz\Desktop\TestImages\test2.jpg		| jcitzko@hotmail.com | Test_428_B |
		|		C:\Users\jcitz\Desktop\TestImages\test3.jpg		| jcitzkovitz@gmail.com | Test_428_B |
		|		C:\Users\jcitz\Desktop\TestImages\test4.jpg		| jordani@stradigi.ai | Test_428_B |