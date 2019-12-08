package com.heyh.test;

import org.junit.Test;

public class MathTest {

    @Test
    public void  test01() {
        int i = 1;
        int j = 1;
        int x = i++;
        System.out.println(x);
        int y = ++j;
        System.out.println(y);
    }

}
