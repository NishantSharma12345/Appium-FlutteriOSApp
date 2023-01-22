package pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClassAndroid;

public class ProductPageTest extends BaseClassAndroid
{
	LoginPage lp;
	OTPPage otpp;
	HomePage hp;
	ProductPage pp;
	
	@BeforeClass
	public void init()
	{
		lp = new LoginPage(driver);
		otpp = new OTPPage(driver);
		hp = new HomePage(driver);
		pp = new ProductPage(driver);
	}
	
	@Test
	public void androidProductPageTestPerform()
	{
		lp.userLogin(prop.getProperty("email"), prop.getProperty("password"));
		otpp.enterOTPNumber();
		hp.singleProductScrollDown();
		pp.dragAndDropQuantityInCart();
		pp.cartButtonClick();
		pp.backButtonClick();
	}
}
