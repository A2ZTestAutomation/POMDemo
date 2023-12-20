package testScripts;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import base.TestBase;



public class Hooks {
	
	@BeforeSuite
	public static void setupDriver() {
		
		 TestBase.initDriver();
	}

	
	@AfterSuite
	public  void tearDown() {
		
		TestBase.tearDown();
	}
}
