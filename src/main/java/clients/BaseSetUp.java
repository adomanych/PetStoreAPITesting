package clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static util.Listener.*;


public class BaseSetUp {

    private String pathUri;

    public BaseSetUp(String pathUri) {
        this.pathUri = pathUri;
    }

    public RequestSpecification createRequest() {

        return new RequestSpecBuilder()
                .addHeader("api_key", "252525")
                .setBaseUri("http://petstore.swagger.io")
                .setBasePath(pathUri)
                .addFilter(new RequestLoggingFilter(LogDetail.ALL, false, contextPrint))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL, false, contextPrint))
                .setContentType(ContentType.JSON)
                .build();
    }
}
