@wasla @belt
Feature: Location selection on log location screen for users

  #TC_LOC_001
  #ATC_LOC_001
  @TestRailId(id=) @JiraStoryId(WBRE-2) @demoRun @automation 
  Scenario: Location prompt to select user location 
    Given the user has logged into the BELT application
    And the user has not selected a location yet
    When the user is trying to access any feature/function
    Then the system will prompt the user to select the location

  #TC_LOC_002
  #ATC_LOC_002
  @TestRailId(id=) @JiraStoryId(WBRE-2) @automation
  Scenario: Location prompt to select user location - Location already selected
    Given the user has logged into the BELT application
    And the user has already selected a location and saved it
    When the user is trying to access any feature/function
    Then the system won't prompt the user to select the location

  #TC_LOC_007
  #ATC_LOC_003
  @TestRailId(id=) @JiraStoryId(WBRE-3) @demoRun @automation
  Scenario: Save valid location - Validation 
    Given  the user has logged into the BELT application
    And User has navigated to Log location screen
    When the user selects a valid terminal, area and location from the list in any possible way
    And the user clicks on confirm button
    Then the system will save the selected location data
    And the system navigates to the previous screen
    And the confirmation message will be displayed as Location update successful
    And the selected location is displayed in the location bar on the top in all screens

  #TC_LOC_010
  #ATC_LOC_005
  @TestRailId(id=) @JiraStoryId(WBRE-3)  @automation
  Scenario: Verify saved location data in all the screens
    Given  the user has logged into the BELT application
    And User has already saved a valid location data successfully
    When the user has navigated to any screen
    Then the user will see his saved location at the location bar at the top of the screen

  #TC_LOC_011 
  #ATC_LOC_006
  @TestRailId(id=) @JiraStoryId(WBRE-9) @demoRun @automation
  Scenario: Change saved location data  
    Given  the user has logged into the BELT application
    And User has already saved a valid location data successfully
    When the user clicks the Edit icon in the current location bar
    Then the user will be navigated to the log location screen
    And the user will see his saved terminal, area and location values in relevant drop downs
    And the user will be able to change the location by selecting from drop down / search by typing / scan the location

#TC_LOC_018
  #ATC_LOC_007
  @TestRailId(id=) @JiraStoryId(WBRE-25) @demoRun @automation
  Scenario: Search valid location by predictive search/ Typing
    Given  the user has logged into the BELT application
    And User has navigated to Log location screen
    And the user has choosen Search option
    When the user starts typing a valid location
    And as soon as the user starts typing, system starts retrieving the matching locations and populates the corresponding matching location for the user to choose from
    And the user selects a valid location from the filtered dropdown
    Then the saved location should be displayed in all the screens

  #TC_LOC_016
  #ATC_LOC_008
  @TestRailId(id=) @JiraStoryId(WBRE-25) @automation
  Scenario: Show recently saved locations first in search option
    Given  the user has logged into the BELT application
    And User has navigated to Log location screen
    When the user has choosen Search option
    Then the user should be able to see the recently used locations in the dropdown first
    And user should be able to select on from it

  #TC_LOC_017
  #ATC_LOC_009
  @TestRailId(id=) @JiraStoryId(WBRE-25) @automation
  Scenario: Select location from recently saved locations
    Given  the user has logged into the BELT application
    And User has navigated to Log location screen
    And the user has choosen Search option
    When the user selects any location from the recently used locations shown in the dropdown
    Then user system should save that location and take them to the previous screen
    And the saved location should be displayed in all the screens

  

  #TC_LOC_019
  #ATC_LOC_010
  @TestRailId(id=) @JiraStoryId(WBRE-25) @demoRun @automation
  Scenario: Search invalid location by predictive search/ Typing
    Given  the user has logged into the BELT application
    And User has navigated to Log location screen
    And the user has choosen Search option
    When the user starts typing a invalidLocation
    Then message should be displayed as No results found or Invalid input. Please try searching for another location
    And user should be able to rescan or enter the details manually
