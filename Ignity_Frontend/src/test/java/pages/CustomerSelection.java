package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;
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
	@FindBy(xpath = "//input[contains(@type,'text')]") WebElement Searchbox;
	@FindBy(xpath = ".//td[1][.//text()[contains(., '')]]") List<WebElement> Customername;
	@FindBy(xpath = "//p[@class='data-not-fonud'][contains(.,'No records found')]") WebElement Datanotfound;
	
	
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
		if(tblsize>0)
		{
			for(WebElement ele :tableRows) 
			{
		    //System.out.println(ele.getText());
				String a= ele.getText();
				if(a.equals("Regular"))
				{
					c++;
				}
				else
				{
					break;
				}
			
			}
		}
		
		if (tblsize == c || tblsize==0)
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
		if(tblsize>0)
		{
			for(WebElement ele :tableRows)
			{
				String a = ele.getText();
				if(a.equals("Free"))
				{
					c++;
				}
				else
				{
					break;
				}
			}
		}
		
		if(tblsize == c || tblsize==0)
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
		if(tblsize>0)
		{
			for(WebElement ele : tableRows)
			{
				String a = ele.getText();
				if(a.equals("Paid"))
				{
					c++;
				}
				else
				{
					break;
				}
			}
		}
		
		if(tblsize == c || tblsize==0)
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
		if(tblsize>0)
		{
			for(WebElement ele : tblrows)
			{
				a= ele.getText();
				if(a== "Regular" || a== "Paid" || a== "Free")
				{
					c++;
				}
				else
				{
					
					break;
				}
			}
		}
		
		if(tblsize == c || tblsize==0 )
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
		if(tblsize>0)
		{
			for(WebElement ele : actex )
			{
				if(ele.getText().equals("Active extended"))
					{
				 		c++;
						flag=1;
					}
				else
				{
					flag=0;
					break;
				}
			}
		}
		
		if(flag==1 || tblsize==c || tblsize==0 )
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
		if(tblsize>0)
		{
			for (WebElement ele : actv)
			{
				if(ele.getText().contains("Active"))
				{
					c++;
					flag=1;
				}
				else
				{
					flag=0;
					break;
				}
			}
		}
		
		if(flag==1 || tblsize==c || tblsize==0)
			return "Active";
		else
			return "NonActive";
		
	}
	
	public String CheckSearchBox(String strsearch)
	{
		//Searchbox.sendKeys(strsearch);
		
		List<WebElement> bb = Customername;
		String tt,dd;
		int rr=0,gg=0, flag=0;
		//String arr[]= new String[10];
		//String arr1[]= new String[10];
		List<String> list = new ArrayList<String>();
		List<String> list1 = new ArrayList<String>();
		
		
		for (WebElement ele : bb)
		{
			tt= ele.getText();
			if(tt.contains(strsearch))
			{
				//arr[rr]=tt; 
			    //System.out.println(arr[rr]);
			    //rr++;
				
				list.add(tt);
			}
			
		}
		
		Searchbox.sendKeys(strsearch);
		List<WebElement> cc = Customername;
		
		for (WebElement ele : cc)
		{
			dd = ele.getText();
			//arr1[gg]=dd;
			//gg++;
			//System.out.println(dd);
			
			list1.add(dd);
			
		}
		
		for(int i=0;i<list1.size();i++)
		{
			int yy = list1.size();
			//String yr =  list.get(i);
			//String gf = list1.get(i);
			if(list.get(i).equals( list1.get(i)))
			{
				flag=1;
			}
			else
			{
				flag=0;
				break;
			}
			
		}
		
		if(flag==1)
		{
			return "Searching is working for searchbox";
		}
		else if (flag==0)
		{
			return "Searching is not working for searchbox";
		}
		
		else
			return "Nothing";
	}
		
	/*
		
		for(rr=0, gg=0; rr<arr.length; rr++, gg++)
		{
			
			if(arr[rr].equals(arr1[gg]))
			{
				flag=1;
			}
			
			else
				flag=0;
			
			
		}
	
		if(flag==1)
		{
			return "Searched box is working";
		}
		else
			return "Searched box is not working";
		
	}*/


}
			