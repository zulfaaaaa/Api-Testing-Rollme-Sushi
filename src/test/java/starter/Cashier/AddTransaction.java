package starter.Cashier;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;
import starter.Login.LoginCashier;

public class AddTransaction {
    protected static String url ="http://128.199.206.32:8000/api/v1/cashier/checkout";

    @Step("the user has cashier access rights")
    public String cashierSetPOSTApiEndpointsForGetAll(){
        return  url;
    }
    @Step("cashier sends a POST request to the membership endpoint with valid data for adding transaction")
    public void cashierSendGETHTTPRequestt() {

        String body = "{\n" +
                "    \"name\": \"Zulfa order 2\",\n" +
                "    \"order_option\": \"DINE_IN\",\n" +
                "    \"number_table\": 4,\n" +
                "    \"payment\": \"BCA\",\n" +
                "    \"items\": [\n" +
                "        {\n" +
                "            \"product_id\": 78,\n" +
                "            \"quantity\": 3,\n" +
                "            \"note\": \"jangan pake esshh\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + LoginCashier.token).contentType("application/json").body(reqBody.toString()).post(cashierSetPOSTApiEndpointsForGetAll());
    }
    @Step("cashier user should receive a response with a status code of 201 Created for adding transaction ")
    public void cashierReceiveValidHTTPResponseCode200(){
        restAssuredThat(response -> response.statusCode(201));
    }
    @Step("a new transaction with the provided information has been successfully created by cashier")
    public void cashierReceivedTheToken(){
        restAssuredThat(response -> response.body("'meta'.'code'", equalTo(201)));
        restAssuredThat(response -> response.body("'meta'.'status'", equalTo("success")));
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("success create order")));
        restAssuredThat(response -> response.body("'data'.'name'", equalTo("Zulfa order 2")));
    }
}
