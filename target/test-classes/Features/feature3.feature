@VisitPage
Feature: Create visit for regitered patient

  
  Scenario: Create Visit for a patient
    When User click start visit and click confirm button
    And  User click on Attachment and complete the upload process and verify Successful Massage for document upload
    And User redirect to patient page and verify document has Attached 
    Then User verify the recent entry for current date and click End visit
    When User again start vist and click on Capture Vitals menu 
    And User enter the Height '170' & Weight '70' and BMI and click save form and button
    And User click End visit and redirect patient page
    Then User verify given Height and Weight is displayed correctly along with BMI
    Then User Verfiy Recent Visit has one more new entry for current date with Vitals tag
    When User click on Merge Visits, select these two visit and click on Merge Selected Visits button
    When User redirect patient page by click return button 
    When User verify entry with current vitals, Attachment Upload Log
    Then User click Add past visit and verify future date is not clickable date picker
    And User Click redirect patient page and click Delete patient and veriy deleted toasted massge
    And User redirect patient search page and verify deleted patient not avaiale in list 
    
    

