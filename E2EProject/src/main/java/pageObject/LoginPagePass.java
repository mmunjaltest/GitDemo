package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPagePass {

	public WebDriver driver;
	By userID = By.xpath("//input[@id='user_email']");
	By password = By.xpath("//input[@id='user_password']");
	By login = By.xpath("//input[@type='submit']");
	public WebElement userID() {
		return driver.findElement(userID);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	public WebElement loginButton() {
		return driver.findElement(login);
	}
	public LoginPagePass(WebDriver driver){
		this.driver = driver;
	}
	
}
