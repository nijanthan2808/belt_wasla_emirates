@wasla @belt
Feature: Log Bag by OHD reference number

  #TC_LogBag_OHD_001
  #ATC_LogBag_OHD_001
  @TestRailId(id=) @JiraStoryId(WBRE-6) @automation
  Scenario: Log bag by scanning -  Valid OHD number
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the log bag function
    And the OHD is created and not on Closed status
    When the loader scans a OHD reference number
    And the user press the enter key to submit
    Then the OHD is LOGGED successfully
    And the message will be displayed as the OHD is logged successfully.DXBEK12345 OHD logged Successfully

  #TC_LogBag_OHD_002
  #ATC_LogBag_OHD_002
  @TestRailId(id=) @JiraStoryId(WBRE-6) @automation
  Scenario:  Log bag by scanning  - Invalid OHD number
		Given  the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the log bag function
    When the loader scans a invalidOHD reference number
    And the user press the enter key to submit
    Then the Invalid OHD reference number error message is displayed until the user scans/enters a valid OHD number

  #TC_LogBag_OHD_014
  #ATC_LogBag_OHD_003
  @TestRailId(id=) @JiraStoryId(WBRE-19) @automation
  Scenario: Log Bag using a OHD reference which is already closed
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the log bag function
    And the OHD exist in the system with closed status
    When the user scans or enters manually the OHD reference number
    And the user press the enter key to submit
    And System validates the status and identifies the status of OHD is closed
    Then an error with OHD is closed response will be shown to the loader
