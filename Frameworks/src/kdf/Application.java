package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import utils.GenericsMethods;

public class Application {
	@Test
	public void invalidLoginTest() throws IOException {
		String[][] data = GenericsMethods.getData("D:\\SelJul11\\TestData.xlsx", "Sheet2");
		Method mtd = new Method();
		for(int i = 1;i<data.length;i++) {
			
			switch(data[i][3]) {
			case "openBrowser":
				mtd.openBrowser();
				break;
			case "maxBrowser":
				mtd.maximizeBrowserWindow();
				break;
			case "impWait":
				mtd.implementImplicitWait();
				break;
			case "navigateToApplication":
				mtd.navigateToAUT(data[i][6]);
				break;
			case "enterUserID":
				mtd.enterUserID(data[i][5], data[i][6]);
				break;
			case "enterPassword":
				mtd.enterPassword(data[i][5], data[i][6]);
				break;
			case "clickButton":
				mtd.clickOnAButton(data[i][4],data[i][5]);
				break;
			case "verifyErrMsg":
				String actualMsg = mtd.getErrorMessage(data[i][5]);
				String expectedMsg = data[i][6];
				Assert.assertEquals(expectedMsg, actualMsg);
				break;
			case "closeApplication":
				mtd.closeApplication();
				break;
			}
		}
	}

}
