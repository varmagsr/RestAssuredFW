
import io.restassured.RestAssured;
import org.testng.annotations.Test;


public class APITestRequestBDD {

    @Test
    public void GetBookingIds_VerifyStatusCode() {
       System.out.println("BDD execution start");

        // Given
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                // When
                .when()
                .get("/booking")
                // Then
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK");


                // To verify booking count
               // .body("bookingid.sum()", Matchers.hasSize(10))
                // To verify booking id at index 3
                //.body("bookingid[3]", Matchers.equalTo(1));


        System.out.println("BDD execution END");

    }


}
