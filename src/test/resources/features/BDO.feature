@wasla
Feature: BDO - Baggage Delivery Order

  #TC_BDO_001
  #ATC_BDO_001
  @TestRailId(id=) @JiraStoryId(WBRE-2) @automation
  Scenario: BDO - Location prmopt on launch of the feature - Without selectnig location
    Given the user has logged into the WASLA application
    And the user hasn't selected a location yet
    And the user has access to Baggage Delivery Order feature and icon is available in the home screen
    When the user clicks on th icon and opens the feature
    Then the user will be prompted to select the location first
 
  #TC_BDO_002
  #ATC_BDO_002
  @TestRailId(id=) @JiraStoryId(WBRE-2) @automation
  Scenario: BDO - Location prmopt on launch of the feature - location already selected
    Given the user has logged into the WASLA application
    And the user has selected a location already
    And the user has access to Baggage Delivery Order feature and icon is available in the home screen
    When the user clicks on th icon and opens the feature
    Then the user will not be prompted to select the location
    And the feature will be launched

  #TC_BDO_003
  #ATC_BDO_003
  @TestRailId(id=) @JiraStoryId(WBRE-152) @automation
  Scenario: BDO - Baggage Delivery Order page launch
    Given the user has logged into the WASLA application
    And the user has selected a location already
    And User has access to the BDO Feature
    When the user launches the BDO feature
    Then the system will successfully open the BDO page
    And with the option for the user, based on given access, to launch Log bag for BDO, Vendor Delivery and Pax Collection

  #TC_BDO_069
  #ATC_BDO_069
  @TestRailId(id=) @JiraStoryId(WBRE-183) @automation
  Scenario: 
    Given the user has logged into the WASLA application
    And user has selected a location outside BDO
    And the location selected is not one of the following -BPA IN, BPA OUT, LFT LUGG IN, LFT LUGG OUT
    And User has access to the BDO Feature
    And the user launches the BDO feature
    And the user navigated to Log bag option
    When the user scans or enters the BDO Tag/ Bag Tag / OHD / AHL ref number and submits the transaction
    Then the system will validate the selected location is one of the following BPA IN, BPA OUT, LFT-LUGG IN, LFT-LUGG OUT
    And if not, then system will display a error message

  #TC_BDO_005
  #ATC_BDO_005
  @TestRailId(id=) @JiraStoryId(WBRE-153) @automation
  Scenario: BDO - Log Bag for BDO with empty tag
    Given the user has logged into the WASLA application
    And user has selected any BDO location
    And User has access to the BDO Feature
    And the user launches the BDO feature
    And the user navigated to Log bag option
    When the user scans or enters empty tag number
    Then the submit button will be disabled

 #TC_BDO_043
  #ATC_BDO_043
  @TestRailId(id=) @JiraStoryId(WBRE-178) @automation
  Scenario: BDO - BPA OUT for Single bag / Multiple Bags - Passive BDO
    Given the user has logged into the WASLA application
    And user has selected location BPA OUT
    And User has access to the BDO Feature
    And the user launches the BDO feature
    And user has launched BDO log bag
    And the bag is Passive
    When the user scans or enters the BDO bag tag in passive status
    And user clicks on log bag SUBMIT
    Then the system will display Operation not allowed BDO not active

   #TC_BDO_056
  #ATC_BDO_056
  @TestRailId(id=) @JiraStoryId(WBRE-180) @automation
  Scenario: BDO -	Log bag - BDO tag with Inactive status at Left Luggage OUT
    Given the user has logged into the WASLA application
    And user has selected location Left Luggage OUT
    And User has access to the BDO Feature
    And the user launches the BDO feature
    And user has launched BDO log bag
    When the user scans or enters the BDO Bag Tag created at LL and LL IN not done
    And user clicks on log bag SUBMIT
    Then the system will display Operation not allowed BDO not active


    #TC_BDO_017
  #ATC_BDO_017
  @TestRailId(id=) @JiraStoryId(WBRE-157) @automation
  Scenario: BDO - Log bag for Single/multiple bag created at Main stores
    Given the user has logged into the WASLA application
    And user has selected location BPA IN
    And User has access to the BDO Feature
    And BDo created at EK store
    And the user is attempting to log a bag
    And BPA IN is not done
    And user selects Is damaged optional
    And option to enter remarks is enabled and mandated
    When user enters valid tag number for log bag
    And user clicks on log bag SUBMIT
    Then system returns successful message Bag Logged successfully along with the count of total bags and scanned bags

 #TC_BDO_018
  #ATC_BDO_018
  @TestRailId(id=) @JiraStoryId(WBRE-157) @automation
  Scenario: BDO - Log bag for Single/multiple bag created at Left Luggage stores
    Given the user has logged into the WASLA application
    And user has selected location BPA IN
    And User has access to the BDO Feature
    And BDo created at LL store
    And the user is attempting to log a bag
    And BPA IN is not done
    And user selects Is damaged optional
    And option to enter remarks is enabled and mandated
    When user enters valid tag number created at LL store for log bag
    And user clicks on log bag SUBMIT
    Then system returns error message that BPA IN cannot be done for BDO created at Left Luggage.

  #TC_BDO_020
  #ATC_BDO_020
  @TestRailId(id=) @JiraStoryId(WBRE-157) @automation
  Scenario: BDO - Single/Multiple Bags - BPA IN is already done
    Given the user has logged into the WASLA application
    And user has selected location BPA IN
    And User has access to the BDO Feature
    And the user is attempting to log a bag
    When the user is logs a bag that already logged in BPA IN
    Then the system will display Bag already logged under BPA IN

  #TC_BDO_021
  #ATC_BDO_021
  @TestRailId(id=) @JiraStoryId(WBRE-157) @automation
  Scenario: BDO - Log bag for tag number that doesn't exist
    Given the user has logged into the WASLA application
    And user has selected location BPA IN
    And User has access to the BDO Feature
    And the user is attempting to log a bag
    When the user scans or enters the BDO Tag number that is invalid
    Then the system will display NO BDO found for given input data - BDO tag number

   #TC_BDO_027
  #ATC_BDO_027
  @TestRailId(id=) @JiraStoryId(WBRE-175) @automation
  Scenario: BDO - Terms and Conditions for active BDO with left luggage out done for all bags
    Given the user has logged into the WASLA application
    And user has selected location Left Luggage OUT
    And User has access to the BDO Feature
    And the user launches the BDO feature
    And the BDO is active and Left luggae out done for all the bags
    And the user launches the Pax collection screen
    And the user scans or enters the BDO Reference and selects bags
    And user entered required details of the Pax/Other and clicks next
    When the user clicks on Terms and Conditions in signature capture screen
    Then the user will be shown the terms and conditions In English and Arabic with agree button
 
  #TC_BDO_031
  #ATC_BDO_031
  @TestRailId(id=) @JiraStoryId(WBRE-175) @automation
  Scenario: BDO - Clear signature option - BDO full delivery
    Given the user has logged into the WASLA application
    And user has selected location Left Luggage OUT
    And User has access to the BDO Feature
    And the user launches the BDO feature
    And the BDO is active and Left luggae out done for all the bags
    And the user launches the Pax collection screen
    And the user scans or enters the BDO Reference and selects bags
    And user entered required details of the Pax/Other and clicks next
    When the user signs and clicks on clear button
    Then clicking on it should clear off the signature on the panel

  #TC_BDO_032
  #ATC_BDO_032
  @TestRailId(id=) @JiraStoryId(WBRE-176) @automation
  Scenario: BDO - Delivery location selection in PAX collection
    Given the user has logged into the WASLA application
    And user has selected location BPA IN
    And User has access to the BDO Feature
    And the user launches the BDO feature
    When the user launches the Pax collection screen
    Then the system will default to Left Luggage OUT as collection location

  #TC_BDO_029
  #ATC_BDO_029
  @TestRailId(id=) @JiraStoryId(WBRE-175) @automation
  Scenario: BDO - BDO full delivery - Left Luggage out not done for any bag
    Given the user has logged into the WASLA application
    And user has selected location BPA IN
    And User has access to the BDO Feature
    And the user launches the BDO feature
    And the user launches the Pax collection screen
    And the BDO is active and Left luggae out not done for any of the bags
    When the user scans or enters the BDO Reference and selects bags
    And user entered required details of the Pax/Other and clicks next
    And user signs and accepts terms and clicks next
    Then system will display an error BDO delivery failed for List BDO tag nbrs

  #TC_BDO_037
  #ATC_BDO_037
  @TestRailId(id=) @JiraStoryId(WBRE-176) @automation
  Scenario: BDO - Field validations in Pax/Others details screen in PAX collection for BDO in active status
    Given the user has logged into the WASLA application
    And user has selected location BPA IN
    And User has access to the BDO Feature
    And the user launches the BDO feature
    And the user launches the Pax collection screen
    When the user scans or enters the BDO Reference and selects bags
    When user didnot enter required fields and clicks next
    Then the system will validate and throw errors for manatory fields

  #TC_BDO_039
  #ATC_BDO_039
  @TestRailId(id=) @JiraStoryId(WBRE-176) @automation
  Scenario: BDO - Scanning already delivered BDO for PAX collection
    Given the user has logged into the WASLA application
    And user has selected location BPA IN
    And User has access to the BDO Feature
    And the user launches the BDO feature
    And the user launches the Pax collection screen
    When the user scans or enters the BDO Reference that is already delivered
    Then system will display bag details as delivery status as Y

  #TC_BDO_042
  #ATC_BDO_042
  @TestRailId(id=) @JiraStoryId(WBRE-178) @automation
  Scenario: BDO - BPA OUT for Single bag / Multiple Bags - Active BDO
    Given the user has logged into the WASLA application
    And user has selected location BPA OUT
    And User has access to the BDO Feature
    And the user launches the BDO feature
    And bag has already been scanned at BPA IN area
    And user has launched BDO log bag
    When the user scans or enters the BDO Bag Tag number in BPA OUT area
    And BPA out is not already done
    Then the system will display success message BDO logged successfully


  #TC_BDO_044
  #ATC_BDO_044
  @TestRailId(id=) @JiraStoryId(WBRE-178) @automation
  Scenario: BDO - BPA OUT for Single bag / Multiple Bags - BDO pending approval
    Given the user has logged into the WASLA application
    And user has selected location BPA OUT
    And User has access to the BDO Feature
    And the user launches the BDO feature
    And user has launched BDO log bag
    And bag has already been scanned at BPA IN area
    When the user scans or enters the BDO Bag Tag that is pending for approval
    And user clicks on log bag SUBMIT
    Then the system will display Operation cannot be performed for not approved urgent BDO

  #TC_BDO_045
  #ATC_BDO_045
  @TestRailId(id=) @JiraStoryId(WBRE-178) @automation
  Scenario: BDO - BPA OUT for Single bag / Multiple Bags - 	 BDO Created at Left Luggage
    Given the user has logged into the WASLA application
    And user has selected location BPA OUT
    And User has access to the BDO Feature
    And the user launches the BDO feature
    And user has launched BDO log bag
    When the user scans or enters the BDO Bag Tag created at Left Luggage and submits
    Then system returns error message that BPA OUT cannot be done for BDO created at Left Luggage

  #TC_BDO_046
  #ATC_BDO_046
  @TestRailId(id=) @JiraStoryId(WBRE-178) @automation
  Scenario: BDO - BPA OUT for Single bag / Multiple Bags - BPA OUT already done
    Given the user has logged into the WASLA application
    And user has selected location BPA OUT
    And User has access to the BDO Feature
    And the user launches the BDO feature
    And user has launched BDO log bag
    When the user scans or enters the BDO Bag Tag that already logged under BPA OUT and submits
    Then system returns error message Bag already logged under BPA OUT

  #TC_BDO_048
 #TC_BDO_048
  #ATC_BDO_048
  @TestRailId(id=) @JiraStoryId(WBRE-179) @automation
  Scenario: BDO - BDOat log bag at Left Luggage stores - Mandating remarks validation
    Given the user has logged into the WASLA application
    And user has selected location Left Luggage IN
    And User has access to the BDO Feature
    And the user launches the BDO feature
    And user has launched BDO log bag
    And the user scans or enters the BDO Bag Tag for Damage mandate
    When user selects Is damaged checkbox
    And clicks on submit without entering comments
    Then system will thow error message as Enter the damage remarks

   #TC_BDO_049
  #ATC_BDO_049
  @TestRailId(id=) @JiraStoryId(WBRE-179) @automation
  Scenario: BDO - Log bag - BDO with Single/multiple bag created at Left Luggage stores
    Given the user has logged into the WASLA application
    And user has selected location Left Luggage IN
    And User has access to the BDO Feature
    And the user launches the BDO feature
    And user has launched BDO log bag
    And Left Luggage IN is not done
    When the user scans or enters the BDO Bag Tag number created at LL
    And user clicks on log bag SUBMIT
    Then system returns successful message Bag Logged successfully along with the count of total bags and scanned bags at LL IN


 #TC_BDO_051
  #ATC_BDO_051
  @TestRailId(id=) @JiraStoryId(WBRE-179) @automation
  Scenario: BDO -	BDO with Single/Multiple Bags created at left luggage - left luggage IN is already done
    Given the user has logged into the WASLA application
    And user has selected location Left Luggage IN
    And User has access to the BDO Feature
    And the user launches the BDO feature
    And user has launched BDO log bag
    When the user scans or enters the BDO Bag Tag number created at LL and Left Luggage IN is already done
    And user clicks on log bag SUBMIT
    Then the system will display Bag already logged under Left Luggage in

 
 #TC_BDO_053
  #ATC_BDO_053
  @TestRailId(id=) @JiraStoryId(WBRE-179) @automation
  Scenario: BDO -	 BDO with Single/Multiple Bags created EK stores - Custom Scan not yet done
    Given the user has logged into the WASLA application
    And user has selected location Left Luggage IN
    And User has access to the BDO Feature
    And the user launches the BDO feature
    And user has launched BDO log bag
    When the user scans or enters the BDO Bag Tag number created at EK store and custom scan is not yet done
    And user clicks on log bag SUBMIT
    Then system will display error as Left Luggage IN allowed only after Custom Scan


  #TC_BDO_055
  #ATC_BDO_055
  @TestRailId(id=) @JiraStoryId(WBRE-180) @automation
  Scenario: BDO -	Log bag - BDO tag with Single bag / Multiple Bags at Left Luggage OUT
    Given the user has logged into the WASLA application
    And user has selected location Left Luggage OUT
    And User has access to the BDO Feature
    And the user launches the BDO feature
    And user has launched BDO log bag
    And Left Luggage out is not already done
    When the user scans or enters the BDO Bag Tag that Left Luggage IN already done
    And user clicks on log bag SUBMIT
    Then the system will display success message BDO logged successfully


  #TC_BDO_058
  #ATC_BDO_058
  @TestRailId(id=) @JiraStoryId(WBRE-180) @automation
  Scenario: BDO -	Log bag - BDO tag with Left luggage OUT already done at Left Luggage OUT
    Given the user has logged into the WASLA application
    And user has selected location Left Luggage OUT
    And User has access to the BDO Feature
    And the user launches the BDO feature
    And user has launched BDO log bag
    When the user scans or enters the BDO Bag Tag that Left Luggage out is already done
    And user clicks on log bag SUBMIT
    Then the system will throw error as Bag already logged under Left Luggage OUT

  #TC_BDO_060
  #ATC_BDO_060
  @TestRailId(id=) @JiraStoryId(WBRE-181) @automation
  Scenario: BDO -	BDO Partial Delivery - BDO with single/multiple bags created at EK stores or left luggage- Only some are eligible for delivery - Select all bags for delivery
    Given the user has logged into the WASLA application
    And user has selected location Left Luggage OUT
    And User has access to the BDO Feature
    And the user launches the BDO feature
    And user launches Vendor delivery
    And the user scans or enters the BDO Reference number for partial delivery
    When the user selects bags to be delivered and submits
    And user entered required details of the Pax/Other and clicks next
    And user signs and accepts terms and clicks next
    And the user scans or enters the BDO Reference number for partial delivery
    Then system will mark only the successfully delivered bags as Y

  #TC_BDO_061
  #ATC_BDO_061
  @TestRailId(id=) @JiraStoryId(WBRE-181) @automation
  Scenario: BDO -	BDO Partial Delivery - BDO with single/multiple bags created at EK stores or left luggage- Only some are eligible for delivery - Select only eligible bags for delivery
    Given the user has logged into the WASLA application
    And user has selected location Left Luggage OUT
    And User has access to the BDO Feature
    And the user launches the BDO feature
    And user launches Vendor delivery
    And the user scans or enters the BDO Reference number for full delivery
    When the user selects all bags to deliver and submits
    And user entered required details of the Pax/Other and clicks next
    And user signs and accepts terms and clicks next
    And the user scans or enters the BDO Reference number for full delivery
    Then system will mark all the selected and successfully delivered bags as Y
