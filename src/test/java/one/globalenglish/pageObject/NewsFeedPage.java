package one.globalenglish.pageObject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import one.globalenglish.testCases.BaseClass;

public class NewsFeedPage extends BaseClass {
	WebDriver ldriver;
	
	@FindBy(xpath="//*[@id=\"newsfeed__china_block1\"]/div[2]/div/div/ul")
	@CacheLookup
	WebElement cards;
			
	public NewsFeedPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	


	
}
