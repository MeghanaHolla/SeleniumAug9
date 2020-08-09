package com.webappsecurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundsConf {
	
	@FindBy(css = "#transfer_funds_content > div > div > div.alert.alert-success")
	private WebElement successMsg;
	
	@FindBy(css="#settingsBox > ul > li:nth-child(3) > a")
	private WebElement userName;
	
	@FindBy(id="logout_link")
	private WebElement logout;
	
	public TransferFundsConf(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String getMsg() {
		String message = successMsg.getText();
		return message;
	}

	public void logoutApp() {
		userName.click();
		logout.click();
	}

}
