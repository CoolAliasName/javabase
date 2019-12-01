package com.heyh.valid.designpattern.singleton.enumSingleTon;

public class SingleTon {

    public static void main(String[] args) {
        EnumSingleTon enumSingleTon1 = EnumSingleTon.INSTANCLE;
        EnumSingleTon enumSingleTon2 = EnumSingleTon.INSTANCLE;

        System.out.println("instance1 == instance2 ? " + (enumSingleTon1 == enumSingleTon2));
        System.out.println(enumSingleTon1);
    }

}
