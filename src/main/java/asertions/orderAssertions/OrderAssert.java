package asertions.orderAssertions;

import models.OrderModel;
import org.testng.Assert;

public class OrderAssert {

    public static void areEquals(OrderModel actual, OrderModel orderModel) {
        Assert.assertEquals(actual, orderModel);

    }

}
