package com.heyh.collection.arrayList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

    @Test
    public void test01() {

        List list = new ArrayList();

        list.add("1212");

        Object set = list.set(0, "3232");

        System.out.println(set);

    }

}
