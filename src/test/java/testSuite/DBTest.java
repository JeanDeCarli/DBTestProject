package testSuite;

import org.testng.annotations.Test;

import Jsons.DataProvider;
import Models.Customer;
import PageObjects.CustomerIndex;

public class DBTest extends TestBase {

	@Test
	public void addNewCustomer() {
		Customer customer = new DataProvider().getCustomer();
		new CustomerIndex(getDriver())
		.changeTheme()
		.clickOnNewCustomerButton()
		.setCustomerInformation(customer)
		.saveCustomerForm()
		.validateCustumerCreation();
	}
	
	@Test
	public void deleteCreatedCusomer() {
		Customer customer = new DataProvider().getCustomer();
		new CustomerIndex(getDriver())
		.changeTheme()
		.clickOnNewCustomerButton()
		.setCustomerInformation(customer)
		.saveCustomerForm()
		.validateCustumerCreation()
		.goBackToCustomerList()
		.SearchCustomerByName(customer.getName())
		.selectSearchedCustomerToBeDeleted()
		.validateDeleteConfirmationMessage()
		.deleteCustomer()
		.validateDeletedMessageSuccessfully();
	}
}