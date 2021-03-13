package one.globalenglish.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import one.globalenglish.pageObject.HomePage;
import one.globalenglish.pageObject.LoginPage;
import one.globalenglish.pageObject.StressPage;

public class TC_Stress_008 extends BaseClass{

	@Test
	public void response() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		StressPage sp=new StressPage(driver);
		
		lp.setusername(username);
		lp.setpassword(password);
		lp.login();
		hp.study();
		hp.stress();
		sp.clicklinks2();
		//sp.clicklinks();
		//sp.window();
		
	}
}
