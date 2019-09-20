package com.heyh.io.serialize.model;

public class Parent {

    private int p_id;

    public Parent() {

    }

    public Parent(int p_id) {
        this.p_id = p_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "p_id=" + p_id +
                '}';
    }
}
