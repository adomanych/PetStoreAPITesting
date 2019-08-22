package asertions;

import models.OrderModel;

import static org.testng.Assert.assertEquals;

public class OrderAssertions {
    public static void areEquals(OrderModel actual, OrderModel expected) {
        assertEquals(actual, expected);
    }

}
