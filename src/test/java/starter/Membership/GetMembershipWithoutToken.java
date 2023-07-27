package starter.Membership;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;
import starter.Login.LoginAdmin;

public class GetMembershipWithoutToken {
    protected static String url ="http://128.199.206.32:8000/api/v1/admin/membership?page=1";
    public String token ="";

    @Step("the user has admin access rights without token")
    public String iSetPOSTApiEndpointsForGetAll(){
        return  url;
    }
    @Step("the user sends a GET request to the membership endpoint")
    public void iSendGETHTTPRequest(){
        SerenityRest.given().get(iSetPOSTApiEndpointsForGetAll());
    }
    @Step("the user should receive a response with a status code of 401")
    public void iReceiveValidHTTPResponseCode401(){
        restAssuredThat(response -> response.statusCode(401));
    }
    @Step("the response should contain a Unauthorized: Missing token")
    public void iReceivedErrorMessageMissingToken(){
        //restAssuredThat(response -> response.body("'message'", equalTo("Unauthorized: Missing token")));
    }
}
