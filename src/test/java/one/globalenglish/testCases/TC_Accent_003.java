package one.globalenglish.testCases;

import java.io.IOException;


import org.testng.annotations.Test;

import one.globalenglish.pageObject.AccentPage;
import one.globalenglish.pageObject.HomePage;
import one.globalenglish.pageObject.LoginPage;

public class TC_Accent_003 extends BaseClass {
	
	
	@Test
	public void accent() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		AccentPage ap=new AccentPage(driver);
		lp.setusername(username);
		lp.setpassword(password);
		lp.login();
		hp.work();
		hp.accent();
		ap.region();
		ap.country();
		ap.click();
		ap.getaccent();
	
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		
	}

}
