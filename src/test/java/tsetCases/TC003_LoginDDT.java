package tsetCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="Datadriven")
	public void verify_LoginDDT(String email, String pwd, String exp)
	{
		try {
			
		logger.info("***  Starting TC003_LOginDDT ***");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		MyAccountPage macc=new MyAccountPage(driver);
		Boolean targetPage=macc.isMyAccountExists();
		
		/*Data is valid - Login Success - test Pass - Logout
		   				  Login failed - test fail
		  
		  Data is invalid - Login Success - test fail - Logout
							Login failed - test pass
		 */
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else	{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else	{
				Assert.assertTrue(false);
			}
	}
		}
		catch(Exception e){
			Assert.fail();
		}
		logger.info("***  Finished TC003_LOginDDT ***");
		
		}
	
}
