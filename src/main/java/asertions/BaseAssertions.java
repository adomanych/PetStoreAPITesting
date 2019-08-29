package asertions;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;


public class BaseAssertions {
    public static void baseAssert(Response response, int statusCode) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.getContentType(), ContentType.JSON.toString(),
                "Error - content type is incorrect");
        softAssert.assertEquals(response.getStatusCode(), statusCode,
                "StatusCode isn't equals");

        softAssert.assertAll();
    }
    public static void baseAssertForPetWithoutBody(Response response, int statusCode) {
        assertEquals(response.getStatusCode(), statusCode, "Status code isn't equals");
    }

}
