package one.globalenglish.pageObject;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sun.media.jfxmedia.logging.Logger;

import one.globalenglish.testCases.BaseClass;


public class HomePage extends BaseClass {
	
	WebDriver ldriver;
	
	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}

	@FindBy(id="dropdown_2")
	@CacheLookup
	WebElement Work;
	
	@FindBy(id="dropdown_1")
	@CacheLookup
	WebElement Study;
	
	
	@FindBy(xpath="//*[@id=\"nav\"]/div/div[2]/a")
	@CacheLookup
	WebElement Progress;
	
	@FindBy(xpath="//*[@id=\"dropdown_2\"]/ul/li[4]/a")
	@CacheLookup
	WebElement Accent;
	
	@FindBy(xpath="//*[@id=\"dropdown_2\"]/ul/li[3]/a")
	@CacheLookup
	WebElement Culture;
	
	@FindBy(xpath="//*[@id=\"dropdown_2\"]/ul/li[1]/a")
	@CacheLookup
	WebElement EmailTemp;
	
	@FindBy(xpath="//*[@id=\"dropdown_1\"]/ul/li[3]/a")
	@CacheLookup
	WebElement Stress;
	
	@FindBy(xpath="//*[@id='dropdown_2']//li[7]")
	@CacheLookup
	WebElement  TabNews;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[2]/div/div[2]/div[5]/div/div/ul/li[1]")
	@CacheLookup
	WebElement PageNews;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[2]/div/div[2]/div[4]/div/a/h3")
	@CacheLookup
	WebElement  LableNews;
	
	@FindBy(xpath="//*[@id=\"fixed-menu-wrap\"]/div[3]/ul/li[5]/a/em")
	@CacheLookup
	WebElement Burger;
	
	@FindBy(xpath="//*[@id=\"fixed-menu-wrap\"]/div[3]/ul/li[5]/ul/li[1]/a")
	@CacheLookup
	WebElement Profile;
	
	@FindBy(xpath="//*[@id=\"fixed-menu-wrap\"]/div[3]/ul/li[5]/ul/li[3]/span/span")
	@CacheLookup
	WebElement System;
	
	
	
	@FindBy(xpath="//*[contains(text(),'Edit')]")
	@CacheLookup
	WebElement edit;
	
	
	
	@FindBy(xpath="//*[contains(text(),'Submit')]")
	@CacheLookup
	WebElement submit;
	
	@FindBy(xpath="//*[contains(text(),'Your profile has')]")
	@CacheLookup
	WebElement Success;
	
	@FindAll(@FindBy(tagName="a"))
	@CacheLookup
	List<WebElement> count;
	
	public void work()
	{
		Work.click();
	}
	
	public void accent()
	{
		Accent.click();
		
	}
	
	public void culture()
	{
		Culture.click();
	}
	
	public void EmailTemplate()
	{
		EmailTemp.click();
	}
	
	public void TabNewsfeed() throws IOException
	{
		TabNews.click();
		Set<String> windowid=ldriver.getWindowHandles();
		Iterator<String> a=windowid.iterator();
		
		String MainWindow=a.next();
		String Newsfeed1=a.next();
		ldriver.switchTo().window(Newsfeed1);
		if(ldriver.getTitle().equals("News Feed"))
		{
			Logger.info(ldriver.getTitle()+" is Available from TAB");
			Assert.assertTrue(true);
		}
		else
		{
			takescreenshot(driver,"NewsFeedValidation1");
			Logger.info(ldriver.getTitle()+" is not Available from TAB");
			Assert.assertTrue(false);
		}
		driver.close();
		driver.switchTo().window(MainWindow);
		Logger.info(ldriver.getTitle());
	}
	
	
	public void pageNewsfeed() throws IOException
	{
		PageNews.click();
		
		Set<String> windowid=ldriver.getWindowHandles();
		Iterator<String> b=windowid.iterator();
		
		String MainWindow=b.next();
		String Newsfeed1=b.next();
		ldriver.switchTo().window(Newsfeed1);
		if(ldriver.getTitle().equals("News Feed"))
		{
			Logger.info(ldriver.getTitle()+" is Available from Page");
			Assert.assertTrue(true);
		}
		else
		{
			takescreenshot(driver,"NewsFeedValidation2");
			Logger.info(ldriver.getTitle()+" is not Available from Page");
			Assert.assertTrue(false);
		}
		driver.close();
		driver.switchTo().window(MainWindow);
		Logger.info(ldriver.getTitle());
	
	}
	
	
	public void LableNewsfeed() throws IOException
	{
		if(LableNews.isDisplayed())
		{
			Logger.info(LableNews.getText()+" available");
			Assert.assertTrue(true);
		}
		else
		{
			Logger.info(LableNews.getText()+" is not available");
			takescreenshot(driver,"NewsFeedValidation3");
			Assert.assertTrue(false);
		}
	}
	
	public void Burger()
	{
		Burger.click();
	}
	
	public void SystemCheck()
	{
		System.click();
	}
	
	public void ProfileValidation() throws IOException
	{
		Logger.info(Profile.isDisplayed()+" profile is displaying in the burger menu");
		Profile.click();
		
		Set<String> profileWindow=ldriver.getWindowHandles();
		Iterator<String> move=profileWindow.iterator();
		String HomePage=move.next();
		String ProfilePage=move.next();
		ldriver.switchTo().window(ProfilePage);
		if(edit.isDisplayed())
		{
			Logger.info(edit.getText()+" is available");
			edit.click();
			submit.click();
			
			Logger.info(Success.isDisplayed()+" Success Message is present");
			Assert.assertTrue(true);
		}
		else {
			takescreenshot(driver,"ProfileValidation");
			Logger.info(edit.getText()+" is not available");
			Assert.assertTrue(false);
		}
			
		ldriver.close();
		ldriver.switchTo().window(HomePage);
		
	}
	public void stress()
	{
		Stress.click();
	}
	public void study()
	{
		Study.click();
	}
	
	public void myprogress()
	{
		Progress.click();
	}
	
	//use lambda and streams concept here
	//print link text from all the links
	//check how many links does not have hrefattribute(broken links)
	public void links()
	{
		List<WebElement> links=count;
		Logger.info("Total number of lins: "+links.size());
		//normal for loop
		for(WebElement link:links)
		{
			Logger.info(link.getText());
		}
		
		//now using Lambda exxpression(for each)
		//links.forEach(link->Logger.info(link.getText()));
		
		
		//filter the broken links based on href attribute  using streams(in below code we are checking the attribute has href or not)
		//long workingLinks=links.stream().filter(link->link.getAttribute("href")!=null).count();
		//Logger.info("Working links are "+ workingLinks);
		//driver.close();
		
	}
}
