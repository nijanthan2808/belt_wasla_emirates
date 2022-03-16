@wasla @belt
	Feature: Log Bag by Bag tag number

  #TC_LogBag_BagTag_001
  #ATC_LogBag_BagTag_001
  @TestRailId(id=T16468715) @JiraStoryId(WBRE-26) @automation
  Scenario: Bag tag number format validation
    Given the user has logged into the WASLA application
    And the user has selected a location already
    And the user has launched the log bag function
    When the user manually enters / scans a valid bagTag number which is in either two AN six N or ten N format
    And the user press the enter key to submit
    Then the system will successfully validate the tag number format and auto submit it

  #TC_LogBag_BagTag_002
  #ATC_LogBag_BagTag_002
  @TestRailId(id=T16468716) @JiraStoryId(WBRE-26) @automation
  Scenario: Bag tag number validation failure
    Given the user has logged into the WASLA application
    And the user has selected a location already
    And the user has launched the log bag function
    When the user manually enters / scans a invalid bagTag number which is in neither two AN six N nor ten N format
    And the user press the enter key to submit
    Then the system will throw an error message as Invalid format until valid tag number is entered

  #TC_LogBag_BagTag_010
  #ATC_LogBag_BagTag_003
  @TestRailId(id=T16468720) @JiraStoryId(WBRE-26) @automation
  Scenario: Bag tag number less than 8 character validation failure
    Given the user has logged into the WASLA application
    And the user has selected a location already
    And the user has launched the log bag function
    When the user hits the enter key without entering eight characters after entering three alpha numeric first as bagTag number
    Then the system will throw an error message as Invalid format untill valid tag number is entered

  #TC_LogBag_BagTag_011
  #ATC_LogBag_BagTag_004
  @TestRailId(id=T16468721) @JiraStoryId(WBRE-26) @automation
  Scenario: Bag tag number less than 10 character validation failure
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the log bag function
    When the user hits the enter key without entering ten characters after entering three numeric first as bagTag number
    Then the system will throw an error message as Invalid format untill valid tag number is entered

  #TC_LogBag_BagTag_014
  #ATC_LogBag_BagTag_006
  @TestRailId(id=T16469321) @JiraStoryId(WBRE-7) @automation
  Scenario: Logging bag with no BSM
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the log bag function
    And the bagTag is in valid format but no BSM created
    When the user scans / enters the no BSM bagTag number manually
    And the user press the enter key to submit
    Then the system will prompt that BSM does not exists
    And the system allows the user to add the optional details manually and log the bag

  #TC_LogBag_BagTag_015
  #ATC_LogBag_BagTag_007
  @TestRailId(id=T16468722) @JiraStoryId(WBRE-15) @automation
  Scenario: Log bag with multiple BSM selection
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the log bag function
    When the user scans a valid bagTag with multiple BSM
    And the user press the enter key to submit
    And there are multiple BSMs found for the given bagTag for the last specified days
    And the user has selected OK option from the multiple BSM prompt
    Then the user can be able to select the right BSM to be logged from the list of passengers with the same bagTag number
    And the message will be displayed that the bag is logged successfully e.g. Bag Tag Number - Logged Successfully
    And Flight number/Date, Passenger Name, Cabin class, Bay, Route - Board point-Off point and the make up area ,Special log item information will be displayed

  #TC_LogBag_BagTag_016
  #ATC_LogBag_BagTag_008
  @TestRailId(id=T16468730) @JiraStoryId(WBRE-13) @automation
  Scenario: Logging bag under special log
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the log bag function
    And the BSM was created from BELT
    And the user selects the special log option
    When the user enters bagTag and submits / scans bagTag
    And the user press the enter key to submit
    Then the system will display the success message
    And the system clears the bag tag and special log type entries
    And Flight number/Date, Passenger Name, Cabin class, Bay, Route - Board point-Off point and the make up area ,Special log item information will be displayed

  #TC_LogBag_BagTag_019
  #ATC_LogBag_BagTag_009
  @TestRailId(id=T16468731) @JiraStoryId(WBRE-13) @automation
  Scenario: Multiple Special log bag type
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the log bag function
    And the BSM was created from BELT
    And the user selects the special log option
    When the user selects the Multi-special log option from  log bag screen
    And the user enters bagTag and submits / scans bagTag
    And the user press the enter key to submit
    Then the system will allow the loader to log multiple tags under the selected special service successfully
    And the system clears the bag tag entry and retains special log type entry

  #TC_LogBag_BagTag_023
  #ATC_LogBag_BagTag_010
  @TestRailId(id=T16469323) @JiraStoryId(WBRE-18) @automation
  Scenario: Enter details manually for bag tag with no data
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the log bag function
    And  the bagTag is in valid format but no BSM created
    When the user scans / enters the no BSM bagTag number manually
    And the user press the enter key to submit
    Then  the system will prompt that BSM does not exists
    And the user should be prompted if he wishes to enter the optional details manually

  #TC_LogBag_BagTag_024
  #ATC_LogBag_BagTag_011
  @TestRailId(id=T16468723) @JiraStoryId(WBRE-18) @automation
  Scenario: Enter details manually for bag tag with no data - Yes option
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the log bag function
    And the bagTag is in valid format but no BSM created
    When the user scans / enters the no BSM bagTag number manually
    And the user press the enter key to submit
    And the user selected Yes option from the prompt
    Then the user should be able to enter the following fields -Passenger Name,Destination,Inbound Flight number and date,Outbound Flight number and date,Bag Weights(Kgs)and any additional notes.
    And the user can edit all the fields and each field is optional one - not mandatory
    And the user should be able to submit successfully without entering any input data

  #TC_LogBag_BagTag_025
  #ATC_LogBag_BagTag_012
  @TestRailId(id=T16468724) @JiraStoryId(WBRE-18) @automation
  Scenario: Enter details manually for bag tag with no data - No option
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the log bag function
    And the bagTag is in valid format but no BSM created
    When the user scans / enters the no BSM bagTag number manually
    And the user press the enter key to submit
    And the user has selected No option from the prompt
    Then the bag should be logged with the success meassage without details
    
    
    
 
