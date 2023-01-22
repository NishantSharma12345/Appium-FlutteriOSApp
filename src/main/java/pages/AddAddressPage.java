package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddAddressPage 
{
	AndroidDriver driver;
	
	@AndroidFindBy(accessibility = "Add Address")
	private WebElement addAddressLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Address 1']")
	private WebElement address1Field;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Address 2']")
	private WebElement address2Field;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Country']")
	private WebElement countryField;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Pin Code']")
	private WebElement pinCodeField;
	
	@AndroidFindBy(accessibility = "Checkout Now !!")
	private WebElement checkoutButton;
	
	public AddAddressPage(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void addAddressLabelVerify()
	{
		Assert.assertEquals(addAddressLabel.getAttribute("content-desc"), "Add Address");
	}
	
	public void addAdressAndCheckout(String address1, String address2, String country, String pinCode)
	{
		Assert.assertEquals(address1Field.getText(), "Address 1");
		address1Field.click();
		address1Field.sendKeys(address1);
		
		Assert.assertEquals(address2Field.getText(), "Address 2");
		address2Field.click();
		address2Field.sendKeys(address2);
		
		Assert.assertEquals(countryField.getText(), "Country");
		countryField.click();
		countryField.sendKeys(country);
		
		Assert.assertEquals(pinCodeField.getText(), "Pin Code");
		pinCodeField.click();
		pinCodeField.sendKeys(pinCode);
		
		Assert.assertEquals(checkoutButton.getAttribute("content-desc"), "Checkout Now !!");
		checkoutButton.click();
	}
}
