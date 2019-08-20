package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Accessors(chain = true)
public class OrderModel {

    @JsonProperty("petId")
    private int petId;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("id")
    private int id;

    @JsonProperty("shipDate")
    private String shipDate;

    @JsonProperty("complete")
    private boolean complete;

    @JsonProperty("status")
    private String status;


    @Getter
    public static enum Status {
        PLACED("placed"), APPROVED("approved"), DELIVERED("delivered");
        private String value;

        Status(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }
    }

    @Override
    public boolean equals(Object o) {
        boolean rezult;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderModel orderModel = (OrderModel) o;
        rezult =
                petId == orderModel.getPetId() &&
                        quantity == orderModel.getQuantity() &&
                        id == orderModel.getId() &&
                        shipDate.equals(orderModel.shipDate) &&
                        complete == orderModel.complete &&
                        status.equals(orderModel.getStatus());
        return rezult;
    }

}