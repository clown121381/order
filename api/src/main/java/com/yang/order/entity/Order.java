package com.yang.order.entity;

import java.util.Date;

public class Order {
    private long id;
    private User user;
    private Menu menu;
    private long aid;
    private Date date;
    private int state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public long getAid() {
        return aid;
    }

    public void setAid(long aid) {
        this.aid = aid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Order(long id, User user, Menu menu, long aid, Date date, int state) {
        this.id = id;
        this.user = user;
        this.menu = menu;
        this.aid = aid;
        this.date = date;
        this.state = state;
    }

    public Order() {
    }
}
