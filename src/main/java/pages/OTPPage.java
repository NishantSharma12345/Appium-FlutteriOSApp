package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import helper.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OTPPage 
{
	AndroidDriver driver;
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'verification')]")
	private WebElement otpText;
	
	@AndroidFindBy(className = "android.widget.Button")
	private WebElement crossButton;
	
	@AndroidFindBy(accessibility = "Enter the OTP")
	private WebElement enterOtpLabel;
	
	@AndroidFindBy(className = "android.widget.EditText")
	private List<WebElement> otpBoxes;
	
	@AndroidFindBy(accessibility = "Back to login page !!")
	private WebElement backToLoginPageButton;
	
	public OTPPage(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void crossButtonClick()
	{
		AppiumUtils.waitForElementToBeClickable(driver, crossButton);
		crossButton.click();
	}
	
	public void enterOTPNumber()
	{
		AppiumUtils.waitForElementToBeClickable(driver, otpText);
		
		Assert.assertEquals(enterOtpLabel.getAttribute("content-desc"), "Enter the OTP");
		
		String[] otpTextArray =  otpText.getAttribute("content-desc").split(" ");	
	    String otpNumber = otpTextArray[4].trim();
	    
	    for(int i = 0; i < otpNumber.length(); i++)
	    {	    	
	    	String singleOTPNumber = String.valueOf(otpNumber.charAt(i));
	    	otpBoxes.get(i).click();
	    	otpBoxes.get(i).sendKeys(singleOTPNumber);
	    }	    
	}
	
	public void backToLoginPageButtonClick()
	{
		Assert.assertEquals(backToLoginPageButton.getAttribute("content-desc"), "Back to login page !!");
		backToLoginPageButton.click();
	}
}
