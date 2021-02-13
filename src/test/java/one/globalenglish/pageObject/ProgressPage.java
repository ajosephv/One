package one.globalenglish.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import one.globalenglish.testCases.BaseClass;

public class ProgressPage extends BaseClass {

	WebDriver ldriver;
	public ProgressPage(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@id=\"mainContainer\"]/div[2]/div")
	@CacheLookup
	WebElement Links;
	
	
	public void ProgressLinks()
	{
		WebElement link=Links;
		
		int cnt=link.findElements(By.tagName("a")).size();
		Logger.info("total links count is: "+ cnt);
		for(int i=0;i<cnt;i++)
		{
			String click=Keys.chord(Keys.CONTROL,Keys.ENTER);
			link.findElements(By.tagName("a")).get(i).sendKeys(click);
			
			
			
		}
	}
	
	
}
