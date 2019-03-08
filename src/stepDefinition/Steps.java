package stepDefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;

import org.junit.Assert;
import org.junit.Test;

public class Steps {				
     
	WebDriver driver;
	
    @Given("^User navigates to outlook.live.com$")				
    public void user_navigates_to_outlook_live_com() throws Throwable							
    {	
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\jcitz\\Desktop\\chromedriver_win32\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.get("http://outlook.live.com/mail/inbox");
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    
    @And("^(.*) logs into a valid Outlook account with (.*)$")
    public void user_logs_into_Outlook(String username, String password) throws Throwable
    {
    	// Click Sign In
    	driver.findElement(By.cssSelector("body > section > div > div > nav > div > div > div > a")).click();

    	// Enter email
    	driver.findElement(By.cssSelector("#i0116")).sendKeys(username);
    	
    	// Click next
    	driver.findElement(By.cssSelector("#idSIButton9")).click();
    	
    	Thread.sleep(1000);
    	
    	// Enter password
    	driver.findElement(By.cssSelector("#i0118")).sendKeys(password);
    	
    	// Click next - click elsewhere first
    	driver.findElement(By.cssSelector("#idChkBx_PWD_KMSI0Pwd")).click();
    	driver.findElement(By.cssSelector("#idSIButton9")).click();
    
    }
    
    @And("^User selects to send an email$")
    public void user_selects_to_send_email() throws Throwable
    {
    	Thread.sleep(2000);
    	
    	// Click Compose Email
    	driver.findElement(By.cssSelector("#app > div > div._2oC_VlxD_DO0bdsijTkmuB > div > div._29KqToSCcntvfbDv_3xuuh > div._2Knz76dTLcJASk7hK-z_Ft > div._38eVVLcrutYhO71_VTR3cc > div > button")).click();
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    }
    
    @Given("^User selects an (.*)$")
    public void user_selects_an_image(String image) throws Throwable
    {
    	Thread.sleep(2000);
    	
    	// Enter the file as input
    	driver.findElement(By.cssSelector("#app > div > div._2oC_VlxD_DO0bdsijTkmuB > div > div._29KqToSCcntvfbDv_3xuuh > div._3Z9HcLQ6oAxnDaLEGF0acC > div._2TH_lqaoOPBpCTlDAQbdPL > span > input:nth-child(1)")).sendKeys(image);
    }
    
    @And("^User enters a (.*) into the To field$")
    public void user_enters_recipient(String recipient) throws Throwable
    {
    	Thread.sleep(2000);
    	
    	// Enter the recipients email address in the To field
    	WebElement toField = driver.findElement(By.cssSelector("#app > div > div._2oC_VlxD_DO0bdsijTkmuB > div > div._29KqToSCcntvfbDv_3xuuh > div._3Z9HcLQ6oAxnDaLEGF0acC > div._3Z9HcLQ6oAxnDaLEGF0acC > div > div._1KJxBCSsRRpiUauU52-5Pc > div._22vbv6th-hFt0ffMlTaRMH > div > div > div > div._3j6EHinwt-MAaY5N3xbaie > div._2Rsp7RsWj1Klj-aBC12ADm.JlHJlXy-TMTx_5dUhbtof > div:nth-child(1) > div > div._3tDaJHgAGDNRcnaEcvOHvU > div > div > div > div > div.ms-FocusZone > div > div > input"));
    	toField.sendKeys(recipient);
    	toField.sendKeys(Keys.ENTER);
    	
    	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }
    
    @And("^User fills Subject line with a (.*)$")
    public void user_fills_subject(String subject) throws Throwable
    {
    	Thread.sleep(2000);
    	
    	// Fill subject line
    	WebElement subjectField = driver.findElement(By.cssSelector("#subjectLine0"));
    	subjectField.sendKeys(subject);
    	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }
    
    @When("^User clicks Send$")
    public void user_clicks_send() throws Throwable
    {	
    	Thread.sleep(4000);
    	
    	// User clicks send
    	driver.findElement(By.cssSelector("#app > div > div._2oC_VlxD_DO0bdsijTkmuB > div > div._29KqToSCcntvfbDv_3xuuh > div._3Z9HcLQ6oAxnDaLEGF0acC > div._3Z9HcLQ6oAxnDaLEGF0acC > div > div._1KJxBCSsRRpiUauU52-5Pc > div._22vbv6th-hFt0ffMlTaRMH > div > div > div > div._3j6EHinwt-MAaY5N3xbaie > div._1BNnReZlP1A569q05PL13b._2AoVj-zRh7kAi1oTQBPoJF.LRMg0GkZwJeZCYObkXUk6 > div._2RWmJQCKUjEfGLTYu_0cC5 > div._3qJ3FHS6GBqeCJTyMlMt3_ > button.ms-Button.ms-Button--primary._3wi0Ec22JNBf3ClMCpnf1Z.root-174")).click();
    	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }
    
    @Then("^Email shall be sent to the (.*) succesfully$")
    public void email_shall_be_sent_to_the_recipient_successfully(String recipient) throws Throwable
    {
    	Thread.sleep(2000);
    	
    	// Check that the email is in the sent folder
    	driver.findElement(By.cssSelector("#app > div > div._2oC_VlxD_DO0bdsijTkmuB > div > div._29KqToSCcntvfbDv_3xuuh > div._2Knz76dTLcJASk7hK-z_Ft > div._1XJLThPJyfP1uedjzaUYHS > div > div.ms-FocusZone._3Y-bYDf3RHNQuCg6reBBbz._2CAT-mgCivHkqBS2RQ5UG9.customScrollBar.disableTextSelection > div > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div")).click();
    	
    	Thread.sleep(2000);
    	
    	
    	WebElement sentList = driver.findElement(By.cssSelector("#app > div > div._2oC_VlxD_DO0bdsijTkmuB > div > div._29KqToSCcntvfbDv_3xuuh > div._3Z9HcLQ6oAxnDaLEGF0acC > div._3Z9HcLQ6oAxnDaLEGF0acC > div > div._2MQLw12eaEtmBJEZBFOl1q > div._1JG8MPYAYFuJ9m1k7gmlsl > div > div > div > div > div"));
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	Thread.sleep(2000);
    	
    	WebElement mostRecent = sentList.findElement(By.className("n101yKKQnfbPMo9fvZ5QH"));
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	String mostRecentEmail = mostRecent.findElement(By.className("_3HQ_h7iVcVeOo03bOFpl")).getAttribute("innerHTML");
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	Assert.assertEquals(recipient, mostRecentEmail);
    }
    
    

}
