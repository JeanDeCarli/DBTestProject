package testSuite;

import org.testng.annotations.Test;

import Jsons.DataProvider;
import PageObjects.CustomerIndex;

public class DBTest extends TestBase {

	@Test
	public void addNewCustomer() {
		new CustomerIndex(getDriver())
		.changeTheme()
		.clickOnNewCustomerButton()
		.setCustomerInformation(new DataProvider().getCustomer())
		.saveCustomerForm()
		.validateCustumerCreation();
	}
}