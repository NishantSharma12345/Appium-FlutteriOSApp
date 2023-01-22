package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import helper.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUpPage 
{
	AndroidDriver driver;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Sign up']")
	private WebElement signUpLabel;
	
	@AndroidFindBy(accessibility = "Create an Account, Its free")
	private WebElement createAccountLabel;
	
	@AndroidFindBy(accessibility = "Email")
	private WebElement emailLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter the email address']")
	private WebElement emailField;
	
	@AndroidFindBy(accessibility = "Password")
	private WebElement passwordLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter the password']")
	private WebElement passwordField;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Sign Up']")
	private WebElement signUpButton;
		
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Already have an account? ']")
	private WebElement alreadyHaveAccountText;
	
	@AndroidFindBy(accessibility = "Login")
	private WebElement loginButton;
	
	public SignUpPage(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void signUpHeaderVerify()
	{
		Assert.assertEquals(signUpLabel.getAttribute("content-desc"), "Sign up");
		Assert.assertEquals(createAccountLabel.getAttribute("content-desc"), "Create an Account, Its free");
	}
	
	public void userSignUp(String email, String password)
	{
		Assert.assertEquals(emailLabel.getAttribute("content-desc"), "Email");
		emailField.click();
		emailField.sendKeys(email);
		
		Assert.assertEquals(passwordLabel.getAttribute("content-desc"), "Password");
		passwordField.click();
		passwordField.sendKeys(password);
		
		driver.hideKeyboard();
		
		Assert.assertEquals(signUpButton.getAttribute("content-desc"), "Sign Up");
		signUpButton.click();		
	}
	
	public void loginClick()
	{
		Assert.assertEquals(alreadyHaveAccountText.getAttribute("content-desc"), "Already have an account? ");
		Assert.assertEquals(loginButton.getAttribute("content-desc"), "Login");
		loginButton.click();	
	}
}
