package clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseSetUp {
    private RequestSpecification requestSpecification;
    private String pathUri;


    public BaseSetUp(String pathUri) {
        this.pathUri = pathUri;
    }

    public RequestSpecification createRequest() {
        requestSpecification = new RequestSpecBuilder()
                .addHeader("api_key", "252525")
                .setBaseUri("http://petstore.swagger.io")
                .setBasePath(pathUri)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .setContentType(ContentType.JSON)
                .build();
        return requestSpecification;
    }
}
