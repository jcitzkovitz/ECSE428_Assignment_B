package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;

import org.junit.Assert;

public class Steps {				
     
	WebDriver driver;
	
	final String signInButtonId = "body > section > div > div > nav > div > div > div > a";
	final String emailFieldId = "#i0116";
	final String nextButtonId = "#idSIButton9";
	final String passwordFieldId = "#i0118";
	final String composeEmailFieldId = "#app > div > div._2oC_VlxD_DO0bdsijTkmuB > div > div._29KqToSCcntvfbDv_3xuuh > div._2Knz76dTLcJASk7hK-z_Ft > div._38eVVLcrutYhO71_VTR3cc > div > button";
	final String fileInputFieldId = "#app > div > div._2oC_VlxD_DO0bdsijTkmuB > div > div._29KqToSCcntvfbDv_3xuuh > div._3Z9HcLQ6oAxnDaLEGF0acC > div._2TH_lqaoOPBpCTlDAQbdPL > span > input:nth-child(1)";
    final String recipientFieldId = "#app > div > div._2oC_VlxD_DO0bdsijTkmuB > div > div._29KqToSCcntvfbDv_3xuuh > div._3Z9HcLQ6oAxnDaLEGF0acC > div._3Z9HcLQ6oAxnDaLEGF0acC > div > div._1KJxBCSsRRpiUauU52-5Pc > div._22vbv6th-hFt0ffMlTaRMH > div > div > div > div._3j6EHinwt-MAaY5N3xbaie > div._2Rsp7RsWj1Klj-aBC12ADm.JlHJlXy-TMTx_5dUhbtof > div:nth-child(1) > div > div._3tDaJHgAGDNRcnaEcvOHvU > div > div > div > div > div.ms-FocusZone > div > div > input";
	final String subjectFieldId = "#subjectLine0";
	final String sentItemsButtonId = "#app > div > div._2oC_VlxD_DO0bdsijTkmuB > div > div._29KqToSCcntvfbDv_3xuuh > div._2Knz76dTLcJASk7hK-z_Ft > div._1XJLThPJyfP1uedjzaUYHS > div > div.ms-FocusZone._3Y-bYDf3RHNQuCg6reBBbz._2CAT-mgCivHkqBS2RQ5UG9.customScrollBar.disableTextSelection > div > div:nth-child(2) > div:nth-child(2) > div:nth-child(2)";
    final String searchBarId = "#searchBoxId > div.yd_VllzT4EtCxmSHIbywD > div > input";
    final String emptySentFolderIconId = "#app > div > div._2oC_VlxD_DO0bdsijTkmuB > div > div._29KqToSCcntvfbDv_3xuuh > div._3Z9HcLQ6oAxnDaLEGF0acC > div._3Z9HcLQ6oAxnDaLEGF0acC > div > div._2UgKGKHpU-LQGDULg8yYH > div._1JG8MPYAYFuJ9m1k7gmlsl > div > img";
	final String nonEmptySentFolderIndicatorId = "#app > div > div._2oC_VlxD_DO0bdsijTkmuB > div > div._29KqToSCcntvfbDv_3xuuh > div._3Z9HcLQ6oAxnDaLEGF0acC > div._3Z9HcLQ6oAxnDaLEGF0acC > div > div._2UgKGKHpU-LQGDULg8yYH > div._1JG8MPYAYFuJ9m1k7gmlsl > div > div > div > div > div > div:nth-child(1) > div";
    final String deleteSentItemsId = "#app > div > div._2oC_VlxD_DO0bdsijTkmuB > div > div._29KqToSCcntvfbDv_3xuuh > div._3Z9HcLQ6oAxnDaLEGF0acC > div._2TH_lqaoOPBpCTlDAQbdPL > div > div > div > div > div.ms-OverflowSet.ms-CommandBar-primaryCommand.primarySet-68 > div:nth-child(1) > button";
    final String confirmDeleteSentItemsId = "#ok-1";
	final String staySignedInId = "#idChkBx_PWD_KMSI0Pwd";
	
	@Given("^User navigates to outlook.live.com$")				
    public void user_navigates_to_outlook_live_com() throws Throwable							
    {	
    	// Set system property
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\jcitz\\Desktop\\chromedriver_win32\\chromedriver.exe");
    	driver = new ChromeDriver();
    	
    	// Go to outlook website
    	driver.get("http://outlook.live.com/mail/inbox");
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    
    @And("^(.*) logs into a valid Outlook account with (.*)$")
    public void user_logs_into_Outlook(String username, String password) throws Throwable
    {
    	// Click Sign In
    	driver.findElement(By.cssSelector(signInButtonId)).click();

    	// Enter email
    	driver.findElement(By.cssSelector(emailFieldId)).sendKeys(username,Keys.ENTER);
    	
    	// Must sleep for a small amount of time as the effects on outlook dont display the Next button fast enough
    	Thread.sleep(500);
    	
    	// Enter password
    	WebElement passwordField = driver.findElement(By.cssSelector(passwordFieldId));
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	
    	passwordField.sendKeys(password,Keys.ENTER);
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    
    @And("^Sent folder shall be initially empty$")
    public void sent_folder_shall_be_initially_empty() throws Throwable
    {
    	// Go to sent items
    	driver.findElement(By.cssSelector(sentItemsButtonId)).click();
    	
    	// Check that there are no emails in the sent folder initially by observing whether the Tody bar is present
    	List<WebElement> todayBar = driver.findElements(By.cssSelector(nonEmptySentFolderIndicatorId));
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	
    	Assert.assertTrue(todayBar.size() == 0);
    }
    
    @Given("^User selects to send an email$")
    public void user_selects_to_send_email() throws Throwable
    {
    	
    	// Click Compose Email
    	WebElement searchBar = driver.findElement(By.cssSelector(searchBarId));
    	searchBar.click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	
    	searchBar.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER);
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    
    @And("^User selects an (.*)$")
    public void user_selects_an_image(String image) throws Throwable
    {
    	// Enter the file as input
    	driver.findElement(By.cssSelector(fileInputFieldId)).sendKeys(image);
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    
    @And("^User enters a (.*) into the To field$")
    public void user_enters_recipient(String recipient) throws Throwable
    {
    	// Enter the recipients email address in the To field
    	WebElement recipientField = driver.findElement(By.cssSelector(recipientFieldId));
    	recipientField.sendKeys(recipient,Keys.ENTER);
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }
    
    @And("^User fills Subject line with a (.*)$")
    public void user_fills_subject(String subject) throws Throwable
    {
    	// Fill subject line
    	WebElement subjectField = driver.findElement(By.cssSelector(subjectFieldId));
    	subjectField.sendKeys(subject);
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }
    
    @When("^User clicks Send$")
    public void user_clicks_send() throws Throwable
    {	
    	// User clicks send
    	WebElement subjectField = driver.findElement(By.cssSelector(subjectFieldId));
    	subjectField.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER);
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }
    
    @Then("^Email shall be sent to the Recipient succesfully$")
    public void email_shall_be_sent_to_the_recipient_successfully() throws Throwable
    {
    	// Check that there is an email in the sent folder by observing that the Today bar appears
    	List<WebElement> todayBar = driver.findElements(By.cssSelector(nonEmptySentFolderIndicatorId));
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	
    	Assert.assertTrue(todayBar.size() != 0);
    }
    
    @After
    public void teardown() {
    	
    	// Delete emails from search
        driver.findElement(By.cssSelector(deleteSentItemsId)).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        
        driver.findElement(By.cssSelector(confirmDeleteSentItemsId)).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    

}
