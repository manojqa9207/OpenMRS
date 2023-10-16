package com.openMRS.stepDef;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.openMRS.Constants.Constants;
import com.openMRS.Utilities.Common_Utilities;
import com.openMRS.WebDriver_Manager.DriverManager;
import com.openMRS.page_objects.LoginPageObj;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Common_Steps {
	
	private static String ScenarioName=null;
	
	public static String getScenarioName() {
		return ScenarioName;
	}


	private static final Logger LOGGER = LogManager.getLogger(Common_Steps.class);
	
	@Before
	public void beforeScenario()
	{
		LOGGER.info("Execution Started");
		try {
			LOGGER.info("Intstantiation CommonUtilies");
			LOGGER.info("Load the Porperties");
			Common_Utilities.getInstance().loadProperties();
			LOGGER.info("Checking the Driver is null or not");
			if (DriverManager.getDriver() == null) {
				LOGGER.info("Driver is Null, Instantiating");
				DriverManager.launch();
				Common_Utilities.getInstance().initWebelement();
				login();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void login() {
		DriverManager.getDriver().get(Constants.URL);
		LoginPageObj.getInstance().enterUsername(Constants.USERNAME);
		LoginPageObj.getInstance().enterPassword(Constants.PASSWORD);
		LoginPageObj.getInstance().clickLocation();;
		LoginPageObj.getInstance().clickLoginButton();	
	}

	
	@AfterStep
	public void takeScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			// If the scenario has failed, capture a screenshot
			try {
				TakesScreenshot screenshot = (TakesScreenshot) DriverManager.getDriver();
				byte[] screenshotBytes = screenshot.getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshotBytes, "image/png", "error_screenshot");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	@After
	public void driverClose() {
		//DriverManager.getDriver().close();
		//DriverManager.getDriver().quit();
	}
	

	
	
	
	
	    
}