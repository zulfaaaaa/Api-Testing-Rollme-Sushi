package starter.Membership;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;
import starter.Login.LoginAdmin;

public class UpdateMembershipInvMethod {
    protected static String url ="http://128.199.206.32:8000/api/v1/admin/membership/22";

    @Step
    public String iSetPOSTApiEndpointsForUpdateInvMethod() { return  url;}
    @Step
    public void iSendGETHTTPRequestForUpdateInvMethod() {

        String body = "{\n" +
                "    \"name\":" + "Zulfa Nursyaa updatee" + ",\n" +
                "    \"email\":" + "zulfaup@gmail.com" + ",\n" +
                "    \"phone\":" + 85863223 + ",\n" +
                "    \"birth_day\":" + "2001-12-28" + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + LoginAdmin.token).contentType("application/json").body(reqBody.toString()).get(iSetPOSTApiEndpointsForUpdateInvMethod());
    }
    @Step
    public void iReceiveValidHTTPResponseCode404ForUpdateInvMethod(){
        restAssuredThat(response -> response.statusCode(404));
    }
    @Step
    public void iReceivedErrorMessageForUpdateInvMethod(){    }
}
