# Testing

TestNG -Test automation framework developed using Java and Selenium with page object model.
Developed as a Maven project that can be easily integrated with Jenkins and run the test. 


***************************************************About the project*********************************************

Test automation framework contains following packages and files as shown in the below image
1. Project: Testing
2. Packages

1. pageObjectsPackage
This package contains all the page classes. All the static methods that are defined in the each page class can be re used 
in test classes by importing the class to perform actions on web elements.

2.	testClassPackage.
This package contains test classes where all the test cases are written using the methods that are defined in page 
classes to validate expense tracker end to end as per the user stories.

3. Xml files.
 	1. pom.xml
Contains all the plugins and dependencies that are required to run the test as maven project. TestNG.xml is configured 
in this pom.xml to trigger the test.

	2.TestNG.xml
	Contains the all class names that are to be triggered to run the complete suite of test cases.

4. Test Output folders.
Reports like index.html and testng-results.xml are generated under these folders once the test is run. 
reportPath = baseDirecotry + "target/surefire-reports/index.html"
****************************************************************************************************************************


Instructions to run the test automation:

Method1 : To Run as Maven Project locally

1. Install and set up Java

2. Install and set up Maven plugin

3. Clone the project.
4. Open Eclipse IDE , from file menu press import -> Maven -> Existing maven projects
Run as maven project. use below commands to run
Navigate to the project main folder using terminal or cmd and type below commands
mvn compile
mvn test

************************************************************************************************************************************

Method2 : To Run as Maven Project using Jenkins

3. Install and set up Jenkins
Fork the project to your account 
Configure to Jenkins as maven project and build the test.


**********************************************************************************************************************************

Method3 : To Run manually

4. Download all the below required jars and configure in buld path

  • Download and add Selenium Jars to the project build path
    Go to http://www.seleniumhq.org/download/
    Download Selenium Client & WebDriver Language Bindings for Java and add to Java build path.
    
  • Download and set Web driver for example chromedriver to invoke the Chrome browser.
  
  •TestNG set up
   Add TestNG plug in to eclipse:
	  
    Download and add TestNG JAR files to the Java build path. Refer below links to download jar files
    https://mvnrepository.com/artifact/org.testng/testng/6.11   
    
  • Download the project, Update the webdriver path in main/ChromeDriverManager
    Open the project using IDE and run the TestNG.xml as testng suite to obtain the results.


