package starter.stepdefinition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Cashier.AddMembInvEmail;
import starter.Cashier.AddMemberWithoutToken;
import starter.Cashier.AddMembershipInvBirthdate;
import starter.Cashier.AddMembershipInvMethod;
import starter.Membership.*;

public class MembershipSteps {
    @Steps
    GetMembership membership;
    @Steps
    GetMembershipInvalidEndpoint getMembershipInvalidEndpoint;
    @Steps
    GetMembershipInvMethod getMembershipInvMethod;
    @Steps
    GetMembershipWithoutToken getMembershipWithoutToken;
    @Steps
    AddPoint addPoint;
    @Steps
    UpdateMembership updateMembership;
    @Steps
    UpdateMembershipInvEndpoint updateMembershipInvEndpoint;
    @Steps
    UpdateMembershipInvMethod updateMembershipInvMethod;
    @Steps
    UpdateMembershipWithoutToken updateMembershipWithoutToken;
    @Steps
    UpdateMembershipInvEmail updateMembershipInvEmail;
//    @Steps
//    UpdateMembershipInvBirthDate updateMembershipInvBirthDate;
    @Steps
    DeleteMembership deleteMembership;


    // ============================== Get Membership ==============================
    @Given("the user has admin access rights")
    public void iSetTheApiPOSTEndpoint() {
        getMembershipInvMethod.iSetPOSTApiEndpointsForGetAll();
        membership.iSetPOSTApiEndpointsForGetAll();
    }
    @When("the user sends a GET request to the membership endpoint")
    public void iSendHTTPGETRequest() {
        membership.iSendGETHTTPRequest();
    }
    @Then("the user should receive a response with a status code of 200 OK")
    public void iReceiveValidHTTPResponseCode200() {
        membership.iReceiveValidHTTPResponseCode200();
        updateMembership.iReceiveValidHTTPResponseCode200();
        deleteMembership.iReceiveValidHTTPResponseCode200();
    }
    @And("the response should contain a list of all membership data")
    public void iReceivedTheTokenGetAllMembership() {
        membership.iReceivedTheToken();
    }

    // ============================== Get Membership Invalid Method==============================
    @When("the user sends a PUT request to the membership endpoint")
    public void iSendPUTHTTPRequest() {
        getMembershipInvMethod.iSendPUTHTTPRequest();
    }
    @Then("the user should receive a response with a status code of 404")
    public void iReceiveValidHTTPResponseCode404() {
        getMembershipInvMethod.iReceiveValidHTTPResponsesCode404();

    }
    @And("the response should contain a error message not found")
    public void iReceivedTheErrorMessageNotFound() {
        getMembershipInvMethod.iReceivedErrorMessageNotFound();}
    // ============================== Get Membership Invalid Endpoint ==============================
    @Given("the user has admin access invalid")
    public void iSetTheApiPOSTInvalidEndpoint() {
        getMembershipWithoutToken.iSetPOSTApiEndpointsForGetAll();
    }
    @When("the user sends a GET request to the invalid membership endpoint")
    public void iSendHTTPGETRequestInvalidEndpoint() {
        getMembershipInvalidEndpoint.iSendGETHTTPRequest();
    }
    @Then("the user should receive a response with a status code of 400")
    public void iReceiveValidHTTPResponsesCode404() {
        getMembershipInvalidEndpoint.iReceiveValidHTTPResponseCode400();

    }
    @And("the response should contain a error message required parameter page")
    public void iReceivedTheErrorMessageReqParam() {
        getMembershipInvalidEndpoint.iReceivedTheErrorMessage();}

    // ============================== Get Membership Without Bearer Token ==============================
    @Given("the user has admin access rights without token")
    public void iSetTheApiPOSTWithoutToken() {
        getMembershipInvalidEndpoint.iSetPOSTApiEndpointsForGetAll();
    }
    @When("the user sends a GET request to the membership endpoint without token")
    public void iSendsGETMethod() { getMembershipWithoutToken.iSendGETHTTPRequest();}
    @Then("the user should receive a response with a status code of 401 for get membership")
    public void iReceiveStatusCode() {
        getMembershipWithoutToken.iReceiveValidHTTPResponseCode401();}
    @And("the response should contain a Unauthorized: Missing token")
    public void iReceivedTheErrorMessageMiss() {
        getMembershipWithoutToken.iReceivedErrorMessageMissingToken();
    }


