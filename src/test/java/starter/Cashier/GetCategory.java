package starter.Cashier;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;
import starter.Login.LoginCashier;

public class GetCategory {
    protected static String url ="http://128.199.206.32:8000/api/v1/cashier/order/category";
    public String token ="";

    @Step("the user has admin access rights")
    public String iSetPOSTApiEndpointsForGetAll(){
        return  url;
    }
    @Step("cashier sends a GET request to the category endpoint")
    public void iSendGETHTTPRequest(){
        SerenityRest.given().header("Authorization", "Bearer " + LoginCashier.token).get(iSetPOSTApiEndpointsForGetAll());
    }
    @Step("cashier should receive a response with a status code of 200 OK")
    public void iReceiveValidHTTPResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("the response should contain a list of all category data")
    public void iReceivedTheToken(){
        restAssuredThat(response -> response.body("'meta'.'code'", equalTo(200)));
        restAssuredThat(response -> response.body("'meta'.'status'", equalTo("success")));
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("successfully retrieved data")));
    }
}
