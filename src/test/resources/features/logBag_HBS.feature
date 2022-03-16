#@wasla @belt
Feature: Log Bag - HBS check

  #TC_LogBag_HBS_001
  #ATC_LogBag_HBS_001
  @TestRailId(id=)  @JiraStoryId(WBRE-24) @automation
  Scenario:   Location, Flight with HBS enabled and bag not security cleared
    Given the user has launched the log Bag Function
    And   the user has selected location which is enabled for HBS alerts
    And   flight and airline is enabled for HBS
    And   bag is not security cleared
    When  the loader scans or enters bagTag manually
    Then  system will display the below alert "Logging Done Successfully X-ray Location Not Cleared " with the pop up 'OK'
    And   the bag details would be displayed to the user with the success message on clicking OK
 

  #TC_LogBag_HBS_002
  #ATC_LogBag_HBS_002
  @TestRailId(id=)  @JiraStoryId(WBRE-24) @automation
  Scenario:   Location, Flight with HBS enabled and bag is security cleared
    Given the user has launched the log Bag Function
    And   the user has selected location which is enabled for HBS alerts
    And   flight and airline is enabled for HBS
    And   bag is security cleared
    When  the loader scans or enters bagTag manually
    Then  system will display the "Bag Logged Successfully" with bag details


  #TC_LogBag_HBS_003
  #ATC_LogBag_HBS_003
  @TestRailId(id=)  @JiraStoryId(WBRE-24) @automation
  Scenario:   Location is security cleared, Flight with HBS enabled and bag is not security cleared
    Given the user has launched the log Bag Function
    And   the user has selected location which is enabled for security cleared flag
    And   flight and airline is enabled for HBS
    And   bag is not security cleared
    When  the loader scans or enters bagTag manually
    Then  system will display the "Bag Logged Successfully" with bag details and mark the bag as security cleared
	

  #TC_LogBag_HBS_004
  #ATC_LogBag_HBS_004
  @TestRailId(id=)  @JiraStoryId(WBRE-41) @automation
  Scenario: Log Bag with Multiple BSM with Special Log and HBS enabled location
    Given the user has launched the log Bag Function
    And   the user has selected a location which is HBS enabled
    And   there are multiple BSMs with the same bagTag number
    When  the loader scans the bagTag or OHD number
    Then  the system will display all the BSM's with the same tag number for the loader to select the right one
    And   system will allow the loader to log a special bag against the selected tag
    And   the security clearance is received for the logged bag
    And   After logging the tag Success message will be displayed e.g. "016997246 - Logged Successfully"
    And   Flight number/Date,Passenger Name,Cabin class,Bay,Route-Board point-Off point and make up area will be displayed

  #TC_LogBag_HBS_005
  #ATC_LogBag_HBS_005
  @TestRailId(id=)  @JiraStoryId(WBRE-41) @automation
  Scenario: Log Bag with no BSM with Special Log with HBS enabled location
    Given the user has launched the log Bag Function
    And   the user has selected a location which is HBS enabled
    And   the tag had no BSM
    When  the loader scans the bagTag number and system prompts "No BSM found"
    Then  the system will allow loader to enter the optional details to log bag and also provide the option to log special bag
    And   the security clearance is received for the logged bag
    And   After logging the tag Success message will be displayed e.g. "016997246 - Logged Successfully"
    And   Flight number/Date,Passenger Name,Cabin class,Bay,Route-Board point-Off point and make up area will be displayed
	