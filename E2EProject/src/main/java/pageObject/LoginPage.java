package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.Base;

public class LoginPage extends Base{
	public WebDriver driver;
	By login = By.xpath(" //i[@class='fa fa-lock fa-lg']");
	By title = By.xpath("//div[@class = 'text-center']");
	By navBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	By popup = By.xpath("//*[text()='NO THANKS']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement login() {

		return driver.findElement(login);
	}

	public WebElement getTile() {
		return driver.findElement(title);
	}

	public WebElement getNavBar() {
		return driver.findElement(navBar);

	}

	public WebElement handlePopup() {
		waitHandle(driver,popup);
		return driver.findElement(popup);

	}
}