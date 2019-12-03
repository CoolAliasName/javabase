package com.heyh.valid.jvm.jvmload.example1;

public class ATest {
    public static void main(String[] args) {
        AClass.a++;
        System.out.println("a的值："+AClass.a);//输出：a的值：2
    }

}