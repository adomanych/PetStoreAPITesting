package business;

import asertions.BaseAssertions;
import asertions.PetAssertions;
import clients.PetClients;
import failModels.PetFailModel;
import io.restassured.response.Response;
import models.PetModel;
import org.apache.commons.lang3.RandomStringUtils;
import util.StatusCode;

public class PetBL {
    private PetClients petClient = new PetClients();
    private Response response;

    private PetModel doUpdate(PetModel petModel) {

        petModel.setName(RandomStringUtils.randomAlphabetic(10));
        petModel.getCategory().setName(RandomStringUtils.randomAlphabetic(10));

        return petModel;
    }

    public void addPetTest(PetModel testPetOne) {
        response = petClient.addNewPet(testPetOne);
        BaseAssertions.baseAssert(response, StatusCode.statusCode.OK.getValue());
        PetAssertions.areEquals(response.getBody().as(PetModel.class), testPetOne);
    }


    public void getPetByValidIDTest(PetModel testPetOne) {
        response = petClient.getPetByID(testPetOne.getId());
        BaseAssertions.baseAssert(response, StatusCode.statusCode.OK.getValue());
    }

    public void updatePetTest(PetModel testPetOne) {
        PetModel testPetTwo = petClient.getPetByID(testPetOne.getId()).as(PetModel.class);
        response = petClient.updatePet(doUpdate(testPetTwo));

        BaseAssertions.baseAssert(response, StatusCode.statusCode.OK.getValue());
        PetAssertions.areEquals(response.getBody().as(PetModel.class), testPetTwo);
    }

    public void deletePresentPetTest(PetModel testPetOne) {
        response = petClient.deletePet(testPetOne.getId());
        BaseAssertions.baseAssert(response, StatusCode.statusCode.OK.getValue());
    }

    public void uploadImageTest(PetModel testPetOne) {
        response = petClient.petPostUploadImage(testPetOne.getId());

        BaseAssertions.baseAssert(response, StatusCode.statusCode.OK.getValue());
    }

    public void getPetByStatusTest(String status) {
        response = petClient.getPetByStatus(status);

        BaseAssertions.baseAssert(response, StatusCode.statusCode.OK.getValue());
    }


    //Negative Test
    public void getPetByInvalIDTest(PetModel testPetModel) {
        response = petClient.getPetByID(testPetModel.getId());
        BaseAssertions.baseAssert(response, StatusCode.statusCode.OBJECT_NOT_FOUND.getValue());
    }

    public void deleteNotPresentPet(PetModel testPetModel) {
        response = petClient.deletePet(testPetModel.getId());
        BaseAssertions.baseAssertForPetWithoutBody(response, StatusCode.statusCode.OBJECT_NOT_FOUND.getValue());
    }
    public void addPetWithInvalidDataTest(PetFailModel petFailModel) {
        response = petClient.addNewPet(petFailModel);
        BaseAssertions.baseAssert(response, StatusCode.statusCode.OK.getValue());
    }
}
