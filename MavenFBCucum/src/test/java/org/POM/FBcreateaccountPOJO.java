package org.POM;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBcreateaccountPOJO extends BaseClass{
	public FBcreateaccountPOJO() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement FName;
	@FindBy(xpath="(//input[@type='text'])[3]")
	private WebElement Lname;
	@FindBy(xpath="(//input[@type='text'])[4]")
	private WebElement PhoneNo;
	@FindBy(xpath="(//input[@type='password'])[2]")
	private WebElement password;
	@FindBy(xpath="//select[@title='Day']")
	private WebElement DOBday;
	@FindBy(xpath="//select[@title='Month']")
	private WebElement DOBmonth;
    @FindBy (xpath="//select[@title='Year']")
	private WebElement DOByear;
    @FindBy (xpath="(//input[@type='radio'])[2]")
    private WebElement SelectMale;
    @FindBy(xpath="(//a[@role='button'])[2]")
    private WebElement Createaccountclick;
	public WebElement getCreateaccountclick() {
		return Createaccountclick;
	}
	public WebElement getFName() {
		return FName;
	}
	public WebElement getLname() {
		return Lname;
	}
	public WebElement getPhoneNo() {
		return PhoneNo;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getDOBday() {
		return DOBday;
	}
	public WebElement getDOBmonth() {
		return DOBmonth;
	}
	public WebElement getDOByear() {
		return DOByear;
	}
	public WebElement getSelectMale() {
		return SelectMale;
	}
}
