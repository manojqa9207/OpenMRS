package com.openMRS.WebDriver_Manager;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.openMRS.Constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private static WebDriver driver = null;

	private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);

	public static void launch() {
		try {
			switch (Constants.BROWSER) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				LOGGER.info("Intiating Chrome Dirver");
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				LOGGER.info("Intiating Firfox Dirver");
				driver = new FirefoxDriver();
				break;

			case "edge":
				WebDriverManager.edgedriver().setup();
				LOGGER.info("Intiating Edge Dirver");
				driver = new EdgeDriver();
				break;
			default:
				WebDriverManager.chromedriver().setup();
				LOGGER.info("Intiating Chrome Dirver");
				driver = new ChromeDriver();
				break;
			}
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			DriverManager.getDriver().manage().deleteAllCookies();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
