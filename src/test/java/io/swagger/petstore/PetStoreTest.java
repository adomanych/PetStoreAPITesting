package io.swagger.petstore;

import asertions.BaseAssert;
import asertions.petAssertions.PetAssert;
import builder.PetCreateBuilder;
import business.petBL.PetFromJsonBL;
import business.petBL.PetUpdateBL;
import client.petClient.PetServices;
import io.restassured.response.Response;
import models.PetModel;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PetStoreTest extends PetServices {
    private static PetModel testPetOne;
    private PetModel testPetTwo;
    private List<PetModel> petModelList;
    private Response response;


    @BeforeSuite
    public static void setUp() {
        System.out.println("Before all");
        testPetOne = new PetCreateBuilder().createPet();

    }

    @Test
    public void testCycle() {
        response = addNewPet(testPetOne);
        BaseAssert.baseAssertWith200StatusCode(response);
        PetAssert.assertThat(PetFromJsonBL.fromJson(response))
                .isEqualTo(testPetOne)
                .assertAll();

        response = getPetByID(testPetOne.getId());
        BaseAssert.baseAssertWith200StatusCode(response);
        PetAssert.assertThat(PetFromJsonBL.fromJson(response)).isEqualTo(testPetOne);


        testPetTwo = PetUpdateBL.doUpdate(PetFromJsonBL.fromJson(response));
        response = updatePet(testPetTwo);
        BaseAssert.baseAssertWith200StatusCode(response);
        PetAssert.assertThat(PetFromJsonBL.fromJson(response))
                .hasId(testPetTwo.getId())
                .hasCategory(testPetTwo.getCategory())
                .assertAll();


        response = deletePet(testPetOne.getId());
        BaseAssert.baseAssertWith200StatusCode(response);

    }


    @Test
    public void getPetByStatusTest() {
        Response response = getPetByStatus(PetModel.Status.SOLD.getValue());
        petModelList = new ArrayList<>();
        petModelList = Arrays.asList(response.as(PetModel[].class));
        BaseAssert.baseAssertWith200StatusCode(response);
        System.out.println(petModelList.get(0));

    }
}


