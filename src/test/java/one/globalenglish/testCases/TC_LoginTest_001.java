package one.globalenglish.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import one.globalenglish.pageObject.LoginPage;



public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void LoginText() throws IOException, InterruptedException
	{
		//driver.get(baseurl);
		Logger.info("url navigated");
		LoginPage lp=new LoginPage(driver);
		lp.cookie();
		lp.lang();
		lp.setusername(username);
		Logger.info("username entered");
		lp.setpassword(password);
		Logger.info("password entered");
		lp.login();
		Logger.info("logged in success");
		
		if(driver.getTitle().equals("GlobalEnglish - Home"))
		{
		Assert.assertTrue(true);
		Logger.info("login pass: "+ driver.getTitle());
		}
		else
		{
			takescreenshot(driver,"LoginText");
			Assert.assertTrue(false);
			Logger.info("login failed");
		}
		
		lp.burger();
		lp.Logout();
	}
}
