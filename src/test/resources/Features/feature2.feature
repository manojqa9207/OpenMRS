@RegisterPage
Feature: Patient Register
  User enter the patient register page and enter the patient details

  Scenario Outline: Patient registed with valid data
    Given User click the Register a patient button
    When User enter the patient Demographics <Given> ,<FamilyName>,<Gender>,<Day>,<Month>,<Year>,<Address>,<Address1>,<City>,<State>,<Country>,<Postal_Code>,<PhoneNumber>
      | Given | FamilyName | Gender | Day | Month | Year | Address      | Address1      | City   | State | Country | Postal_Code | PhoneNumber |
      | Manoj | Kumar      | Male   |   5 | May   | 1990 | South Street | 1st Main Road | Trichy | TN    | India   |      621204 |  8765432180 |
    Then User  verify the given Name, Gender, Birthdate, Address, Phone number are populated correctly and click confirm
    Then User verify Patient details page is redirected and verify the age is calculated correctly based on the date of birth provided
