package io.swagger.petstore;

import controls.PetCreator;
import controls.PetUpdate;
import io.restassured.response.Response;
import methodsAPI.ManipulationWithPet;
import models.Pet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetStoreTest extends ManipulationWithPet {
    private static Pet testPetOne;
    private Pet testPetTwo;
    @BeforeAll
    public static void setUp() {
        System.out.println("Before all");
        testPetOne = new PetCreator().createPet();
    }
    @Test
    public void addNewPetTest() {
        System.out.println(" addNewPetTest");
        Response response = addNewPet(testPetOne);
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void getPetTest() {
        System.out.println(" getPetTest");
        Response response = getPet(testPetOne.getId());
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void updatePetTest() {
        System.out.println(" updatePetTest");
        testPetTwo = new PetUpdate().doUpdate(testPetOne.getId());
        Response response = updatePet(testPetTwo);
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void deletePetTest() {
        System.out.println(" deletePetTest");
        Response response = deletePet(123);
        assertEquals(200, response.getStatusCode());
    }
}


