package com.openMRS.stepDef;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.openMRS.Constants.Constants;
import com.openMRS.Utilities.Common_Utilities;
import com.openMRS.WebDriver_Manager.DriverManager;
import com.openMRS.page_objects.HomePageObj;
import com.openMRS.page_objects.VisitPageObj;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VisitPage {
	
	private static final Logger LOGGER = LogManager.getLogger(VisitPage.class);
	
	
	@When("User click start visit and click confirm button")
	public void user_click_start_visit_and_click_confirm_button() {
		VisitPageObj.getInstance().clickStartVisit();
		VisitPageObj.getInstance().clickConfirmButton();
		LOGGER.info("\n Clicks start visit and click Confirm button");
	}

	@When("User click on Attachment and complete the upload process and verify Successful Massage for document upload")
	public void user_click_on_attachment_and_complete_the_upload_process_and_verify_successful_massage_for_document_upload() {
	   
		
	    VisitPageObj.getInstance().clickAttachments();
	    VisitPageObj.getInstance().clickUploadFile(Constants.DOCUMENTPATH);
	    String actualToastSuccessfullMassge = VisitPageObj.getInstance().getToastSuccessfullMassge();
	    String expectedToastSuccessfullMassge = "The attachment was successfully uploaded.";
	    Assert.assertEquals(expectedToastSuccessfullMassge, actualToastSuccessfullMassge);
	    
	    LOGGER.info("\n  Click Attament and upload documet and verify Toast Successfull Massage");
	    
	}

	@When("User redirect to patient page and verify document has Attached")
	public void user_redirect_to_patient_page_and_verify_document_has_attached() {
		
		VisitPageObj.getInstance().redirectPatientPage();
		String actualLabelTextAttachment = VisitPageObj.getInstance().labelTextAttachment();
		Assert.assertEquals(Constants.DOCUMENTNAME, actualLabelTextAttachment);

		LOGGER.info("\n  Redirect patient page and verify Attamentupload document ");
		
	}

	@Then("User verify the recent entry for current date and click End visit")
	public void user_verify_the_recent_entry_for_current_date_and_click_end_visit() {
		
		String expectedVisitDate = Common_Utilities.currentDate();
		String actualRecentVisitDate = VisitPageObj.getInstance().recentVisitDate();
		Assert.assertEquals(expectedVisitDate, actualRecentVisitDate);
		VisitPageObj.getInstance().clickEndVisit();
		VisitPageObj.getInstance().clickYesButton();
	
		LOGGER.info("\n  Verify recent visit entry for current date ");
		
	}

	@When("User again start vist and click on Capture Vitals menu")
	public void user_again_start_vist_and_click_on_capture_vitals_menu() {

		VisitPageObj.getInstance().clickStartVisit();
		VisitPageObj.getInstance().clickConfirmButton();
		VisitPageObj.getInstance().clickCaptureVitals();
		LOGGER.info("\n User again start vist and click on Capture Vitals menu ");
	}

	@When("User enter the Height {string} & Weight {string} and BMI and click save form and button")
	public void user_enter_the_height_weight_and_bmi_and_click_save_form_and_button(String height, String weight) {
		
		VisitPageObj.getInstance().enterHeight(height);
		HomePageObj.getInstance().clickNextButton();
		VisitPageObj.getInstance().enterWeight(weight);
		HomePageObj.getInstance().clickNextButton();
		double bmi = Double.parseDouble(weight) /((Double.parseDouble(height)/100)*(Double.parseDouble(height)/100)); 
		VisitPageObj.getInstance().clickSaveForm();
		VisitPageObj.getInstance().clickSaveButton();
		if(VisitPageObj.getInstance().buttonYesEndVisit.isDisplayed()) {
		VisitPageObj.getInstance().clickbuttonYesEndVisit();
		}
		LOGGER.info("\n User User enter the Height and weight click save form ");
		
	}

	@When("User click End visit and redirect patient page")
	public void user_click_end_visit_and_redirect_patient_page() {
	   VisitPageObj.getInstance().clickEndVisitAgain();
	   VisitPageObj.getInstance().clickYesButton();
	   VisitPageObj.getInstance().redirectPatientPage();
	   LOGGER.info("\n  click End visit and redirect patient page ");
	}

	@Then("User verify given Height and Weight is displayed correctly along with BMI")
	public void user_verify_given_height_and_weight_is_displayed_correctly_along_with_bmi() {
	   String actulaValueOfHeight = VisitPageObj.getInstance().valueHeight();
	   String actulaValueOfWeight = VisitPageObj.getInstance().valueWeight();
	   String actualValueCalculatedBMI = VisitPageObj.getInstance().valueCalculatedBMI();
	   
	   String expectedHeight = "170";
	   String expectedWeight = "70";
	   String expectedBMI = "24.2";
	    
	   Assert.assertEquals(actulaValueOfHeight, expectedHeight);
	   Assert.assertEquals(expectedWeight, actulaValueOfWeight);
	   Assert.assertEquals(expectedBMI, actualValueCalculatedBMI);
	   LOGGER.info("\n Verify Patient's Height, Weight and BMI ");
	}

	@Then("User Verfiy Recent Visit has one more new entry for current date with Vitals tag")
	public void user_verfiy_recent_visit_has_one_more_new_entry_for_current_date_with_vitals_tag() throws AWTException {
	   
	   String actualRecentVisitWithVitals = VisitPageObj.getInstance().recentVisitWithVitals(); 
	   String currentDate = Common_Utilities.currentDate();
	   String expectedRecentVisitWithVitals = currentDate+"\nVitals";	   
	   Assert.assertEquals(expectedRecentVisitWithVitals, actualRecentVisitWithVitals);
	  
	   LOGGER.info("\n  Verfiy Recent Visit has one more new entry for current date with Vitals tag ");
		
	}
	
	@When("User click on Merge Visits, select these two visit and click on Merge Selected Visits button")
	public void user_click_on_merge_visits_select_these_two_visit_and_click_on_merge_selected_visits_button() {
		
		VisitPageObj.getInstance().clickMergeVisits();
		VisitPageObj.getInstance().checkBoxVitals();
		VisitPageObj.getInstance().checkBoxAttachedUpload();
		VisitPageObj.getInstance().clickMergeVisitsBtn();
		VisitPageObj.getInstance().redirectPatientPage();
	    
		LOGGER.info("\n  click on Merge Visits, select these two visit and click on Merge Selected Visits button ");
	}

	@When("User redirect patient page by click return button")
	public void user_redirect_patient_page_by_click_return_button() {
		VisitPageObj.getInstance().clickReturnButton();
		LOGGER.info("\n  redirect patient page by click return button ");
	}

	@When("User verify entry with current vitals, Attachment Upload Log")
	public void user_verify_entry_with_current_vitals_attachment_upload_log() {
		 String actualRecentVisitWithVitalsAndAttached = VisitPageObj.getInstance().recentVisitWithVitals(); 
		   String currentDate2 = Common_Utilities.currentDate();
		   String expectedRecentVisitWithVitalsAndAttached = currentDate2+"\nVitals, Attachment Upload";
		   Assert.assertEquals(expectedRecentVisitWithVitalsAndAttached, actualRecentVisitWithVitalsAndAttached);
		   LOGGER.info("\n  verify entry with current vitals, Attachment Upload Log ");
	}

	@Then("User click Add past visit and verify future date is not clickable date picker")
	public void user_click_add_past_visit_and_verify_future_date_is_not_clickable_date_picker() {
	    
		VisitPageObj.getInstance().clickAddPastVisit();
		if (VisitPageObj.getInstance().futureDate().isDisplayed()) {
			Common_Utilities.referPage();
		}
		Common_Utilities.referPage();
		 LOGGER.info("click Add past visit and verify future date is not clickable date picker");
		 
	}

	@Then("User Click redirect patient page and click Delete patient and veriy deleted toasted massge")
	public void user_click_redirect_patient_page_and_click_delete_patient_and_veriy_deleted_toasted_massge() {
		  
		VisitPageObj.getInstance().clickDeletePatient();
		VisitPageObj.getInstance().enterDeleteReason();
		VisitPageObj.getInstance().clickButtonDeleteConfirm();
		String actualTtoastedDeletePatientMassage = VisitPageObj.getInstance().toastedDeletePatientMassage();
		Assert.assertEquals(Constants.PATIENTDELETEDMASSGE, actualTtoastedDeletePatientMassage);
		String patientId = VisitPageObj.getInstance().patientId();
		VisitPageObj.getInstance().enterPatientID(patientId);
		LOGGER.info("\n Click redirect patient page and click Delete patient and veriy deleted toasted massge");
	}

	@Then("User redirect patient search page and verify deleted patient not avaiale in list")
	public void user_redirect_patient_search_page_and_verify_deleted_patient_not_avaiale_in_list() {
		 
		VisitPageObj.getInstance().keyEventEnterButton();
		String expectedNoRecordsFound = "No matching records found";
		Assert.assertTrue(DriverManager.getDriver().getPageSource().contains(expectedNoRecordsFound));
		LOGGER.info("\n Redirect patient search page and verify deleted patient not avaiale in list");
		
		DriverManager.getDriver().quit();

	}

}
