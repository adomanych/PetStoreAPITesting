package business;

import asertions.BaseAssertions;
import asertions.OrderAssertions;
import clients.OrderClients;
import io.restassured.response.Response;
import models.OrderModel;

public class OrderBL {

    OrderClients orderClient = new OrderClients();
    private Response response;


    public void getInventoriesTest(int statusCode) {
        response = orderClient.getInventories();
        BaseAssertions.baseAssert(response, statusCode);
    }

    public void postOrderTest(OrderModel orderModel, int statusCode) {
        response = orderClient.postOrder(orderModel);
        BaseAssertions.baseAssert(response, statusCode);
        OrderAssertions.areEquals(response.getBody().as(OrderModel.class), orderModel);
    }

    public void getByOrderIDTest(OrderModel orderModel, int statusCode) {
        response = orderClient.getByOrderID(orderModel.getId());
        BaseAssertions.baseAssert(response, statusCode);

    }

    public void deleteOrderTest(OrderModel orderModel, int statusCode) {
        response = orderClient.deleteOrder(orderModel.getId());
        BaseAssertions.baseAssert(response, statusCode);
    }


}
