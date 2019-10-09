package com.heyh.valid.io.serialize.model;

import java.io.Serializable;

public class Serialize extends Parent implements Serializable {

    private static final long seriaVersionUID = 12306;
//    private static final long seriaVersionUID = -2337937881709830076L;

    private int id;
    private String name;

    // 静态成员属于类的静态域，序列化之后序列对象实例域的信息，不会序列化静态域
//    static String addr;

    // 没有实现序列化的成员变量会直接导致这个对象序列化失败
    // 但是可以通过 transient 关键字指定成员不进行序列化
    // 可以手动序列化
    transient NoSerialize noSerialize;

    public Serialize(int p_id) {
        super(p_id);
    }

//    public int time; // 序列化到文件后新增到成员变量

    /*public Serialize(int id, String name, String addr) {
        this.id = id;
        this.name = name;
        this.addr = addr;
        noSerialize = new NoSerialize(id + 20000000);
        System.out.println("进入构造方法，参数 id: " + id + ", name: " + name + ", addr: " + addr);
    }*/

    public Serialize(int p_id, int id, String name) {
        super(p_id);
        this.id = id;
        this.name = name;
        noSerialize = new NoSerialize(id + 20000000);
        System.out.println("进入构造方法，参数 id: " + id + ", name: " + name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public String getAddr() {
        return this.addr;
    }*/

    public NoSerialize getNoSerialize() {
        return this.noSerialize;
    }

    public void setNoSerialize(NoSerialize noSerialize) {
        this.noSerialize = noSerialize;
    }

    @Override
    public String toString() {
        return "Serialize{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", noSerialize=" + noSerialize +
                '}';
    }
}
