package starter.Cashier;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;
import starter.Login.LoginAdmin;
import starter.Login.LoginCashier;

public class AddMembershipInvMethod {
    protected static String url ="http://128.199.206.32:8000/api/v1/admin/membership";
    // public String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MiwiZXhwIjoxNjg2NzE4MDk1fQ.1T1uu0I-tyfb-Gbitkr3rEdzEqknrUhA-N_3_FmD_B0";

    @Step //("the user has admin access rights")
    public String iSetPOSTApiEndpointsForGetAll(){
        return  url;
    }
    @Step //("the user sends a POST request to the membership endpoint with post valid data")
    public void iSendGETHTTPRequest() {

        String body = "{\n" +
                "    \"name\":" + "Zulfa coba" + ",\n" +
                "    \"email\":" + "zulfacoba@gmail.com" + ",\n" +
                "    \"phone\":" + 87838321 + ",\n" +
                "    \"birth_day\":" + "2002-03-30" + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + LoginCashier.token).contentType("application/json").body(reqBody.toString()).get(iSetPOSTApiEndpointsForGetAll());
    }
    @Step //("the user should receive a response with a status code of 201 Created")
    public void iReceiveValidHTTPResponseCode400Bad(){
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step //("a new membership with the provided information has been successfully created")
    public void iReceivedErrorMessageBadRequest(){
        restAssuredThat(response -> response.body("'meta'.'code'", equalTo(400)));
    }
}
