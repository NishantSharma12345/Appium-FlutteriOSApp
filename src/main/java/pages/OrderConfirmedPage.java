package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OrderConfirmedPage 
{
	AndroidDriver driver;
	
	@AndroidFindBy(accessibility = "Order Confirmed!!")
	private WebElement orderConfirmedLabel;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Go Back To Home Page!!']")
	private WebElement backToHomePageButton;
	
	public OrderConfirmedPage(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void orderConfirmedLabelVerify()
	{
		Assert.assertEquals(orderConfirmedLabel.getAttribute("content-desc"), "Order Confirmed!!");
	}
	
	public void goBackToHomePageClick()
	{
		Assert.assertEquals(backToHomePageButton.getAttribute("content-desc"), "Go Back To Home Page!!");
		backToHomePageButton.click();
	}
}
