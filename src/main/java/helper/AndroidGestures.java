package helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidGestures 
{
	AndroidDriver driver;
	
	public AndroidGestures(AndroidDriver driver)
	{
		this.driver = driver;
	}
	
	public void longClickGesture(WebElement element, String duration)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)element).getId(),
				"duration", duration				
				));
	}
	
	public void scrollGesture(int left,int top, int width, int height, String direction)
	{
		boolean canScrollMore;
		do 
		{
			canScrollMore = (Boolean)((JavascriptExecutor)driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					"left", left, "top", top, "width", width, "height", height,
					"direction", direction,
					"percent", 3.0 
					));
		}while(canScrollMore);
	}
	
	public void swipeGesture(WebElement element,String direction, double percent)
	{
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)element).getId(),
				"direction", direction,
				"percent", percent,
				"speed", 5 * driver.getDisplayDensity()
				));
	}
	
	public void scrollToText(String text)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
	}
	
	public void clickGesture(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("mobile: clickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId()
			));
	}
	
	public void doubleClickGesture(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId()
			));
	}
	
	public void dragGesture(WebElement element, int endX, int endY)
	{
		((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)element).getId(),
				"endX", endX,
				"endY", endY,
				"speed", 0.5 * driver.getDisplayDensity()

				));
	}
	
	public void flingGesture(WebElement element, String direction, int speed)
	{
		boolean canScrollMore;
		do
		{
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) element).getId(),
				    "direction", direction,
				    "speed", speed
				));
		}while(canScrollMore);
	}
	
	public void pinchOpenGesture(WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "percent", 0.75
			));
	}
	
	public void pinchCloseGesture(WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "percent", 0.75
			));
	}
}
