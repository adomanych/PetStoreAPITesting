package business;

import asertions.BaseAssertions;
import asertions.PetAssertions;
import clients.PetClients;
import failModels.PetFailModel;
import io.restassured.response.Response;
import models.PetModel;
import org.apache.commons.lang3.RandomStringUtils;

public class PetBL {
    private PetClients petClient = new PetClients();
    private Response response;

//    public PetBL(PetModel petModel) {
//        this.testPetOne = petModel;
//        petClient = new PetClients();
//    }
//
//    public PetBL(PetFailModel petFailModel) {
//        this.petFailModel = petFailModel;
//        petClient = new PetClients();
//    }


    private PetModel doUpdate(PetModel petModel) {

        petModel.setName(RandomStringUtils.randomAlphabetic(10));
        petModel.getCategory().setName(RandomStringUtils.randomAlphabetic(10));

        return petModel;
    }

    public void addPetTest(PetModel testPetOne, int statusCode) {
        response = petClient.addNewPet(testPetOne);
        BaseAssertions.baseAssert(response, statusCode);
        PetAssertions.areEquals(response.getBody().as(PetModel.class), testPetOne);
    }

    public void addPetTest(PetFailModel petFailModel, int statusCode) {
        response = petClient.addNewPet(petFailModel);
        BaseAssertions.baseAssert(response, statusCode);
    }

    public void getPetByIDTest(PetModel testPetOne, int statusCode) {
        response = petClient.getPetByID(testPetOne.getId());
        BaseAssertions.baseAssert(response, statusCode);
    }

    public void updatePetTest(PetModel testPetOne, int statusCode) {
        PetModel testPetTwo = petClient.getPetByID(testPetOne.getId()).as(PetModel.class);
        response = petClient.updatePet(doUpdate(testPetTwo));
        BaseAssertions.baseAssert(response, statusCode);
        PetAssertions.areEquals(response.getBody().as(PetModel.class), testPetTwo);
    }

    public void deletePetTest(PetModel testPetOne, int statusCode) {
        response = petClient.deletePet(testPetOne.getId());
        BaseAssertions.baseAssert(response, statusCode);
    }

    public void uploadImageTest(PetModel testPetOne, int statusCode) {
        response = petClient.petPostUploadImage(testPetOne.getId());
        BaseAssertions.baseAssert(response, statusCode);
    }

    public void getPetByStatusTest(String status, int statusCode) {
        response = petClient.getPetByStatus(status);
        BaseAssertions.baseAssert(response, statusCode);
    }

}
