package methodsAPI;

import BaseSet.BaseSetUp;
import controls.FormatToJSon;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Pet;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;

public class PetServices extends BaseSetUp{

    private final String petUrl = "/v2/pet/";

    protected Response addNewPet(Pet pet) {
        return given(createRequest())
                .body(FormatToJSon.formatToJSon(pet))
                .post(petUrl)
                .then().extract().response().prettyPeek();
    }
    public Response getPetByID(int id) {
        return given(createRequest())
                .get(petUrl + id)
                .then()
                .assertThat()
                .body("id", Matchers.equalTo(id))
                .extract().response().prettyPeek();
    }
    public Response getPetByStatus(String status) {
        return  given(createRequest())
                .get(petUrl + "findByStatus?status=" + status)
                .then()
                .extract().response().prettyPeek();
    }
    protected Response updatePet(Pet pet) {
        return given(createRequest())
                .body(FormatToJSon.formatToJSon(pet))
                .put()
                .then().extract().response().prettyPeek();
    }

    protected Response deletePet(int id) {
        return given(createRequest())
                .delete(petUrl + id)
                .then().extract().response().prettyPeek();
    }
}