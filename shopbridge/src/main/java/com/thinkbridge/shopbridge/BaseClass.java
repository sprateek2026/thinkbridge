package com.thinkbridge.shopbridge;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig rc = new ReadConfig();

	public String baseurl = rc.getapplicationurl();
	public String username = rc.getusername();
	public String email = rc.getemail();
	public String org = rc.getorg();
	public String languages = rc.getlanguage();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browsername")
	@BeforeClass
	public void setup(String browser) {

		logger = Logger.getLogger("shopbridge");
		PropertyConfigurator.configure("log4j.properties");
		if (browser.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("ie")) {

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}


	}
	
	public void capturescreenshot(WebDriver driver,String tname) throws IOException {
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png"));	
		System.out.println("Screenshot captured");
	}

	@AfterClass
	public void teardown() {
	
		driver.quit();
	}

}
