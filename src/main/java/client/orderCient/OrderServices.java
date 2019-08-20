package client.orderCient;

import client.BaseSetUp;
import client.ClassForPath;
import io.restassured.response.Response;
import models.OrderModel;

import static io.restassured.RestAssured.given;

public class OrderServices extends BaseSetUp {

    public OrderServices() {
        super(ClassForPath.orderUri);
    }

    public Response getInventories() {
        return given(createRequest())
                .get(ClassForPath.petInventoryPath);
    }
    public Response postOrder(OrderModel orderModel) {
        return given(createRequest())
                .body(orderModel)
                .post(ClassForPath.orderPostPath);
    }
    public Response getByOrderID(int id) {
        return given(createRequest())
                .get(ClassForPath.orderPostPath + id);
    }

    public Response deleteOrder(int id) {
        return given(createRequest())
                .delete(ClassForPath.orderPostPath + id);
    }
}
