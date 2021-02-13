package one.globalenglish.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import one.globalenglish.pageObject.CultureNotePage;
import one.globalenglish.pageObject.HomePage;
import one.globalenglish.pageObject.LoginPage;

public class TC_Culture_004 extends BaseClass {
	

	@Test
	public void Cultures() throws IOException, InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		CultureNotePage cp=new CultureNotePage(driver);
		lp.setusername(username);
		lp.setpassword(password);
		lp.login();
		hp.work();
		hp.culture();
        cp.culturehomePageValidation();
		cp.getregion();
		cp.getcountry();
		cp.onclick();
		cp.CulturecountryPageValidation();
		cp.topicvalidation();
		
		
		
		
	}
	
	
}
