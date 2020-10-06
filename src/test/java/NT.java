import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NT {

    @Test
    public void PetInfo()
    {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet/";

        // Get the RequestSpecification of the request that you want to sent
        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.
        RequestSpecification httpRequest = RestAssured.given();

        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        Response response = httpRequest.request(Method.GET, String.valueOf(2));

        // Now let us print the body of the message to see what response
        // we have received from the server
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
        // ResponseBody Body = response.getBody();

        JsonPath jsonPathEvaluator = response.jsonPath();

        System.out.println("Pet Name " + jsonPathEvaluator.get("tags"));


    }

}
