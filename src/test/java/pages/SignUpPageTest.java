package pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClassiOS;

public class SignUpPageTest extends BaseClassiOS
{
	LoginPage lp;
	SignUpPage sp;

	@BeforeClass
	public void init()
	{
		lp = new LoginPage(driver);
		sp = new SignUpPage(driver);
	}
	
	@Test
	public void androidUserSignUpPageTestPerform()
	{
		lp.signUpClick();
		sp.signUpHeaderVerify();
		loginClickVerify();
		sp.userSignUp(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	public void loginClickVerify()
	{
		sp.loginClick();
		lp.signUpClick();		
	}
}
