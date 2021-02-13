package one.globalenglish.pageObject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import one.globalenglish.testCases.BaseClass;

public class AccentPage extends BaseClass {
	
	WebDriver ldriver;
	
	public AccentPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="region-select-list")
	@CacheLookup
	WebElement Region;
	
	@FindBy(id="country-select-list")
	@CacheLookup
	WebElement Country;
	
	@FindBy(xpath="//*[@id=\"selectDialog\"]/button")
	@CacheLookup
	WebElement click;
	
	@FindBy(xpath="//div[@class='menu-title-container collapsible-item single-line-label truncatable-text body-2']/span[.='Chile']")
	@CacheLookup
	WebElement accentTitle;
	
	
	public void region()
	{
		Select getregin=new Select(Region);
		getregin.selectByVisibleText("South America");
		
	}
	
	public void country()
	{
		Select getcountry=new Select(Country);
		getcountry.selectByVisibleText("Chile (3)");	
	}
	
	
	public void click()
	{
		click.click();	
	}
	
	public void getaccent() throws IOException
	{
		String a=accentTitle.getText();
		if(a.equals("Chile"))
		{
			Assert.assertTrue(true);
			Logger.info(a + " is available");
		}
		else
		{	
			Logger.info(a + " is not available");
			takescreenshot(driver,"accent");
			Assert.assertTrue(false);
	
		}
	}
	
	
	
	
	
}
