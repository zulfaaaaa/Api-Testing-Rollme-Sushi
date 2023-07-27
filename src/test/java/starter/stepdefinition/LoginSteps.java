package starter.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
//import starter.Login.InvalidAdminByEndpoint;
import starter.Login.LoginAdmin;
import starter.Login.LoginCashier;

public class LoginSteps {
    @Steps
    LoginAdmin login;
    @Steps
    LoginCashier loginCashier;
//    @Steps
//    InvalidAdminByEndpoint invalidAdminByEndpoint;

    // ========================= Login Admin =========================
    @Given("I set the api POST endpoint")
    public void iSetTheApiPOSTEndpoint() {login.iSetPOSTApiEndpoints();}
    @When("I send HTTP POST request")
    public void iSendHTTPPOSTRequest() {login.iSendGETHTTPRequest();}
    @Then("I receive valid HTTP response code 200")
    public void iReceiveValidHTTPResponseCode200() {login.iReceiveValidHTTPResponseCode200();}
    @And("I received the token")
    public void iReceivedTheToken() {login.iReceivedTheToken();}

    // ========================= Login Admin =========================
//    @Given("I set the api POST endpoint")
//    public void iSetTheApiPOSTEndpoint() {login.iSetPOSTApiEndpoints();}
//    @When("I send HTTP POST request")
//    public void iSendHTTPPOSTRequest() {login.iSendGETHTTPRequest();}
//    @Then("I receive valid HTTP response code 200")
//    public void iReceiveValidHTTPResponseCode200() {login.iReceiveValidHTTPResponseCode200();}
//    @And("I received the token")
//    public void iReceivedTheToken() {login.iReceivedTheToken();}


    // ========================= Login Cashier =========================
    @Given("cashier set the api POST endpoint")
    public void cashierrSetTheApiPOSTEndpoint() {loginCashier.cashierSetPOSTApiEndpoints();}
    @When("cashier send HTTP POST request")
    public void cashierrSendHTTPPOSTRequest() {loginCashier.cashierSendGETHTTPRequest();}
    @Then("cashier receive valid HTTP response code 200")
    public void cashierrReceiveValidHTTPResponseCode200() {loginCashier.cashierReceiveValidHTTPResponseCode200();}
    @And("cashier received the token")
    public void cashierrReceivedTheToken() {loginCashier.cashierReceivedTheToken();}

}
