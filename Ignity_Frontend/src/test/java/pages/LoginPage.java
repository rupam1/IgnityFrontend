package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(xpath = "//input[contains(@formcontrolname,'email')]") WebElement email;
	@FindBy(xpath = "//input[@formcontrolname='password']") WebElement password;
	@FindBy(xpath = "//span[contains(.,'Please provide your email')]") WebElement emailerrormssg;
	@FindBy(xpath = "//span[contains(.,'Please provide your password')]") WebElement passworderrormessage;
	@FindBy(xpath = "//span[contains(.,'Please enter a valid email address')]") WebElement emailvaliderrormsg;
	@FindBy(xpath = "//button[contains(@type,'submit')]") WebElement loginbutton;
	@FindBy(xpath = "//div[contains(@class,'error-msg-container')]") WebElement emailpasserrormsg;
	
	public String EmailErrorMessage()
	{
		email.clear();
		email.click();
		password.clear();
		password.click();
		String emilerrormsg = emailerrormssg.getText();
		return emilerrormsg;
	}
	
	public String PasswordErrorMessage()
	{
		password.clear();
		password.click();
		email.click();
		String passerrormsg = passworderrormessage.getText();
		return passerrormsg;
	}
	
	public void SetEmail(String stremail)
	{
		email.clear();
		email.sendKeys(stremail);
	}
	
	public void SetPassword(String strpassword)
	{
		password.clear();
		password.sendKeys(strpassword);
	}
	
	public void ClickLoginButton()
	{
		loginbutton.click();
	}
	
	public String EmailPasswordErrorMessage()
	{
		String a = emailpasserrormsg.getText();
		return a;
	}
	
	public void PasswordFieldClick()
	{
		password.click();
	}
	
	public String ValidEmailErrorMesage()
	{
		String validerrormessage  = emailvaliderrormsg.getText();
		return validerrormessage;
	}

}
