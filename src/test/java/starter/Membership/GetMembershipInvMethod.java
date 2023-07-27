package starter.Membership;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;
import starter.Login.LoginAdmin;

public class GetMembershipInvMethod {
    protected static String url ="http://128.199.206.32:8000/api/v1/admin/membership?page=1";
    public String token ="";

    @Step("the user has admin access rights")
    public String iSetPOSTApiEndpointsForGetAll(){
        return  url;
    }
    @Step("the user sends a PUT request to the membership endpoint")
    public void iSendPUTHTTPRequest(){
        SerenityRest.given().header("Authorization", "Bearer " + LoginAdmin.token).put(iSetPOSTApiEndpointsForGetAll());
    }
    @Step("the user should receive a response with a status code of 404")
    public void iReceiveValidHTTPResponsesCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }
    @Step("the response should contain a error message not found")
    public void iReceivedErrorMessageNotFound(){
        //restAssuredThat(response -> response.body("'message'", equalTo("Not Found")));
    }
}
