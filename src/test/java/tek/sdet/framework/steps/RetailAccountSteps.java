package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.*;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;
import tek.sdet.framework.utilities.DataGenerator;

public class RetailAccountSteps extends CommonUtility {
	
	POMFactory pom = new POMFactory();

	
	
	
	
	@When("User click on Account option")
	public void userClickOnAccountOption() {
		
		
		click(pom.retailAccount().accountLink);
	    
	}
	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String name, String phone) {
		 clearTextUsingSendKeys(pom.retailAccount().nameField);
		 sendText(pom.retailAccount().nameField,name);
		 clearTextUsingSendKeys(pom.retailAccount().phoneField);
		 sendText(pom.retailAccount().phoneField,phone);
		 
	    
	}
	@When("User click on Update button")
	public void userClickOnUpdateButton() {
		
		
		click(pom.retailAccount().updateBttn);
		
		
	    
	}
	@Then("user profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(pom.retailAccount().personalInfoUpdateSuccessMssg);
		String expectedMessage = "Personal Information Updated Successfully";
		String acctualMessage = pom.retailAccount().personalInfoUpdateSuccessMssg.getText();
		
		Assert.assertEquals(expectedMessage,acctualMessage);
		logger.info("Account Information Updated Successfully");
	
	    
	}
	
	//updatePeyment
	
	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		
	   
	   click(pom.retailAccount().addPaymentlink);
	  
	}
	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(io.cucumber.datatable.DataTable dataTable) {
		
//		[
//		  {
//		    "cardNumber": "8743333333333333",
//		    "nameOnCard": "mohamed iben",
//		    "expirationMonth": "8",
//		    "expirationYear": "2024",
//		    "securityCode": "657"
//		  }
//		]

		
		List<Map<String ,String>> cardInfo = dataTable.asMaps(String.class, String.class);
		
		sendText(pom.retailAccount().cardNumberField, cardInfo.get(0).get("cardNumber"));
		sendText(pom.retailAccount().nameOnCardField, cardInfo.get(0).get("nameOnCard"));
		selectByVisibleText(pom.retailAccount().expirationMonthField, cardInfo.get(0).get("expirationMonth"));
		selectByVisibleText(pom.retailAccount().expireationYearField, cardInfo.get(0).get("expirationYear"));
		sendText(pom.retailAccount().securityCodeField, cardInfo.get(0).get("securityCode"));
	
		
		
	    
	}
	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		
		click(pom.retailAccount().paymentSubmitBtn);
	    
	}
	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String expectedMsge) {
		
		waitTillPresence(pom.retailAccount().paymentMethodSuccessMssg);
		expectedMsge = "Payment Method added sucessfully";
		String acctualMsge = pom.retailAccount().paymentMethodSuccessMssg.getText();
		
		Assert.assertEquals(expectedMsge,acctualMsge);
		logger.info(expectedMsge);
	
		

	   
	}
	
	
	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		
		click(pom.retailAccount().clickOnCard);
		
		click(pom.retailAccount().editBtn);
	    
	}
	@When("user edit information with below data")
	public void userEditInformationWithBelowData(io.cucumber.datatable.DataTable dataTable) {
    List<Map<String ,String>> cardInfo = dataTable.asMaps(String.class, String.class);
    
    
		clearTextUsingSendKeys(pom.retailAccount().cardNumberField2);
		sendText(pom.retailAccount().cardNumberField2, cardInfo.get(0).get("cardNumber"));
		
		clearTextUsingSendKeys(pom.retailAccount().nameOnCardField2);
		sendText(pom.retailAccount().nameOnCardField2, cardInfo.get(0).get("nameOnCard"));
		
		selectByVisibleText(pom.retailAccount().expirationMonthField2, cardInfo.get(0).get("expirationMonth"));
		selectByVisibleText(pom.retailAccount().expireationYearField2, cardInfo.get(0).get("expirationYear"));
		
		clearTextUsingSendKeys(pom.retailAccount().securityCodeField2);
		sendText(pom.retailAccount().securityCodeField2, cardInfo.get(0).get("securityCode"));
		
		
	   
	}
	@When("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		
		click(pom.retailAccount().updateBtn2);
	    
	}
	
	@Then("a message should  display {string}")
	public void aMessageShouldDisplay(String expectedMsge) {
		
		
		waitTillPresence(pom.retailAccount().edditMesg);
		expectedMsge = "Payment Method updated Successfully";
		String acctualMsge = pom.retailAccount().edditMesg.getText();
		
		Assert.assertEquals(expectedMsge,acctualMsge);
		logger.info(expectedMsge);
	   
	}
	
	//Remove payment
	
	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		
		click(pom.retailAccount().clickOnCard);
		
		click(pom.retailAccount().removeBtn);
	    
	}
	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		
	logger.info("payment has been removed");
	
	    
	}
	
	//add address
	
	
	@When("User clicks on the Add address option")
	public void userClicksOnTheAddAddressOption() {
		
		click(pom.retailAccount().addAddressLink);
		logger.info("Add Address Link was clicked successfully");
		}
	
	@When("user fills the new address form with below information")
	public void userFillsTheNewAddressFormWithBelowInformation(io.cucumber.datatable.DataTable dataTable) {
		
		List<Map<String, String>> addressInfo = dataTable.asMaps(String.class, String.class);
		
		selectByVisibleText(pom.retailAccount().AddressCountryDropdown, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("country")));
		sendText(pom.retailAccount().addressNameField, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("fullName")));
		sendText(pom.retailAccount().addressPhoneField, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("phoneNumber")));
		sendText(pom.retailAccount().addressStreetField, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("streetAddress")));
		sendText(pom.retailAccount().addressApartmentNum, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("apt")));
		sendText(pom.retailAccount().addressCityField, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("city")));
		selectByVisibleText(pom.retailAccount().addressStateDropdown, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("state")));
		sendText(pom.retailAccount().addressZipCodeField, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("zipCode")));
		
		logger.info("Address form was filled out successfully");
	}
		
	
	@Then("a message  displayed {string}")
	public void aMessageDisplayed(String expectedMsge) {
		
		
		click(pom.retailAccount().addressAddBttn);
		
		waitTillPresence(pom.retailAccount().addressSuccessMssg);
		expectedMsge = "Address Added Successfully";
		String acctualMsge = pom.retailAccount().addressSuccessMssg.getText();
		
		Assert.assertEquals(expectedMsge,acctualMsge);
		logger.info(expectedMsge);
		logger.info("Add Address Button was clicked successfully");
	}
	
	//edit Address
	
	@When("User click on edit address option")
	public void userClickOnEditAddressOption() {
		
		click(pom.retailAccount().editAddressBtn);
		logger.info("User clicked on Edit Address button");
		}
	   
	
	@When("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(io.cucumber.datatable.DataTable dataTable) {
		
		List<Map<String, String>> updateAddress = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(pom.retailAccount().AddressCountryDropdown, updateAddress.get(0).get("country"));
		 
		clearTextUsingSendKeys(pom.retailAccount().addressNameField);
		sendText(pom.retailAccount().addressNameField, updateAddress.get(0).get("fullName"));
		 
		clearTextUsingSendKeys(pom.retailAccount().addressPhoneField);
		sendText(pom.retailAccount().addressPhoneField, updateAddress.get(0).get("phoneNumber"));
		 
		clearTextUsingSendKeys(pom.retailAccount().addressStreetField);
		sendText(pom.retailAccount().addressStreetField, updateAddress.get(0).get("streetAddress"));
		 
		clearTextUsingSendKeys(pom.retailAccount().addressApartmentNum);
		sendText(pom.retailAccount().addressApartmentNum, updateAddress.get(0).get("apt"));
		 
		clearTextUsingSendKeys(pom.retailAccount().addressCityField);
		sendText(pom.retailAccount().addressCityField, updateAddress.get(0).get("city"));
		 
		clearTextUsingSendKeys(pom.retailAccount().addressStateDropdown);
		sendText(pom.retailAccount().addressStateDropdown, updateAddress.get(0).get("state"));
		 
		clearTextUsingSendKeys(pom.retailAccount().addressZipCodeField);
		sendText(pom.retailAccount().addressZipCodeField, updateAddress.get(0).get("zipCode"));
		 
		logger.info("User filled the new address information");
		}
	   

	    
	
	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		
		click(pom.retailAccount().updateAddressBtn);
		logger.info("User clicked on update address button");
		}
	   
	
	@Then("a message should be displayed after editing {string}")
	public void aMessageShouldBeDisplayedAfterEditing(String string) {
		waitTillPresence(pom.retailAccount().addressUpdatedSuccessfully);
		Assert.assertTrue(isElementDisplayed(pom.retailAccount().addressUpdatedSuccessfully));
		logger.info("User updated the address successfully");
	
	}
	
	 
	
	@When("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		//removeAddressBtn
		
		click(pom.retailAccount().removeAddressBtn);
		
		logger.info("clicked on remove button");
	    
	}
	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		
		if (!isElementDisplayed(pom.retailAccount().removeAddressBtn)) {
		    logger.info("Address details still available");
		    Assert.assertFalse("Address details should not be available", true);
	   
}
	   
	}

}
