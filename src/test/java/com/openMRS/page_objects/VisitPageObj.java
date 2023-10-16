package com.openMRS.page_objects;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.openMRS.Constants.Constants;
import com.openMRS.Utilities.Common_Utilities;
import com.openMRS.WebDriver_Manager.DriverManager;
import com.openMRS.stepDef.Common_Steps;

public class VisitPageObj {

	private static final Logger LOGGER = LogManager.getLogger(VisitPageObj.getInstance());

	private static VisitPageObj VisitPageObjInstance = null;

	// private Constructor
	private VisitPageObj() {
		// PageFactory.initElements(DriverManager.getDriver(), this);
	}

	// Singleton Design Pattern
	public static VisitPageObj getInstance() {
		if (VisitPageObjInstance == null) {
			VisitPageObjInstance = new VisitPageObj();
		}
		return VisitPageObjInstance;
	}

	@FindBy(xpath = "//div[normalize-space()='Start Visit']")
	private WebElement linkStartVisit;

	@FindBy(xpath = "//*[@id=\"referenceapplication.realTime.endVisit\"]/div/div[2]/text()")
	private WebElement linkEndVisit;

	@FindBy(xpath = "(//button[contains(text(),'Yes')])[2]")
	private WebElement buttonYesButton;

	@FindBy(xpath = "(//button[@class=\"confirm right\"])[6]")
	private WebElement buttonConfirm;

	@FindBy(xpath = "//a[@id=\"attachments.attachments.visitActions.default\"]")
	private WebElement linkAttachments;

	@FindBy(id = "visit-documents-dropzone")
	private WebElement buttonVisitDocumentDrop;

	@FindBy(xpath = "//textarea[@ng-model='typedText.fileCaption']")
	private WebElement txtTextArae;

	@FindBy(xpath = "//button[@ng-click=\"uploadFile()\"]")
	private WebElement buttonUploadFile;

	@FindBy(xpath = "//p[contains(text(),'The attachment was successfully uploaded.')]")
	private WebElement toastSuccessfullMassage;

	@FindBy(xpath = "(//a)[6]")
	private WebElement redirectPatientPage;

	@FindBy(xpath = "//div[@ng-hide=\"editMode\"]")
	private WebElement labelTextAttachment;

	@FindBy(xpath = "//a[@class=\"ng-binding\"]")
	private WebElement recentVisitDate;

	@FindBy(xpath = "//a[@id=\"referenceapplication.realTime.vitals\"]")
	private WebElement labelCaptureVitals;

	@FindBy(id = "w8")
	private WebElement txtHeight;

	@FindBy(id = "w10")
	private WebElement txtWeight;

	@FindBy(id = "calculated-bmi")
	private WebElement calculatedBMI;

	@FindBy(id = "save-form")
	private WebElement labelSaveForm;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement buttonSave;

	@FindBy(xpath = "(//a)[20]")
	private WebElement linkEndVisitAgain;

	@FindBy(xpath = "//*[@id=\"weight\"]/span[1]")
	private WebElement valueWeight;

	@FindBy(xpath = "//*[@id=\"height\"]/span[1]")
	private WebElement valueHeight;

	@FindBy(xpath = "//*[@id=\"calculated-bmi\"]")
	private WebElement valueCalculatedBMI;

	@FindBy(xpath = "(//li[@class='ng-scope'])[3]")
	private WebElement recentVisitWithVitals;

	@FindBy(xpath = "//div[contains(text(),'Merge Visits')]")
	private WebElement linkMergeVisits;

	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	private WebElement checkBoxVitals;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	private WebElement checkBoxAttachedUpload;

	@FindBy(id = "mergeVisitsBtn")
	private WebElement buttonMergeVisitsBtn;

	@FindBy(xpath = "//input[@value='Return']")
	private WebElement buttonReturn;

	@FindBy(xpath = "//div[contains(text(),'Add Past Visit')]")
	private WebElement linkAddPastVisit;

	@FindBy(xpath = "(//td[@class='day disabled'])[4]")
	private WebElement futureDate;

	@FindBy(xpath = "//div[contains(text(),'Delete Patient')]")
	private WebElement linkDeletePatient;

