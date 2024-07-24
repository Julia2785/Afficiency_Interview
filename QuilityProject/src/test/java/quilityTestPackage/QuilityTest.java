package quilityTestPackage;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QuilityTest {
	
	public String baseUrl = "https://quility-test.afficiency.com/?affiliateCode=SFG0000003";
	public WebDriver driver ;
	JavascriptExecutor js;
	
	@BeforeClass
	public void LaunchBrowser() throws InterruptedException {
		
		this.driver = new ChromeDriver(); 
		this.driver.manage().window().maximize();
		this.driver.get(baseUrl);
		Thread.sleep(2000);
		 js = (JavascriptExecutor) driver; 
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
 
 
  @Test(dataProvider="SignUpTestData", dataProviderClass = ExcelData.class)
  public void submitForm(String fn,String mn,String ln,String Add,String City,String zcode,String st,String DOb,String ph_no,String email)
  {
	  
	  System.out.printf(fn+"\t"+mn+"\t"+ln+"\t"+Add+"\t"+City+"\t"+zcode+"\t"+st+"\t"+DOb+"\t"+ph_no+"\t"+email);
	
	 driver.findElement(By.xpath("//div[@class='pi-inner-main-div']//div[@class='input-field-div'][1]//input[@type='text']")).sendKeys(fn);

	 driver.findElement(By.xpath("//div[@class='pi-inner-main-div']//div[@class='input-field-div'][2]//input[@type='text']")).sendKeys(mn);

      driver.findElement(By.xpath("//div[@class='pi-inner-main-div']//div[@class='input-field-div'][3]//input[@type='text']")).sendKeys(ln);

      driver.findElement(By.xpath("//div[@class='pi-inner-main-div']//div[@class='input-field-steetCity'][1]//input[@type='text']")).sendKeys(Add);

      driver.findElement(By.xpath("//div[@class='pi-inner-main-div']//div[@class='input-field-steetCity'][2]//input[@type='text']")).sendKeys(City);

      driver.findElement(By.xpath("//div[@class='zipcitypersonalInfo'][1]//input[@maxlength='5']")).sendKeys(zcode);

      driver.findElement(By.xpath("//div[@class='pi-inner-main-div']//div[@class='onlystatepersonalinfo'][1]//input[@value='New York']")).click();

      driver.findElement(By.xpath("//div[@class='pi-inner-main-div']//div[@class='DOBpersonalInfo'][1]//input[@type='text']")).sendKeys(DOb);

      WebElement gender=driver.findElement(By.xpath("//div[@class='pi-inner-main-div']//div[@class='genderpersonalinfo'][1]//input"));
       gender.click();
          Actions actions1 = new Actions(driver);
          actions1.sendKeys(Keys.DOWN).build().perform();
          
          actions1.sendKeys(Keys.DOWN).build().perform();//press down arrow key
          Actions actions2 = new Actions(driver);
          actions2.sendKeys(Keys.ENTER).build().perform();//press enter
    
      driver.findElement(By.xpath("//div[@class='pi-inner-main-div']//div[@class='input-field-div'][4]//input[@id='outlined-basic']")).click();

      driver.findElement(By.xpath("//div[@class='pi-inner-main-div']//div[@class='input-field-div'][4]//input[@id='outlined-basic']")).sendKeys(ph_no);

      driver.findElement(By.xpath("//div[@class='pi-inner-main-div']//div[@class='input-field-div'][5]//input[@type='text']")).sendKeys(email);
      
      driver.findElement(By.xpath("//div[@class='button-main-div'][1]//button[@id='click']")).click();
	  
	
  }
  
  @AfterClass
  public void tearDown() throws InterruptedException {
      Thread.sleep(2000);
     // this.driver.quit();
  }
 
	
}
