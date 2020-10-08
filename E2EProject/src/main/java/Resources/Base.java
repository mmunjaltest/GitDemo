package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		
	 prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\Eclipse workspace\\E2EProject\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("Browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\64\\RadicalSoftware\\chromedriver_win32_B38\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(browserName.equals("iexplorer")){
			System.setProperty("webdriver.ie.driver",
					"D:\\64\\RadicalSoftware\\IEDriverServer_x64_3.12.0");
			WebDriver driver=new InternetExplorerDriver();  
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	public void waitHandle(WebDriver driver, By element ) {
		WebDriverWait wt = new WebDriverWait(driver, 30);
		wt.until(ExpectedConditions.elementToBeClickable(element));
		
		
		
	}

	public void getScreenshotPath(String testCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile ));
	}
	
	
}
