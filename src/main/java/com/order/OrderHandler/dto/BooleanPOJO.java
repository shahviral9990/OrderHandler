package com.order.OrderHandler.dto;

public class BooleanPOJO {
    private boolean response;

    public BooleanPOJO(boolean response) {
        this.response = response;
    }

    public BooleanPOJO() {
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }
}
