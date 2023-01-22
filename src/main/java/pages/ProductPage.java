package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import helper.iOSGestures;
import helper.AppiumUtils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage extends iOSGestures
{
	IOSDriver driver;
	
	@AndroidFindBy(xpath = "(//android.widget.Button)[1]")
	private WebElement backButton;
	
	@AndroidFindBy(accessibility ="1")
	private WebElement quantityNumber;
	
	/*@AndroidFindBy(xpath = "//android.view.View/android.widget.Button")
	private WebElement cartButton;*/
	
	@AndroidFindBy(xpath = "(//android.widget.Button)[2]")
	private WebElement cartButton;
	
	public ProductPage(IOSDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void backButtonClick()
	{
		backButton.click();
	}
	
	public void cartButtonClick()
	{
		cartButton.click();
		AppiumUtils.sleep(4);
	}
	
	public void dragAndDropQuantityInCart()
	{
		dragFromToForDurationGesture(quantityNumber,"1.0",555,444,959,2000);
		AppiumUtils.sleep(4);
	}
}
