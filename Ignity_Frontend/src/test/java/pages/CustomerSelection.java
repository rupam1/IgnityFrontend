package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerSelection {
	
	@FindBy(xpath = "//span[contains(.,'Select customer')]") WebElement CustomerPageTitle;
	
	public String CustomerPageTitle()
	{
		return CustomerPageTitle.getText();
	}

}
