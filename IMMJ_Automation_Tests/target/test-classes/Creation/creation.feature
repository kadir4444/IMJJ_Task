@AccCreateSmokeTest
Feature: Account Creation
  
  @AccCreateSmokeTest_Case_1
  Scenario: E2E Customer Account Creation journey
    Given user is on the homepage
    When user clicks on Sign in button
    And user enters "mak4444@dress.co.uk" into email addess textfield
    And user clicks on 'Create an account' button
    And user selects 'Mr' radio button
    And user enters 'Mohammed Abdul' into first name textfield
    And user enters 'Kadir' into last name textfield
    And user enters 'mak4444@dress.co.uk' into email address textfield
    And user enters 'mak4444' into password textfield
    And user selects '29' on day dropdown
    And user selects 'September' on month dropdown
    And user selects '2000' on year dropdown
    And user selects 'true' on Sign up for our newsletter! check box
    And user selects 'true' on Receive special offers from our partners! check box
    And user enters 'Mohammed Abdul' into first name textfield
    And user enters 'Kadir' into last name textfield
    And user enters 'Greenfield Community College' into company textfield
    And user enters 'Greenfield Community College' into Address textfield
    And user enters 'Shipgate Street' into Address Line2 textfield
    And user enters 'Denver' into City textfield
    And user selects 'Colorado' into State textfield
    And user enters '80201' into Zip/Postal Code textfield
    And user selects 'United States' on Country dropdown
    And user enters 'Additional information' into additional information textarea
    And user enters '02085501101' into Homephone textfield
    And user enters '07412369554' into mobilephone textfield
    And user enters 'My address' into Assign an address alias for future reference textfield
    Then user sees 'MY ACCOUNT' heading
    And user sees sign out button
    And user sees 'Welcome to your account. Here you can manage all of your personal information and orders.' text
    And user sees Order History and details button
    And user sees My Credit Slips button
    And user sees My Addresses button
    And user sees My Personal Information button
    And user sees My Wishlists button
