package one.globalenglish.testCases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import one.globalenglish.pageObject.LoginPage;
import one.globalenglish.utilities.XLUtils;

public class TC_LoginTestDDT_002 extends BaseClass{
	
	
	@Test(dataProvider="LoginData")
	public void login(String user, String password) throws IOException, InterruptedException
	{
		LoginPage aa=new LoginPage(driver);
		
		aa.setusername(user);
		aa.setpassword(password);
		aa.login();
		
		if(driver.getTitle().equals("GlobalEnglish - Home"))
		{
			
			Assert.assertTrue(true);
			Logger.info("homepage:"+ driver.getTitle());
			aa.burger();
			aa.Logout();	
		}
		else
		{
			
			Thread.sleep(3000);
			Logger.info("Testcase failed" + aa.invalidmessage());
			Assert.assertTrue(false);	
		}
		driver.get(baseurl);
	}
	
	@DataProvider(name="LoginData")
	
	String [][] getData() throws IOException
	{
		String path= System.getProperty("user.dir") + "./src/test/java/one/globalenglish/testData/LoginData.xlsx";
		
		int rowcount=XLUtils.getRowCount(path, "sheet1");
		int columcount=XLUtils.getCellCount(path, "sheet1", 1);
		String Logindata[][]=new String[rowcount][columcount];
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<columcount;j++)
			{
				Logindata[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
			}
		}
		return Logindata;
		
	}
	
	

}