    // ============================== Add Membership Without Name ==============================
//    @Given("the user has admin access rights for without name")
//    public void iSetPOSTApiEndpointsWithoutName() {addMemberWithoutName.iSetPOSTApiEndpointsWithoutNamee();}
//    @When("the user sends a POST request to the membership endpoint for without name")
//    public void iSendHTTPGETRequestWithoutName() {
//        addMemberWithoutName.iSendGETHTTPRequestWithoutNamee();
//    }
//    @Then("the user should receive a response with a status code of 400 for without name")
//    public void iSendHTTPPOSTRequestWithoutName() {addMemberWithoutName.iReceiveValidHTTPResponseCode400WithoutNamee();}
//    @And("the response should contain a error message bad request for without name")
//    public void iReceivedErrorMessageBadReqWithoutName() {
//        addMemberWithoutName.iReceivedTheErrorMessageWithoutNamee();
//    }




    // ============================== Add Point Membership ==============================
    @Given("the user has admin access rights for add point")
    public void iSetPOSTApiEndpointsForAddPoints() {addPoint.iSetPOSTApiEndpointsForAddPoint();}
    @When("The user sends a POST request to the membership endpoint with valid data for adding points")
    public void iSendHTTPPOSTRequestForAddPoint() {
        addPoint.iSendGETHTTPRequest();
    }
    @Then("the user should receive a response with a status code of 201 Created for adding point valid")
    public void iReceiveResponseCodeForAddPoint() { addPoint.iReceiveValidHTTPResponseCode200ForAddpoint();}

    @And("The points for the member with that ID have been successfully added by the specified amount")
    public void iReceivedTheTokenAddMembershpForAddPoint() {
        addPoint.iReceivedTheToken();
    }

    // ============================== Edit Membership ==============================
    @When("The user sends a POST request to the membership endpoint with valid data for edit membership")
    public void iSendHTTPPOSTRequestForEditMembership() {
        updateMembership.iSendGETHTTPRequest();
    }
    @And("The membership with that ID has been successfully updated with the provided information")
    public void iReceivedTheTokenAddMembershpForEditMembership() {
        updateMembership.iReceivedTheToken();
    }

    // ============================== Edit Membership Invalid Endpoint ==============================
    @Given("the user has admin access rights for update membership invalid endpoint")
    public void iSetPOSTApiEndpointsUpdateInvEnd() {updateMembershipInvEndpoint.iSetPOSTApiEndpointsForUpdateInvEndpoints();}
    @When("The user sends a POST request to the membership endpoint with valid data for edit membership invalid endpoint")
    public void iSendHTTPPUTRequestForUpdateInvEnd() { updateMembershipInvEndpoint.iSendGETHTTPRequestForUpdateInvEndpoint();
    }
    @Then("the user should receive a response with a status code of 404 for edit membership invalid endpoint")
    public void iReceiveValidHTTPResponseCode400ForUpInvEnd() {updateMembershipInvEndpoint.iReceiveValidHTTPResponseCode404ForUpdateInvEndpoint();}
    @And("the response should contain a error message not found for edit membership invalid endpoint")
    public void iReceivedTheTokenAddMembershpForUpdateInvEnd() { updateMembershipInvEndpoint.iReceivedErrorMessageForUpdateInvEndpoint();
    }

    // ============================== Edit Membership Invalid Method ==============================
    @Given("the user has admin access rights for update membership invalid method")
    public void iSetPOSTApiEndpointsUpdateInvMethod() {updateMembershipInvMethod.iSetPOSTApiEndpointsForUpdateInvMethod();}
    @When("The user sends a POST request to the membership endpoint with valid data for edit membership invalid method")
    public void iSendHTTPPUTRequestForUpdateInvMethod() { updateMembershipInvMethod.iSendGETHTTPRequestForUpdateInvMethod();}
    @Then("the user should receive a response with a status code of 404 for edit membership invalid method")
    public void iReceiveValidHTTPResponseCode400ForUpInvMethod() {updateMembershipInvMethod.iReceiveValidHTTPResponseCode404ForUpdateInvMethod();}
    @And("the response should contain a error message not found for edit membership invalid method")
    public void iReceivedTheTokenAddMembershpForUpdateInvMethod() { updateMembershipInvMethod.iReceivedErrorMessageForUpdateInvMethod();}

