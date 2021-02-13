package one.globalenglish.testCases;

import org.testng.annotations.Test;

import one.globalenglish.pageObject.HomePage;
import one.globalenglish.pageObject.LoginPage;

public class TC_Home_011 extends BaseClass{
	
	@Test
	public void HomeLinks()
	{
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		lp.setusername(username);
		lp.setpassword(password);
		lp.login();
		hp.links();
		
	}

}
