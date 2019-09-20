package com.heyh.io.serialize.model;

public class NoSerialize {

    private int id;

    public NoSerialize() {
    }

    public NoSerialize(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "NoSerialize{" +
                "id=" + id +
                '}';
    }
}
