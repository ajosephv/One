package one.globalenglish.pageObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import one.globalenglish.testCases.BaseClass;

public class GctutorialPage extends BaseClass {
	WebDriver ldriver;
	
	public GctutorialPage(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(css="div.ft-container.ng-scope>div.title.style>span")
	@CacheLookup
	WebElement gctitle;
	
	@FindBy(xpath="//*[@id=\"headerDiv\"]/div[1]/a")
	@CacheLookup
	WebElement ok;
	
	@FindBy(id="mlssideMenu")
	@CacheLookup
	WebElement links;
	
	@FindBy(xpath="//div[@id='mlssideMenu']/a")
	@CacheLookup
	WebElement links2;
	
	
	

	

	public void gcheading()
	{
		try {
		String b=gctitle.getText();
		Assert.assertTrue(b.equals("Global Community Tutorials"));
		Logger.info(b);
		}
		catch(Exception e) {
			Logger.info( e.getMessage());
		}
	}
	
	public void ok()
	{
		ok.click();
		
	}
	
	
	//this is to checl the reponse value is more than 400 or not for each links
	public void ActivityValidation() throws IOException
	{
		
		List<WebElement> links=driver.findElements(By.xpath("//div[@id='mlssideMenu']/a"));
		for(WebElement link:links)
		{
			String url=link.getAttribute("href");
			HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int resp=conn.getResponseCode();
			Logger.info("the :"+ link.getText()+"has a success message with value "+resp);
			if(resp>=400)
			{
				takescreenshot(driver,"GCTutorial");
				Assert.assertTrue(false);
			}
		}
	}
		//this is to check the total count of links and open the activity links in new tab and make sure it loads without any issue
		public void ActivityValidation1()
		{
			
			WebElement link=links;
			int count=link.findElements(By.tagName("a")).size();
			Logger.info( "total links coubt is: "+ count);
			for(int i=0;i<count;i++)
			{
			String newtab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			link.findElements(By.tagName("a")).get(i).sendKeys(newtab);
				
			}
		}
		
				
	}

