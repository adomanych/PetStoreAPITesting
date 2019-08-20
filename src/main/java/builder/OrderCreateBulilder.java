package builder;

import business.OrderBL.GetDate;
import models.OrderModel;
import org.apache.commons.lang3.RandomStringUtils;

public class OrderCreateBulilder {
    private int id = Integer.parseInt(RandomStringUtils.randomNumeric(6));
    private int quantity = Integer.parseInt(RandomStringUtils.randomNumeric(1));
    private String status = OrderModel.Status.DELIVERED.getValue();
    private OrderModel orderModel;


    public OrderModel createNewOreder(int petId) {
        orderModel = OrderModel.builder()
                .id(id)
                .petId(petId)
                .quantity(quantity)
                .shipDate(GetDate.getShipDate())
                .status(status)
                .complete(true)
                .build();
        return orderModel;
    }
}
