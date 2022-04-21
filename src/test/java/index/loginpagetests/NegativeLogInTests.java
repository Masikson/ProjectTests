package index.loginpagetests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import index.base.CsvDataProviders;
import index.base.TestUtilities;
import index.pages.ConfirmationPage;
import index.pages.ErrorPage;
import index.pages.LoginPage;


public class NegativeLogInTests extends TestUtilities {
	
	@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void negativeLogInTest(Map<String, String> testData) { // we will receive separate map from each row of our file
		// Data
		String no = testData.get("no");
		String username = testData.get("username");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMessage");
		String description = testData.get("description");

		log.info("Starting negativeLogInTest #" + no + " for " + description);

		// open confirmation page
		ConfirmationPage confirmationPage = new ConfirmationPage(driver, log);
		confirmationPage.openPage();
		
		//proceed
		LoginPage loginPage = confirmationPage.clickConfirmation();

		// execute negative login
		ErrorPage errorPage = loginPage.negativeLogIn(username, password);
		
		//get error message 
		String actualErrorMessage = errorPage.getErrorMessageText();
		
		// Verification
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
						+ expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
	}



}
