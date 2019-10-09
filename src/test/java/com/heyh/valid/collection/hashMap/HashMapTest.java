package com.heyh.valid.collection.hashMap;

import com.heyh.valid.collection.hashMap.impl.MyHashMap;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    @Test
    public void test1() {
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        for (int i = 0; i < 10; i++) {
            myHashMap.put("key: " + i, "value: " + i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("key " + i + ", value is: " + myHashMap.get("key: " + i));
        }
    }

    @Test
    public void test2() {
        Map<String, String> map = new HashMap<>();
    }

}
