@wasla 
Feature: WRE - Rack Bag

  #TC_RackBag_001
  #ATC_RackBag_001
  @TestRailId(id=) @JiraStoryId(WBRE-139) @automation
  Scenario: Successful racking validation with bag tag number
  	Given the user has logged into the WASLA application
    And the store IN is already done 
    And the user has selected a location to rack
    And  the user has launched the Rack feature
    And the user has entered or scanned the valid tag ref number 
		When the user scans, selects the rack from the list or enters the rack number manually where the bag needs to be racked
		And the scanned rack number belongs to the location selected 
		And then submits for available bags to racking 
		Then the system will show the OHD details and clicking on it will show full details
		And the user will click on Submit to rack
		And  the system will display Racking done successfully response

 
  #TC_RackBag_002
  #ATC_RackBag_002
  @TestRailId(id=) @JiraStoryId(WBRE-139) @automation
  Scenario: Successful racking validation with OHD number
  	Given the user has logged into the WASLA application
    And the store IN is already done
    And the user has selected a location to rack
    And  the user has launched the Rack feature
		When the user scans, selects the rack from the list or enters the rack number manually where the bag needs to be racked
    And the user has entered or scanned the valid OHD ref number 
		And the scanned rack number belongs to the location selected 
		And then submits for available bags to racking 
		Then the system will display Racking done successfully response
    
  #TC_RackBag_003
  #ATC_RackBag_003
  @TestRailId(id=) @JiraStoryId(WBRE-139) @automation
  Scenario: Racking validation failure -  NO OHD Found for the tag
  	Given the user has logged into the WASLA application
    And the user has selected a location to rack
    And  the user has launched the Rack feature
    And the scanned rack number belongs to the location selected 
    And the user scans, selects the rack from the list or enters the rack number manually where the bag needs to be racked
    When the user scans or enters the tag/OHD number and searches
    And then submits for available bags to racking 
		And No OHD is found for the tag  
		Then  the system will search and if no data found then will display error to the user No OHD exists for the tag number. Cannot rack the bag without OHD
		
 

	#TC_RackBag_004
  #ATC_RackBag_004
  @TestRailId(id=) @JiraStoryId(WBRE-139) @automation
  Scenario: Racking validation failure -  Racking OHD without store in
  	Given the user has logged into the WASLA application
    And the user has selected a location to rack
    And  the user has launched the Rack feature
    And the user scans, selects the rack from the list or enters the rack number manually where the bag needs to be racked
  	When the user scans or enters the tag/OHD number without store IN and searches
    And the bag is not logged in corresponding storage IN
		Then  the system will throw a message that Racking allowed only after storage



  #TC_RackBag_005
  #ATC_RackBag_005
  @TestRailId(id=) @JiraStoryId(WBRE-139) @automation
  Scenario: Racking validation failure -  Multiple OHD 
  	Given the user has logged into the WASLA application
    And the bag is logged in the main store
     And the user has selected a location to rack
    And  the user has launched the Rack feature
    And the user scans, selects the rack from the list or enters the rack number manually where the bag needs to be racked
  	When the user scans or enters the tag/OHD number with multiple OHD and searches
  	And the user will click on Submit to rack
		And there are multiple OHDs mapped to the tag 
		#Then  the system will display both the OHD and allow user to select the right one 
		#And on selection of the right OHD system will display Racking done successfully response
    
    
  #TC_RackBag_006
   #TC_RackBag_006
  #ATC_RackBag_006
  @TestRailId(id=) @JiraStoryId(WBRE-139) @automation
  Scenario: Racking validation failure -   Racking OHD to a different location 
  	Given the user has logged into the WASLA application
  	And OHD is logged main store  
    And the user has selected a location to rack
    And  the user has launched the Rack feature
    And user is attempting to rack the bag in the left luggage  
		#Then  the system will throw a message that Racking Location Should be Inside the Store : ABC 
		And  ABC can be any location - Customs, Main Store, etc
    
    
    #TC_RackBag_007
  #ATC_RackBag_007
  @TestRailId(id=) @JiraStoryId(WBRE-139) @automation
  Scenario: Racking validation failure -    Tag with OHD on closed status 
  	Given the user has logged into the WASLA application
    And the user has selected a location to rack
    And  the user has launched the Rack feature
    And the user scans, selects the rack from the list or enters the rack number manually where the bag needs to be racked
    When the user has entered or scanned the valid tag/OHD ref number 
    And the OHD is on close status 
		And the bag is being logged in the right location 
		Then  the system will throw a message  OHD not found
			