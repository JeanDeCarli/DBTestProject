package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testSuite.TestBase;

public class CustomerIndex extends TestBase{
	
	private static String themeSelector = "switch-version-select";
	private static String newCustomerButtonSelector = ".header-tools div.t5 a.btn-default";
	private static String searchCustomerButtonSelector = "a.search-button";
	private static String searchCustomerFieldSelector = "search-input";
	private static String checkAllCustomerSelector = "select-all-none";
	private static String deleteButtonSelector = "delete-selected-button";
	private static String deleteConfirmationMessageSelector = "p.alert-delete-multiple-one";
	private static String deleteConfirmationButtonSelector = "delete-multiple-confirmation-button";
	private static String successDeletedMessageSelector = "div.alert-success span p";
	private static String deletefeedbackMessage = "Your data has been successfully deleted from the database.";
	private static String deleteConfirmationMessage = "Are you sure that you want to delete this 1 item?";
	private static String themeValue = "bootstrap_theme_v4";
	
  public CustomerIndex(WebDriver driver) {
	  super(driver);
  }
  
  public CustomerIndex changeTheme() {
	  WebElement select = getDriver().findElement(By.id(themeSelector));
	  Select bootstrapVersion = new Select(select);
	  bootstrapVersion.selectByValue(themeValue);
	  return this;
  }
  
  public NewCustomer clickOnNewCustomerButton() {
	  getDriver().findElement(By.cssSelector(newCustomerButtonSelector)).click();
	  return new NewCustomer(getDriver());
  }
  
  public CustomerIndex SearchCustomerByName(String name) {
	  getDriver().findElement(By.cssSelector(searchCustomerButtonSelector)).click();
	  WebElement searchField = getDriver().findElement(By.className(searchCustomerFieldSelector));
	  searchField.sendKeys(name);
	  searchField.sendKeys(Keys.ENTER);
	  waitAfterSearch(name);
	  
	  return this;
  }
  
  public CustomerIndex selectAllCustomerToBeDeleted() {
	  WebElement checkBox = getDriver().findElement(By.className(checkAllCustomerSelector));
	  checkBox.click();
	  WebElement deleteButton = getDriver().findElement(By.className(deleteButtonSelector));
	  deleteButton.click();
	  
	  return this;
  }
  
  public CustomerIndex validateDeleteConfirmationMessage() {
	  WebElement message = getDriver().findElement(By.cssSelector(deleteConfirmationMessageSelector));
	  waitElementToBeVisible(message);
	  Assert.assertTrue(message.getText().contains(deleteConfirmationMessage));
	  
	  return this;
  }
  
  public CustomerIndex deleteCustomer() {
	  getDriver().findElement(By.className(deleteConfirmationButtonSelector)).click();
	  waitAfterDelete();
	  
	  return this;
  }
  
  public CustomerIndex validateDeletedMessageSuccessfully() {
	  WebElement message = getDriver().findElement(By.cssSelector(successDeletedMessageSelector));
	  Assert.assertTrue(message.getText().contains(deletefeedbackMessage));
	  
	  return this;
  }
}
