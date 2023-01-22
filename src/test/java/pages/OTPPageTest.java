package pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClassiOS;

public class OTPPageTest extends BaseClassiOS
{
	LoginPage lp;
	OTPPage otpp;
	
	@BeforeClass
	public void init()
	{
		lp = new LoginPage(driver);
		otpp = new OTPPage(driver);
	}
	
	@Test
	public void androidOTPPageTestPerform()
	{
		lp.userLogin(prop.getProperty("email"), prop.getProperty("password"));
		otpp.crossButtonClick();
		otpp.backToLoginPageButtonClick();
		lp.userLogin(prop.getProperty("email"), prop.getProperty("password"));
		otpp.enterOTPNumber();
	}
}
