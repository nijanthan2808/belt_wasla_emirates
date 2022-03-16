@belt
Feature: Create QOH for BELT

  #TC_BQOH_001
  #ATC_BQOH_001
  @TestRailId(id=) @JiraStoryId(WBRE-46) @JiraStoryId(WBRE-31) @automation
  Scenario: Create QOH for single tag number
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the Create QOH screen
    When the user enter the tag number in the tag number field
    And the user enters valid airline originator and submits
    Then the entered tag number will be added to the list
    And after submitting it will show created successfully message

  #TC_BQOH_002
  #ATC_BQOH_002
  @TestRailId(id=) @JiraStoryId(WBRE-47) @automation
  Scenario: Create QOH for multiple tags
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the Create QOH screen
    When the user enters multiple tag numbers and adds it to the list
    And the user enter valid carrier code
    And the user submits the added tags
    Then the system will create the QOH for all entered tag numbers agianst mentioned airline originator code

  #TC_BQOH_005
  #ATC_BQOH_003
  @TestRailId(id=) @JiraStoryId(WBRE-50) @automation
  Scenario: Changeing location from Create QOH screen
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the Create QOH screen
    When the user changes the location
    And the user created QOH for a tag
    Then the newly chaged location should reflect in the created QOH

  #TC_BQOH_006
  #ATC_BQOH_004
  @TestRailId(id=) @JiraStoryId(WBRE-51) @automation
  Scenario: Airline originator format error validation
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the Create QOH screen
    When the user enters invalid airline originator code
    And the user enters valid tag number
    And the user submits the added tags
    Then the system throws an error message as Airline Originator is not valid. Please check and try again

  #TC_BQOH_008
  #ATC_BQOH_005
  @TestRailId(id=) @JiraStoryId(WBRE-51) @automation
  Scenario: Enter same tag more than once to add to the list
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the Create QOH screen
    When the user enters same tag number mare than once and adds it to the list
    Then the sytem will throw an error message as Tag is already added in the list

  #TC_BQOH_011
  #ATC_BQOH_006
  @TestRailId(id=) @JiraStoryId(WBRE-51) @automation
  Scenario: Total number of tags in the list limit validation
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the Create QOH screen
    When the user enters ten tag numbers
    And the user trying to add the eleventh tag number to the list
    Then the sytem will throw an error message as Limit exceeded - max ten tags allowed for creation

#TC_BQOH_013
#ATC_BQOH_007
 @TestRailId(id=) @JiraStoryId(WBRE-51) @automation
 Scenario: Create QOH for MultiBSM  
   Given the user has logged into the BELT application
   And the user has selected a location already
   And the user has launched the Create QOH screen
   And the tag number has multiple valid BSM
   When the user enter the multi BSM tag number in the tag number field
   And the user enter valid carrier code
   And the user submits the added tags
   Then the system will prompt the user to select the right BSM and creates the QOH