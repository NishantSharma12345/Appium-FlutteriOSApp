package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage 
{
	AndroidDriver driver;
	
	@AndroidFindBy(accessibility = "Back")
	private WebElement backButton;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Your Cart Is Empty']")
	private WebElement emptyCartLabel;
	
	@AndroidFindBy(accessibility = "Back To Home Page!!")
	private WebElement backToHomeButton;
	
	@AndroidFindBy(accessibility = "Add Address Now !!")
	private WebElement addAddressButton;
	
	public CartPage(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void backButtonClick() 
	{
		backButton.click();
	}
	public void backToHomeButtonClick()
	{
		backToHomeButton.click();
	}
	
	public void addAddressButtonClick()
	{	
		addAddressButton.click();
	}
	
	public void emptyOrNotEmptyCartPage()
	{
		if(backToHomeButton.isDisplayed())
		{
			Assert.assertEquals(emptyCartLabel.getAttribute("content-desc"), "Your Cart Is Empty");
			Assert.assertEquals(backToHomeButton.getAttribute("content-desc"), "Back To Home Page!!");
			backToHomeButton.click();			
		}
		else if(addAddressButton.isDisplayed())
		{
			Assert.assertEquals(addAddressButton.getAttribute("content-desc"), "Add Address Now !!");
			addAddressButton.click();		
		}
	}
}
