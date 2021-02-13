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

public class EmailPage extends BaseClass{

	WebDriver ldriver;
	
	public EmailPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@id=\"quotes\"]/span[2]/div/a")
	@CacheLookup
	WebElement Tutorial;
	
	@FindBy(id="selectCategory")
	@CacheLookup
	WebElement Category;
	
	@FindBy(id="selectTopic")
	@CacheLookup
	WebElement Topic;
	
	@FindBy(id="exportButton")
	@CacheLookup
	WebElement OpenEmail;
	
	public void selectTutorial() throws IOException
	{
		if(Tutorial.isDisplayed())
		{
			Logger.info(Tutorial.getText()+" is present");
			Assert.assertTrue(true);
		}
		else
		{
			takescreenshot(driver,"EmailTempValidation");
			Logger.info(Tutorial.getText()+" is Not present");
			Assert.assertTrue(false);	
		}
	}
	
	public void selectCategory()
	{
		Select em=new Select(Category);
		em.selectByVisibleText("Notices");
		Logger.info("Category is present");
	}
	
	public void selectTopic()
	{
		Select em=new Select(Topic);
		em.selectByVisibleText("Suspended Account");
		Logger.info("Topic is present");
	}
	
	public void selectemail() throws IOException
	{
		if(OpenEmail.isDisplayed())
		{
			Logger.info(OpenEmail.getText()+" is present");
			Assert.assertTrue(true);
		}
		else
		{
			takescreenshot(driver,"EmailTempValidation");
			Logger.info(OpenEmail.getText()+" is Not present");
			Assert.assertTrue(false);	
		}
	}
	
}
