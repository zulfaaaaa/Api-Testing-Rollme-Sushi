package starter.Membership;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;
import starter.Login.LoginAdmin;

public class DeleteMembershipInvId {
    protected static String url ="http://128.199.206.32:8000/api/v1/admin/membership/100000";
    public String token ="";

    @Step
    public String iSetPOSTApiEndpointsForGetAll(){
        return  url;
    }
    @Step
    public void iSendGETHTTPRequest(){
        SerenityRest.given().header("Authorization", "Bearer " + LoginAdmin.token).delete(iSetPOSTApiEndpointsForGetAll());
    }
    @Step
    public void iReceiveValidHTTPResponseCode200(){
        restAssuredThat(response -> response.statusCode(404));
    }
    @Step
    public void iReceivedTheToken(){
        restAssuredThat(response -> response.body("'meta'.'code'", equalTo(404)));
    }
}
