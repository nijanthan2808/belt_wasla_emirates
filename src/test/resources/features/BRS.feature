@belt
Feature: BRS - Load Bag

  #TC_BRS_LoadBag_001
  #ATC_BRS_LoadBag_001
  @TestRailId(id=) @JiraStoryId(WBRE-98) @JiraStoryId(WBRE-31) @automation
  Scenario: Load bag operation in valid ULD 
  	Given the user has logged into the BELT application
    And the user has selected a location already
    And  the user has launched the BRS load bag feature
    And the bag tag has a valid BSM existing in BELT
    When the user scans or enters a valid ULD number which can be loaded with bags 
    And the user scans or enters the bag tag number
    Then the system will display a confirmation message with a beep sound that the bag is loaded as YES - 01766450048 - Bag Loaded successfully
    And the system will also increment the bag count in the ULD 
 		And the system will display the tag number of the last bag loaded in the screen
 		
 		
  
  #TC_BRS_LoadBag_002
  #ATC_BRS_LoadBag_002
  @TestRailId(id=) @JiraStoryId(WBRE-22) @automation
  Scenario: Bag already loaded error validation
  	Given the user has logged into the BELT application
    And the user has selected a location already
    And  the user has launched the BRS load bag feature
    And the bag has already loaded on the ULD / flight
    When the user scans or enters a valid ULD number which can be loaded with bags 
    And the user scans or enters the bag tag number
    Then the system should play a long beep and give an error message as EK450048 - bag already loaded on ULDAEKD2222
    
  
  #TC_BRS_LoadBag_003
  #ATC_BRS_LoadBag_003
  @TestRailId(id=) @JiraStoryId(WBRE-22) @automation
  Scenario: BSM exists for multiple tags in more than one flight
  	Given the user has logged into the BELT application
    And the user has selected a location already
    And  the user has launched the BRS load bag feature
    And the bag tag has multiple BSMs  created against it 
    When the user scans or enters a valid ULD number which can be loaded with bags 
    And the user scans or enters the bag tag number
    Then the system should play a long beep and give an error message as EK450048 - bag already loaded on ULDAEKD2222
 
 
    
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		