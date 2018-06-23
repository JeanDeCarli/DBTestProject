package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Models.Customer;
import junit.framework.Assert;
import testSuite.TestBase;

public class NewCustomer extends TestBase {

	public NewCustomer(WebDriver driver) {
		super(driver);
	}
	
	public NewCustomer setCustomerInformation(Customer customer) {
		getDriver().findElement(By.id("field-customerName")).sendKeys(customer.getName());
		getDriver().findElement(By.id("field-contactLastName")).sendKeys(customer.getLastName());
		getDriver().findElement(By.id("field-contactFirstName")).sendKeys(customer.getContactFirstName());
		getDriver().findElement(By.id("field-phone")).sendKeys(customer.getPhone());
		getDriver().findElement(By.id("field-addressLine1")).sendKeys(customer.getAddressLine1());
		getDriver().findElement(By.id("field-addressLine2")).sendKeys(customer.getAddressLine2());
		getDriver().findElement(By.id("field-city")).sendKeys(customer.getCity());
		getDriver().findElement(By.id("field-state")).sendKeys(customer.getState());
		getDriver().findElement(By.id("field-postalCode")).sendKeys(customer.getPostalCode());
		getDriver().findElement(By.id("field-country")).sendKeys(customer.getCountry());
		this.selectFromEmployeer(customer.getFromEmployeer());
		getDriver().findElement(By.id("field-creditLimit")).sendKeys(customer.getCreditLimit());
		
		return this;
	}
	
	public NewCustomer selectFromEmployeer(String value) {
		getDriver().findElement(By.id("field_salesRepEmployeeNumber_chosen")).click();
		WebElement fakeSelect =  getDriver()
				.findElement(By.cssSelector("#field_salesRepEmployeeNumber_chosen div.chosen-search input"));
		fakeSelect.sendKeys(value);
		fakeSelect.sendKeys(Keys.TAB);
				
		return this;
	}
	
	public NewCustomer saveCustomerForm() {
		getDriver().findElement(By.id("form-button-save")).click();
		
		return this;
	}
	
	public NewCustomer validateCustumerCreation() {
		//WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("report-success")));
		
		
		Assert.assertTrue(getDriver().findElement(By.id("report-success")).getText()
				.contains("Your data has been successfully stored into the database"));
		
		return this;
	}
}