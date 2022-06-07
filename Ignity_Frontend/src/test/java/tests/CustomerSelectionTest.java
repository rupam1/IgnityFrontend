package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CustomerSelection;
import tests.AllTest;

public class CustomerSelectionTest extends Base {
	
	@Test(priority=0)
	public void login()
	{
	//Login the Ignity Application
	AllTest alltest = PageFactory.initElements(driver, AllTest.class);
	alltest.SuccessfulLogin();
	
	}
	
	@Test(priority=1)
	public void ISCustomerLoginPageLoaded()
	{
		CustomerSelection cusselec = PageFactory.initElements(driver, CustomerSelection.class);
		Assert.assertEquals(cusselec.CustomerPageTitle(), "SELECT CUSTOMER");
	}
	

}
