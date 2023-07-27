package starter.Login;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class LoginAdmin {
    protected static String url ="http://128.199.206.32:8000/api/v1/admin/login";
    public static String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MiwiZXhwIjoxNjg3NzA5MzMxfQ.i2hz0KEJi30yucbjB9CygThcOXycmIBAgV1IX4buTZ0";
    @Step("I set the api POST endpoint")
    public String iSetPOSTApiEndpoints(){
        return  url;
    }
    @Step("I send HTTP POST request")
    public void iSendGETHTTPRequest(){
        String body = "{\"username\":\"admin\", \"password\": \"admin\" }";

        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(iSetPOSTApiEndpoints());
    }

    @Step("I receive valid HTTP response code 200")
    public void iReceiveValidHTTPResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I received the token")
    public void iReceivedTheToken(){
        restAssuredThat(response -> response.body("'meta'.'code'", equalTo(200)));
        restAssuredThat(response -> response.body("'meta'.'status'", equalTo("success")));
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("successfully login")));
        restAssuredThat(response -> response.body("'data'.'username'", equalTo("admin")));
        restAssuredThat(response -> response.body("'data'.'user_code'", equalTo("AM-01")));
    }
}
