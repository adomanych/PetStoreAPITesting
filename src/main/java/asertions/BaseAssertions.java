package asertions;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;


public class BaseAssertions {
    public static void baseAssert(Response response, int statusCode) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.getContentType(), ContentType.JSON.toString(),
                "Error - content type is incorrect");
        softAssert.assertEquals(response.getStatusCode(), statusCode,
                "StatusCode isn't equals");

        softAssert.assertAll();
    }

}
