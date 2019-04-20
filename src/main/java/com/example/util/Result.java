package com.example.util;

public class Result {
    private Integer state;
    private String message;
    private Object Data;

    public Result(){}

    public Result(Integer state, String message, Object data) {
        this.state = state;
        this.message = message;
        Data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }
}
