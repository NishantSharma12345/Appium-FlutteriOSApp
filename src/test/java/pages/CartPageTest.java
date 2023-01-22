package pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClassAndroid;

public class CartPageTest extends BaseClassAndroid 
{
	LoginPage lp;
	OTPPage otpp;
	HomePage hp;
	ProductPage pp;
	CartPage cp;
	
	@BeforeClass
	public void init()
	{
		lp = new LoginPage(driver);
		otpp = new OTPPage(driver);
		hp = new HomePage(driver);
		pp = new ProductPage(driver);
		cp = new CartPage(driver);
	}
	
	@Test
	public void androidCartPageTestPerform()
	{
		lp.userLogin(prop.getProperty("email"), prop.getProperty("password"));
		otpp.enterOTPNumber();
		hp.cartButtonClick();
		cp.emptyOrNotEmptyCartPage();
		hp.singleProductScrollDown();
		pp.dragAndDropQuantityInCart();
		pp.backButtonClick();
		hp.cartButtonClick();
		cp.addAddressButtonClick();
	}
}
