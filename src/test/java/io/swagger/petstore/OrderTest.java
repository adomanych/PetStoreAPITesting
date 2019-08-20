package io.swagger.petstore;

import asertions.BaseAssert;
import asertions.orderAssertions.OrderAssert;
import builder.OrderCreateBulilder;
import builder.PetCreateBuilder;
import business.OrderBL.OrderFromJson;
import client.orderCient.OrderServices;
import client.petClient.PetServices;
import io.restassured.response.Response;
import models.OrderModel;
import models.PetModel;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class OrderTest {

    private static OrderModel testOrderOne;
    private static PetModel testPetModel;
    private static OrderServices orderServices;
    private static PetServices petServices;
    private Response response;


    @BeforeSuite
    public static void setUp() {
        petServices = new PetServices();
        testPetModel = new PetCreateBuilder().createPet();
        testOrderOne = new OrderCreateBulilder().createNewOreder(testPetModel.getId());
        orderServices = new OrderServices();
    }
    @Test
    public void getPetInventory() {
        petServices.addNewPet(testPetModel);
        response = orderServices.getInventories();
        BaseAssert.baseAssertWith200StatusCode(response);

        response = orderServices.postOrder(testOrderOne);
        BaseAssert.baseAssertWith200StatusCode(response);
        OrderAssert.areEquals(OrderFromJson.fromJson(response), testOrderOne);

        response = orderServices.getByOrderID(testOrderOne.getId());
        BaseAssert.baseAssertWith200StatusCode(response);
        OrderAssert.areEquals(OrderFromJson.fromJson(response), testOrderOne);

        response = orderServices.deleteOrder(testOrderOne.getId());
        BaseAssert.baseAssertWith200StatusCode(response);

        petServices.deletePet(testPetModel.getId());

    }


}
