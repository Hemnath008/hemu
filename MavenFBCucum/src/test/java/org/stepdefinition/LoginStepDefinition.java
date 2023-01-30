package org.stepdefinition;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.POM.LoginPOJO;
import org.base.BaseClass;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition extends BaseClass{
	
	
	
	@Given("user should launch the Chrome Browser and enter the url")
	public void user_should_launch_the_Chrome_Browser_and_enter_the_url() {
	    toLaunchBroswer();
	    toLoadUrl("https://en-gb.facebook.com/");
	    toMaximize();
	}

	@When("User should enter the incorrect username and password")
	public void user_should_enter_the_incorrect_username_and_password() {
		LoginPOJO l = new LoginPOJO();
		toFill(l.getUserId(), "Hemnath");
		toFill(l.getPassword(), "Hem@3456");
	    
	}

	@When("user should click login button")
	public void user_should_click_login_button() throws InterruptedException {
		
		LoginPOJO l = new LoginPOJO();
		l.getLoginButton().click();
		Thread.sleep(3000);
	    
	}

	@Then("user should navigate to incorrect credential page")
	public void user_should_navigate_to_incorrect_credential_page() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("/login/?privacy_mutation_token"), "Verify Invalid User id or Password page");
	    System.out.println("Verified");
	    driver.quit();
	}
	
	@When("User should enter the valid username and invalid password")
	public void userShouldEnterTheValidUsernameAndInvalidPassword() throws InterruptedException {
		LoginPOJO l = new LoginPOJO();
		toFill(l.getUserId(), "Hemnath Valid");
		toFill(l.getPassword(), "Hem@3456");
	}
	

	@When("User should enter the valid username and valid password")
	public void userShouldEnterTheValidUsernameAndValidPassword() throws IOException {
		
		LoginPOJO l = new LoginPOJO();
		toFill(l.getUserId(), toReadExcel(4, 0, "Sheet1") );
		toFill(l.getPassword(), toReadExcel(4, 1, "Sheet1"));
	}
	@Then("user should navigate to home page")
	public void userShouldNavigateToHomePage() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("facebook.com"), "Verify valid User id and Password page");
	    System.out.println("Valid user and pass Verified");
	    driver.quit();
	}
	
	@When("User should enter the invalid username {string} and valid password {string}")
	public void userShouldEnterTheInvalidUsernameAndValidPassword(String a, String b) {
		LoginPOJO l = new LoginPOJO();
		toFill(l.getUserId(), a );
		toFill(l.getPassword(), b);
	    
	}
	    

}
