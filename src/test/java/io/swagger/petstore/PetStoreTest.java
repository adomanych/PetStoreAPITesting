package io.swagger.petstore;

import builders.FailPetCreateBuilders;
import builders.PetCreateBuilders;
import business.PetBL;
import clients.PetClients;
import failModels.PetFailModel;
import models.PetModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import util.Listener;


@Listeners(Listener.class)
public class PetStoreTest extends PetClients {


    private PetModel testPetOne;
    private PetBL petBL;


    @BeforeClass
    public void setUp() {
        testPetOne = new PetCreateBuilders().createPet();
        petBL = new PetBL();

    }

    @Test
    public void petTest() {
        petBL.addPetTest(testPetOne);
        petBL.getPetByValidIDTest(testPetOne);
        petBL.updatePetTest(testPetOne);
        petBL.deletePresentPetTest(testPetOne);
        petBL.getPetByInvalIDTest(testPetOne);


    }

    @Test
    public void uploadImage() {
        petBL.uploadImageTest(testPetOne);

    }

    @Test
    public void getInvalidPet() {
        petBL.getPetByInvalIDTest(testPetOne);

    }

    @Test
    public void deleteNotPresentPet() {
        petBL.deleteNotPresentPet(testPetOne);

    }

    @Test
    public void addPetWithInvalidData() {
        PetFailModel petFailModel = new FailPetCreateBuilders().createFailPet();
        petBL.addPetWithInvalidDataTest(petFailModel);

    }

    @Test
    public void getPetByStatus() {
        petBL.getPetByStatusTest("sold");

    }

}


