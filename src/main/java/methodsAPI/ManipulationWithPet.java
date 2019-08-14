package methodsAPI;

import controls.FormatFromJson;
import controls.FormatToJSon;
import controls.PetCreator;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Category;
import models.Pet;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;

public class ManipulationWithPet {

    private RequestSpecification requestSpecification;
    private Response response;
    private Pet pet;
    private final String petUrl = "/v2/pet";


    private RequestSpecification createRequest() {
        requestSpecification = new RequestSpecBuilder()
                .addHeader("api_key", "252525")
                .setBaseUri("http://petstore.swagger.io")
                .setBasePath(petUrl)
                .setContentType(ContentType.JSON)
                .build();
        return requestSpecification;
    }

    public Response addNewPet(Pet pet) {
        return given(createRequest())
                .body(FormatToJSon.formatToJSon(pet))
                .post()
                .then().extract().response().prettyPeek();
    }

    public Response getPet(int id) {
        return given(createRequest())
                .get("/" + id)
                .then()
                .assertThat()
                .body("id", Matchers.equalTo(id))
                .extract().response().prettyPeek();
    }

    public Response updatePet(Pet pet) {
        return given(createRequest())
                .body(FormatToJSon.formatToJSon(pet))
                .put()
                .then().extract().response().prettyPeek();
    }

    public Response deletePet(int id) {
        return given(createRequest())
                .delete("/" + id)
                .then().extract().response().prettyPeek();
    }
}