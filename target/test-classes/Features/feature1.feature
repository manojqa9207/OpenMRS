
 @LoginPage
Feature: Open the OpenMHR URL 
			Enter the with valid credtial and verify HomePage

  Scenario: Login into OpenMHR and verify the Homepage
    Given User launch the OpenMHR URL
    When User enter the valid credentials and click any location
    Then User click the Login button and verify the HomePage
    

  