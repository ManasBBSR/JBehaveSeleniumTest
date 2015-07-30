package com.suj.steps;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;


public class JbehaveSteps {

	public static WebDriver driver;
	
	
	@Given("User is on Ultimatix Home Page")
	public void user_is_on_Ultimatix_Home_Page() throws Throwable {
		//Create a new instance of the Chrome driver
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe"); 
		driver = new ChromeDriver();
		//System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer_Win32_2.45.0\\IEDriverServer.exe");
        //WebDriver driver=new InternetExplorerDriver(); 
		//Put a Implicit wait, this means that any search for elements on the page could take the time the 
		//implicit wait is set for before throwing exception
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Launch the Online Store Website
		driver.get("https://www.ultimatix.net");
	}

	@When("User enters valid UserName $UserName")// standalone
	//@Alias("User enters valid <UserName>")
	@Aliases(values={"User enters valid <UserName>"})// examples table
    public void user_enters_valid_UserName(@Named("UserName") String UserName) throws Throwable {
		// Find the element that's ID the User Name Field 
        driver.findElement(By.id("USER")).sendKeys(UserName);
		//driver.findElement(By.id("USER")).sendKeys("888932");
	}

	@When("User enter valid Password $Password")// standalone
	@Aliases(values={"User enter valid <Password>"})// examples table
	public void user_enter_valid_Password(@Named("Password") String Password) throws Throwable {
        // Enter Password on the element found by the above desc.
        driver.findElement(By.id("PASSWORD")).sendKeys(Password);
		//driver.findElement(By.id("PASSWORD")).sendKeys("Bdd@5678");
	}

	@When("User click on Login")
	public void user_click_on_Login() throws Throwable {
        // Now submit by clicking on the login button 
        driver.findElement(By.id("login_button")).click();
	}

	@Then("Message displayed Login Successfully")
	public void message_displayed_Login_Successfully() throws Throwable {
        // Print a Log In message to the screen
        System.out.println("Login Successfully");
        //Robot movement to move Mouse Pointer out of screen
        Robot robot = new Robot();
        // SET THE MOUSE X Y POSITION
        robot.mouseMove(0, 0);
        driver.findElement(By.linkText("Employee Services")).click();
        Thread.sleep(1000);
        System.out.println("Employee Services Clicked");
	}

	@When("User LogOut from the Application")
	public void user_LogOut_from_the_Application() throws Throwable {
        // Now submit by clicking on the logout button 
        driver.findElement(By.id("uam_modal")).click();
        driver.findElement(By.id("logoutbutton")).click();	
	}

	@Then("Message displayed LogOut Successfully")
	public void message_displayed_LogOut_Successfully() throws Throwable {
        // Print a Log In message to the screen
        System.out.println("Login Successfully");		    
	}


}