    // ============================== Edit Membership Without Bearer Token ==============================
    @Given("the user has admin access rights for update membership without token")
    public void iSetPOSTApiEndpointsUpdateWToken() {updateMembershipWithoutToken.iSetPOSTApiEndpointsForUpdateWithoutToken();}
    @When("The user sends a POST request to the membership endpoint with valid data for edit without token")
    public void iSendHTTPPUTRequestForUpdateWToken() { updateMembershipWithoutToken.iSendGETHTTPRequestUpdateWithoutToken();}
    @Then("the user should receive a response with a status code of 401 for edit membership without token")
    public void iReceiveValidHTTPResponseCode401UpdateWToken() {updateMembershipWithoutToken.iReceiveValidHTTPResponseCode401UpdateWithoutToken();}
    @And("the response should contain a error message not found for edit membership without token")
    public void iReceivedErrorMessageForUpdateWToken() { updateMembershipWithoutToken.iReceivedErrorMessageUpdateWithoutToken();}

    // ============================== Edit Membership Invalid Email ==============================
    @Given("the user has admin access rights for update membership invalid email")
    public void iSetPOSTApiEndpointsUpdateInvEmail() {updateMembershipInvEmail.iSetPOSTApiEndpointsForUpdateInvEmail();}
    @When("The user sends a POST request to the membership endpoint with invalid email")
    public void iSendHTTPPUTRequestForUpdateInvEmail() { updateMembershipInvEmail.iSendGETHTTPRequestForUpdateInvEmail();}
    @Then("the user should receive a response with a status code of 400 for edit membership invalid email")
    public void iReceiveValidHTTPResponseCode400UpdatInvEmail() {updateMembershipInvEmail.iReceiveValidHTTPResponseCode400ForUpdateInvEmail();}
    @And("the response should contain a error message invalid email format for edit membership invalid email")
    public void iReceivedErrorMessageForUpdateInvEmail() { updateMembershipInvEmail.iReceivedErrorMessageForUpdateInvEmail();}

    // ============================== Edit Membership Invalid Birthdate ==============================
//    @Given("the user has admin access rights for update invalid birthdate")
//    public void iSetPOSTApiEndpointsUpdateInvBirthDate() {updateMembershipInvBirthDate.iSetPOSTApiEndpointsForUpdateInvBirthdate();}
//    @When("the user sends a POST request to the membership endpoint for update invalid birthdate")
//    public void iSendHTTPPUTRequestForUpdateInvBirthDate() { updateMembershipInvBirthDate.iSendGETHTTPRequestForUpdateInvBirthdate();}
//    @Then("the user should receive a response with a status code of 400 for update invalid birthdate")
//    public void iReceiveValidHTTPResponseCode400UpdatBirthDate() {updateMembershipInvBirthDate.iReceiveValidHTTPResponseCode400ForUpdateInvBirthdate();}
//    @And("the response should contain a error message bad request for update invalid birthdate")
//    public void iReceivedErrorMessageForUpdateInvBirthDate() { updateMembershipInvBirthDate.iReceivedTheErrorMessageForUpdateInvBirthdate();}


    // ============================== Delete Membership ==============================
    @When("the user sends a DELETE request to the membership endpoint with valid id")
    public void iSendHTTPGETRequestForDeleteMembership() {
        deleteMembership.iSendGETHTTPRequest();
    }
    @And("the membership with that ID has been successfully deleted")
    public void iReceivedTheTokenGForDeleteMembership() {
        deleteMembership.iReceivedTheToken();
    }

    // ============================== Delete Membership Invalid Id ==============================
//    @Given("the user has admin access rights for delete invalid id")
//    public void iSetPOSTApiEndpointsUpdateInvBirth() {updateMembershipInvBirthDate.iSetPOSTApiEndpointsForUpdateInvBirthdate();}
//    @When("the user sends a POST request to the membership endpoint for update invalid birthdate")
//    public void iSendHTTPPUTRequestForUpdateInvBirth() { updateMembershipInvBirthDate.iSendGETHTTPRequestForUpdateInvBirthdate();}
//    @Then("the user should receive a response with a status code of 400 for update invalid birthdate")
//    public void iReceiveValidHTTPResponseCode400UpdatInvBirth() {updateMembershipInvBirthDate.iReceiveValidHTTPResponseCode400ForUpdateInvBirthdate();}
//    @And("the response should contain a error message bad request for update invalid birthdate")
//    public void iReceivedErrorMessageForUpdateInvBirth() { updateMembershipInvBirthDate.iReceivedTheErrorMessageForUpdateInvBirthdate();}

}
