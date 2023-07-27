package starter.Cashier;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

import starter.Login.LoginCashier;

public class CashierAddMembership {
    protected static String url ="http://128.199.206.32:8000/api/v1/cashier/membership";

    @Step("the user has cashier access rights")
    public String cashierSetPOSTApiEndpointsForGetAll(){
        return  url;
    }
    @Step("cashier sends a POST request to the membership endpoint with post valid data")
    public void cashierSendGETHTTPRequest() {

        String body = "{\n" +
                "    \"name\":" + "Zulfa memberadd2" + ",\n" +
                "    \"email\":" + "zulfaMember122@gmail.com" + ",\n" +
                "    \"phone\":" + 671319 + ",\n" +
                "    \"birth_day\":" + "2001-09-20" + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + LoginCashier.token).contentType("application/json").body(reqBody.toString()).post(cashierSetPOSTApiEndpointsForGetAll());
    }
    @Step("cashier should receive a response with a status code of 201 Created")
    public void cashierReceiveValidHTTPResponseCode200(){
        restAssuredThat(response -> response.statusCode(201));
    }
    @Step("a new membership with the provided information has been successfully created by cashier")
    public void cashierReceivedTheToken(){
        restAssuredThat(response -> response.body("'meta'.'code'", equalTo(201)));
        restAssuredThat(response -> response.body("'meta'.'status'", equalTo("Success")));
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("Membership created")));
        restAssuredThat(response -> response.body("'data'.'name'", equalTo("Zulfa memberadd2")));
    }
}
