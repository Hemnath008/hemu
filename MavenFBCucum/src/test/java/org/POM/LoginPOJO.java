package org.POM;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOJO extends BaseClass{
	
	
	public LoginPOJO() {
		PageFactory.initElements(driver, this);
	}
    @FindBy(xpath = "//input[@type='text']")
	private WebElement UserId;
    @FindBy(xpath ="//input[@type='password']")
    private WebElement password;
    
    @FindBy (xpath = "//button[@value='1']")
    private WebElement loginButton;

	public WebElement getUserId() {
		return UserId;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
}
