@wasla @belt
Feature: Search Option / Tag Search

  #TC_SearchOptions_002
  #ATC_SearchOptions_001
  @TestRailId(id=) @JiraStoryId(WBRE-109) @automation
  Scenario: Ability to search for Tag Number BIR
    Given the user has logged into the WASLA application
    And the user has selected a location already
    And the user has launched the Search feature
    And the user selected the date range for BIR
    When the user scans or enters the tag number and selects the BIR option
    And the user clicks on search
    Then the system will display the details available for the tag
    And Clicking on a result will display the complete details

  #TC_SearchOptions_004
  #ATC_SearchOptions_002
  @TestRailId(id=) @JiraStoryId(WBRE-113) @JiraStoryId(WBRE-123) @automation
  Scenario: Tag number search -  MACS tab with EK
    Given the user has logged into the WASLA application
    And the user has selected a location already
    And the user has launched the Search feature
    And the user selected the date range for MACS 
    When the user scans or enters the tag number and selects the option MACS with EK
    And the user clicks on search
    Then the system will display the details available for the tag
    And Clicking on a result will display the complete details
    
      #TC_SearchOptions_004
  #ATC_SearchOptions_003
  @TestRailId(id=) @JiraStoryId(WBRE-113) @JiraStoryId(WBRE-123) @automation
  Scenario: Tag number search -  MACS tab with OAL
    Given the user has logged into the WASLA application
    And the user has selected a location already
    And the user has launched the Search feature
    And the user selected the date range for MACS 
    When the user scans or enters the tag number and selects the option MACS with OAL
    And the user clicks on search
    Then the system will display the details available for the tag
    And Clicking on a result will display the complete details
    
      #TC_SearchOptions_004
  #ATC_SearchOptions_004
  @TestRailId(id=) @JiraStoryId(WBRE-113) @JiraStoryId(WBRE-123) @automation
  Scenario: Tag number search -  MACS tab with BOTH
    Given the user has logged into the WASLA application
    And the user has selected a location already
    And the user has launched the Search feature
    And the user selected the date range for MACS
    When the user scans or enters the tag number and selects the option MACS with BOTH
    And the user clicks on search
    Then the system will display the details available for the tag
    And Clicking on a result will display the complete details
  
  #TC_SearchOptions_005
  #ATC_SearchOptions_005
  @TestRailId(id=) @JiraStoryId(WBRE-113) @JiraStoryId(WBRE-124) @JiraStoryId(WBRE-135) @automation
  Scenario: Tag number search -  WT (AHL/OHD/DPR) tab
        Given the user has logged into the WASLA application
    And the user has selected a location already
    And the user has launched the Search feature
    When the user scans or enters the tag number and selects the option WT
    And the user clicks on search
    Then the system will display the details available for the tag
    And Clicking on a result will display the complete details

  #TC_SearchOptions_006
  #ATC_SearchOptions_006
  @TestRailId(id=) @JiraStoryId(WBRE-113) @JiraStoryId(WBRE-122) @automation
  Scenario: Tag number search - WT FWD tab
        Given the user has logged into the WASLA application
    And the user has selected a location already
    And the user has launched the Search feature
    When the user scans or enters the tag number and selects the option WT FWD
    And the user clicks on search
    Then the system will display the details available for the tag
    And Clicking on a result will display the complete details

  #TC_SearchOptions_003
  #ATC_SearchOptions_007
  @TestRailId(id=) @JiraStoryId(WBRE-113) @automation
  Scenario: Tag number search - All Systems
    Given the user has logged into the WASLA application
    And the user has selected a location already
    And the user has launched the Search feature
    And the user selected the date range for ALL
    When the user scans or enters the tag number and selects the option 'All'
    And the user clicks on search
    Then the system will search all the systems - BIR, WT FWD, WT (AHL/OHD/DPR) MACS -EK & OAL) and with the option to the user to deselect one of the source in MACS and display the details
		And the user will be able to swtich accross the tabs and view the results
		
  #TC_SearchOptions_007
  #ATC_SearchOptions_008
  @TestRailId(id=) @JiraStoryId(WBRE-113) @automation
  Scenario: Tag number search - All Systems - No result
    Given the user has logged into the WASLA application
    And the user has selected a location already
    And the user has launched the Search feature
    And the user selected the date range for ALL
    When the user scans or enters the tag number with no data and selects the option 'All'
    And the user click on search
    Then the system will search all the systems - BIR, WT FWD, WT (AHL/OHD/DPR) MACS -EK & OAL)
    And display error "Tag not found" in all tabs


