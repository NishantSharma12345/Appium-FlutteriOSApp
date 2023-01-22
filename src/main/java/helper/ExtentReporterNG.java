package helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG 
{
	public static ExtentReports extent;

	public static ExtentReports getReporterObject()
	{
		String path = System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Appium Flutter App Automation Results");
		reporter.config().setDocumentTitle("Appium Flutter App Test Results");
		reporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Nishant Sharma");
		extent.setSystemInfo("Project Name", "Flutter Android App Testing");
		extent.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		extent.setSystemInfo("User Location", System.getProperty("user.country"));
		extent.setSystemInfo("OS Version", System.getProperty("os.version"));
		extent.setSystemInfo("Jave Version", System.getProperty("java.version"));
		return extent;
	}
}
