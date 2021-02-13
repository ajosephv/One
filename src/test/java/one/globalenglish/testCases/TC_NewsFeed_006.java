package one.globalenglish.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import one.globalenglish.pageObject.HomePage;
import one.globalenglish.pageObject.LoginPage;
import one.globalenglish.pageObject.NewsFeedPage;

public class TC_NewsFeed_006 extends BaseClass {
	
	
	
	@Test
	public void NewsFeedValidation1() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		
		lp.setusername(username);
		lp.setpassword(password);
		lp.login();
		hp.work();
		hp.TabNewsfeed();
		
	}	
	
}