	@FindBy(xpath = "//input[@id='delete-reason']")
	private WebElement txtDeleteReason;

	@FindBy(xpath = "(//button[@class='confirm right'])[5]")
	private WebElement buttonDeleteConfirm;

	@FindBy(xpath = "//p[contains(text(),'Patient has been deleted successfully')]")
	private WebElement toastedDeletePatientMassage;

	@FindBy(xpath = "(//button[contains(text(),'Yes')])[5]")
	public WebElement buttonYesEndVisit;

	@FindBy(xpath = "//input[@id='patient-search']")
	private WebElement txtPatientSearch;

	@FindBy(xpath = "(//span)[25]")
	private WebElement labelPatientId;

	@FindBy(tagName = "td")
	private WebElement labelNoRecordFound;

	public void enterPatientID(String patientID) {
		try {
			Common_Utilities.getInstance().highlightElement(txtPatientSearch);
			Common_Utilities.getInstance().sendDataTextBox(txtPatientSearch, patientID);
			LOGGER.info("Click Yes End button ");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public String labelNoRecordFound() {
		return labelNoRecordFound.getText();
	}

	public String patientId() {
		return labelPatientId.getText();
	}

	public String toastedDeletePatientMassage() {
		return toastedDeletePatientMassage.getText();

	}

	public void clickbuttonYesEndVisit() {
		try {
			Common_Utilities.getInstance().highlightElement(buttonYesEndVisit);
			Common_Utilities.getInstance().clickOnWebelemtn(buttonYesEndVisit);
			LOGGER.info("Click Yes End button ");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void clickButtonDeleteConfirm() {
		try {
			Common_Utilities.getInstance().highlightElement(buttonDeleteConfirm);
			Common_Utilities.getInstance().clickOnWebelemtn(buttonDeleteConfirm);
			LOGGER.info("Click cofirm Delete button ");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void enterDeleteReason() {
		try {
			Common_Utilities.getInstance().highlightElement(txtDeleteReason);
			Common_Utilities.getInstance().sendDataTextBox(txtDeleteReason, "Testing");
			LOGGER.info("Delete the patient");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void clickDeletePatient() {
		Common_Utilities.getInstance().highlightElement(linkDeletePatient);
		linkDeletePatient.click();
	}

	public WebElement futureDate() {
		return futureDate;

	}

	public void clickAddPastVisit() {
		Common_Utilities.getInstance().highlightElement(linkAddPastVisit);
		linkAddPastVisit.click();
	}

	public void clickReturnButton() {
		try {
			Common_Utilities.getInstance().highlightElement(buttonReturn);
			Common_Utilities.getInstance().clickOnWebelemtn(buttonReturn);
			LOGGER.info("Click Return button ");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void clickMergeVisitsBtn() {
		try {
			Common_Utilities.getInstance().highlightElement(buttonMergeVisitsBtn);
			Common_Utilities.getInstance().clickOnWebelemtn(buttonMergeVisitsBtn);
			LOGGER.info("Click Merge Visit button ");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void checkBoxVitals() {
		Common_Utilities.getInstance().highlightElement(checkBoxVitals);
		boolean isSelected = checkBoxVitals.isSelected();
		// performing click operation if element is not checked
		if (isSelected == false) {
			checkBoxVitals.click();
		}
	}

	public void checkBoxAttachedUpload() {
		Common_Utilities.getInstance().highlightElement(checkBoxAttachedUpload);
		boolean isSelected = checkBoxAttachedUpload.isSelected();
		// performing click operation if element is not checked
		if (isSelected == false) {
			checkBoxAttachedUpload.click();
		}
	}

	public void clickMergeVisits() {
		try {
			Common_Utilities.getInstance().highlightElement(linkMergeVisits);
			Common_Utilities.getInstance().clickOnWebelemtn(linkMergeVisits);
			LOGGER.info("Click Merge Visits ");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public String valueCalculatedBMI() {
		return valueCalculatedBMI.getText();
	}

	public String valueWeight() {
		return valueWeight.getText();
	}

	public String valueHeight() {
		return valueHeight.getText();
	}

	public String recentVisitWithVitals() {
		return recentVisitWithVitals.getText();
	}

	public void clickEndVisitAgain() {
		try {
			Common_Utilities.getInstance().highlightElement(linkEndVisitAgain);
			Common_Utilities.getInstance().clickOnWebelemtn(linkEndVisitAgain);
			LOGGER.info("Click End Visit Again");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void clickSaveButton() {
		try {
			Common_Utilities.getInstance().highlightElement(buttonSave);
			Common_Utilities.getInstance().clickOnWebelemtn(buttonSave);
			LOGGER.info("Click Save Button");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void clickSaveForm() {
		try {
			Common_Utilities.getInstance().highlightElement(labelSaveForm);
			Common_Utilities.getInstance().clickOnWebelemtn(labelSaveForm);
			LOGGER.info("Click Save form");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public String calculatedBMI() {
		return calculatedBMI.getText();
	}

	public void enterHeight(String height) {
		try {
			Common_Utilities.getInstance().highlightElement(txtHeight);
			Common_Utilities.getInstance().sendDataTextBox(txtHeight, height);
			LOGGER.info("Enter the patient's Height");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void enterWeight(String weight) {
		try {
			Common_Utilities.getInstance().highlightElement(txtWeight);
			Common_Utilities.getInstance().sendDataTextBox(txtWeight, weight);
			LOGGER.info("Enter the patient's Weight");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void clickCaptureVitals() {
		try {
			Common_Utilities.getInstance().highlightElement(labelCaptureVitals);
			Common_Utilities.getInstance().clickOnWebelemtn(labelCaptureVitals);
			LOGGER.info("Click Capture Vitals Label");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public String recentVisitDate() {
		return recentVisitDate.getText();
	}

	public String labelTextAttachment() {
		return labelTextAttachment.getText();
	}

	public void clickYesButton() {
		try {

			Thread.sleep(2000);
			Common_Utilities.getInstance().highlightElement(buttonYesButton);
			Common_Utilities.getInstance().clickOnWebelemtn(buttonYesButton);
			LOGGER.info("Click Yes Button ");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void redirectPatientPage() {
		try {
			Common_Utilities.getInstance().highlightElement(redirectPatientPage);
			Common_Utilities.getInstance().clickOnWebelemtn(redirectPatientPage);
			LOGGER.info("Successfully redirect patient page ");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public String getToastSuccessfullMassge() {
		return toastSuccessfullMassage.getText();
	}

	public void clickEndVisit() {
		try {
			Common_Utilities.getInstance().highlightElement(linkEndVisit);
			Common_Utilities.getInstance().clickOnWebelemtn(linkEndVisit);
			LOGGER.info("Click End Visit Link ");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void clickStartVisit() {
		try {
			Common_Utilities.getInstance().highlightElement(linkStartVisit);
			Common_Utilities.getInstance().clickOnWebelemtn(linkStartVisit);
			LOGGER.info("Click Start Visit Link ");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void clickConfirmButton() {
		try {
			Common_Utilities.getInstance().highlightElement(buttonConfirm);
			Common_Utilities.getInstance().clickOnWebelemtn(buttonConfirm);
			LOGGER.info("Click confirm button ");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void clickAttachments() {
		try {
			Common_Utilities.getInstance().highlightElement(linkAttachments);
			Common_Utilities.getInstance().clickOnWebelemtn(linkAttachments);
			LOGGER.info("Click link Attachments ");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void clickUploadFile(String path) {
		try {
			Common_Utilities.getInstance().highlightElement(buttonVisitDocumentDrop);
			Thread.sleep(2000);
			buttonVisitDocumentDrop.click();
			// Common_Utilities.getInstance().clickOnWebelemtn(buttonVisitDocumentDrop);
			Common_Utilities.getInstance().uploadFie(path);
			Common_Utilities.getInstance().highlightElement(buttonUploadFile);
			Common_Utilities.getInstance().clickOnWebelemtn(buttonUploadFile);
			txtTextArae.sendKeys(Constants.DOCUMENTNAME);
			Common_Utilities.getInstance().clickOnWebelemtn(buttonUploadFile);
			LOGGER.info("Click button upload file");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}
	
	public void keyEventEnterButton() {
		try {
			Robot rb = new Robot();
			rb.delay(2000);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
