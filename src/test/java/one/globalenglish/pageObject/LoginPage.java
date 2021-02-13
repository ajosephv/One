package one.globalenglish.pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(id="accept_cookie")
	@CacheLookup
	WebElement cookie;
	
	@FindBy(xpath="//*[@id=\"enLang\"]/span")
	@CacheLookup
	WebElement lang;
	
	
	@FindBy(name="username")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(id="login_button")
	@CacheLookup
	WebElement login;
	
	@FindBy(xpath="//*[@id=\"error_msg\"]/span[2]")
	@CacheLookup
	WebElement invalidCred;
	
	@FindBy(xpath="//*[@id=\"fixed-menu-wrap\"]/div[3]/ul/li[5]/a")
	@CacheLookup
	WebElement burger;
	
	@FindBy(xpath="//*[@id=\"fixed-menu-wrap\"]/div[3]/ul/li[5]/ul/li[5]/a")
	@CacheLookup
	WebElement logout;
	
	
	public void cookie()
	{
		cookie.click();
	}
	
	public void lang()
	{
		lang.click();
	}
	public void setusername(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	public void setpassword(String password)
	{
		txtpassword.sendKeys(password);
	}
	
	public void login() 
	{
		login.click();
		
	}
	
	public WebElement invalidmessage()
	{
	
	invalidCred.getText();
	return invalidCred;
	
	
	
	}
	
	public void burger()
	{
		burger.click();
	}
	
	public void Logout() throws InterruptedException
	{
		logout.click();
		Thread.sleep(4000);
	}
	
	public void clearusername()
	{
		txtUserName.clear();
	}
	
	public void clearpassword()
	{
		txtpassword.clear();
	}

}
