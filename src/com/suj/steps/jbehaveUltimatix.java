/*package com.suj.steps;

import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class jbehaveUltimatix{
	
	public static WebDriver driver;
	@Then("Message displayed Login Successfully	")
	public void thenMessageDisplayedLoginSuccessfully() throws Exception{
		System.out.println("Login Successfully");
        //Robot movement to move Mouse Pointer out of screen
        Robot robot = new Robot();
        // SET THE MOUSE X Y POSITION
        robot.mouseMove(0, 0);
        driver.findElement(By.linkText("Employee Services")).click();
        Thread.sleep(60000);
        System.out.println("Employee Services Clicked"); 
	}
	@When("User enter valid Password")
	public void whenUserEnterValidPassword(){
		driver.findElement(By.id("PASSWORD")).sendKeys("03343Ty01410*"); 
	}
	@Then("Message displayed LogOut Successfully")
	public void thenMessageDisplayedLogOutSuccessfully(){
		System.out.println("Login Successfully"); 
	}
	@When("User LogOut from the Application")
	public void whenUserLogOutFromTheApplication(){
		driver.findElement(By.id("uam_modal")).click();
        driver.findElement(By.id("logoutbutton")).click(); 
	}
	@When("User enters valid UserName")
	public void whenUserEntersValidUserName(){
		driver.findElement(By.id("USER")).sendKeys("890093"); 
	}
	@Given("User is on Ultimatix Home Page")
	public void givenUserIsOnUltimatixHomePage(){
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
	@When("User click on Login")
	public void whenUserClickOnLogin(){
		driver.findElement(By.id("login_button")).click();
	}
}*/