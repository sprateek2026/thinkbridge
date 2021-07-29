package com.thinkbridge.shopbridge;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SignUp {

	@FindBy(id = "name")
	private WebElement fullname;

	@FindBy(id = "orgName")
	private WebElement orgname;

	@FindBy(id = "singUpEmail")
	private WebElement email;

	@FindBy(xpath = "//*[contains(@type,'submit')]")
	private WebElement sumbit;

	@FindBy(xpath = "//span[contains(text(),'I agree to the')]")
	private WebElement checkbox;

	@FindBy(xpath = "//div[@id='language']/div/span/span/span")
	private WebElement dropdown;

	@FindBy(xpath = "//li[@id='ui-select-choices-1']/div/a/div[contains(text(),'')]")
	private List<WebElement> dropdownlist;

	WebDriver driver;

	public SignUp(WebDriver driver)

	{

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> ValidateDropDown() {

		dropdown.click();
		return dropdownlist ;
		
		/*
		 * String[] exp = { "English", "Dutch" };
		 * 
		 * 
		 * List<WebElement> allOptions= dropdownlist;
		 * 
		 * System.out.println(allOptions.size()); for (WebElement we : allOptions) {
		 * System.out.println(we.getText()); boolean match = false; for (int i = 0; i <
		 * exp.length; i++) { if (we.getText().equals(exp[i])) { match = true; } }
		 * 
		 * Assert.assertTrue(match, we.getText()); }
		 */
		
		
	}

	public void setuername(String username, String orgnisation, String mail) {
		fullname.sendKeys(username);
		orgname.sendKeys(orgnisation);
		email.sendKeys(mail);
		return;
	}

	public void clicktermsandconditions() {
		checkbox.click();

	}

	public void getstarted() {
		sumbit.click();
		// return new HomePage(driver);
	}

}
