package Academy;

import static org.testng.Assert.assertEquals;

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

import junit.framework.Assert;
import pageObject.LoginPage;
import pageObject.LoginPagePass;

public class ValidateTitle extends Base{
	public WebDriver driver; 
	private static Logger log =LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void intiliaze() throws IOException {
		driver = initializeDriver();
		log.info("Driver successfully initialized");
		driver.get(prop.getProperty("url"));
	log.info("Navigated to home page");
	}
	
	@Test
	public void getTitle() throws IOException, InterruptedException {
		
	Thread.sleep(15000);
		driver.findElement(By.xpath("//*[text()='NO THANKS']")).click();
		LoginPage l = new LoginPage(driver);
		System.out.println(l.getTile().getText());
Assert.assertEquals(l.getTile().getText(), "FEATURED COURSES");
		
		
log.info("Successfully validated the Text message");

}

	@AfterTest
	public void teardown() {
		
		driver.close();
	}

	
}
