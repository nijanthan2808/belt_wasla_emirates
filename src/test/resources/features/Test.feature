@wasla
Feature: Test BDO


 #TestCase_001
  #can provide the tags that has to be labled for this test  
  @TestRailId(id=) @JiraStoryId() @automation
  Scenario: login to the application and order one t-shirt
    Given the user has launched the application
    And   logged into the application
    And   goto t-shirt section
    And   add the t-shirt to cart
    And   proceed to checkout and increase the quantity
    And   proceed to checkout and enter message
    And   proceed to checkout and agree terms 
    And   proceed to checkout and choose payment
    When  the user confirms the order
    Then  the order placed and verified
    And   user signed out of the application
    
   