package com.openMRS.page_objects;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.openMRS.Utilities.Common_Utilities;
import com.openMRS.WebDriver_Manager.DriverManager;

import io.cucumber.datatable.DataTable;

public class HomePageObj {

	private static final Logger LOGGER = LogManager.getLogger(HomePageObj.getInstance());

	private static HomePageObj HomePageObjInstance = null;

	// private Constructor
	private HomePageObj() {
		// PageFactory.initElements(DriverManager.getDriver(), this);
	}

	// Singleton Design Pattern
	public static HomePageObj getInstance() {
		if (HomePageObjInstance == null) {
			HomePageObjInstance = new HomePageObj();
		}
		return HomePageObjInstance;
	}

	@FindBy(xpath = "//a[normalize-space()='Register a patient']")
	private WebElement buttonResigterPatient;

	@FindBy(xpath = "//input[@name='givenName']")
	private WebElement txtGivenName;

	@FindBy(xpath = "//input[@name='familyName']")
	private WebElement txtFamilyName;

	@FindBy(id = "next-button")
	private WebElement button_NextButton;

	@FindBy(id = "gender-field")
	private WebElement selectGender;

	@FindBy(id = "birthdateDay-field")
	private WebElement txtDay;

	@FindBy(xpath = "//select[@id='birthdateMonth-field']")
	private WebElement selectMonth;

	@FindBy(id = "birthdateYear-field")
	private WebElement txtYear;

	@FindBy(id = "address1")
	private WebElement txtAddress1;

	@FindBy(id = "address2")
	private WebElement txtAddress2;

	@FindBy(id = "cityVillage")
	private WebElement txtCityVillage;

	@FindBy(id = "stateProvince")
	private WebElement txtStateProvince;

	@FindBy(id = "country")
	private WebElement txtCountry;

	@FindBy(id = "postalCode")
	private WebElement txtPostalCode;

	@FindBy(name = "phoneNumber")
	private WebElement txtPhoneNumber;

	@FindBy(id = "submit")
	private WebElement buttonConfirm;
	
	
	/*
	 * For Assertion
	 * 
	 */
	@FindBy(xpath ="(//div[@id='dataCanvas']//p)[1]")
	private WebElement getGivenName;
	
	@FindBy(xpath ="(//div[@id='dataCanvas']//p)[2]")
	private WebElement getGender;
	
	@FindBy(xpath ="(//div[@id='dataCanvas']//p)[3]")
	private WebElement getBirthDate;
	
	@FindBy(xpath ="(//div[@id='dataCanvas']//p)[4]")
	private WebElement getAddress;
	
	@FindBy(xpath ="(//div[@id='dataCanvas']//p)[5]")
	private WebElement getPhonenumber;

	public String getGivenName() {
		return getGivenName.getText();	
	}
	public String getGender() {
		return getGender.getText();	
	}
	public String getBirthDate() {
		return getBirthDate.getText();	
	}
	public String getAddress() {
		return getAddress.getText();	
	}
	public String getPhonenumber() {
		return getPhonenumber.getText();	
	}

	@FindBy(xpath = "(//div[@class='gender-age col-auto']/span)[2]")
	private WebElement getYear;
	
