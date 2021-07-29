package com.thinkbridge.shopbridge;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupPage extends BaseClass {

	@Test

	public void logintest() throws IOException, InterruptedException {

		driver.get(baseurl);

		logger.info("URL Opened");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		SignUp sup = new SignUp(driver);

		
		List<WebElement> allOptions=  sup.ValidateDropDown();
		for (WebElement we : allOptions) 
		{
			System.out.println(we.getText());	
		boolean match = false;
		String[] myData = languages.split(";");
		
		for (int i = 0; i < myData.length; i++) {
			if (we.getText().equals(myData[i].toString())) {
				match = true;
			}
		}
		Assert.assertTrue(match, we.getText());
		}
		sup.setuername(username, org, email);
		logger.info("Username Organisation and Email Entered");
		sup.clicktermsandconditions();
		Thread.sleep(10000);
        logger.info("Terms and condition checkbox checked"); 
		//sup.getstarted();
		logger.info("Get statred button clicked");

	}

}
