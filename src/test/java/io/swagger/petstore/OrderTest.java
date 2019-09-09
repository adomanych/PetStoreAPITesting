package io.swagger.petstore;

import builders.OrderCreateBulilders;
import builders.PetCreateBuilders;
import business.OrderBL;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.OrderModel;
import models.PetModel;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import util.Listener;

@Listeners(Listener.class)
public class OrderTest {

    private OrderModel testOrderOne;
    private PetModel testPetModel;
    private OrderBL orderBL;


    @BeforeClass
    public void setUp(ITestContext context) {

        orderBL = new OrderBL();
        testPetModel = new PetCreateBuilders().createPet();
        testOrderOne = new OrderCreateBulilders().createNewOreder(testPetModel.getId());

    }

    @Description()
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void orderTest() {
        orderBL.getInventoriesTest();
        orderBL.postOrderTest(testOrderOne);
        orderBL.deleteOrderTest(testOrderOne);
        orderBL.getOrderByInvalidId(testOrderOne);

    }


}
