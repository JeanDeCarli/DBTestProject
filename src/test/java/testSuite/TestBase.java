package testSuite;

import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class TestBase {
	public WebDriver driver = null;
	
	public TestBase() {
	}
	public TestBase(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  this.driver = new ChromeDriver();
	  this.driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
  }

  @AfterClass
  public void afterClass() {
	  if(this.driver != null){
		  driver.quit();
	  }
  }
}
