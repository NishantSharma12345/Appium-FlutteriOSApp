package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import helper.AndroidGestures;
import helper.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends AndroidGestures {
	AndroidDriver driver;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[1]")
	private WebElement logoutButton;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='EXPLORE']")
	private WebElement exploreLabel;

	@AndroidFindBy(accessibility = "Check some out of here!!")
	private WebElement checkSomeLabel;

	@AndroidFindBy(xpath = "//android.widget.ImageView")
	private List<WebElement> bannerImages;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'Hyundai')]")
	private WebElement product;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'From:')]")
	private List<WebElement> products;

	@AndroidFindBy(accessibility = "Explore Cart Now !!")
	private WebElement cartButton;

	@AndroidFindBy(accessibility = "Okay")
	private WebElement okayButton;
	
	@AndroidFindBy(accessibility = "Feedback")
	private WebElement feedbackLabel;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter your feedback']")
	private WebElement feedbackField;
	
	@AndroidFindBy(accessibility = "Send")
	private WebElement sendButton;
	
	public HomePage(AndroidDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void logoutButtonClick() 
	{
		logoutButton.click();
	}

	public void headerTextVerify() 
	{
		Assert.assertEquals(exploreLabel.getAttribute("content-desc"), "EXPLORE");
		Assert.assertEquals(checkSomeLabel.getAttribute("content-desc"), "Check some out of here!!");
	}

	public void bannerSwipe() 
	{
		AppiumUtils.sleep(2);
		AppiumUtils.waitForElementToBeClickable(driver, bannerImages.get(0));
		for (int i = 0; i < bannerImages.size(); i++) 
		{
			swipeGesture(bannerImages.get(i), "left", 0.75);
		}
	}
	
	public void singleProductScrollDown() 
	{ 
		scrollToText("Enter your feedback");
	    products.get(1).click(); 
	}
	 
	public void productScrollUpAndDown(ProductPage pp) 
	{
		scrollToText("Enter your feedback");
		for (int i = 0; i < products.size(); i++) 
		{
			products.get(i).click();
		    pp.backButtonClick();
		    swipeGesture(products.get(i), "left", 0.20);
		}
	}
	
	public void singleProductScrollAndLongPress() 
	{
		for (int i = 2; i < products.size(); i--) 
		{
			longClickGesture(products.get(i), "2000");			
			doubleClickGesture(okayButton);
			swipeGesture(products.get(i), "right", 0.20);
			if(i==0) 
			{
				break;
			}
		}	
	}

	public void cartButtonClick() 
	{
		scrollToText("Enter your feedback");
		Assert.assertEquals(cartButton.getAttribute("content-desc"), "Explore Cart Now !!");
		cartButton.click();
	}
	
	public void sendFeedback()
	{
		Assert.assertEquals(feedbackLabel.getAttribute("content-desc"), "Feedback");
		Assert.assertEquals(feedbackField.getText(), "Enter your feedback");
		feedbackField.click();
		feedbackField.sendKeys("Good Product");
		driver.hideKeyboard();
		Assert.assertEquals(sendButton.getAttribute("content-desc"), "Send");
		sendButton.click();
	}
}
