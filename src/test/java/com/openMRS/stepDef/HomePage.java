package com.openMRS.stepDef;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.analysis.function.HarmonicOscillator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.openMRS.Utilities.Common_Utilities;
import com.openMRS.WebDriver_Manager.DriverManager;
import com.openMRS.page_objects.HomePageObj;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage {

	private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

	@Given("User click the Register a patient button")
	public void user_click_the_register_a_patient_button() {
		HomePageObj.getInstance().clickRegisterPatient();
		LOGGER.info(" User clicks the Register button");
	}

	@When("User enter the patient Demographics <Given> ,<FamilyName>,<Gender>,<Day>,<Month>,<Year>,<Address>,<Address1>,<City>,<State>,<Country>,<Postal_Code>,<PhoneNumber>")
	public void user_enter_the_patient_demographics_given_family_name_gender_day_month_year_address_address1_city_state_country_postal_code_phone_number(
			DataTable dataTable) {
		try {
			HomePageObj.getInstance().patientDatiles(dataTable);
			LOGGER.info("Successfully entered the Patient details");
		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	@Then("User  verify the given Name, Gender, Birthdate, Address, Phone number are populated correctly and click confirm")
	public void user_verify_the_given_name_gender_birthdate_address_phone_number_are_populated_correctly_and_click_confirm() {
		try {
			String actualGivenName = HomePageObj.getInstance().getGivenName();
			String actualGender = HomePageObj.getInstance().getGender();
			String actualBirthDate = HomePageObj.getInstance().getBirthDate();
			String actualAddress = HomePageObj.getInstance().getAddress();
			String actualPhonenumber = HomePageObj.getInstance().getPhonenumber();

			String expetedGivenName = "Name: Manoj, Kumar";
			String expetedGender = "Gender: Male";
			String expetedBirthDate = "Birthdate: 5, May, 1990";
			String expetedAddress = "Address: South Street, 1st Main Road, Trichy, TN, India, 621204";
			String expetedPhonenumber = "Phone Number: 8765432180";

			Assert.assertEquals(actualGivenName, expetedGivenName);
			Assert.assertEquals(actualGender, expetedGender);
			Assert.assertEquals(actualBirthDate, expetedBirthDate);
			Assert.assertEquals(actualAddress, expetedAddress);
			Assert.assertEquals(expetedPhonenumber, actualPhonenumber);
			LOGGER.info("Verify patiet details are populated");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Then("User verify Patient details page is redirected and verify the age is calculated correctly based on the date of birth provided")
	public void user_verify_patient_details_page_is_redirected_and_verify_the_age_is_calculated_correctly_based_on_the_date_of_birth_provided() {
		HomePageObj.getInstance().clickCofirmButton();
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int birthYear = Integer.parseInt(HomePageObj.getInstance().getBirthDate().substring(19));
		int expectedAge = currentYear - birthYear;
		int actualAge = Integer.parseInt(HomePageObj.getInstance().getYear().substring(0, 2));
		try {
			Assert.assertEquals(actualAge, expectedAge);
			LOGGER.info("Verify Age based provided birth year");

		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

}
