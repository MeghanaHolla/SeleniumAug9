package kdf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Method {
	
	WebDriver driver;
	public void openBrowser() {
		driver = new ChromeDriver();
	}
	public void maximizeBrowserWindow() {
		driver.manage().window().maximize();
	}

	public void implementImplicitWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public void navigateToAUT(String url) {
		driver.get(url);
	}
	public void enterUserID(String locValue, String userID) {
		driver.findElement(By.id(locValue)).sendKeys(userID);
	}
	public void enterPassword(String locValue, String password) {
		driver.findElement(By.id(locValue)).sendKeys(password);
	}
	public void clickOnAButton(String loc, String locValue) {
		if(loc.equals("id")) {
		driver.findElement(By.id(locValue)).click();
		}
		else if(loc.equals("name")) {
			driver.findElement(By.name(locValue)).click();
		}
	}
	public String getErrorMessage(String locValue) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locValue)));
		String errMsg = driver.findElement(By.cssSelector(locValue)).getText();
		return errMsg;
	}
	public void closeApplication() {
		driver.close();
	}
}
