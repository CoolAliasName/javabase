package com.heyh.valid.reflection.bean;

public class ExtendType extends Type {

    public int pubIntExtendField;
    public String pubStringExtendField;
    private int prvIntExtendField;

    public ExtendType(){
        Log("Default Constructor");
    }

    ExtendType(int arg1, String arg2){
        pubIntExtendField = arg1;
        pubStringExtendField = arg2;

        Log("Constructor with parameters");
    }

    public void setIntExtendField(int field7) {
        this.prvIntExtendField = field7;
    }
    public int getIntExtendField() {
        return prvIntExtendField;
    }

    private void Log(String msg){
        System.out.println("ExtendType:" + msg);
    }

}