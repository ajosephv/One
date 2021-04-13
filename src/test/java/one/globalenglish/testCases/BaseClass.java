package one.globalenglish.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jsoup.Connection.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import one.globalenglish.pageObject.LoginPage;
import one.globalenglish.utilities.ReadConfig;

public class BaseClass {

	ReadConfig read = new ReadConfig();
	public String baseurl=read.geturl();
	public String url1=read.geturl1();
	public String username=read.getusername();
	public String password=read.getpassword();
	public String result=read.getsystemcheckresult();
	

	public static WebDriver driver;
	
	public static Logger Logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		Logger = Logger.getLogger("Edge Login");
		//Logger Logger=LogManager.getLogger(Base.class.getName());
	
		PropertyConfigurator.configure("log4j.properties");
		   
		   if(br.equals("chrome"))
		   {
		//System.setProperty("webdriver.chrome.driver",read.getchrome());
			   WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		   }
		   else if(br.equals("firefox"))
		   {
			   //System.setProperty("webdriver.gecko.driver",read.getfirefox());
			   WebDriverManager.firefoxdriver().setup();
			   driver = new FirefoxDriver();
			   
		   }
		   else if(br.equals("ie"))
		   {
			   //System.setProperty("webdriver.ie.driver",read.getie());
			   WebDriverManager.iedriver().setup();
			   driver = new InternetExplorerDriver();
		   }
		   
		   
	       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		   driver.get(baseurl);
		   LoginPage b=new LoginPage(driver);
		   driver.manage().window().maximize();
		   b.cookie();
		   b.lang();
	}
	
	@AfterClass
	public void close()
	{
		
		driver.quit();
	}

	
	//this method is to take screenshot
	public void takescreenshot(WebDriver Driver, String tname) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot Taken");
		
		
		
		
	}
	
	
	//creating user defined function to generate unique email address	
		public String randomestring()
		{
			String generatedstring=RandomStringUtils.randomAlphabetic(5);
			return(generatedstring);
		}
		
		public String randomeNum()
		{
			String generatedstring2=RandomStringUtils.randomNumeric(4);
			return(generatedstring2);
		}
		
		
}
