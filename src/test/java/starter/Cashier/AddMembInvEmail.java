package starter.Cashier;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;
import starter.Login.LoginAdmin;
import starter.Login.LoginCashier;

public class AddMembInvEmail {
    protected static String url ="http://128.199.206.32:8000/api/v1/admin/membership";
    // public String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MiwiZXhwIjoxNjg2NzE4MDk1fQ.1T1uu0I-tyfb-Gbitkr3rEdzEqknrUhA-N_3_FmD_B0";

    @Step
    public String iSetPOSTApiEndpointsForInputWithoutName(){
        return  url;
    }
    @Step
    public void iSendGETHTTPRequestForInputWithoutName() {

        String body = "{\n" +
                "    \"name\":" + "Zulfa invalid email" + ",\n" +
                "    \"email\":" + "zulfawithoutnamegmail.commm" + ",\n" +
                "    \"phone\":" + 8734324 + ",\n" +
                "    \"birth_day\":" + "2002-09-23" + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + LoginCashier.token).contentType("application/json").body(reqBody.toString()).post(iSetPOSTApiEndpointsForInputWithoutName());
    }
    @Step
    public void iReceiveValidHTTPResponseCode400ForInputWithoutName(){
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step
    public void iReceivedTheTokenForInputWithoutName() {
        restAssuredThat(response -> response.body("'meta'.'code'", equalTo(400)));
        restAssuredThat(response -> response.body("'meta'.'status'", equalTo("error")));
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("Invalid email format")));
    }
}
