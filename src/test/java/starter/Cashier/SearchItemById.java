package starter.Cashier;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;
import starter.Login.LoginCashier;

public class SearchItemById {
    protected static String url ="http://128.199.206.32:8000/api/v1/cashier/order/item/78";
    public String token ="";

    @Step("the user has admin access rights")
    public String iSetPOSTApiEndpointsForGetAll(){
        return  url;
    }
    @Step("cashier sends a GET request to the category endpoint with id valid for search item")
    public void iSendGETHTTPRequest(){
        SerenityRest.given().header("Authorization", "Bearer " + LoginCashier.token).get(iSetPOSTApiEndpointsForGetAll());
    }
    @Step("cashier should receive a response with a status code of 200 OK")
    public void iReceiveValidHTTPResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("the item with the given ID has been successfully displayed")
    public void iReceivedTheToken(){
        restAssuredThat(response -> response.body("'meta'.'code'", equalTo(200)));
        restAssuredThat(response -> response.body("'meta'.'status'", equalTo("success")));
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("successfully retrieved data")));
        restAssuredThat(response -> response.body("'data'.'id'", equalTo(71)));
    }
}
