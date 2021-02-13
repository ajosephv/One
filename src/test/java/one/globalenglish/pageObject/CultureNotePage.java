package one.globalenglish.pageObject;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import one.globalenglish.testCases.BaseClass;

public class CultureNotePage extends BaseClass {

	WebDriver ldriver;
	
	public CultureNotePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@id=\"continent-select-list\"]")
	@CacheLookup
	WebElement Region;
	
	@FindBy(xpath="//*[@id=\"country-select-list\"]")
	@CacheLookup
	WebElement Country;
	
	@FindBy(xpath="//*[@id=\"selectDialog\"]/button")
	@CacheLookup
	WebElement click;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/span[1]")
	@CacheLookup
	WebElement Topic;
	@FindBy(xpath="/html/body/div[4]/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[2]/div[2]")
	@CacheLookup
	WebElement Topicdrop;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[2]/div[2]/div[4]/div[1]/div[2]/h3")
	@CacheLookup
	WebElement TopicValidate;

	public void getregion()
	{
		Select a=new Select(Region);
		a.selectByVisibleText("Australia");
	}
	
	public void getcountry()
	{
		Select b=new Select(Country);
		b.selectByVisibleText("New Zealand");
	}

	public void onclick()
	{
		click.click();
	}

	public void culturehomePageValidation() throws IOException
	{
		if(ldriver.getTitle().equals("GlobalEnglish - Culture Notes"))
		{
			Assert.assertTrue(true);
			Logger.info("page title is "+driver.getTitle());
		}
		else {
			takescreenshot(driver,"Cultures");
			Logger.info("Page title is not "+driver.getTitle());
			Assert.assertTrue(false);
		}
	}
	
	public void CulturecountryPageValidation() throws IOException
	{
		if(ldriver.getTitle().equals("GlobalEnglish - Culture Notes | Australia: New Zealand"))
		{
			Assert.assertTrue(true);
			Logger.info("page title is "+driver.getTitle());
		}
		else {
			takescreenshot(driver,"Cultures");
			Logger.info("Page title is not "+driver.getTitle());
			Assert.assertTrue(false);
		}

	}
	
	
	public void topicvalidation() throws IOException
	{
		 Topic.click();
		 Logger.info("dropdown clicked");
		  
		 List<WebElement> count=driver.findElements(By.xpath("Topicdrop"));
	
		  for(int i=0;i<count.size();i++)
		  {
			 count.get(i).click();
			 System.out.println(Topicdrop.getText());
		  }	  		  
		 
		
		  
		  
	}
	
	
	
	
	
}
