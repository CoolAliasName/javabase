package com.heyh.test;

import org.junit.Test;

import java.util.*;

public class MapTest {

    @Test
    public void hashMap() {
        Map map = new HashMap<>();
        map.put(null, 1);
        System.out.println(map.get(null));

        map.put(null, 2);
        System.out.println(map.get(null));
    }

    @Test
    public void hashSet() {
        HashSet set = new HashSet();
    }

    @Test
    public void list() {
        List list = new ArrayList();
        String s = "1";
        list.add(s);
        sys(list);

        s = "2";
        sys(list);
    }

    public void sys(List list) {
        for (Object obj: list) {
            System.out.println(obj.toString());
        }
    }

}