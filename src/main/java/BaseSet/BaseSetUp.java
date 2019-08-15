package BaseSet;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseSetUp {
    private RequestSpecification requestSpecification;
    public RequestSpecification createRequest() {
        requestSpecification = new RequestSpecBuilder()
                .addHeader("api_key", "252525")
                .setBaseUri("http://petstore.swagger.io")
                .setContentType(ContentType.JSON)
                .build();
        return requestSpecification;
    }
}
