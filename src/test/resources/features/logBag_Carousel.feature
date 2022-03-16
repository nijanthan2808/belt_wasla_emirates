#@wasla @belt
Feature: Log Bag - Carousel

  #TC_LogBag_Carousel_001
  #ATC_LogBag_Carousel_001
  @TestRailId(id=)  @JiraStoryId(WBRE-23) @automation
  Scenario: Log Bag - Incorrect carousel
    Given the user has launched the Log Bag function
    And   the user has selected a location already
    And   Selected location does not belong to the flight carousal
    When  the loader scans or enters the bagTag number
    Then  system would prompt the loader with the right make up carousel location  "Drop off location incorrect - Correct location C21 FLT EK001 / 13Oct Do you want to force log YES/NO"

  #TC_LogBag_Carousel_002
  #ATC_LogBag_Carousel_002
  @TestRailId(id=)  @JiraStoryId(WBRE-23) @automation
  Scenario: Log Bag - Incorrect carousel - Yes option - without multi log
    Given the user has launched the log Bag Function
    And   the user has selected a location already
    And   Selected location does not belong to the flight carousal
    And   the multi log option is not selected
    And   the loader scans or enters the bagTag number
    When  the user selects Yes option on the prompt to force log
    Then  system logs the bag successfully in correct location
  

  #TC_LogBag_Carousel_003
  #ATC_LogBag_Carousel_003
  @TestRailId(id=)  @JiraStoryId(WBRE-23) @automation
  Scenario: Log Bag - Incorrect carousel - No option - without multi log
    Given the user has launched the log Bag Function
    And   the user has selected a location already
    And   Selected location does not belong to the flight carousal
    And   the loader scans or enters the bagTag number
    And   the multi log option is not selected
    When  the user selects No option on the prompt
    Then  system should not log the bag
    And   the systems goes back to log bag screen
    And   the entered bag tag number should be auto cleared
   

  #TC_LogBag_Carousel_004
  #ATC_LogBag_Carousel_004
  @TestRailId(id=)  @JiraStoryId(WBRE-23) @automation
  Scenario: Log Bag - Incorrect carousel - No option - with multi log
    Given the user has launched the log Bag Function
    And   the user has selected a location already
    And   Selected location does not belong to the flight carousal
    And   the loader scans or enters the bagTag number
    And   the multi log option is selected
    When  the user selects No option on the prompt
    Then  system should not log the bag
    And   the systems goes back to log bag screen
    And   the selected items will remain in the screen

  #TC_LogBag_Carousel_005
  #ATC_LogBag_Carousel_005
  @TestRailId(id=)  @JiraStoryId(WBRE-42) @automation
  Scenario: Log Bag with Multiple BSM with Special Log and incorrect carousal
    Given the user has launched the log Bag Function
    And   the user has selected a location already
    And   there are multiple BSMs with the same bagTag number
    And   bag was dropped off at a wrong carousal
    When  the loader scans the bagTag or OHD number
    Then  the system will display all the BSM's with the same tag number for the loader to select the right one
    And   the system will prompt to select the correct carousal
    And   the user will be able to select the special log against this tag
    And   After logging the tag Success message will be displayed e.g. "016997246 - Logged Successfully"
    And   Flight number/Date,Passenger Name,Cabin class,Bay,Route-Board point-Off point and make up area will be displayed
  