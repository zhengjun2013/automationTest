package Test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pageObject.GooglePageObjects;

public class TestNGDemo {
		
		WebDriver driver = null;
		ExtentReports extent;
		ExtentSparkReporter spark;
		
		@BeforeTest
		public void setUp() {
			String projPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", projPath+"/src/test/resources/WebDrivers/chromedriver.exe");
			driver = new ChromeDriver();
			
			extent = new ExtentReports();
	        spark = new ExtentSparkReporter("extentReport.html");
	        extent.attachReporter(spark);
		}
		
		@Test
		public void testRun() {
		
			ExtentTest test3 = extent.createTest("Google Test");
			GooglePageObjects googlePageObject = new GooglePageObjects(driver);
		
			driver.get("http://google.com");
		
			googlePageObject.googleSearchByText("Selenium Automation Test");
		
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
			googlePageObject.googleSearchClick();
			test3.log(Status.INFO, "Testing is complete");
		
		}
		@Test
		public void test1() {
			
			ExtentTest test1 = extent.createTest("TestCase1", "Test Case 1");
			test1.log(Status.PASS, "Test is passed");
			
		}
		
		@Test
		public void test2() {
			ExtentTest test2 = extent.createTest("TestCase2", "Test Case 2");
			test2.log(Status.FAIL, "Test failed");
		}
		
		@AfterTest
		public void tearDown() {
			driver.close();
			driver.quit();
			System.out.println("Automation Test is successfully completed!");
			
			extent.flush();
		}
		
}
