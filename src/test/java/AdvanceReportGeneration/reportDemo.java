package AdvanceReportGeneration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class reportDemo {
	ExtentReports report;
	
	@BeforeTest
	public void configDetails()
	{
//		ExtentReports, ExtentSparkReporter are the classes which are responsible for report generation.
//		We have to give the path for new folder in the project to create within the project with .html file
		String path=System.getProperty("user.dir")+"\\reports\\report.html";
//		we have to send the path as an argument for ExtentSparkReporter object so that it creates a file
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
//		using this reference variable(object=reporter) we can set the reportname & docTitle
		reporter.config().setReportName("Project Report");
		reporter.config().setDocumentTitle("Test Results");
		
		 report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Vishal");
		
	}
	@Test
	public void sampleTest()
	{
		
		report.createTest("sampleTest");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
//		After the text completion we may have to close the report object otherwise still it will be in report generation mode
		report.flush();
		
	}
}
