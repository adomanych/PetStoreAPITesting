package asertions;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.NoArgsConstructor;

import static org.testng.Assert.assertEquals;


@NoArgsConstructor
public class BaseAssert {

    public static void baseAssertForContentType(Response response) {
        assertEquals(response.getContentType(), ContentType.JSON.toString());
    }

    public static void baseAssertWith200StatusCode(Response response) {
        assertEquals(response.getStatusCode(), 200);
    }

    public static void baseAssertWith400StatusCode(Response response) {
        assertEquals(response.getStatusCode(), 400);
    }

    public static void baseAssertWith405StatusCode(Response response) {
        assertEquals(response.getStatusCode(), 405);
    }

    public static void baseAssertWith404StatusCode(Response response) {
        assertEquals(response.getStatusCode(), 404);
    }

}
