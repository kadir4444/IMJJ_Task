@PurcahseSmokeTest
Feature: Purchase Journey
  
  @PurcahseSmokeTest_Case_1
  Scenario: E2E Customer Purchase journey
    Given user is on the homepage
    When user clicks on blouse label
    And user inputs "2" into quantity textfield
    And user clicks on increase quantity button
    And user clicks on decrease quantity button
    And user selects 'M' on size dropdown
    And user selects White on the colour icon
    And user selects Black on the colour icon
    And user selects on Add to cart button
    And user selects Proceed to checkout button
    And user enters Process to checkout button
    And user inputs 'Hello 12344354 !"£$£%^^&*' into comment textarea
    And user enters Process to checkout button
    And user select true on radio button on Terms and Conditions checkbox
    And user enters Process to checkout button
    And user clicks on Pay by bank wire button
    And user clicks on I confirm my order button
    Then user sees 'ORDER CONFIRMATION' heading
    And user sees 'Amount $56.00' text
    
    #Was going to add another testcase to verify in Order details screen but was hampered due to time constraint as personal issues (Wedding planning)
    