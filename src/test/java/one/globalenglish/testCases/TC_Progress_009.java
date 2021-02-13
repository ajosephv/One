package one.globalenglish.testCases;

import org.testng.annotations.Test;

import one.globalenglish.pageObject.HomePage;
import one.globalenglish.pageObject.LoginPage;
import one.globalenglish.pageObject.ProgressPage;

public class TC_Progress_009 extends BaseClass 
{
	
	@Test
	public void OpenProgresslinks()
	{
	LoginPage lp=new LoginPage(driver);
	HomePage hp=new HomePage(driver);
	ProgressPage pp=new ProgressPage(driver);
	
	lp.setusername(username);
    lp.setpassword(password);
    lp.login();
    hp.myprogress();
    pp.ProgressLinks();
	
	}
	

}
