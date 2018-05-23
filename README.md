OpsMx Web UI testing was developed with the help of Selenium Webdriver automation testing tool where test scritps were 
developed using programming language Java with Modular testing framework with the help of TestNG.

UITestBase.java class deals with the common functions used and this class responsible for loading the configuration 
from the “data driven.properties” file, initializing the web driver and login and logout.

Datadriven.properties file stores the information that remains static throughout the testing such as application URL, 
login credentials.

id.txt file has the object id's for each Canary ID's. Here we can provide the id numbers for which we want to run the test for.

Maven was used for building execution and dependency purpose. Ingetrating he TestNG dependency in POM.xml file and running 
this POM.xml file using Jenkins.
