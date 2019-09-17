package com.ExtramarksWebsite_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage 
{
	@FindBy(xpath="//a[@class='forgot-password']")
	WebElement ForgotPassword;
	
	@FindBy(xpath="//input[@id='fgtemail']")
	WebElement enterMobile;
	
	@FindBy(xpath="//button[@type='button' and @class='btn btn-banner blue']")
	WebElement ResetPasswordBtn;
	
	@FindBy(xpath="//ul[@id='navigation-top']//a[@class='signin']")
	public	WebElement SignIn;
	
	public void forgotPassword(String mobile) throws InterruptedException
	{
		
		ForgotPassword.click();
		enterMobile.sendKeys(mobile);
		ResetPasswordBtn.click();
	}
	
}
