package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Models.Customer;
import junit.framework.Assert;
import testSuite.TestBase;

public class NewCustomer extends TestBase {
	
	private static String customerNameFieldSelector = "field-customerName";
	private static String contactLastNameFieldSelector = "field-contactLastName";
	private static String contactFirstNameFieldSelector = "field-contactFirstName";
	private static String phoneFieldSelector = "field-phone";
	private static String addressLine1FieldSelector = "field-addressLine1";
	private static String addressLine2FieldSelector = "field-addressLine2";
	private static String cityFieldSelector = "field-city";
	private static String stateFieldSelector = "field-state";
	private static String postalCodeFieldSelector = "field-postalCode";
	private static String countryFieldSelector = "field-country";
	private static String creditLimitFieldSelector = "field-creditLimit";
	private static String fromEmployeeSelector = "field_salesRepEmployeeNumber_chosen";
	private static String fromEmployeeFieldSelector = "#field_salesRepEmployeeNumber_chosen div.chosen-search input";
	private static String saveButtonSelector = "form-button-save";
	private static String successFeedbackSelector = "report-success";
	private static String backToCustomerLinkSelector = "#report-success a:nth-child(2)";
	private static String customerSuccessfullyAddedMessage = "Your data has been successfully stored into the database";
	
	public NewCustomer(WebDriver driver) {
		super(driver);
	}
	
	public NewCustomer setCustomerInformation(Customer customer) {
		getDriver().findElement(By.id(customerNameFieldSelector)).sendKeys(customer.getName());
		getDriver().findElement(By.id(contactLastNameFieldSelector)).sendKeys(customer.getLastName());
		getDriver().findElement(By.id(contactFirstNameFieldSelector)).sendKeys(customer.getContactFirstName());
		getDriver().findElement(By.id(phoneFieldSelector)).sendKeys(customer.getPhone());
		getDriver().findElement(By.id(addressLine1FieldSelector)).sendKeys(customer.getAddressLine1());
		getDriver().findElement(By.id(addressLine2FieldSelector)).sendKeys(customer.getAddressLine2());
		getDriver().findElement(By.id(cityFieldSelector)).sendKeys(customer.getCity());
		getDriver().findElement(By.id(stateFieldSelector)).sendKeys(customer.getState());
		getDriver().findElement(By.id(postalCodeFieldSelector)).sendKeys(customer.getPostalCode());
		getDriver().findElement(By.id(countryFieldSelector)).sendKeys(customer.getCountry());
		this.selectFromEmployeer(customer.getFromEmployeer());
		getDriver().findElement(By.id(creditLimitFieldSelector)).sendKeys(customer.getCreditLimit());
		
		return this;
	}
	
	public NewCustomer selectFromEmployeer(String value) {
		getDriver().findElement(By.id(fromEmployeeSelector)).click();
		WebElement fakeSelect =  getDriver().findElement(By.cssSelector(fromEmployeeFieldSelector));
		fakeSelect.sendKeys(value);
		fakeSelect.sendKeys(Keys.TAB);
				
		return this;
	}
	
	public NewCustomer saveCustomerForm() {
		getDriver().findElement(By.id(saveButtonSelector)).click();
		
		return this;
	}
	
	public NewCustomer validateCustumerCreation() {
		WebElement successFeedback = getDriver().findElement(By.id(successFeedbackSelector));
		waitElementToBeVisible(successFeedback);
		
		Assert.assertTrue(successFeedback.getText().contains(customerSuccessfullyAddedMessage));
		
		return this;
	}
	
	public CustomerIndex goBackToCustomerList() {
		WebElement backButton = getDriver().findElement(By.cssSelector(backToCustomerLinkSelector));
		waitElementToBeVisible(backButton);
		backButton.click();
		
		return new CustomerIndex(getDriver());
	}
}