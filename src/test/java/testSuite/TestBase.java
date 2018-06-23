package testSuite;

import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TestBase {
	private WebDriver driver = null;
	
	public TestBase() {
	}
	
	public TestBase(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
  @BeforeTest
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  this.driver = new ChromeDriver();
	  this.driver.manage().window().maximize();
	  this.driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
  }

  @AfterTest
  public void afterClass() {
	  if(this.driver != null){
		  this.driver.quit();
	  }
  }
  
  public void waitElementToBeVisible(WebElement element){
	  for (int i = 0; !element.isDisplayed() && i < 5; i++) {
		  try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
  }
  
  public void waitAfterSearch(String result){
	  for (int i = 0; !this.driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(3)")).getText().contains(result) && 
			  i < 5; i++) {
		  try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
  }
}
