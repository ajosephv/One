package one.globalenglish.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

		//pro is a object of property class
		Properties pro;
		
		
		//THIS IS A CONSTRUCTOR
		public ReadConfig()
		{
			
			//src is a variable
			File src=new File("./configuration/config.properties");
			try {
				FileInputStream fis = new FileInputStream(src);
				pro = new Properties();
				pro.load(fis);
				
			} catch (Exception e) {
				System.out.println("Ex ception is : " + e.getMessage());
			}
		}
		
		public String geturl()
		{
			String url=pro.getProperty("baseurl");
			return url;
		}
		
		public String geturl1()
		{
		String url1=pro.getProperty("url1")	;
		return url1;
		}
		
		public String getusername()
		{
			String name=pro.getProperty("username");
			return name;
		}
		
		public String getpassword()
		{
			String pass=pro.getProperty("password");
			return pass;
		}
		
		
		
		public String getchrome()
		{
			String chrome=pro.getProperty("chrome");
			return chrome;
		}
		
		public String getie()
		{
			String ie=pro.getProperty("ie");
			return ie;
		}
		
		public String getfirefox()
		{
			String firefox=pro.getProperty("firefox");
			return firefox;
		}
		
		public String getsystemcheckresult()
		{
			String result=pro.getProperty("result");
			return result;
			
		}
		
}
