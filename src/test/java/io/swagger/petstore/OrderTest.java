package io.swagger.petstore;

import builders.OrderCreateBulilders;
import builders.PetCreateBuilders;
import business.OrderBL;
import models.OrderModel;
import models.PetModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderTest {

    private OrderModel testOrderOne;
    private PetModel testPetModel;
    private OrderBL orderBL;


    @BeforeClass
    public void setUp() {
        orderBL = new OrderBL();
        testPetModel = new PetCreateBuilders().createPet();
        testOrderOne = new OrderCreateBulilders().createNewOreder(testPetModel.getId());

    }

    @Test
    public void orderTest() {
        orderBL.getInventoriesTest();
        orderBL.postOrderTest(testOrderOne);
        orderBL.deleteOrderTest(testOrderOne);
        orderBL.getOrderByInvalidId(testOrderOne);
    }


}
