package com.yang.order.entity;

import java.util.List;

public class OrderVo {
    private int code;
    private String msg;
    private int count;
    private List<Order> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Order> getData() {
        return data;
    }

    public void setData(List<Order> data) {
        this.data = data;
    }

    public OrderVo(int code, String msg, int count, List<Order> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public OrderVo() {
    }
}
