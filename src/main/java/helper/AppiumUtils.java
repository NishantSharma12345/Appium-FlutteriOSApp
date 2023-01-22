package helper;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils 
{
	public AppiumDriverLocalService service;
	
	public AppiumDriverLocalService startAppiumServer(String ipAddress, int port)
	{
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\ASUS\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(ipAddress).usingPort(port).build();
		
		service.start();
		return service;				
	}
	
	public static void waitForElementToBeClickable(AppiumDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForElementToAppear(AppiumDriver driver,WebElement element, String attribute, String value)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains((element), attribute, value));				
	}
	
	public static void waitForElementToVisible(AppiumDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static Dimension getElementSize(WebElement element)
	{
		Dimension elementSize = ((RemoteWebElement)element).getSize();
		return elementSize;
	}
	
	public Dimension getWindowSize(AppiumDriver driver)
	{
		Dimension windowSize = driver.manage().window().getSize();
		return windowSize;
	}
	
	public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException
	{
		File source = driver.getScreenshotAs(OutputType.FILE);
		String currentDate = DateClass.dateFormat();
		String destination = System.getProperty("user.dir")+"\\Screenshots\\"+testCaseName+" "+currentDate+".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}
	
	public static void sleep(int sec) 
	{
	    try
	    {
	    	Thread.sleep(sec*1000);
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
	
	public static boolean retryingFindClick(WebElement element) 
	{
	    boolean result = false;
	    int attempts = 0;
	    while(attempts < 5) 
	    {
	        try 
	        {
	            element.click();
	            result = true;
	            break;
	        } 
	        catch(StaleElementReferenceException e) 
	        {
	        	e.printStackTrace();
	        }
	        sleep(1);
	        attempts++;
	    }
	    return result;
	}
}
