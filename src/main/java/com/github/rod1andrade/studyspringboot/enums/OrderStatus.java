package com.github.rod1andrade.studyspringboot.enums;

import java.util.Arrays;

/**
 * @author Rodrigo Andrade
 */
public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private final int code;

    OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static OrderStatus valueOf(int code) {
        return Arrays.stream(OrderStatus.values())
                .filter(orderStatus -> orderStatus.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
