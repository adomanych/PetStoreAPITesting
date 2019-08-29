package util;

import lombok.Getter;

public class StatusCode {
    @Getter
    public enum statusCode {
        OK(200),
        INVALID_INPUT(400),
        OBJECT_NOT_FOUND(404),
        SERVER_EROOR(500);

        private int value;

        statusCode(int value) {
            this.value = value;
        }


    }
}
