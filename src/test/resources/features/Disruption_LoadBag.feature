@belt
Feature: BRS Disruption - Load Bag

  #TC_BRS_Disruption_019
  #ATC_BRS_Disruption_001
  @TestRailId(id=C464764) @JiraStoryId(WBRE-195) @automation
  Scenario: Unregistered Disrupted ULD 
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the Disruption load bag feature
    And Disruption mode is 'ON'
    And the user is attempting to scan the ULD
    When the user scans or manually enters the unregistered ULD number
    Then the system should throw the error message, "ULD NOT REGISTERED"
   
  #TC_BRS_Disruption_020
  #ATC_BRS_Disruption_002
  @TestRailId(id=C464765) @JiraStoryId(WBRE-195) @automation
  Scenario: Disrupted ULD Status = Assigned 
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the Disruption load bag feature
    And ULD is registered as 'Disruption ULD'
    And Disruption mode is 'ON'
    And the user is attempting to scan the ULD 
    And Disrupted ULD status = Assigned
    When the user scans or manually enters the ULD number which is already assigned
    Then the system should throw the error message, "ULD NOT REGISTERED" 
    And on clicking on 'Dismiss', the ULD details should be cleared from the screen  
   
  #TC_BRS_Disruption_018
  #ATC_BRS_Disruption_003
  @TestRailId(id=C464763) @JiraStoryId(WBRE-195) @automation
  Scenario: Valid ULD status - Open 
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the Disruption load bag feature
    And ULD is registered as 'Disruption ULD'
    And Disruption mode is 'ON'
    And the user is attempting to scan the ULD 
    When the user scans the ULD or manually enters the ULD number
    Then the system will validate the ULD scanned and display the ULD details 

  #TC_BRS_Disruption_002/1
  #ATC_BRS_Disruption_004
  @TestRailId(id=C464769) @JiraStoryId(WBRE-70) @automation
  Scenario: Successful Load - ULD and Bag destination are the same
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the Disruption load bag feature
    And ULD is registered as 'Disruption ULD'
    And Disruption mode is 'ON'
    And ULD has already been scanned 
    And bag belongs to a Flight which is headed to the same destination as the Disrupted ULD.
    And the user is attempting to load the bag 
    When the user scans the tag or manually enters the tag number
    Then System will allow loading of bags to the ULD, with the following message in Green "YES Bag..Successfully Loaded.."

  #TC_BRS_Disruption_026
  #ATC_BRS_Disruption_005
  @TestRailId(id=C464784) @JiraStoryId(WBRE-) @automation
  Scenario: Bag already loaded error validation
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the Disruption load bag feature
    And ULD is registered as 'Disruption ULD'
    And Disruption mode is 'ON'
    And ULD has already been scanned 
    And the bag has already loaded on the ULD / flight 
    When the user scans the tag or manually enters the tag number
    Then the system should play a long beep and give an error message as Bag already Loaded

  #TC_BRS_Disruption_004
  #ATC_BRS_Disruption_006
  @TestRailId(id=C464771) @JiraStoryId(WBRE-70) @automation
  Scenario: Successful Load - Bag information validation 
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the Disruption load bag feature
    And ULD is registered as 'Disruption ULD'
    And Disruption mode is 'ON'
    And ULD has already been scanned 
    And bag is not already loaded 
    And the user is attempting to load the bag 
    When the user scans the tag or manually enters the valid tag number
    Then System will allow loading of bags to the ULD, with the following message in Green "YES Bag..Successfully Loaded.."
    And the following details should be seen on the screen eg - Last Bag tag Scanned, Total No. of Bags loaded etc.

  #TC_BRS_Disruption_006
  #ATC_BRS_Disruption_007
  @TestRailId(id=C464773) @JiraStoryId(WBRE-70) @automation
  Scenario: Tag number not found
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the Disruption load bag feature
    And ULD is registered as 'Disruption ULD'
    And Disruption mode is 'ON'
    And ULD has already been scanned 
    And bag is not already loaded 
    And the user is attempting to load the bag 
    When the user scans the tag or manually enters the invalid tag number
    Then system will display red scan "NO UNKNOWN BAG TAG " with the option to dismiss
  
  #TC_BRS_Disruption_008
  #ATC_BRS_Disruption_008
  @TestRailId(id=C464774) @JiraStoryId(WBRE-70) @automation
  Scenario: Non-disrupted ULD
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the Disruption load bag feature
 	And ULD is NOT registered as 'Disruption ULD'
	And Disruption mode is 'ON'
	And the user is attempting to load the bag 
	When the user scans or manually enters the Non-disrupted ULD number
    Then the system should throw the error message, "ULD NOT REGISTERED"
	
  #TC_BRS_Disruption_009
  #ATC_BRS_Disruption_009
  @TestRailId(id=C464775) @JiraStoryId(WBRE-70) @automation
  Scenario: Destination Mismatch (not TL)
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the Disruption load bag feature
    And ULD is registered as 'Disruption ULD'
    And Disruption mode is 'ON'
    And the destination of ULD and bag does not match 
    And ULD has already been scanned 
    And the user is attempting to load the bag
    When the user scans the tag or manually enters the tag number with different destination as of ULD
    Then the system will display message "ULD destination does not match"
  
  #TC_BRS_Disruption_011
  #ATC_BRS_Disruption_010
  @TestRailId(id=C464777) @JiraStoryId(WBRE-190) @automation
  Scenario: BSM exists for multiple tags in more than one flight - Loader user
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the Disruption load bag feature
    And ULD is registered as 'Disruption ULD'
    And Disruption mode is 'ON'
    And ULD has already been scanned 
    And the tag has miultiple BSMs linked for the past x days
    When the user scans the multi BSM tag number bag
    Then System displays a red scan "NO..DUPLICATE BAGTAG" with an option to "Dismiss"
  
  #TC_BRS_Disruption_016
  #ATC_BRS_Disruption_011
  @TestRailId(id=C464761) @JiraStoryId(WBRE-192) @automation
  Scenario: Disruption Mode is ON
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the Disruption load bag feature
    When Disruption mode is 'ON'
    Then the system should allow the user to view the disruption feature 

  #TC_BRS_Disruption_024
  #ATC_BRS_Disruption_012
  @TestRailId(id=C464766) @JiraStoryId(WBRE-196) @automation
  Scenario: Baggage class mismatch 
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the Disruption load bag feature
    And ULD is in Open status 
    And the user is attempting to load a bag for different class other than the one that is registered on the disrupted ULD
    And user has entered the Class related ULD number 
    And all other disruption reconciliation checks of bag and ULD matches except for the Class
    When the user scans/enters the tag of different class than ULD class
    Then the system should validate the baggage class and the ULD class and display error message like "NO - WRONG ULD CLASS - ULD Class F, Bag Class J"

  #TC_BRS_Disruption_025
  #ATC_BRS_Disruption_013
  @TestRailId(id=C464767) @JiraStoryId(WBRE-196) @automation
  Scenario: Baggage class matches 
    Given the user has logged into the BELT application
    And the user has selected a location already
    And the user has launched the Disruption load bag feature
    And ULD is in Open status 
    And the user is attempting to load a bag of same class other that is registered on the disrupted ULD
    And user has entered the Class related ULD number 
    And all other disruption reconciliation checks of bag and ULD matches, including Class
    When the user scans/enters the tag of same class
    Then System will allow loading of bags to the ULD, with the following message in Green "YES Bag..Successfully Loaded.."


