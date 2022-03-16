@belt
Feature: BRS - Load Bag

  #TC_BRS_LoadBag_001
  #ATC_BRS_LoadBag_001
  @TestRailId(id=) @JiraStoryId(WBRE-54) @automation
  Scenario: Unregistered ULD validation
    Given the user has logged into the BELT application
    And the user has access to BRS load bag feature
    And the user role is either 0 or 1
    And the user has selected a location already
    And the user has launched the BRS load bag feature
    And the ULD not registered
	When the user scans / enters the unregistered ULD number
    Then the system will throw an error message as Invalid ULD or ULD not registered
    And the long beep sound will be played

  #TC_BRS_LoadBag_002
  #ATC_BRS_LoadBag_002
  @TestRailId(id=) @JiraStoryId(WBRE-54) @JiraStoryId(WBRE-56) @automation
  Scenario: Closed ULD validation
    Given the user has logged into the BELT application
    And the user has access to BRS load bag feature
    And the user role is either 0 or 1
    And the user has selected a location already
    And the user has launched the BRS load bag feature
    And the ULD is in Closed status
	When the user scans / enters the Closed ULD number
    Then the system will throw an error message as ULD not open for loading
    And the long beep sound will be played

  #TC_BRS_LoadBag_003
  #ATC_BRS_LoadBag_003
  @TestRailId(id=) @JiraStoryId(WBRE-54) @JiraStoryId(WBRE-56) @automation
  Scenario: Dispatched ULD validation
    Given the user has logged into the BELT application
    And the user has access to BRS load bag feature
    And the user role is either 0 or 1
    And the user has selected a location already
    And the user has launched the BRS load bag feature
    And the ULD is in Dispatched status
	When the user scans / enters the Dispatched status ULD number
    Then the system will throw an error message as ULD not open for loading
    And the long beep sound will be played

  #TC_BRS_LoadBag_004
  #ATC_BRS_LoadBag_004
  @TestRailId(id=) @JiraStoryId(WBRE-54) @JiraStoryId(WBRE-56) @automation
  Scenario: Dispatched STG ULD validation
    Given the user has logged into the BELT application
    And the user has access to BRS load bag feature
    And the user role is either 0 or 1
    And the user has selected a location already
    And the user has launched the BRS load bag feature
    And the ULD is in Dispatched STG status
	When the user scans / enters the Dispatched STG status ULD number
    Then the system will throw an error message as ULD not open for loading
    And the long beep sound will be played

  #TC_BRS_LoadBag_005
  #ATC_BRS_LoadBag_005
  @TestRailId(id=) @JiraStoryId(WBRE-54) @JiraStoryId(WBRE-56) @automation
  Scenario: Ramp ULD validation
    Given the user has logged into the BELT application
    And the user has access to BRS load bag feature
    And the user role is either 0 or 1
    And the user has selected a location already
    And the user has launched the BRS load bag feature
    And the ULD is in Ramp status
	When the user scans / enters the Ramp status ULD number
    Then the system will throw an error message as ULD not open for loading
    And the long beep sound will be played

  #TC_BRS_LoadBag_006
  #ATC_BRS_LoadBag_007
  @TestRailId(id=) @JiraStoryId(WBRE-54) @JiraStoryId(WBRE-56) @automation
  Scenario: Positioned ULD validation
    Given the user has logged into the BELT application
    And the user has access to BRS load bag feature
    And the user role is either 0 or 1
    And the user has selected a location already
    And the user has launched the BRS load bag feature
    And the ULD is in Positioned status
    When the user scans / enters the Positioned status ULD number
    Then the system will throw an error message as ULD not open for loading
    And the long beep sound will be played

  #TC_BRS_LoadBag_008
  #ATC_BRS_LoadBag_008
  @TestRailId(id=) @JiraStoryId(WBRE-63) @automation	
  Scenario: Tag deleted - Single BSM
  	Given the user has logged into the BELT application
  	And the user has access to BRS load bag feature
    And the user role is either 0 or 1
 	And the user has selected a location already
 	And the user has launched the BRS load bag feature
 	And the tag has been already deleted
 	When the user scans or enters a valid ULD number which can be loaded with bags
 	And the user scans or enters the Single BSM deleted bag tag number
 	Then the system will display 'NO - DELETED TAG' Press 'dismiss' to continue
 	And the long beep sound will be played

  #TC_BRS_LoadBag_009
  #ATC_BRS_LoadBag_009
  @TestRailId(id=) @JiraStoryId(WBRE-63) @automation	
  Scenario: BSM exists for multiple tags in more than one flight - Loader user
  	Given the user has logged into the BELT application
  	And the user has access to BRS load bag feature
    And the user role is either 0 or 1
 	And the user has selected a location already
 	And the user has launched the BRS load bag feature
 	And the bag tag has multiple BSMs created against it
 	When the user scans or enters a valid ULD number which can be loaded with bags
 	And the user scans or enters the Multi BSM bag tag number 
 	Then the system will throw an error as 'Duplicate Tag' available
 	And the long beep sound will be played 	

  #TC_BRS_LoadBag_001
  #ATC_BRS_LoadBag_010
  @TestRailId(id=C464746) @JiraStoryId(WBRE-98) @automation
  Scenario: Load bag operation in valid ULD
    Given the user has logged into the BELT application
    And the user has access to BRS load bag feature
    And the user role is either 0 or 1
    And the user has selected a location already
    And the user has launched the BRS load bag feature
    And the bag tag has a valid BSM existing in BELT
    When the user scans or enters a valid ULD number which can be loaded with bags
    And the user scans or enters the bag tag number
    Then the confirmation message is displayed with a beep sound that the bag is loaded successfully e.g. YES - Bag Tag Number - Bag Loaded successfully
    And the system will also increment the bag count in the ULD
    And the system will display the tag number of the last bag loaded in the screen

 #TC_BRS_LoadBag_002
  #ATC_BRS_LoadBag_011
  @TestRailId(id=C464747) @JiraStoryId(WBRE-22) @automation
  Scenario: Bag already loaded error validation
    Given the user has logged into the BELT application
    And the user has access to BRS load bag feature
    And the user role is either 0 or 1
    And the user has selected a location already
    And the user has launched the BRS load bag feature
    And the bag has already loaded on the ULD / flight
    When the user scans or enters a valid ULD number which can be loaded with bags
    And the user scans or enters the bag tag number
    Then the system should play a long beep and give an error message as Bag already Loaded
   
  #TC_BRS_LoadBag_012
  #ATC_BRS_LoadBag_012
  @TestRailId(id=) @JiraStoryId(WBRE-59) @automation
  Scenario: ULD Capacity - Maximum load warning validation
    Given the user has logged into the BELT application
    And the user has access to BRS load bag feature
    And the user role is either 0 or 1
    And the user has selected a location already
    And the user has launched the BRS load bag feature
    And ULD is on Open status
    And the user scans or enters a valid ULD number which can be loaded with bags
	And ULD Maximum capacity threshold has been defined 
	And reconciliation checks of bag and ULD matches 
	And the user is attempting to load the bag which is overshooting the ULD capacity  
	When the user scans/enters the tag 
	Then  the system will throw an error ULD Maximum Capacity Reached 

  #TC_BRS_LoadBag_013
  #ATC_BRS_LoadBag_013
  @TestRailId(id=) @JiraStoryId(WBRE-53) @automation
  Scenario: No BSM exists for the tag
    Given the user has logged into the BELT application
    And the user has access to BRS load bag feature
    And the user role is either 0 or 1
    And the user has selected a location already
    And the user has launched the BRS load bag feature
    And there is no BSM available with the tag
    When the user scans or enters a valid ULD number which can be loaded with bags
    And the user scans or enters the No BSM bag tag number
    Then the system will display NO UNKNOWN TAG/BAG NOT ELIGIBLE FOR LOADING
    And the long beep sound will be played

  #TC_BRS_LoadBag_030
  #ATC_BRS_LoadBag_014
  @TestRailId(id=C464743) @JiraStoryId(WBRE-68) @automation
  Scenario:  Not Authorised to load by DCS validation
    Given the user has logged into the BELT application
    And the user has access to BRS load bag feature
    And the user role is either 0 or 1
    And the user has selected a location already
    And the user has launched the BRS load bag feature
    And ULD is on Open status
    And user has entered the ULD number
    And reconciliation checks of bag and ULD matches
	And the user is attempting to load the bag
	And bag is not authorised to load or bag is NATL or standby
	When the user scans/enters the NATL bag tag
	Then the system will throw error and display NOT AUTHORISED TO LOAD
	
  #TC_BRS_LoadBag_015
  #ATC_BRS_LoadBag_015
  @TestRailId(id=) @JiraStoryId(WBRE-64) @automation
  Scenario: Flight number validations 
    Given the user has logged into the BELT application
    And the user has access to BRS load bag feature
    And the user role is either 0 or 1
    And the user has selected a location already
    And the user has launched the BRS load bag feature
    And ULD is on Open status
    And user has entered the ULD number		
	And the user is attempting to load the bag on a different flight and date
	When the user scans/enters the tag from different flight
	Then the system will throw an error and display NO - WRONG FLIGHT, Bag Belongs to EKxxxx/13Nov19 
	And the user will dismiss and proceed
	
  #TC_BRS_LoadBag_016
  #ATC_BRS_LoadBag_016
  @TestRailId(id=) @JiraStoryId(WBRE-58) @automation
  Scenario: Baggage class mismatch validation
    Given the user has logged into the BELT application
     And the user has access to BRS load bag feature
    And the user role is either 0 or 1
    And the user has selected a location already
    And the user has launched the BRS load bag feature
    And ULD is on Open status
    And the user is attempting to load a bag for different class other than the one that is registered on the ULD
    And user has entered the ULD number of specific class
    And all other reconciliation checks of bag and ULD matches  except for the class
    And system displays the ULD details - Flight Number / Date / STD / ULD No. / Destination / Class/Category / Bay / Bag Count / Staff Number / last successfully loaded bag in the current transaction
    When the user scans/enters the tag of different class
    Then the system will throw an error and display No WRONG ULD CLASS
    
  #TC_BRS_LoadBag_027
  #ATC_BRS_LoadBag_017
  @TestRailId(id=C464741) @JiraStoryId(WBRE-65) @automation
  Scenario: Category Mismatch Validation
    Given the user has logged into the BELT application
    And the user has access to BRS load bag feature
    And the user role is either 0 or 1
    And the user has selected a location already
    And the user has launched the BRS load bag feature
    And ULD is on Open status
    And user has entered the ULD number of specific category		
	And the flight/date is valid  
	And the user is attempting to load the bag of given category to a different category of ULD 
	When the user scans/enters the tag of different category
	Then the system will throw an error and display NO Wrong ULD type 
	
  #TC_BRS_LoadBag_018
  #ATC_BRS_LoadBag_018
  @TestRailId(id=) @JiraStoryId(WBRE-61) @automation
  Scenario: Inbound segregation validation
    Given the user has logged into the BELT application
    And the user has access to BRS load bag feature
    And the user role is either 0 or 1
    And the user has selected a location already
    And the user has launched the BRS load bag feature
    And ULD is on Open status
    And user has entered the ULD number	specific to IB segregation
    And the inbound segregation doesn't match and rest of the checks match with that of the ULD  
	And Best ULD does not exist
	And the user is attempting to load the bag  
	When the user scans/enters the tag which is not meant to be loaded onto this ULD or is not part of the inbound segregation 
	Then the system will throw an error and display 'ULD Inbound Segregation rules does not match with Bag'
		
  #TC_BRS_LoadBag_019
  #ATC_BRS_LoadBag_019
  @TestRailId(id=) @JiraStoryId(WBRE-63) @automation
  Scenario: Special Segregation for Single and Multiple BSMs
    Given the user has logged into the BELT application
    And the user has access to BRS load bag feature
    And the user role is either 0 or 1
    And the user has selected a location already
    And the user has launched the BRS load bag feature
    And ULD is on Open status			
	And user has entered the ULD number	specific to special segregation
	And the user is attempting to load the bag  
	When the user scans/enters the tag of special segregation
	Then the system will throw an error and display NO WRONG ULD 
	And will not allow the user to load the bag on that ULD 

 
  #TC_BRS_LoadBag_020
  #ATC_BRS_LoadBag_020
  @TestRailId(id=) @JiraStoryId(WBRE-63) @automation	
  Scenario: Best ULD prompt validation 
	Given the user has logged into the BELT application
	And the user has access to BRS load bag feature
    And the user role is either 0 or 1
	And the user has selected a location already
 	And the user has launched the BRS load bag feature
 	And ULD is on Open status
 	And the user is attempting to load the bag which is of a specific cabin class and the ULD is of mixed class and ULD for Y class already exists
 	When the user scans/enters the tag which can be loaded in BEST ULD
 	Then the system will throw an error and display WRONG ULD, BEST ULD - ..... IS AVAILABLE Y Class
   	
  #TC_BRS_LoadBag_021
  #ATC_BRS_LoadBag_021
  @TestRailId(id=) @JiraStoryId(WBRE-63) @automation	
  Scenario: Sector Validations for Single and Multiple BSMs
  	Given the user has logged into the BELT application
  	And the user has access to BRS load bag feature
    And the user role is either 0 or 1
 	And the user has selected a location already
 	And the user has launched the BRS load bag feature
 	And ULD is on Open status
	And ULD is registered for the other leg of the same flight 
 	And the user is attempting to load the bag for a shorter leg on a multi-leg flight for which the ULD is not registered
 	When the user scans/enters the tag of different destination than ULD
 	Then the system will display an error to the user NO - WRONG ULD DESTINATION 
  
  #TC_BRS_LoadBag_034
  #ATC_BRS_LoadBag_022
  @TestRailId(id=C464745) @JiraStoryId(WBRE-) @automation	
  Scenario: Close ULD/OffLoad Bag button Disabled - Loader User
  	Given the user has logged into the BELT application
  	And the user has access to BRS load bag feature
    And the user role is either 0 or 1
	And the user has selected a location already
	And the user has launched the BRS load bag feature
	When the user scans or enters a valid ULD number which can be loaded with bags
	Then the CloseULD and OffLoad Bag buttons should be Disabled
	
  #TC_BRS_LoadBag_035
  #ATC_BRS_LoadBag_023
  @TestRailId(id=) @JiraStoryId(WBRE-61) @automation
  Scenario: Outbound segregation validation
    Given the user has logged into the BELT application
    And the user has access to BRS load bag feature
    And the user role is either 0 or 1
    And the user has selected a location already
    And the user has launched the BRS load bag feature
    And ULD is on Open status
    And user has entered the ULD number	specific to OB segregation
    And the outbound segregation doesn't match and rest of the checks match with that of the ULD  
	And Best ULD does not exist
	And the user is attempting to load the bag  
	When the user scans/enters the tag which is not meant to be loaded onto this ULD or is not part of the outbound segregation 
	Then the system will throw an error and display 'ULD outbound Segregation rules does not match with Bag'
	
  #TC_BRS_LoadBag_009
  #ATC_BRS_LoadBag_009
  @TestRailId(id=) @JiraStoryId(WBRE-63) @automation	
  Scenario: BSM exists for multiple tags in the same flight - Loader user
  	Given the user has logged into the BELT application
  	And the user has access to BRS load bag feature
    And the user role is either 0 or 1
 	And the user has selected a location already
 	And the user has launched the BRS load bag feature
 	And the bag tag has multiple BSMs created against it
 	When the user scans or enters a valid ULD number which can be loaded with bags
 	And the user scans or enters the Multi BSM bag tag number for same flight
 	Then the system will throw an error as 'Duplicate Tag' available
 	And the long beep sound will be played 	
  	