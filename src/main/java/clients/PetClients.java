package clients;

import failModels.PetFailModel;
import io.restassured.response.Response;
import models.PetModel;
import util.RestPath;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PetClients extends BaseSetUp{


    public PetClients() {
        super(RestPath.petUrl);
    }

    public Response addNewPet(PetModel pet) {
        return given(createRequest())
                .body(pet)
                .post();
    }

    public Response addNewPet(PetFailModel petFailModel) {
        return given(createRequest())
                .body(petFailModel)
                .post();
    }

    public Response getPetByID(int id) {
        return given(createRequest())
                .get("" + id);
    }

    public Response getPetByStatus(String status) {
        return given(createRequest())
                .get(RestPath.petFindByStatusPath + status);
    }


    public Response updatePet(PetModel pet) {
        return given(createRequest())
                .body(pet)
                .put();
    }

    public Response deletePet(int id) {
        return given(createRequest())
                .delete("" + id);
    }


    public Response petPostUploadImage(int id) {
        return given(createRequest())
                .pathParam("id", id)
                .contentType("multipart/form-data")
                .multiPart(new File("C:\\Users\\Арсен\\Desktop\\PetPicture.jpg"))
                //.formParam("", )
                .post("/{id}/uploadImage");
    }

//    protected Response uploadImage(int id, )
}