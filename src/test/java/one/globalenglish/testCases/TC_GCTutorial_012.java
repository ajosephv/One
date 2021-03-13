package one.globalenglish.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import one.globalenglish.pageObject.GctutorialPage;
import one.globalenglish.pageObject.HomePage;
import one.globalenglish.pageObject.LoginPage;

public class TC_GCTutorial_012 extends BaseClass {
	
	@Test
	public void GCTutorial() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		GctutorialPage gp=new GctutorialPage(driver);
		lp.setusername(username);
		lp.setpassword(password);
		lp.login();
		hp.work();
		hp.GCtutorial();
		gp.gcheading();
		gp.ok();
		gp.ActivityValidation();
			
	}
	
	@Test
	public void GCTutorial1()
	{
		GctutorialPage gp=new GctutorialPage(driver);
		gp.ActivityValidation1();
	}
}
