@belt
Feature: DFS

  #TC_DFS_005
  #ATC_DFS_001
  @TestRailId(id=)  @JiraStoryId(WBRE-4) @JiraStoryId(WBRE-31) @automation
  Scenario: Getting flight info by flight number and date
    Given the user has logged into the BELT application
    And the user has selected a location already
    And  the user has launched the DFS feature
    When the user enters valid flight number flightNumber
    And  the user selects a valid date flightDate
    And  the user clicks on Confirm button
   Then  the system will launch the Departure Flight Info Screen

  
  #TC_DFS_007
  #ATC_DFS_002
  @TestRailId(id=)  @JiraStoryId(WBRE-4) @automation
  Scenario: Verify the details available in Flight info screen
    Given the user has logged into the BELT application
    And the user has selected a location already
    And  the user has launched the DFS feature
    When   the user launched the Departure Flight Info Screen by entering flight number flightNumber and date flightDate
    Then   the system should list Flight number/Date,Status,Route,Bay,STD,ATD,ETD,Carousal,RegNo,Make-up area,Aircraft,Gate,Terminal,Hold Door,Bay,Belt

  #TC_DFS_009
  #ATC_DFS_003
  @TestRailId(id=)  @JiraStoryId(WBRE-5) @automation
  Scenario: Flight number validation - Invalid format
    Given the user has logged into the BELT application
    And the user has selected a location already
    And  the user has launched the DFS feature
    When  the user enter the Flight number which is not in two A(carrier) and minimum one N to maximum four N format(Flight number)
    And   the user selects valid date and hits the confirm button
    Then  the system should throw error message as Invalid flight number

  #TC_DFS_010
  #ATC_DFS_004
  @TestRailId(id=)  @JiraStoryId(WBRE-5) @automation
  Scenario: Flight number validation - Incorrect flight number
    Given the user has logged into the BELT application
    And the user has selected a location already
    And  the user has launched the DFS feature
    When  the user enters valid carrier code and invalid flight number
    And   the flight number format is valid
    And   the user selects valid date and hits the confirm button
    Then  the system should throw error message as Invalid flight number 

  #TC_DFS_011
  #ATC_DFS_005
  @TestRailId(id=)  @JiraStoryId(WBRE-5) @automation
  Scenario: Flight number validation - Incorrect carrier code
    Given the user has logged into the BELT application
    And the user has selected a location already
    And  the user has launched the DFS feature
    When  the user enters invalid carrier code and valid flight number
    And   the flight number format is valid
    And   the user selects valid date and hits the confirm button
    Then  the system should throw error message as Invalid Carrier





