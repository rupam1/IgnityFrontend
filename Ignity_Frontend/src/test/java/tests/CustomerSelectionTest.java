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
		//String bb= cusselec.CustomerPageTitle();
		Assert.assertEquals(cusselec.CustomerPageTitle(), "SELECT CUSTOMER");
	}
	
	@Test(priority=2)
	public void CheckAccounttypeForFree()
	{
		CustomerSelection cusselec = PageFactory.initElements(driver, CustomerSelection.class);
		Assert.assertEquals(cusselec.CheckAccounttypeForFreeItem(), "Free");
		
	}
	
	@Test(priority=3)
	public void CheckAccounttypeForRegular()
	{
		CustomerSelection cusselec = PageFactory.initElements(driver, CustomerSelection.class);
		Assert.assertEquals(cusselec.ChkAccountTypeDropDownBtnForRegularItem(), "Regular");
		
	}
	
	@Test(priority=4)
	public void CheckAccounttypeForPaid()
	{
		CustomerSelection cusselec = PageFactory.initElements(driver, CustomerSelection.class);
		Assert.assertEquals(cusselec.CheckAccounttypeForPaidItem(), "Paid");
		
	}
	
	@Test(priority=5)
	public void CheckAccounttypeForAll()
	{
		CustomerSelection cusselec = PageFactory.initElements(driver, CustomerSelection.class);
		Assert.assertEquals(cusselec.CheckAccounttypeForAllItem(), "All");
	}
	
	@Test(priority=6)
	public void CheckStatusForActiveExtended()
	{
		CustomerSelection cusselec = PageFactory.initElements(driver, CustomerSelection.class);
		Assert.assertEquals(cusselec.CheckStatusWithActiveExtended(), "Active extended");
	}
	
	@Test(priority=7)
	public void CheckStatusForActive()
	{
		CustomerSelection cusselec = PageFactory.initElements(driver, CustomerSelection.class);
		Assert.assertEquals(cusselec.CheckStatusWithActive(), "Active");
	}
	

}
