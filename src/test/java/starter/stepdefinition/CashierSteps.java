package starter.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Cashier.*;

public class CashierSteps {
    @Steps
    CashierAddMembership cashierAddMembership;
    @Steps
    AddMembershipInvBirthdate addMembershipInvBirthdate;
    @Steps
    AddMembershipInvMethod addMembershipInvMethod;
    @Steps
    AddMemberWithoutToken addMemberWithoutToken;
    @Steps
    AddMembInvEmail addMembInvEmail;
    @Steps
    GetCategory getCategory;
    @Steps
    SearchItemById searchItemById;
    @Steps
    SearchItemByName searchItemByName;
    @Steps
    AddTransaction addTransaction;

    // ============================== Add Membership ==============================
    @Given("the user has cashier access rights")
    public void iSetTheApiPOSTEndpoint() {
        cashierAddMembership.cashierSetPOSTApiEndpointsForGetAll();
    }
    @When("cashier sends a POST request to the membership endpoint with alid data for adding membership")
    public void iSendHTTPPOSTRequest() {
        cashierAddMembership.cashierSendGETHTTPRequest();
    }
    @Then("cashier user should receive a response with a status code of 201 Created")
    public void iReceiveValidHTTPResponseCode201() {
        cashierAddMembership.cashierReceiveValidHTTPResponseCode200();
    }
    @And("a new membership with the provided information has been successfully created by cashier")
    public void iReceivedTheTokenAddMembershp() {
        cashierAddMembership.cashierReceivedTheToken();
    }


    // ============================== Add Membership Without Bearer Token ==============================
    @Given("the user has admin access without token")
    public void iSetPOSTApiEndpointsForGetAll() {addMemberWithoutToken.iSetPOSTApiEndpointsForGetAll();}
    @When("the user sends a POST request to the membership endpoint without token for add memb")
    public void iSendHTTPPOSTReq() { addMemberWithoutToken.iSendGETHTTPRequestForAddMembWToken();}
    @Then("the user should receive a response with a status code of 401 for add memb without token")
    public void iReceiverResponseCode401() { addMemberWithoutToken.iReceiveValidHTTPResponseCode401();}
    @And("the response should contain a Unauthorized: Missing token for add memb")
    public void iReceiveErrorMessage() { addMemberWithoutToken.iReceivedErrorMessage();}

    // ============================== Add Membership Invalid Method ==============================
    @Given("the user has admin access right")
    public void iSetPOSTApiEndpointsForGetInv() {addMembershipInvMethod.iSendGETHTTPRequest();}
    @When("the user sends a GET request to the membership endpoint with post valid data")
    public void iSendHTTPGETRequestInv() {
        addMembershipInvMethod.iSendGETHTTPRequest();
    }
    @Then("the user should receive a response with a status code of 400 Bad Req")
    public void iSendHTTPPOSTRequestForInvAdd() {addMembershipInvMethod.iReceiveValidHTTPResponseCode400Bad();}
    @And("the response should contain a error message bad request")
    public void iReceivedErrorMessageBadReq() {
        addMembershipInvMethod.iReceivedErrorMessageBadRequest();
    }
    // ============================== Add Membership Invalid Format Email ==============================
    @Given("the user has admin access rights for invalid email")
    public void iSetPOSTApiEndpointsInvEmail() {addMembInvEmail.iSetPOSTApiEndpointsForInputWithoutName();}
    @When("the user sends a POST request to the membership endpoint for invalid email")
    public void iSendHTTPGETRequestInvEmail() {
        addMembInvEmail.iSendGETHTTPRequestForInputWithoutName();
    }
    @Then("the user should receive a response with a status code of 400 for invalid email")
    public void iSendHTTPPOSTRequestForInvEmail() {addMembInvEmail.iReceiveValidHTTPResponseCode400ForInputWithoutName();}
    @And("the response should contain a error message bad request for invalid email")
    public void iReceivedErrorMessageBadReqInvEmail() {
        addMembInvEmail.iReceivedTheTokenForInputWithoutName();
    }
    // ============================== Add Membership Invalid Birthdate ==============================
    @Given("the user has admin access rights for invalid birthdate")
    public void iSetPOSTApiEndpointsInvBirth() {addMembershipInvBirthdate.iSetPOSTApiEndpointsForInvBirthdate();}
    @When("the user sends a POST request to the membership endpoint for invalid birthdate")
    public void iSendHTTPGETRequestInvBirth() {
        addMembershipInvBirthdate.iSendGETHTTPRequestForInvBirthdate();
    }
    @Then("the user should receive a response with a status code of 400 for invalid birthdate")
    public void iSendHTTPPOSTRequestForInvBirth() {addMembershipInvBirthdate.iReceiveValidHTTPResponseCode400InvBirthdate();}
    @And("the response should contain a error message bad request for invalid birthdate")
    public void iReceivedErrorMessageBadReqInvBirth() {
        addMembershipInvBirthdate.iReceivedTheTokenInvBirthdate();
    }

    // ============================== Get Category ==============================
    @When("cashier sends a GET request to the category endpoint")
    public void iSendHTTPGETRequest() {
        getCategory.iSendGETHTTPRequest();
    }
    @Then("cashier should receive a response with a status code of 200 OK")
    public void iReceiveValidHTTPResponseCode200() {
        getCategory.iReceiveValidHTTPResponseCode200();
        searchItemById.iReceiveValidHTTPResponseCode200();
        searchItemByName.iReceiveValidHTTPResponseCode200();
    }
    @And("the response should contain a list of all category data")
    public void iReceivedTheTokenGetAllMembership() {
        getCategory.iReceivedTheToken();
    }

    // ============================== Search Item By Id ==============================
    @When("cashier sends a GET request to the category endpoint with id valid for search item")
    public void iSendHTTPGETRequestForSearchItemById() {
        searchItemById.iSendGETHTTPRequest();
    }
    @And("the item with the given ID has been successfully displayed")
    public void iReceivedTheTokenGetItemById() {
        searchItemById.iReceivedTheToken();
    }

    // ============================== Search Item By Name ==============================
    @When("cashier sends a GET request to the category endpoint with name item valid for search item")
    public void iSendHTTPGETRequestForSearchItemByName() {
        searchItemByName.iSendGETHTTPRequest();
    }
    @And("the item with the given name has been successfully displayed")
    public void iReceivedTheTokenGetItemByName() {
        searchItemByName.iReceivedTheToken();
    }

    // ============================== Add Transaction ==============================
    @When("cashier sends a POST request to the membership endpoint with valid data for adding transaction")
    public void iSendHTTPGETRequestForAddTransaction() {
        addTransaction.cashierSendGETHTTPRequestt();
    }
    @Then("cashier user should receive a response with a status code of 201 Created for adding transaction")
    public void iReceiveValidHTTPResponseCode201ForAddTrnsaction() {
        addTransaction.cashierReceiveValidHTTPResponseCode200();
    }
    @And("a new transaction with the provided information has been successfully created by cashier")
    public void iReceivedTheTokenForAddTransaction() {
        addTransaction.cashierReceivedTheToken();
    }
}
