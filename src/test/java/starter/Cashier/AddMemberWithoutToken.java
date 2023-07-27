package starter.Cashier;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;
import starter.Login.LoginAdmin;

public class AddMemberWithoutToken {
    protected static String url ="http://128.199.206.32:8000/api/v1/admin/membership";
    // public String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MiwiZXhwIjoxNjg2NzE4MDk1fQ.1T1uu0I-tyfb-Gbitkr3rEdzEqknrUhA-N_3_FmD_B0";

    @Step("the user has admin access without token")
    public String iSetPOSTApiEndpointsForGetAll(){
        return  url;
    }
    @Step("the user sends a POST request to the membership endpoint with post valid data")
    public void iSendGETHTTPRequestForAddMembWToken() {

        String body = "{\n" +
                "    \"name\":" + "Zulfa coba" + ",\n" +
                "    \"email\":" + "zulfacoba@gmail.com" + ",\n" +
                "    \"phone\":" + 87838321 + ",\n" +
                "    \"birth_day\":" + "2002-03-30" + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("contentType","application/json").body(reqBody.toString()).post(iSetPOSTApiEndpointsForGetAll());
    }
    @Step("the user should receive a response with a status code of 401")
    public void iReceiveValidHTTPResponseCode401(){
        restAssuredThat(response -> response.statusCode(401));
    }
    @Step("the response should contain a Unauthorized: Missing token")
    public void iReceivedErrorMessage(){}
}
