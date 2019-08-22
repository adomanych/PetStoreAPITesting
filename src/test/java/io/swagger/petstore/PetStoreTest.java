package io.swagger.petstore;

import builders.FailPetCreateBuilders;
import builders.PetCreateBuilders;
import business.PetBL;
import clients.PetClients;
import failModels.PetFailModel;
import models.PetModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


public class PetStoreTest extends PetClients {

    private List<PetModel> petModelList;
    private PetModel testPetOne;
    private PetBL petBL;


    @BeforeClass
    public void setUp() {
        testPetOne = new PetCreateBuilders().createPet();
        petBL = new PetBL();

        //  petBL = new PetBL(testPetOne);

    }

    @Test
    public void petTest() {
        petBL.addPetTest(testPetOne, 200);
        petBL.getPetByIDTest(testPetOne, 200);
        petBL.updatePetTest(testPetOne, 200);
        petBL.deletePetTest(testPetOne, 200);
        petBL.getPetByIDTest(testPetOne, 404);

    }
    @Test
    public void uploadImage() {
        petBL.uploadImageTest(testPetOne, 200);
    }



    @Test
    public void getInvalidPet() {
        petBL.getPetByIDTest(testPetOne, 404);
    }

    @Test(expectedExceptions = AssertionError.class)//?
    public void deleteNotPresentPet() {
        petBL.deletePetTest(testPetOne, 404);
    }


    @Test
    public void addPetWithInvalidData() {
        PetFailModel petFailModel = new FailPetCreateBuilders().createFailPet();
        petBL.addPetTest(petFailModel, 500);
    }

    @Test
    public void getPetByStatus() {//?
        petBL.getPetByStatusTest("ale", 200);
    }

}


