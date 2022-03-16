***************************** Test Automation Framework *****************************

About the Framework:
•	This framework is designed to automate the web/browser based applications.
•	This framework is built on top of Selenium and Cucumber BDD frameworks and concepts. 
•	Java is the language used to code the logics in this framework along with Selenium.
•	This framework can be further extended with the use of Appium and can be used to automate mobile applications.
•	Maven is used as build tool for this framework.
•	Since Maven is used, all the dependencies are captured in the pom.xml and will be downloaded while execution. 
•	Hence there will be no dependencies on the creator's machine. Can be imported and used anyone's machine.
•	Page Object Model methodology is used to manage the elements of the application pages and actions on those elements.
•	All the data and credentials are kept in property file (can use any format of file) which ensures there is no hardcoding in the script.
•	So, whenever there is a change in data, configuration, locator or any other objects it's a one place change in the property files.
•	Page objects, Test steps, Test runner, Setups, Utilities and other major modules are kept in separate class files.
•	Any method of a class can be accessed and used from other classes with the help of inheritance. 
		
Importing the project:
Pre requisites:
•	Java installed in machine - JDK 1.8 or higher
•	IDE – Eclipse(Preferred) or IntelliJ 

Steps to Import Project:
•	Download the project zip file and extract.
•	Import the extracted folder in IDE.
•	Right click on the project and go to Maven -> Update Project.
•	The dependencies specified in pom.xml will start to download.
•	Based on the browser version in user machine we can download the appropriate driver from seleniumhq and replace in ‘src/test/resources/drivers’.

Information & Understanding the framework:
•	This project included the whole test automation pack created for one of our applications in Emirates Airlines – The application called BELT-WASLA.
•	The process of the framework starts from TestRunner.java - ‘./src/test/java/com/beltWasla/runners/TestRunner.java’ is the runner file that specifies which test files/feature files to execute and other initializing.
•	 The ‘.feature’ files which is in ‘com.beltWasla.features’ package in src/test/java folder are the test cases that needs to be implemented and executed.
•	This ‘.feature’ files are the test case files and the steps of those test cases are implemented in ‘com.beltWasla.steps’ package inside src/test/java folder.
•	All the pages of the application and its page objects are captured in ‘com.beltWasla.pages’ inside src/test/java folder.
•	These page classes will also have the actions done on those page objects as methods which will be called and used in steps classes.
•	Since this application cannot be used outside my organisation, to use and execute this framework I have automated a test webpage for one scenario for this demonstration purpose.
•	The scenario will be in ‘./src/test/java/com/beltWasla/features/Test.feature’. This is the test case. 
•	And the steps will be implemented in ‘./src/test/java/com/beltWasla/steps/TestSteps.java’.
•	Page Objects are captured and methods are created for actions on the objects are in ‘./src/test/java/com/beltWasla/pages/TestPage.java’.
•	Other credentials, Configurations and data are kept under ‘./src/test/resources/properties’ folder.
•	Reports and Screenshots are disabled for demo.

To run the pack:
•	Right click on project and go to Run as -> maven test
•	Or Right click on project and go to Show in Terminal -> Terminal and then enter ‘mvn test’
 

	
	
	
	
