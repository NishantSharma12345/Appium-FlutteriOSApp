package pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClassAndroid;

public class AddAddressPageTest extends BaseClassAndroid
{
	LoginPage lp;
	OTPPage otpp;
	HomePage hp;
	ProductPage pp;
	CartPage cp;
	AddAddressPage aap;
	
	@BeforeClass
	public void init()
	{
		lp = new LoginPage(driver);
		otpp = new OTPPage(driver);
		hp = new HomePage(driver);
		pp = new ProductPage(driver);
		cp = new CartPage(driver);
		aap = new AddAddressPage(driver);
	}
	
	@Test
	public void androidAddAddressAndCheckoutPerform()
	{
		lp.userLogin(prop.getProperty("email"), prop.getProperty("password"));
		otpp.enterOTPNumber();
		hp.singleProductScrollDown();
		pp.dragAndDropQuantityInCart();
		pp.backButtonClick();
		hp.cartButtonClick();
		cp.addAddressButtonClick();
		aap.addAddressLabelVerify();
		aap.addAdressAndCheckout(prop.getProperty("address1"), prop.getProperty("address2"), prop.getProperty("country"), prop.getProperty("pincode"));
	}
}
