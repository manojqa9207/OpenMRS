package com.openMRS.page_objects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.openMRS.Utilities.Common_Utilities;
import com.openMRS.WebDriver_Manager.DriverManager;
import com.openMRS.stepDef.Common_Steps;

public class LoginPageObj {
	private static final Logger LOGGER=LogManager.getLogger(LoginPageObj.getInstance());
	
	private static LoginPageObj LoginPageOblInstance=null;
	//private Constructor
	private LoginPageObj() {
		//PageFactory.initElements(DriverManager.getDriver(), this);
	}

	//Singleton Design Pattern
	public static LoginPageObj getInstance() {
		if (LoginPageOblInstance == null) {
			LoginPageOblInstance = new LoginPageObj();
		}
		return LoginPageOblInstance;
	}
	
	
	 @FindBy(id ="username") private WebElement txtUsername;
	 @FindBy(id="password") private WebElement txtPassword;
	// xpathWemelent="//li[@id='"+Common_Steps.getRandomStringFromList()+"']";
	 @FindBy(xpath = "//li[@id='Inpatient Ward']") private WebElement LOCATION;
	 @FindBy(xpath = "//input[@id='loginButton']") private WebElement
	 LOGIN_BUTTON;
	
	WebDriver driver = DriverManager.getDriver();

//	By txtUsername = By.id("username");
//	By txtPassword = By.id("password");
//	By LOCATION = By.xpath("//li[@id='Inpatient Ward']");
//	By LOGIN_BUTTON = By.xpath("//input[@id='loginButton']");
	
	public void enterUsername(String username) {
		Common_Utilities.getInstance().highlightElement(txtUsername);
		Common_Utilities.getInstance().sendDataTextBox(txtUsername, username);
	}

	public void enterPassword(String password) {
		Common_Utilities.getInstance().highlightElement(txtPassword);
		Common_Utilities.getInstance().sendDataTextBox(txtPassword, password);
	}

	public void clickLocation() {
		Common_Utilities.getInstance().highlightElement(LOCATION);
		Common_Utilities.getInstance().clickOnWebelemtn(LOCATION);
	}

	public void clickLoginButton() {
		Common_Utilities.getInstance().highlightElement(LOGIN_BUTTON);
		Common_Utilities.getInstance().clickOnWebelemtn(LOGIN_BUTTON);
	}

}
