package com.heyh.valid.enums;

public enum Color {

    RED("红色", (short) 1), GREEN("绿色", (short) 2);

    private String name;
    private short code;

    private Color(String name, short code) {
        this.name = name;
        this.code = code;
    }

    public void getColor() {
        System.out.println("这是 " + this.name);
    }

}
