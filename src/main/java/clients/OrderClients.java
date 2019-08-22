package clients;

import io.restassured.response.Response;
import models.OrderModel;
import util.RestPath;

import static io.restassured.RestAssured.given;

public class OrderClients extends BaseSetUp {

    public OrderClients() {
        super(RestPath.orderUri);
    }

    public Response getInventories() {
        return given(createRequest())
                .get(RestPath.petInventoryPath);
    }
    public Response postOrder(OrderModel orderModel) {
        return given(createRequest())
                .body(orderModel)
                .post(RestPath.orderPostPath);
    }
    public Response getByOrderID(int id) {
        return given(createRequest())
                .get(RestPath.orderPostPath + id);
    }

    public Response deleteOrder(int id) {
        return given(createRequest())
                .delete(RestPath.orderPostPath + id);
    }
}
