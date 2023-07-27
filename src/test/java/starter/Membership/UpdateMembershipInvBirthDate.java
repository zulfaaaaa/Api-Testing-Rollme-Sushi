//package starter.Membership;
//import net.serenitybdd.rest.SerenityRest;
//import net.thucydides.core.annotations.Step;
//import org.json.JSONObject;
//
//import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
//import static org.hamcrest.Matchers.*;
//import starter.Login.LoginAdmin;
//
//public class UpdateMembershipInvBirthDate {
//    protected static String url ="http://128.199.206.32:8000/api/v1/admin/membership/33";
//
//    @Step
//    public String iSetPOSTApiEndpointsForUpdateInvBirthdate() { return  url;}
//    @Step
//    public void iSendGETHTTPRequestForUpdateInvBirthdate() {
//
//        String body = "{\n" +
//                "    \"name\":" + "Zulfa update 33" + ",\n" +
//                "    \"email\":" + "zulfaup@gmail.com" + ",\n" +
//                "    \"phone\":" + 85863223 + ",\n" +
//                "    \"birth_day\":" + "2001-12-28" + ",\n" +
//                "}";
//        JSONObject reqBody = new JSONObject(body);
//
//        SerenityRest.given().header("Authorization", "Bearer " + LoginAdmin.token).contentType("application/json").body(reqBody.toString()).put(iSetPOSTApiEndpointsForUpdateInvBirthdate());
//    }
//    @Step
//    public void iReceiveValidHTTPResponseCode400ForUpdateInvBirthdate(){
//        restAssuredThat(response -> response.statusCode(400));
//    }
//    @Step
//    public void iReceivedTheErrorMessageForUpdateInvBirthdate(){
//        restAssuredThat(response -> response.body("'meta'.'code'", equalTo(400)));
//    }
//}
