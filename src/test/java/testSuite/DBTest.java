package testSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PageObjects.CustomerIndex;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class DBTest extends TestBase {

	@Test
	public void addNewCustomer() {
		new CustomerIndex(driver)
		.changeTheme()
		.clickOnNewCustomerButton();
	}
}