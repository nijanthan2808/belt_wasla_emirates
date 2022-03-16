@wasla
Feature: WRE Left Luggage

  #TC_LEFTLUGG_004
  #ATC_LEFTLUGG_001
  @TestRailId(id=) @JiraStoryId(WBRE-148) @automation
  Scenario: Left Luggage - Passenger should be able to clear the signature
    Given the user has logged into the WASLA application
    And user has selected the left luggage location
    And User has access to the Left Luggage Feature
    And left Luggage record already exists in WASLA Desktop
    And the user has launched the Deposit feature from the Left Luggage feature page
    And the user is attempting to scan or manually enter or select a receipt number from the available list
    When the user selects the receipt number
    Then the system will display the single receipt number
    And allow the user to select the receipt for which bag needs to accepted for depositing
    And system will display the signature screen where the passenger can sign to accept the terms and conditions
    And the passenger should be able to clear the signature

  #TC_LEFTLUGG_003
  #ATC_LEFTLUGG_002
  @TestRailId(id=) @JiraStoryId(WBRE-148) @automation
  Scenario: Left Luggage - Depositing bag with single receipt number
    Given the user has logged into the WASLA application
    And user has selected the left luggage location
    And User has access to the Left Luggage Feature
    And left Luggage record already exists in WASLA Desktop
    And the user has launched the Deposit feature from the Left Luggage feature page
    And the user is attempting to scan or manually enter or select a receipt number from the available list
    When the user selects the receipt number
    Then the system will display the single receipt number
    And allow the user to select the receipt for which bag needs to accepted for depositing
    And system will display the signature screen where the passenger can sign to accept the terms and conditions
    And system will successfully save the signature when Submitting this information

  #TC_LEFTLUGG_005
  #ATC_LEFTLUGG_003
  @TestRailId(id=) @JiraStoryId(WBRE-148) @automation
  Scenario: Left Luggage - Depositing bags with no receipt found and receipts found with closed status
    Given the user has logged into the WASLA application
    And user has selected the left luggage location
    And User has access to the Left Luggage Feature
    And left Luggage record already exists in WASLA Desktop
    And the user has launched the Deposit feature from the Left Luggage feature page
    When the user is attempting to scan or manually enter a invalid receipt number
    And if there are no receipts found or if the receipts are found but the status is closed
    Then the system will display No Open Left Luggage Records found

  #TC_LEFTLUGG_009
  #ATC_LEFTLUGG_009
    @TestRailId(id=) @JiraStoryId(WBRE-149) @automation
   Scenario: Left Luggage - Bag racking with multiple Storage IDs
  Given the user has logged into the WASLA application
  	And user has selected the left luggage location
  And User has access to the Left Luggage Feature
  And the bag has already been deposited
  And left Luggage record already exists in WASLA Desktop
  When the user has launched the racking feature from the Left Luggage feature page
  And user scans or enters or selects the rack number from the list
  And the user is scanning or manually entering the left luggage tag number for racking
  And submit for racking
  Then system will display racking status against each bag tag with the below details Racking Done Successfully.Total Bags : 3 Bags to Rack : 2" along with the count of the bags that are yet to be racked
  
  #TC_LEFTLUGG_010
  #ATC_LEFTLUGG_010
    @TestRailId(id=) @JiraStoryId(WBRE-149) @automation
   Scenario: Left Luggage - Bag racking with multiple Storage IDs - All bags racked
    Given the user has logged into the WASLA application
   And user has selected the left luggage location
  And User has access to the Left Luggage Feature
  And the bag has already been deposited
  And left Luggage record already exists in WASLA Desktop
  When the user has launched the racking feature from the Left Luggage feature page
  And the user is scanning or manually entering all the left luggage tag number for racking
  And submit for racking
  Then System will display racking status against each bag tag with the below details All Bags racked.Total Bags : 3. Bags to Rack : 0"
  
  #TC_LEFTLUGG_013
  #ATC_LEFTLUGG_013
    @TestRailId(id=) @JiraStoryId(WBRE-149) @automation
   Scenario: Left Luggage - Racking when left luggage tag format is valid or the storage ID status is closed
    Given the user has logged into the WASLA application
   And user has selected the left luggage location
  And User has access to the Left Luggage Feature
  And the bag has already been deposited
  When the user has launched the racking feature from the Left Luggage feature page
  And user scans or enters or selects the rack number from the list
  And the user is scanning or manually entering the invalid left luggage tag number
  And submit for racking
  Then the system will throw error message as Invalid storage tag ID - Racking transaction failed
 
 
  #TC_LEFTLUGG_015
  #ATC_LEFTLUGG_015
      @TestRailId(id=) @JiraStoryId(WBRE-150) @automation
  Scenario: Left Luggage - Launching bag collection
    Given the user has logged into the WASLA application
    And user has selected the left luggage location
    And left Luggage record already exists in WASLA Desktop
    And user has access to left luggage Function
    And Left luggage should be deposited & racked
    And Collect charges has been initiated in the desktop
    When the user is attempting to launch collection feature
    Then the system will display all the receipts which are ready for collection with the indication of the tag has been scanned or not
    And the details displayed are - all Receipt number, Total number of bags, Bags Scanned

      #TC_LEFTLUGG_016
  #ATC_LEFTLUGG_016
  @TestRailId(id=) @JiraStoryId(WBRE-150) @automation
  Scenario: Left Luggage - Scanning a valid tag
    Given the user has logged into the WASLA application
    And user has selected the left luggage location
    And left Luggage record already exists in WASLA Desktop
    And user has access to left luggage Function
    And Left luggage should be deposited & racked
    And Collect charges has been initiated in the desktop
    And the user is attempting to launch collection feature
    And user scanned and selected the LL receipt number
    When the user scans the tag that belongs to the selected receipt
    Then the system will mark the corresponding LL tag as scanned

      #TC_LEFTLUGG_017
  #ATC_LEFTLUGG_017
  @TestRailId(id=) @JiraStoryId(WBRE-150) @automation
  Scenario: Left Luggage - Scanning a incorrect tag
    Given the user has logged into the WASLA application
    And user has selected the left luggage location
    And left Luggage record already exists in WASLA Desktop
    And user has access to left luggage Function
    And Left luggage should be deposited & racked
    And Collect charges has been initiated in the desktop
    And the user is attempting to launch collection feature
    And user scanned and selected the LL receipt number
    When the user scans the tag that doesnot belongs to the selected receipt
    Then the system will display an error Please enter the storage tag belonging to ref nbr nnnnnn

    
      #TC_LEFTLUGG_018
  #ATC_LEFTLUGG_018
  @TestRailId(id=) @JiraStoryId(WBRE-150) @automation
  Scenario: Left Luggage - Scanning a already scanned tag
   Given the user has logged into the WASLA application
    And user has selected the left luggage location
    And left Luggage record already exists in WASLA Desktop
    And user has access to left luggage Function
    And Left luggage should be deposited & racked
    And Collect charges has been initiated in the desktop
    And the user is attempting to launch collection feature
    And user scanned and selected the LL receipt number
    When the user scans the tag that already scanned
    Then the system will display an error Storage tag is already scanned

      #TC_LEFTLUGG_019
  #ATC_LEFTLUGG_019
  @TestRailId(id=) @JiraStoryId(WBRE-150) @automation
  Scenario: Left Luggage - Enabling signature capture
    Given the user has logged into the WASLA application
    And user has selected the left luggage location
    And left Luggage record already exists in WASLA Desktop
    And user has access to left luggage Function
    And Left luggage should be deposited & racked
    And Collect charges has been initiated in the desktop
    And the user is attempting to launch collection feature
    And user scanned and selected the LL receipt number for sign
    And the sign button is disabled
    When the user scans the bag tag for sign
    Then the signature capture frame should be enabled

      #TC_LEFTLUGG_020
  #ATC_LEFTLUGG_020
  @TestRailId(id=) @JiraStoryId(WBRE-150) @automation
  Scenario: Left Luggage - Successful signature capture
    Given the user has logged into the WASLA application
    And user has selected the left luggage location
    And left Luggage record already exists in WASLA Desktop
    And user has access to left luggage Function
    And Left luggage should be deposited & racked
    And Collect charges has been initiated in the desktop
    And the user is attempting to launch collection feature
    And user scanned and selected the LL receipt number for sign
    When the user clicks on the signature button for a left luggage
    Then the system will display the signature block where the customer has to sign
    And the text I accept the terms and conditions stipulated as mentioned in the receipt with the check box
    And the option to clear the captured signature or submit to save the signature
    And system will enable the submit button only if the signature has been captured and the terms and condition has been accepted
    And on submit the system will display Thank you Signature Saved Successfully in green

    
      #TC_LEFTLUGG_022
  #ATC_LEFTLUGG_022
  @TestRailId(id=) @JiraStoryId(WBRE-174) @automation
  Scenario: Left Luggage - Default location selection
    Given the user has logged into the WASLA application
    When User has access to the Left Luggage Feature
    Then the system will auto select the left luggage location as a default