	public String getYear() {
		return getYear.getText();	
	}
	
	
	public void clickRegisterPatient() {
		try {
			Common_Utilities.getInstance().highlightElement(buttonResigterPatient);
			Common_Utilities.getInstance().clickOnWebelemtn(buttonResigterPatient);
			LOGGER.info("Click Registeation button ");
		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	public void enterPatientName(String givenName, String familyName) {
		try {
			Common_Utilities.getInstance().highlightElement(txtGivenName);
			Common_Utilities.getInstance().sendDataTextBox(txtGivenName, givenName);
			Common_Utilities.getInstance().highlightElement(txtFamilyName);
			Common_Utilities.getInstance().sendDataTextBox(txtFamilyName, familyName);
			LOGGER.info("Enter the patient's Name ");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void clickNextButton() {
		try {
			Common_Utilities.getInstance().highlightElement(button_NextButton);
			Common_Utilities.getInstance().clickOnWebelemtn(button_NextButton);
			LOGGER.info("Enter the patient's Name ");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}
	
	public void clickCofirmButton() {
		try {
			Common_Utilities.getInstance().highlightElement(buttonConfirm);
			Common_Utilities.getInstance().clickOnWebelemtn(buttonConfirm);
			LOGGER.info("Click the Confirm Button ");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void selectGender(String value) {
		try {
			Common_Utilities.getInstance().highlightElement(selectGender);
			Common_Utilities.getInstance().selectFromDropDown(selectGender, "text", value);
			LOGGER.info("Select the patient's gender");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void selectBirthDay(String day, String select_Month, String year) {
		try {
			Common_Utilities.getInstance().highlightElement(txtDay);
			Common_Utilities.getInstance().sendDataTextBox(txtDay, day);
			Common_Utilities.getInstance().highlightElement(selectMonth);
			Common_Utilities.getInstance().selectFromDropDown(selectMonth, "text", select_Month);
			Common_Utilities.getInstance().highlightElement(txtYear);
			Common_Utilities.getInstance().sendDataTextBox(txtYear, year);
			LOGGER.info("Select the patient's Birth Day");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void enterPatientAddress(String address1,String address2, String cityVillage, String state, String country, String postalCode ) {
		try {
			Common_Utilities.getInstance().highlightElement(txtAddress1);
			Common_Utilities.getInstance().sendDataTextBox(txtAddress1, address1);
			Common_Utilities.getInstance().highlightElement(txtAddress2);
			Common_Utilities.getInstance().sendDataTextBox(txtAddress2, address2);
			Common_Utilities.getInstance().highlightElement(txtCityVillage);
			Common_Utilities.getInstance().sendDataTextBox(txtCityVillage, cityVillage);
			Common_Utilities.getInstance().highlightElement(txtStateProvince);
			Common_Utilities.getInstance().sendDataTextBox(txtStateProvince, state);
			Common_Utilities.getInstance().highlightElement(txtCountry);
			Common_Utilities.getInstance().sendDataTextBox(txtCountry, country);
			Common_Utilities.getInstance().highlightElement(txtPostalCode);
			Common_Utilities.getInstance().sendDataTextBox(txtPostalCode, postalCode);
			LOGGER.info("Entet the patient's Address");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}	

	public void enterPhoneNumber(String phoneNumber) {

		try {
			Common_Utilities.getInstance().highlightElement(txtPhoneNumber);
			Common_Utilities.getInstance().sendDataTextBox(txtPhoneNumber, phoneNumber);
			LOGGER.info("Entet the patient's Phone Number");
		} catch (Exception e) {
			LOGGER.error(e);
		}

	}
	 int actuatYear;
		public static void patientDatiles(DataTable dataTable)
		{
			try {
			List<Map<String, String>> data = dataTable.asMaps();

			for (Map<String, String> row : data) {
				HomePageObj.getInstance().enterPatientName(row.get("Given"), row.get("FamilyName"));
				HomePageObj.getInstance().clickNextButton();
				HomePageObj.getInstance().selectGender(row.get("Gender"));
				HomePageObj.getInstance().clickNextButton();
				HomePageObj.getInstance().selectBirthDay(row.get("Day"), row.get("Month"), row.get("Year"));
				//actuatYear = Integer.parseInt(row.get("Year"));
				HomePageObj.getInstance().clickNextButton();
				HomePageObj.getInstance().enterPatientAddress(row.get("Address"), row.get("Address1"), row.get("City"), row.get("State"), row.get("Country"), row.get("Postal_Code"));
				HomePageObj.getInstance().clickNextButton();
				HomePageObj.getInstance().enterPhoneNumber(row.get("PhoneNumber"));
				HomePageObj.getInstance().clickNextButton();
				HomePageObj.getInstance().clickNextButton();
			}	
			
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
}
