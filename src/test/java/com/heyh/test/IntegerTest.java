package com.heyh.test;

import org.junit.Test;

public class IntegerTest {

    @Test
    public void Test() {
        Demo demo = new Demo();
        System.out.println("Integer: " + demo.getId());
    }

    @Test
    public void recursion() {
        int n = 5;
        System.out.println(factorial(n));
    }

    public int factorial(int n) {
        /*int num = n;
        for (int i = n - 1; i > 0; i--) {
            num = num * i;
        }
        return num;*/

        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

}
