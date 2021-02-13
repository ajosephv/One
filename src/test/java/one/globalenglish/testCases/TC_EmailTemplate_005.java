package one.globalenglish.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import one.globalenglish.pageObject.EmailPage;
import one.globalenglish.pageObject.HomePage;
import one.globalenglish.pageObject.LoginPage;

public class TC_EmailTemplate_005 extends BaseClass {
	
  @Test
  public void EmailTempValidation() throws IOException {
	  
	  LoginPage lp=new LoginPage(driver);
	  HomePage hp=new HomePage(driver);
	  EmailPage ep=new EmailPage(driver);
	  
	  lp.setusername(username);
	  lp.setpassword(password);
	  lp.login();
	  hp.work();
	  hp.EmailTemplate();
	  
	  if(driver.getTitle().equals("GlobalEnglish - Email Templates"))
	  {
			Logger.info(driver.getTitle()+" is present");
			Assert.assertTrue(true);
		}
		else
		{
			takescreenshot(driver,"EmailTempValidation");
			Logger.info(driver.getTitle()+" is Not present");
			Assert.assertTrue(false);	
		}
	  
	  ep.selectTutorial();
	  ep.selectCategory();
	  ep.selectTopic();
	  ep.selectemail();
	  
	  
  }

  

}
