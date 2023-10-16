package com.openMRS.Utilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.openMRS.Constants.Constants;
import com.openMRS.WebDriver_Manager.DriverManager;
import com.openMRS.page_objects.HomePageObj;
import com.openMRS.page_objects.LoginPageObj;
import com.openMRS.page_objects.VisitPageObj;
import com.openMRS.stepDef.Common_Steps;


public class Common_Utilities {
	private static final Logger LOGGER=LogManager.getLogger(Common_Utilities.getInstance());
	private static Common_Utilities CommonUtilitiesInstance=null;
	//private Constructor
	private Common_Utilities() {
	}

	//Singleton Design Pattern
	public static Common_Utilities getInstance() {
		if (CommonUtilitiesInstance == null) {
			CommonUtilitiesInstance = new Common_Utilities();
		}
		return CommonUtilitiesInstance;
	}

	public void loadProperties() {
		Properties properties = new Properties();

		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Constants.URL = properties.getProperty("URL");
		Constants.USERNAME = properties.getProperty("Username");
		Constants.PASSWORD = properties.getProperty("Password");
		Constants.BROWSER = properties.getProperty("Browser");
		Constants.DOCUMENTPATH= properties.getProperty("DocumentPath");
		Constants.DOCUMENTNAME=properties.getProperty("DocuementName");
		Constants.PATIENTDELETEDMASSGE=properties.getProperty("MassageDeletedPatient");
	}
	
	
	 public void initWebelement() {
	  PageFactory.initElements(DriverManager.getDriver(),LoginPageObj.getInstance()); 
	  PageFactory.initElements(DriverManager.getDriver(),HomePageObj.getInstance());
	  PageFactory.initElements(DriverManager.getDriver(),VisitPageObj.getInstance());
	  }
	 
	 public static void referPage() {
		 DriverManager.getDriver().navigate().refresh();
	 }
	
	public void  takeScreenshot() {
		try {
			File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(screenshot, new File(Common_Steps.getScenarioName()+".png"));
			FileUtils.copyFile(screenshot, new File("screenshot.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void highlightElement(WebElement element) {
		try {
			JavascriptExecutor executer = (JavascriptExecutor)DriverManager.getDriver();
			executer.executeScript("arguments[0].setAttribute('style','border: 3px solid blue');", element);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static String currentDate() {
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MMM.yyyy");
			String current = dateFormat.format(date);
			return current;
	}

	public void selectFromDropDown(WebElement dropdown, String howto, String value) {
		Select select = new Select(dropdown);
		switch (howto) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "text":
			select.selectByVisibleText(value);
			break;
		default:
			LOGGER.info("Please provide valid Selection. Valid selection are : Text, Index, Value");
			break;
		}
	}
	
	
	public static void sendDataTextBox(WebElement element,String inputData)
	{
		try {
			waitforWebElement(element);
			if(elementisDisplayed(element))
			{
				JavascriptExecutor j = (JavascriptExecutor) DriverManager.getDriver();
				j.executeScript("arguments[0].value='"+inputData+"'", element);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	public static void clickOnWebelemtn(WebElement element) {
		try {
			waitforWebElement(element);
			if(elementisDisplayed(element))
			{
				JavascriptExecutor j = (JavascriptExecutor) DriverManager.getDriver();
				j.executeScript("arguments[0].click();", element);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static boolean elementisDisplayed(WebElement element) {
		boolean displayed = false;
		try {
			waitforWebElement(element);
			displayed = element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return displayed;
	}
	 
	public static void waitforWebElement(WebElement element) {
		try {
			WebDriverWait wd = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));
			wd.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		
	public static void uploadFie( String path) {
    	
		try {
    		Robot rb = new Robot(); 
    		rb.delay(2000);
    		
    		/*Put path to file in a clipboard */
			StringSelection stringselection = new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.delay(2000);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			rb.delay(2000);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

	
	
}
