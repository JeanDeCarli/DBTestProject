package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testSuite.TestBase;

public class CustomerIndex extends TestBase{
	
  public CustomerIndex(WebDriver driver) {
	  super(driver);
  }
  
  public CustomerIndex changeTheme() {
	  WebElement select = getDriver().findElement(By.id("switch-version-select"));
	  Select bootstrapVersion = new Select(select);
	  bootstrapVersion.selectByValue("bootstrap_theme_v4");
	  return this;
  }
  
  public NewCustomer clickOnNewCustomerButton() {
	  getDriver().findElement(By.cssSelector(".header-tools div.t5 a.btn-default")).click();
	  return new NewCustomer(getDriver());
  }
  
  public CustomerIndex SearchCustomerByName(String name) {
	  getDriver().findElement(By.cssSelector("a.search-button")).click();
	  WebElement searchField = getDriver().findElement(By.className("search-input"));
	  searchField.sendKeys(name);
	  searchField.sendKeys(Keys.ENTER);
	  waitAfterSearch(name);
	  
	  return this;
  }
  
  public CustomerIndex selectSearchedCustomerToBeDeleted() {
	  WebElement checkBox = getDriver().findElement(By.className("select-all-none"));
	  checkBox.click();
	  WebElement deleteButton = getDriver().findElement(By.className("delete-selected-button"));
	  deleteButton.click();
	  
	  return this;
  }
  
  public CustomerIndex validateDeleteConfirmationMessage() {
	  WebElement message = getDriver().findElement(By.cssSelector("p.alert-delete-multiple-one"));
	  waitElementToBeVisible(message);
	  Assert.assertTrue(message.getText().contains("Are you sure that you want to delete this 1 item?"));
	  
	  return this;
  }
  
  public CustomerIndex deleteCustomer() {
	  getDriver().findElement(By.className("delete-multiple-confirmation-button"));
	  
	  return this;
  }
  
  public CustomerIndex validateDeletedMessageSuccessfully() {
	  WebElement message = getDriver().findElement(By.cssSelector("div.alert-success span p"));
	  Assert.assertTrue(message.getText().contains("Your data has been successfully deleted from the database."));
	  
	  return this;
  }
}
