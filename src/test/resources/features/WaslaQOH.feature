@wasla 
Feature: Create QOH for WASLA User

  #TC_WQOH_001
  #ATC_WQOH_001
  @TestRailId(id=) @JiraStoryId(WBRE-98) @JiraStoryId(WBRE-31) @automation
  Scenario: Create QOH for single tag number with or without BSM
    Given the user has logged into the WASLA application
    And the user has selected a location already
    And the user has launched the Create QOH screen
    When the user enter the tag number with or without BSM in the tag number field
    And the user selects valid airline originator from dropdown and submits
    Then the entered tag number will be added to the list
    And after submitting it will show created successfully message

  #TC_WQOH_002   
  #ATC_WQOH_002
  @TestRailId(id=) @JiraStoryId(WBRE-99) @automation
  Scenario: Create QOH for multiple tags with valid BSM
    Given the user has logged into the WASLA application
    And the user has selected a location already
    And the user has launched the Create QOH screen
    When the user enters multiple tag numbers with BSM and adds it to the list
    And the user select valid carrier code
    And the user submits the added tags
    Then the system will create the QOH for all entered tag numbers agianst mentioned airline originator code

  #TC_WQOH_004
  #ATC_WQOH_003
  @TestRailId(id=) @JiraStoryId(WBRE-99) @automation
  Scenario: Create QOH for multiple tags with one or more tags rejected
    Given the user has logged into the WASLA application
    And the user has selected a location already
    And the user has launched the Create QOH screen
    When the user enters multiple tag numbers with one or more rejected and adds it to the list
    And the user select valid carrier code
    And the user submits the added tags
    Then the system will create the QOH and show the error message for rejected as QOH creation unsuccessful - due tag 1 - 2 from the below rejected


  #TC_WQOH_005
  #ATC_WQOH_004
  @TestRailId(id=) @JiraStoryId(WBRE-100) @JiraStoryId(WBRE-31) @automation
  Scenario: QOH already exist error validation
    Given the user has logged into the WASLA application
    And the user has selected a location already
    And the user has launched the Create QOH screen
    When the user enter the tag number which already has a QOH generated
    And the user selects valid airline originator from dropdown and submits
    Then the system will throw an error as QOH already exists/created


  #TC_WQOH_011
  #ATC_WQOH_007
  @TestRailId(id=) @JiraStoryId(WBRE-104) @automation
  Scenario: Enter same tag more than once to add to the list
    Given the user has logged into the WASLA application
    And the user has selected a location already
    And the user has launched the Create QOH screen
    When the user enters same tag number mare than once and adds it to the list
    Then the sytem will throw an error message as Tag is already added in the list

  #TC_WQOH_014
  #ATC_WQOH_008
  @TestRailId(id=) @JiraStoryId(WBRE-104) @automation
  Scenario: Total number of tags in the list limit validation
    Given the user has logged into the WASLA application
    And the user has selected a location already
    And the user has launched the Create QOH screen
    When the user enters ten tag numbers
    And the user trying to add the eleventh tag number to the list
    Then the sytem will throw an error message as Limit exceeded - max ten tags allowed for creation


#TC_WQOH_016
#ATC_WQOH_010
 @TestRailId(id=) @JiraStoryId(WBRE-146) @automation
 Scenario: Create QOH for MultiBSM  
   Given the user has logged into the BELT application
   And the user has selected a location already
   And the user has launched the Create QOH screen
   And the tag number has multiple valid BSM
   When the user enter the multi BSM tag number in the tag number field
   And the user select valid carrier code
   And the user submits the added tags
   Then the system will prompt the user to select the right BSM and creates the QOH 
   
  #TC_WQOH_017
  #ATC_WQOH_011
  @TestRailId(id=) @JiraStoryId(WBRE-98) @JiraStoryId(WBRE-31) @automation
  Scenario: Create QOH for No BSM		
    Given the user has logged into the WASLA application
    And the user has selected a location already
    And the user has launched the Create QOH screen
    When the user enter the tag number without BSM in the tag number field
    And the user selects valid airline originator from dropdown and submits
    Then the entered tag number will be added to the list
    And after submitting it will show created successfully message
