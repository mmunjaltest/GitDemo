package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;
import pageObject.LoginPage;

public class ValidateNavigatonBar extends Base {
	public WebDriver driver; 
	private static Logger log =LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void intiliaze() throws IOException {
		driver = initializeDriver();
		System.out.println(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));

	}

	@Test
	public void navigationBar() throws IOException, InterruptedException {

		LoginPage nv = new LoginPage(driver);
		nv.handlePopup().click();
		Assert.assertTrue(nv.getNavBar().isDisplayed());
		boolean value = nv.getNavBar().isDisplayed();
		System.out.println(value);
		log.info("Navigation bar is displayed");
	}

	@AfterTest
	public void teardown() {

		driver.close();
	}

}
