package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class AllTest extends Base {
	
	@Test(priority=0)
	
	public void EmailErrorMessageCheck()
	{
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		String emailerrormsg = loginpage.EmailErrorMessage();
		Assert.assertEquals(emailerrormsg, "Please provide your email");
	}
	
	@Test(priority=1)
	public void PasswordErrorMessagecheck()
	{
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		String passworderrormsg =  loginpage.PasswordErrorMessage();
		Assert.assertEquals(passworderrormsg, "Please provide your password");
	}
	
	@Test(priority=2)
	public void ValidEmailErrorMessageCheck()
	{
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.SetEmail("rupam");
		loginpage.PasswordFieldClick();
		Assert.assertEquals(loginpage.ValidEmailErrorMesage(), "Please enter a valid email address");
	}
	
	@Test(priority=3)
	public void CheckCorrectUserNameWrongPassword()
	{
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.SetEmail("rupam@metatude.com");
		loginpage.SetPassword("1234");
		loginpage.ClickLoginButton();
		String EmailPasswordErrorMessag = loginpage.EmailPasswordErrorMessage();
		Assert.assertEquals(EmailPasswordErrorMessag, "The email or password you have entered is invalid");
		
	}
	
	@Test(priority=4)
	public void CheckWrongUsernameCorrectPassword()
	{
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.SetEmail("rupam@m.com");
		loginpage.SetPassword("Rupam@@100");
		loginpage.ClickLoginButton();
		Assert.assertEquals(loginpage.EmailPasswordErrorMessage(), "The email or password you have entered is invalid");
		
	}
	
	@Test(priority=5)
	public void WrongUsernamePassword()
	{
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.SetEmail("rupam@m.com");
		loginpage.SetPassword("rupam");
		loginpage.ClickLoginButton();
		Assert.assertEquals(loginpage.EmailPasswordErrorMessage(), "The email or password you have entered is invalid");
	}

}
