package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import pageObject.LoginPage;
import pageObject.LoginPagePass;

public class HomePage extends Base{
	public WebDriver driver; 
	private static Logger log =LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void intiliaze() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test(dataProvider="getData")
	public void getURL(String Usrname,String Password) throws IOException, InterruptedException {
		
		Thread.sleep(16000);
		driver.findElement(By.xpath("//*[text()='NO THANKS']")).click();
		
		LoginPage obj = new LoginPage(driver);
		obj.login().click();
		
		LoginPagePass lp  =  new LoginPagePass(driver);
		lp.userID().sendKeys(Usrname);
		lp.password().sendKeys(Password);
		
		Thread.sleep(5000);
		lp.loginButton().click();
		log.info("homepage test is successfullll");
}
	
	@AfterTest
	public void teardown() {
		
		driver.close();
	}

	@DataProvider
public Object[][] getData() {
	
		Object[][] data = new Object[2][2];
		data[0][0] = "restricteduser.com";
		data[0][1] = "abcd";
		data[1][0] = "unrestricteduser.com";
		data[1][1] = "pqrst";
		
		return data;
		
		
}

}
