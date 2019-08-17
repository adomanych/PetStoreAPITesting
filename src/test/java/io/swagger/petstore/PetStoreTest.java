package io.swagger.petstore;

import asertions.petAssertions.PetAssert;
import business.PetCreate;
import business.PetUpdate;
import io.restassured.response.Response;
import client.pet.PetServices;
import models.PetModel;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetStoreTest extends PetServices {
    private static PetModel testPetOne;
    //private static PetAssert petAssert;
    private PetModel testPetTwo;


    @BeforeAll
    public static void setUp() {
        System.out.println("Before all");
        testPetOne = new PetCreate().createPet();
    }

    @Test
    @Order(1)
    public void addNewPetTest() {
        Response response = addNewPet(testPetOne);
        PetModel petone = response.getBody().as(PetModel.class);
        PetAssert.assertThat(petone).isEqualTo(testPetOne);
    }

    @Test
    @Order(2)
    public void getPetTest() {
        Response response = getPetByID(testPetOne.getId());
        assertEquals(200, response.getStatusCode());
    }

    @Test
    @Order(5)
    public void getPetByStatusTest() {
        Response response = getPetByStatus(PetModel.Status.PENDING.getValue());
        assertEquals(200, response.getStatusCode());

    }

    @Test
    @Order(3)
    public void updatePetTest() {
        System.out.println(" updatePetTest");
        testPetTwo = new PetUpdate().doUpdate(testPetOne.getId());
        Response response = updatePet(testPetTwo);
        assertEquals(200, response.getStatusCode());
    }

    @Test
    @Order(4)
    public void deletePetTest() {
        System.out.println(" deletePetTest");
        Response response = deletePet(testPetOne.getId());
        assertEquals(200, response.getStatusCode());
    }
}


