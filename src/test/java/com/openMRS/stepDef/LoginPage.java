package com.openMRS.stepDef;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.openMRS.WebDriver_Manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage {

	private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);

	@Given("User launch the OpenMHR URL")
	public void user_launch_the_open_mhr_url() {

		LOGGER.info("User launch the OpenMHR URL");

	}

	@When("User enter the valid credentials and click any location")
	public void user_enter_the_valid_credentials_and_click_any_location() {

		LOGGER.info("User enter the valid credentials and click any location");

	}

	@Then("User click the Login button and verify the HomePage")
	public void user_click_the_login_button_and_verify_the_home_page() {
		LOGGER.info("User clicks the login button");

		String pageTitle = DriverManager.getDriver().getTitle();
		String expectedTitle = "Home";
		Assert.assertEquals("Page title doesn't match.", expectedTitle, pageTitle);
		LOGGER.info("User successfully logged in and HomePage verified");

	}
}
