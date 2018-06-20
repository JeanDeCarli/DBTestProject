package PageObjects;

import org.openqa.selenium.By;
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
}
