package cucumberTest;

import org.junit.runner.RunWith;		
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
@RunWith(Cucumber.class)				
@CucumberOptions(features="feature",glue={"stepDefinition"})						
public class SeleniumTest 				
{		

}