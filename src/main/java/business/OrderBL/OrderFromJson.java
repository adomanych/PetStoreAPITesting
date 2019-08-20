package business.OrderBL;

import io.restassured.response.Response;
import models.OrderModel;

public class OrderFromJson {
    public static OrderModel fromJson(Response response) {
        return response.as(OrderModel.class);

    }
}
