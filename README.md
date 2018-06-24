# DBTestProject

This project contains the implamentation of the DBServer test for an automation position.

## Maven dependencies

- Guava
- Selenium
- TestNG
- WebDriverManager
- GSON


## Project organization
This project contains 4 packages like described below

+ Jsons -- This package contains:
	+  Customer's information into a Json file simulating a NOSQL database
	+  DataProvider class witch is the responsible for reading the json files and return all the data content into an object
+ Models -- This package contains:
	+ Customer.java witch is the model used to create an instance of Customer responsible for caring all the data returned from the DataProvider.java
+ PageOjects -- This package contains:
	+ CustomerIndex class witch is used to map all the used elements related to the Customer list page; This class also contains the iteration and validation methods also related to the list customer page
	+ NewCustomer class witch is used to map all the used elements related to the New Customer page; This class also contains the iteration and validation methods also related to the New Customer page
+ TestSuite -- This package contains:
	+ DBTest class containing the both tests required; The test methods was developed in order to have an easy way to read keeping it easy to identify all the test steps
	+ TestBase class witch is the responsible for the @BeforeTest and also the @AfterTest extended by the DBTest class; It also contains the WebDriver help methods creating the possibility to be used in any PageObject
