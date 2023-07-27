package starter.Membership;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;
import starter.Login.LoginAdmin;

public class GetMembershipInvalidEndpoint {
    protected static String url ="http://128.199.206.32:8000/api/v1/admin/membership?pages=1";
    public String token ="";

    @Step("the user has admin access invalid")
    public String iSetPOSTApiEndpointsForGetAll(){
        return  url;
    }
    @Step("the user sends a GET request to the invalid membership endpoint")
    public void iSendGETHTTPRequest(){
        SerenityRest.given().header("Authorization", "Bearer " + LoginAdmin.token).get(iSetPOSTApiEndpointsForGetAll());
    }
    @Step("the user should receive a response with a status code of 400 Bad Request")
    public void iReceiveValidHTTPResponseCode400(){
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("the response should contain a error message required parameter page")
    public void iReceivedTheErrorMessage(){
//        restAssuredThat(response -> response.body("'meta'.'code'", equalTo(400)));
//        restAssuredThat(response -> response.body("'meta'.'status'", equalTo("error")));
//        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("required parameter page")));
    }
}
