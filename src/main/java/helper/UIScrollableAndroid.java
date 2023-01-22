package helper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UIScrollableAndroid 
{
	AndroidDriver driver;
	
	public UIScrollableAndroid(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//UIScrollable is a powerful Android class that performs element lookups in scrollable layouts. 
	//In most cases you should use "scrollIntoView" class which performs scroll action until the 
	//destination element is found on the screen.

	//We can use UIScrollable swipe in following cases: - search elements in a list (e.g. country 
	//list) - search elements outside of the screen (e.g. input field, text or button)
	
	//ScrollIntoView has UiSelector as search criteria input that allows you to find elements by: 
	//- by text (exact, contains, match, starts with or regex) - id (exact or regex)

	// Page object
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().text(\"exact_text\"))")
	private WebElement withTextFuction;

	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().textContains(\"part_text\"))")
	private WebElement withTextContainsFuction;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*part_id.*\"))")
	private WebElement withIdFunction;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*part_id.*\").text(\"exact_text\"))")
	private WebElement withIdAndTextFunction;
	
	
	// FindElement	
	public void withTextFuction(String exact_text)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().text(\""+exact_text+"\"))"));
	}
	
	public void withTextContainsFuction(String part_text)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().textContains(\""+part_text+"\"))"));		
	}
	
	public void withIdFunction(String part_id)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().resourceIdMatches(\".*"+part_id+".*\"))"));
	}
	
	public void withIdAndTextFunction(String part_id, String exact_text)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().resourceIdMatches(\".*"+part_id+".*\").text(\""+exact_text+"\"))"));
	}
	
	public void withSetMaxSearchSwipesFunction(String exact_text) 
	{
		//Long view issue
		//For some longer views it is necessary to increase "setMaxSearchSwipes". 
		//This value allows to set the maximum count of swipe retries made until the search is stopped.
		// set max swipes to 10
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes(10)" +
		         ".scrollIntoView(new UiSelector().text(\""+exact_text+"\"))"));
	}
}
