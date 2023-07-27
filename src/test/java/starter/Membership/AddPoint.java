package starter.Membership;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;
import starter.Login.LoginAdmin;

public class AddPoint {
    protected static String url ="http://128.199.206.32:8000/api/v1/admin/membership/point";

    @Step("the user has admin access rights for add point")
    public String iSetPOSTApiEndpointsForAddPoint(){
        return  url;
    }
    @Step("the user sends a POST request to the membership endpoint with post valid data")
    public void iSendGETHTTPRequest() {

        String body = "{\n" +
                "    \"id\":" + 33 + ",\n" +
                "    \"total_transaction\":" + 70000 + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + LoginAdmin.token).contentType("application/json").body(reqBody.toString()).post(iSetPOSTApiEndpointsForAddPoint());
    }
    @Step("the user should receive a response with a status code of 201 Created")
    public void iReceiveValidHTTPResponseCode200ForAddpoint(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("a new membership with the provided information has been successfully created")
    public void iReceivedTheToken() {
        restAssuredThat(response -> response.body("'meta'.'code'", equalTo(201)));
        restAssuredThat(response -> response.body("'meta'.'status'", equalTo("Success")));
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("Membership edited")));
        restAssuredThat(response -> response.body("'data'.'name'", equalTo("membershipss")));
    }
}
