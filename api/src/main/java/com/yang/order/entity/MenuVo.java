package com.yang.order.entity;

import java.util.List;

public class MenuVo {
    private int code;
    private String msg;
    private int count;
    private List<Menu> data;

    public MenuVo(int code, String msg, int count, List<Menu> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
    public MenuVo() {
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public int getCount() {
        return count;
    }

    public List<Menu> getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setData(List<Menu> data) {
        this.data = data;
    }
}
