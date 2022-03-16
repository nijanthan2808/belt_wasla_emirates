@wasla
Feature: BDO - Baggage Delivery Order

  #TC_BDO_006
  #ATC_BDO_006
  @TestRailId(id=) @JiraStoryId(WBRE-157) @automation
  Scenario: BDO - Default location validation for Customs user
    Given Custom the user has logged into the WASLA application
    And User has access to the Customs Feature
    When the user logged in
    Then the system will auto sets the location as CUSTSCAN with no option to change the location

  #TC_BDO_007
  #ATC_BDO_007
  @TestRailId(id=) @JiraStoryId(WBRE-157) @automation
  Scenario: BDO - BPA out successfully done by custom
    Given Custom the user has logged into the WASLA application
    And User has access to the Customs Feature
    When the user scans or enters the BDO Tag /Bag Tag / OHD Ref number and clicks on "enter"
    Then the system will display"Success" message in green
    And along with the tag details as Tag/OHD Nbr, Passenger Name, BDO Type, Bag Routing, Remarks (optional)
    And with option to enter text and buttons to Accept/Reject
    And on clicking on "Accept" system will display "Customs Status updated Successfully"

  #TC_BDO_008
  #ATC_BDO_008
  @TestRailId(id=) @JiraStoryId(WBRE-157) @automation
  Scenario: BDO - BPA out not done  successfully by custom
    Given Custom the user has logged into the WASLA application
    And User has access to the Customs Feature
    When the user scans or enters the BDO Tag /Bag Tag / OHD Ref number and clicks on "enter"
    Then the system will display message "FAILED'  in Red
    And with the tag details as Tag/OHD Tag Nbr, Passenger Name, BDO Type, Bag Routing,
    And Remarks/Accept/Reject should not be available

  #TC_BDO_009
  #ATC_BDO_009
  @TestRailId(id=) @JiraStoryId(WBRE-157) @automation
  Scenario: BDO - Customs rejection - BPA out is done for the tag
    Given Custom the user has logged into the WASLA application
    And User has access to the Customs Feature
    And the user has enterered the tag number got the info and success message
    When the user Rejects
    Then the system will display "Customs Status updated Successfully"

  #TC_BDO_010
  #ATC_BDO_010
  @TestRailId(id=) @JiraStoryId(WBRE-157) @automation
  Scenario: BDO - BDO not active
    Given Custom the user has logged into the WASLA application
    And User has access to the Customs Feature
    And the BDO is not in active status
    When the user scans or enters the BDO Tag / Bag Tag / OHD Ref number and clicks on "Enter"
    Then the system will display an error "Custom scan cannot be done. BDO not active" with a dismiss option

  #TC_BDO_011
  #ATC_BDO_011
  @TestRailId(id=) @JiraStoryId(WBRE-157) @automation
  Scenario: BDO - Multiple BDO for the given tag
    Given Custom the user has logged into the WASLA application
    And User has access to the Customs Feature
    And multiple BDO's are available for the scanned Tag / OHD number
    When the user scans or enters the Bag Tag Ref number and clicks on "Enter"
    Then the system will display all the non-delivered BDO's tagged to the bag tag and allow user the option to select the right one
    And on selection the Featurealities covered under the story should be followed

  #TC_BDO_012
  #ATC_BDO_012
  @TestRailId(id=) @JiraStoryId(WBRE-157) @automation
  Scenario: BDO - BDO created at Left Luggage Location
    Given Custom the user has logged into the WASLA application
    And User has access to the Customs Feature
    And the BDO was created at left luggae location
    When the user scans or enters the Bag Tag Ref number and clicks on "Enter"
    Then the system will display an  error "Operation not allowed for BDO created at Left luggage" with dismiss option

  #TC_BDO_013
  #ATC_BDO_013
  @TestRailId(id=) @JiraStoryId(WBRE-157) @automation
  Scenario: BDO - Custom  Scan for already failed / rejected scan
    Given Custom the user has logged into the WASLA application
    And User has access to the Customs Feature
    And Custom Scan has already failed or rejected for a Tag/OHD
    When Custom user scans the same Tag/ OHD
    Then System should warn the user "Last failed Scan on this bag was done on MMM DD, YY at HH:MM by user code (staff who did the last Reject/failed scan).
    And The rejection/failed details should be shown of the last rejection/failed action in case of multiple failed scenarios with option to dismiss

  #TC_BDO_014
  #ATC_BDO_014
  @TestRailId(id=) @JiraStoryId(WBRE-157) @automation
  Scenario: BDO - Custom  Scan for already failed / rejected scan - Dismiss option
    Given Custom the user has logged into the WASLA application
    And User has access to the Customs Feature
    And Custom Scan has already failed or rejected for a Tag/OHD
    When Custom user scans the same Tag/ OHD and get the last scan failed details
    And user clicks on Dismiss option available
    Then system will display the details of the tag and allow the user to accept/reject

  #TC_BDO_015
  #ATC_BDO_015
  @TestRailId(id=) @JiraStoryId(WBRE-157) @automation
  Scenario: BDO -	Customs scan on a tag already accepted
    Given Custom the user has logged into the WASLA application
    And User has access to the Customs Feature
    And Custom Scan has already accepted
    When Custom user scans the same Tag/ OHD
    Then the system will display an warning "Operation not allowed – customs scan already done" with dismiss option

