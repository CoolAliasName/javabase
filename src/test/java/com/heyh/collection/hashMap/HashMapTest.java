package com.heyh.collection.hashMap;

import com.heyh.collection.hashMap.impl.MyHashMap;
import org.junit.Test;

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

}
