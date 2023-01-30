package org.POM;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbForgotPassPOJO extends BaseClass{
	public FbForgotPassPOJO() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Forgotten password?']")
	private WebElement Forgotpassword;
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement PHorEmail;
	
	@FindBy(xpath="//button[@value='1']")
	private WebElement search;

	public WebElement getForgotpassword() {
		return Forgotpassword;
	}

	public WebElement getPHorEmail() {
		return PHorEmail;
	}

	public WebElement getSearch() {
		return search;
	}
	

}


