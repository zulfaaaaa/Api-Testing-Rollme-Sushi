package starter.Membership;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;
import starter.Login.LoginAdmin;

public class GetMembership {
    protected static String url ="http://128.199.206.32:8000/api/v1/admin/membership?page=1";
    public String token ="";

    @Step("the user has admin access rights")
    public String iSetPOSTApiEndpointsForGetAll(){
        return  url;
    }
    @Step("the user sends a GET request to the membership endpoint")
    public void iSendGETHTTPRequest(){
        SerenityRest.given().header("Authorization", "Bearer " + LoginAdmin.token).get(iSetPOSTApiEndpointsForGetAll());
    }
    @Step("the user should receive a response with a status code of 200 OK")
    public void iReceiveValidHTTPResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("the response should contain a list of all membership data")
    public void iReceivedTheToken(){
        restAssuredThat(response -> response.body("'meta'.'code'", equalTo(200)));
        restAssuredThat(response -> response.body("'meta'.'status'", equalTo("Success")));
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("Membership list")));
    }
}
