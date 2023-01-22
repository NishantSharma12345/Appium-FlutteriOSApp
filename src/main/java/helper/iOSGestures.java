package helper;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;

public class iOSGestures 
{
	IOSDriver driver;
	
	public iOSGestures(IOSDriver driver)
	{
		this.driver = driver;
	}
	
	public void touchAndHoldGesture(WebElement element, String duration)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("element", ((RemoteWebElement)element).getId());
		params.put("duration", duration);
		
		driver.executeScript("mobile:touchAndHold", params);
	}
	
	public void scrollGesture(WebElement element, String direction)
	{
		//toVisible: Boolean parameter. If set to true then asks to scroll to the first visible element in the parent 
		//container. Has no effect if element is not set
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("element", ((RemoteWebElement)element).getId());
		params.put("direction", direction);
		
		driver.executeScript("mobile:scroll", params);
	}
	
	public void swipeGesture(WebElement element,String direction, double percent)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("element", ((RemoteWebElement)element).getId());
		params.put("direction", direction);
		params.put("percent", percent);
		
		driver.executeScript("mobile:swipe", params);
	}
	
	public void scrollToText(String text)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
	}
	
	public void tapGesture(WebElement element, int x, int y)
	{
		//The best way to tap on an element is using element.click(). So why do we have mobile: tap? 
		//This method allows for extra parameters x and y signifying the coordinate at which to click.
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("element", ((RemoteWebElement)element).getId());
		params.put("x", x);
		params.put("y", y);
		
		driver.executeScript("mobile:tap", params);
	}
	
	public void doubleTapGesture(WebElement element)
	{
		//x and y value representing the screen coordinate you wish to tap
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("element", ((RemoteWebElement)element).getId());
		params.put("x", 100);
		params.put("y", 200);
		
		driver.executeScript("mobile:doubleTap", params);
	}
	
	public void dragFromToForDurationGesture(WebElement element, String duration, int fromX, int fromY, int toX, int toY)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("element", ((RemoteWebElement)element).getId());
		params.put("duration", duration);
		params.put("fromX", fromX);
		params.put("fromY", fromY);
		params.put("toX", toX);
		params.put("toY", toY);
		
		driver.executeScript("mobile:dragFromToForDuration", params);
	}
	
	public void pinchGesture(WebElement element, float value, float velocity)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("element", ((RemoteWebElement)element).getId());
		//The only required parameter is scale:
        //Values between 0 and 1 refer to a "pinch"
	    //Values greater than 1 refer to a "zoom"
		//Scale: Pinch scale of type float. Use a scale between 0 and 1 to "pinch close" or zoom out and a scale greater 
		//than 1 to "pinch open" or zoom in. Mandatory parameter
		//Velocity: The velocity of the pinch in scale factor per second (float value). Mandatory parameter
		params.put("scale", value);
		params.put("velocity", velocity);
		
		driver.executeScript("mobile:pinch", params);
	}
	
	public void selectPickerWheelValueGesture(WebElement element, String order, double offset)
	{
		//Order: Either next to select the value next to the current one from the target picker wheel or previous to select 
		//the previous one. Mandatory parameter
		//Offset: The value in range [0.01, 0.5]. It defines how far from picker wheel's center the click should happen. The actual 
		//distance is calculated by multiplying this value to the actual picker wheel height. Too small offset value may not change 
		//the picker wheel value and too high value may cause the wheel to switch two or more values at once.
		//Usually the optimal value is located in range [0.15, 0.3]. 0.2 by default
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("element", ((RemoteWebElement)element).getId());
		params.put("order", order);
		params.put("offset", offset);
		
		driver.executeScript("mobile:selectPickerWheelValue", params);
	}
	
	public void alertGesture(WebElement element, String action, String buttonLabel)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("element", ((RemoteWebElement)element).getId());
		params.put("action", action);
		params.put("buttonLabel", buttonLabel);
		
		driver.executeScript("mobile:alert", params);
	}
	
	public void twoFingerTapGesture(WebElement element, String action, String buttonLabel)
	{
		//A two-finger-tap is a single tap using two fingers
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("element", ((RemoteWebElement)element).getId());
		
		driver.executeScript("mobile:twoFingerTap", params);
	}
}
