package org.stepdefinition;

import javax.xml.xpath.XPath;

import org.POM.FbForgotPassPOJO;
import org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument.Selector.Xpath;
import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgetPassStepDefinition extends BaseClass {
	
	@When("User should click the forgotten password")
	public void user_should_click_the_forgotten_password() {
		toLaunchBroswer();
	    toLoadUrl("https://en-gb.facebook.com/");
	    toMaximize();
		FbForgotPassPOJO f = new FbForgotPassPOJO();	
		f.getForgotpassword().click();
		
		 
	}

	@When("User Should enter the phone number and click search")
	public void user_Should_enter_the_phone_number_and_click_search() throws InterruptedException {
		FbForgotPassPOJO f = new FbForgotPassPOJO();	
		
		toFill(f.getPHorEmail(), "9087234567");
		f.getSearch().click();
		Thread.sleep(3000);
	    
	}

	@Then("User Should navigate recover password page")
	public void user_Should_navigate_recover_password_page() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("https://en-gb.facebook.com/recover/initiate"), "Verify forgot pass");
	    System.out.println("Verified");
	   
	}
	@When("To print title")
	public void toPrintTitle() {
	    WebElement title = driver.findElement(By.xpath("//div[@class='_9nq2 marginBottom16px']"));
	    String text = title.getText();
	    System.out.println(text);
	    
	}

}
