package one.globalenglish.pageObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import one.globalenglish.testCases.BaseClass;

public class StressPage extends BaseClass {
	
	WebDriver ldriver;
	
	public StressPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[2]/a[1]")
	@CacheLookup
	WebElement links;
	

	@FindBys(@FindBy(css="div[class='style'] a"))
	@CacheLookup
	List<WebElement> Clicks2;
	
	@FindBy(tagName="a")
	@CacheLookup
	WebElement count;
	
	
	
	
	
	//this is to check the network tab and get the response code status value(200 is fine.. 400 or more than 400 is blockers)
	public void clicklinks2() throws MalformedURLException, IOException
	{
		List<WebElement> Links= driver.findElements(By.cssSelector("div[class='style'] a"));
		for(WebElement link : Links)
		{
			String url=link.getAttribute("href");
			HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
			
			conn.setRequestMethod("HEAD");
			conn.connect();
			int resp=conn.getResponseCode();
			Logger.info("the link with"+ link.getText()+ "is success with response code" +resp);
					if(resp>400)
					{
						Logger.info("the link with"+ link.getText()+ "is broken with response code" +resp);
						Assert.assertTrue(false);
						
					}
		}
	}
	
	
	//this is to check the network tab and get the response code status value(200 is fine.. 400 or more than 400 is blockers)
	public void clicklinks() throws IOException
	{
		String url= links.getAttribute("href");
		HttpURLConnection conn= (HttpURLConnection)new URL(url).openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();  
        int resp=conn.getResponseCode();
        Logger.info(resp);
		
	}
	
	//opening the links in new tab and taking the title 
	public void window()
	{
		Logger.info(driver.findElements(By.tagName("a")).size());//this will give total links count
		
		WebElement middle=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[3]")); //limititng webdriver scope and this will give thelinks cont  based on limit
		Logger.info(middle.findElements(By.tagName("a")).size());
		
		
		WebElement row1=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[3]/div[1]"));
		Logger.info(row1.findElements(By.tagName("a")).size());
		int total=row1.findElements(By.tagName("a")).size();
		//click on each link and in new tab and get the title
		for(int i=0;i<total;i++)
		{
			String clickonlink=Keys.chord(Keys.CONTROL,Keys.ENTER);
			row1.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);
			Logger.info(driver.getTitle());
			
			
		}
	}
	
	

}
