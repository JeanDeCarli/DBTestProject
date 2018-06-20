package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.Select;

import Models.Customer;
import testSuite.TestBase;

public class NewCustomer extends TestBase {

	public NewCustomer(WebDriver driver) {
		super(driver);
	}
	
	public NewCustomer setCustomerInformation(Customer customer) {
		getDriver().findElement(By.id("field-customerName")).sendKeys(customer.Name);
		getDriver().findElement(By.id("field-contactLastName")).sendKeys(customer.LastName);
		getDriver().findElement(By.id("field-contactFirstName")).sendKeys(customer.ContactFirstName);
		getDriver().findElement(By.id("field-phone")).sendKeys(customer.Phone);
		getDriver().findElement(By.id("field-addressLine1")).sendKeys(customer.AddressLine1);
		getDriver().findElement(By.id("field-addressLine2")).sendKeys(customer.AddressLine2);
		getDriver().findElement(By.id("field-city")).sendKeys(customer.City);
		getDriver().findElement(By.id("field-state")).sendKeys(customer.State);
		getDriver().findElement(By.id("field-postalCode")).sendKeys(customer.PostalCode);
		getDriver().findElement(By.id("field-country")).sendKeys(customer.Country);
		WebElement fromEmployeer = getDriver().findElement(By.id("field_salesRepEmployeeNumber_chosen"));
		Select fromEmployeerField = new Select(fromEmployeer);
		fromEmployeerField.selectByValue(customer.FromEmployeer);
		getDriver().findElement(By.id("field-creditLimit")).sendKeys(customer.CreditLimit);
		
		return this;
	}

}