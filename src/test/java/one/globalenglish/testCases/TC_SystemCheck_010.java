package one.globalenglish.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import one.globalenglish.pageObject.HomePage;
import one.globalenglish.pageObject.LoginPage;
import one.globalenglish.pageObject.SystemCheckPage;

public class TC_SystemCheck_010 extends BaseClass {
	
	
	@Test
	public void SystemCheckValidation() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		SystemCheckPage scp=new SystemCheckPage(driver);
		
		lp.setusername(username);
		lp.setpassword(password);
		lp.login();
		hp.Burger();
		hp.SystemCheck();
		scp.Audiovalidation();
		//this is test
		
	}
	

}
