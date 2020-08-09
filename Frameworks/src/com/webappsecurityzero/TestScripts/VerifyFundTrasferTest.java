package com.webappsecurityzero.TestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webappsecurity.zero.Pages.AccountSummary;
import com.webappsecurity.zero.Pages.Login;
import com.webappsecurity.zero.Pages.TransferFundsConf;
import com.webappsecurity.zero.Pages.TransferFundsVerify;
import com.webappsecurity.zero.Pages.TrnasferFunds;

import utils.GenericsMethods;

public class VerifyFundTrasferTest {

	WebDriver driver;
	@BeforeTest
	public void openApplication() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/login.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void verifyFundTransfer() throws IOException {
		Login lp = new Login(driver);
		AccountSummary acc = new AccountSummary(driver);
		TrnasferFunds tf = new TrnasferFunds(driver);
		TransferFundsVerify tfv = new TransferFundsVerify(driver);
		TransferFundsConf tfc = new TransferFundsConf(driver);

		String[][] data = GenericsMethods.getData("D:\\SelJul11\\TestData.xlsx", "Sheet1");

		for(int i = 1;i<data.length;i++) {
			lp.applicationLogin(data[i][0],data[i][1]);
			acc.clickFundTransfer();
			tf.fundTransfer(data[i][2],	data[i][3]);
			tfv.submitClick();
			String actualMsg = tfc.getMsg();
			String expectedMsg = data[i][4];
			Assert.assertEquals(actualMsg, expectedMsg);
			tfc.logoutApp();
			driver.navigate().to("http://zero.webappsecurity.com/login.html");
		}

	}



	@AfterTest
	public void closeApplication() {
		driver.close();
	}
}
