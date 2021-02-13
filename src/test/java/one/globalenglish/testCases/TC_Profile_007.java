package one.globalenglish.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import one.globalenglish.pageObject.HomePage;
import one.globalenglish.pageObject.LoginPage;

public class TC_Profile_007 extends BaseClass {
	
	@Test
	public void ProfileValidation() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		
		lp.setusername(username);
		lp.setpassword(password);
		lp.login();
		hp.Burger();
		hp.ProfileValidation();
		
	}

}
