package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import helper.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage 
{
	AndroidDriver driver;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Login']")
	private WebElement loginLabel;
	
	@AndroidFindBy(accessibility = "Welcome back ! Login with your credentials")
	private WebElement welcomeLabel;
	
	@AndroidFindBy(accessibility = "Email")
	private WebElement emailLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter your email address']")
	private WebElement emailField;
	
	@AndroidFindBy(accessibility= "Password")
	private WebElement passwordLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter your password']")
	private WebElement passwordField;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Login']")
	private WebElement loginButton;
		
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Dont have an account?']")
	private WebElement dontHaveAccountText;
	
	@AndroidFindBy(accessibility= "Sign Up")
	private WebElement signUpButton;
	
	public LoginPage(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void loginHeaderVerify()
	{
		Assert.assertEquals(loginLabel.getAttribute("content-desc"), "Login");
		Assert.assertEquals(welcomeLabel.getAttribute("content-desc"), "Welcome back ! Login with your credentials");
	}
	
	public void userLogin(String email, String password)
	{
		AppiumUtils.waitForElementToBeClickable(driver, emailField);
		
		Assert.assertEquals(emailLabel.getAttribute("content-desc"), "Email");
		emailField.click();
		emailField.sendKeys(email);
		
		Assert.assertEquals(passwordLabel.getAttribute("content-desc"), "Password");
		passwordField.click();
		passwordField.sendKeys(password);
		
		driver.hideKeyboard();
		
		Assert.assertEquals(loginButton.getAttribute("content-desc"), "Login");
		loginButton.click();
	}
	
	public void signUpClick()
	{
		Assert.assertEquals(dontHaveAccountText.getAttribute("content-desc"), "Dont have an account?");
		Assert.assertEquals(signUpButton.getAttribute("content-desc"), "Sign Up");
		signUpButton.click();
	}
}
