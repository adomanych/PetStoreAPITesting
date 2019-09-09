package business;

import asertions.BaseAssertions;
import asertions.OrderAssertions;
import clients.OrderClients;
import io.restassured.response.Response;
import models.OrderModel;
import util.StatusCode;

public class OrderBL {

    OrderClients orderClient = new OrderClients();
    private Response response;


//    public OrderBL(Logger log) {
//        this.log = log;
//    }


    public void getInventoriesTest() {
        response = orderClient.getInventories();

        BaseAssertions.baseAssert(response, StatusCode.statusCode.OK.getValue());
    }

    public void postOrderTest(OrderModel orderModel) {
        response = orderClient.postOrder(orderModel);

        BaseAssertions.baseAssert(response, StatusCode.statusCode.OK.getValue());
        OrderAssertions.areEquals(response.getBody().as(OrderModel.class), orderModel);
    }

    public void getByOrderIDTest(OrderModel orderModel) {
        response = orderClient.getByOrderID(orderModel.getId());

        BaseAssertions.baseAssert(response, StatusCode.statusCode.OK.getValue());

    }

    public void deleteOrderTest(OrderModel orderModel) {
        response = orderClient.deleteOrder(orderModel.getId());

        BaseAssertions.baseAssert(response, StatusCode.statusCode.OK.getValue());
    }

    //Negative

    public void getOrderByInvalidId(OrderModel orderModel) {
        response = orderClient.getByOrderID(orderModel.getId());

        BaseAssertions.baseAssert(response, StatusCode.statusCode.OBJECT_NOT_FOUND.getValue());
    }


}
