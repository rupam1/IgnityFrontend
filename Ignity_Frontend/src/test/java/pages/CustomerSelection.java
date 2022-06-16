package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CustomerSelection {
	
	@FindBy(xpath = "//span[contains(.,'Select customer')]") WebElement CustomerPageTitle;
	@FindBy(xpath = "(//select[@class='form-control dropdown-selection'])[1]") WebElement Accounttype;
	@FindBy(xpath = "(//span[contains(.,'Regular')])[2]") WebElement Regtype;
	@FindBy(xpath = "//input[contains(@class,'search-text-box ng-untouched ng-pristine ng-valid')]") WebElement searchbox;
	@FindBy(xpath = "(//span[starts-with(.,'Regular')])") List<WebElement> regular;
	@FindBy(xpath = "(//span[normalize-space(text())='Free'])") List<WebElement> free;
	@FindBy(xpath = "(//span[normalize-space(text())='Paid'])") List<WebElement> paid;
	@FindBy(xpath = "(//span[normalize-space(text())='All'])") List<WebElement> all;
	@FindBy(xpath = "(//select[@class='form-control dropdown-selection'])[2]") WebElement Status;
	@FindBy(xpath = ".//td[4][.//text()[starts-with(., 'Active extended')]]") List<WebElement> ActiveExtended;
	@FindBy(xpath = ".//td[4][.//text()[starts-with(., 'Active')]]") List<WebElement> Active;
	
	
	public String CustomerPageTitle()
	{
		return CustomerPageTitle.getText();
	}
	
	public String ChkAccountTypeDropDownBtnForRegularItem() {
		//int flag=0;
		int c=0;
		int tblsize = 0;
		Select dropdown = new Select(Accounttype);
		//dropdown.selectByVisibleText("All");
		//dropdown.selectByVisibleText("Free");
		//dropdown.selectByVisibleText("Paid");
		dropdown.selectByValue("1");
		List<WebElement> tableRows = regular;
		tblsize = tableRows.size();
		for(WebElement ele :tableRows) {
		    //System.out.println(ele.getText());
			String a= ele.getText();
			if(a.equals("Regular"))
			{
			c++;
			}
			
		}
		
		if (tblsize == c)
			return "Regular";
		else
			return "NonRegular";
				
	}
	
	public String CheckAccounttypeForFreeItem()
	{
		int tblsize=0;
		int c=0;
		Select dropdown = new Select(Accounttype);
		dropdown.selectByVisibleText("Free");
		List<WebElement> tableRows = free;
		tblsize = tableRows.size();
		
		for(WebElement ele :tableRows)
		{
			String a = ele.getText();
			if(a.equals("Free"))
			{
				c++;
			}
		}
		
		if(tblsize == c)
			return "Free";
		else
			return "NonFree";
		
	}
	
	public String CheckAccounttypeForPaidItem()
	{
		int tblsize=0;
		int c=0;
		Select dropdown = new Select(Accounttype);
		dropdown.selectByVisibleText("Paid");
		List<WebElement> tableRows = paid;
		tblsize = tableRows.size();
		for(WebElement ele : tableRows)
		{
			String a = ele.getText();
			if(a.equals("Paid"))
			{
				c++;
			}
		}
		
		if(tblsize == c)
			return "Paid";
		else
			return "NonPaid";
		
	}
	
	public String CheckAccounttypeForAllItem()
	{
		int tblsize;
		int c = 0;
		String a;
		Select dropdown = new Select(Accounttype);
		dropdown.selectByVisibleText("All");
		List<WebElement> tblrows = all;
		tblsize = tblrows.size();
		for(WebElement ele : tblrows)
		{
			a= ele.getText();
			if(a== "Regular" || a== "Paid" || a== "Free")
			{
				c++;
			}
		}
		
		if(tblsize == c)
			return "All";
		else
			return "Not All"; 
				
	}
	
	public String CheckStatusWithActiveExtended()
	{
		int flag=0;
		int c=0;
		int tblsize;
		Select dropdown = new Select(Status);
		dropdown.selectByVisibleText("Active extended");
		List<WebElement> actex = ActiveExtended;
		tblsize= actex.size();
		
		for(WebElement ele : actex )
		{
			if(ele.getText().equals("Active extended"))
					{
				 		c++;
						flag=1;
					}
			else
				flag=0;
				break;
		}
		
		if(flag==1 || tblsize==c )
			return "Active extended";
		else
			return "Active is not extended";
	}
	
	public String CheckStatusWithActive()
	{
		int flag=0;
		int tblsize=0;
		int c=0;
		Select dropdown = new Select(Status);
		dropdown.selectByVisibleText("Active");
		List<WebElement> actv = Active;
		tblsize=actv.size();
		for (WebElement ele : actv)
		{
			if(ele.getText().contains("Active"))
			{
				c++;
				flag=1;
			}
			else
				flag=0;
				break;
		}
		
		if(flag==1 || tblsize==c )
			return "Active";
		else
			return "NonActive";
		
	}

}
