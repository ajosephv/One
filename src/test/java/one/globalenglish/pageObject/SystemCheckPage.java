package one.globalenglish.pageObject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import one.globalenglish.testCases.BaseClass;

public class SystemCheckPage extends BaseClass {

	WebDriver ldriver;
	public SystemCheckPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@id='mainController']/div/span")
	@CacheLookup
	WebElement title;
	
	@FindBy(id="audio-next")
	@CacheLookup
	WebElement Next;
	
	@FindBy(id="audioIcon")
	@CacheLookup
	WebElement AudioClick;
	
	@FindBy(xpath="//*[@id='systemCheckElement']/div/div[2]/div[3]/div[1]")
	@CacheLookup
	WebElement  Heard;
	
	@FindBy(id="audio-results_1")
	@CacheLookup
	WebElement Result;
	
	@FindBy(id="audio-next")
	@CacheLookup
	WebElement aa;
	
	@FindBy(id="audio-next")
	@CacheLookup
	WebElement bb;
	
	public void Audiovalidation() throws IOException
	{
		if(title.getText().equals("System Check"))
		{
			Assert.assertTrue(true);
		}
		else {
			takescreenshot(driver, "SystemCheckValidation");
			Logger.info("this is not system check page");
			Assert.assertTrue(false);
		}
		
		if(Next.isEnabled())
		{
			takescreenshot(driver,"SystemCheckValidation");
			Logger.info("Next button is in enabled status hence failed");
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
			AudioClick.isEnabled();
			Logger.info(AudioClick.isEnabled()+" Audio is enabled");
			
			boolean a=Heard.isSelected();
			if(a)
			{
				takescreenshot(driver,"SystemCheckValidation");
				Logger.info(a+" heard radio button is already selected hence failed");
				Assert.assertTrue(false);
			}
			else {
				Logger.info(a+" heard radio button is not selected hence passed");
				AudioClick.click();
				Heard.click();
				boolean b=Result.getText().contains((CharSequence) result);
				if(b)
				{
					Logger.info("result captured"+ Result.getText());
					Next.click();
					Assert.assertTrue(true);
					Logger.info("navigated to next page");
				}
				else {
					takescreenshot(driver,"SystemCheckValidation");
					Logger.info(Result.getText()+" result message does not match with expected result");
					Assert.assertTrue(false);
				}
				
			}

			
			
		}
		}
		
		
		
		
	}

	
	
	
	


