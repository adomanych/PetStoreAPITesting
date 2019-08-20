package client.petClient;

import client.BaseSetUp;
import client.ClassForPath;
import io.restassured.response.Response;
import models.PetModel;

import static io.restassured.RestAssured.given;

public class PetServices extends BaseSetUp {


    public PetServices() {
        super(ClassForPath.petUrl);
    }

    public Response addNewPet(PetModel pet) {
        return given(createRequest())
                .body(pet)
                .post();
    }

    public Response getPetByID(int id) {
        return given(createRequest())
                .get("" + id);
    }

    public Response getPetByStatus(String status) {
        return given(createRequest())
                .get(ClassForPath.petFindByStatusPath + status);
    }

    protected Response updatePet(PetModel pet) {
        return given(createRequest())
                .body(pet)
                .put();
    }

    public Response deletePet(int id) {
        return given(createRequest())
                .delete("" + id);
    }

//    protected Response uploadImage(int id, )
}