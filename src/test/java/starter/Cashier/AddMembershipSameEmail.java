//package starter.Membership;
//import net.serenitybdd.rest.SerenityRest;
//import net.thucydides.core.annotations.Step;
//import org.json.JSONObject;
//
//import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
//import static org.hamcrest.Matchers.*;
//import starter.Login.LoginAdmin;
//
//public class AddMembershipSameEmail {
//    protected static String url ="http://128.199.206.32:8000/api/v1/admin/membership";
//    // public String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MiwiZXhwIjoxNjg2NzE4MDk1fQ.1T1uu0I-tyfb-Gbitkr3rEdzEqknrUhA-N_3_FmD_B0";
//
//    @Step("the user has admin access rights")
//    public String iSetPOSTApiEndpointsForGetAll(){
//        return  url;
//    }
//    @Step("the user sends a POST request to the membership endpoint with post valid data")
//    public void iSendGETHTTPRequest() {
//
//        String body = "{\n" +
//                "    \"name\":" + "Zulfa same email" + ",\n" +
//                "    \"email\":" + "zulfamembe211@gmail.com" + ",\n" +
//                "    \"phone\":" + 873424 + ",\n" +
//                "    \"birth_day\":" + "2005-03-23" + ",\n" +
//                "}";
//        JSONObject reqBody = new JSONObject(body);
//
//        SerenityRest.given().header("Authorization", "Bearer " + LoginAdmin.token).contentType("application/json").body(reqBody.toString()).post(iSetPOSTApiEndpointsForGetAll());
//    }
//    @Step("the user should receive a response with a status code of 201 Created")
//    public void iReceiveValidHTTPResponseCode200(){
//        restAssuredThat(response -> response.statusCode(201));
//    }
//    @Step("a new membership with the provided information has been successfully created")
//    public void iReceivedTheToken(){
//        restAssuredThat(response -> response.body("'meta'.'code'", equalTo(201)));
//        restAssuredThat(response -> response.body("'meta'.'status'", equalTo("Success")));
//        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("Membership created")));
//        restAssuredThat(response -> response.body("'data'.'name'", equalTo("Zulfa same email")));
//    }
//}
