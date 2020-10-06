
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JsonPathInRestAssured {
    public static Response res;
    @BeforeTest
    public void setup(){
        RestAssured.baseURI = "https://postman-echo.com";
        RestAssured.basePath = "/GET";
        res = given()
                .when()
                .get();
    }

    @Test
    public void testBody(){
        String json = res.getBody().asString();
        JsonPath jsonPath = new JsonPath(json);
        String str = jsonPath.getJsonObject("headers.x-forwarded-port");
        System.out.println("Port Found : "+str);
        Assert.assertEquals(str, "443");
    }
}
