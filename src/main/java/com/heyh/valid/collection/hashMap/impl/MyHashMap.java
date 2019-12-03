package com.heyh.valid.collection.hashMap.impl;

import com.heyh.valid.collection.hashMap.MyMap;

import java.util.ArrayList;
import java.util.List;

/**
 * HashMap的要素之一，就是数组，
 * 第一步：定义数组，及数组初始化大小、扩容阀值
 *
 * @param <K>
 * @param <V>
 */
public class MyHashMap<K, V> implements MyMap<K, V> {

    // 数组的默认初始化长度
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    // 阀值比例
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int defaultInitCapacity;
    private float defaultLoadFactor;

    // Map当中entry的数量
    private int entryUseSize;

    // 数组
    private Entry<K, V>[] table = null;

    /**
     * 构造函数使用了"门面模式"
     * 即两个构造方法指向的其实是同一个，对外却暴露了两个"门面"
     * --------------------------------------------------------------------------------------
     */
    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int defaultInitCapacity, float defaultLoadFactor) {

        if (defaultInitCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + defaultInitCapacity);
        }

        if (defaultLoadFactor <= 0 || Float.isNaN(defaultLoadFactor)) {
            throw new IllegalArgumentException("Illegal load factor: " + defaultLoadFactor);
        }

        this.defaultInitCapacity = defaultInitCapacity;
        this.defaultLoadFactor = defaultLoadFactor;

        table = new Entry[this.defaultInitCapacity];
    }
    /**--------------------------------------------------------------------------------------*/

    /**
     * HashMap的要素之一，这里体现了单链表
     *
     * @param <K>
     * @param <V> --------------------------------------------------------------------------------------
     */
    class Entry<K, V> implements MyMap.Entry<K, V> {

        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry() {

        }

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Entry next() {
            return this.next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }
    /**--------------------------------------------------------------------------------------*/

    /**
     * 从put的实现来看，若是频繁的进行 resize/rehash 操作，会影响性能
     *
     * @param k
     * @param v
     * @return
     */
    @Override
    public V put(K k, V v) {
        V oldValue = null;
        // 是否需要扩容？
        // 扩容完毕，肯定需要重新散列
        if (entryUseSize >= defaultInitCapacity * defaultLoadFactor) {
            resize(2 * defaultInitCapacity);
        }

        // 得到hash值，计算出数组中的位置
        int index = hash(k) & (defaultInitCapacity - 1);
        if (table[index] == null) { // 如果通过hash值定位Entry[]后,Entry[]中的元素为null，那么直接将新的Entry放入
            table[index] = new Entry<K, V>(k, v, null);
            ++entryUseSize;
        } else { // 如果不为null,需要遍历单链表,此时又会存在两种情况（更新or插入）
            Entry<K, V> entry = table[index];
            Entry<K, V> e = entry;
            while (e != null) {
                if (k == e.getKey() || k.equals(e.getKey())) { // 如果传入的key值已存在，则更新value值
                    oldValue = e.value;
                    e.value = v;
                    return oldValue;
                }
                e = e.next; // 如果传入的key值不存在，则一直查找链表中到下一位，直到找到最后一位（链表最后一位的next == null）
            }
            table[index] = new Entry<K, V>(k, v, entry); // 遍历玩整个链表还是找不到对应的key值，则需要"挤压"单链表将新的Entry<K, V>插入到链表到第一位
            ++entryUseSize;
        }
        return oldValue;
    }

    @Override
    public V get(K k) {
        int index = hash(k) & (defaultInitCapacity - 1);

        if (table[index] == null) {
            return null;
        } else {
            Entry<K, V> entry = table[index];
            do {
                if (k == entry.getKey() || k.equals(entry.getKey())) {
                    return entry.getValue();
                }
                entry = entry.next;
            } while (entry != null);
        }

        return null;
    }

    /**
     * resize/rehash的过程，就是数组变大，原来数组中的entry元素一个个的put到新数组的过程，需要注意的是一些状态变量的改变。
     *
     * @param i
     */
    private void resize(int i) {
        Entry[] newTable = new Entry[i];
        // 改变了数组的大小
        defaultInitCapacity = i;
        entryUseSize = 0;
        rehash(newTable);
    }

    private void rehash(Entry<K, V>[] newTable) {
        // 得到原来老的 Entry 集合，注意遍历单链表
        List<Entry<K, V>> entryList = new ArrayList<>();
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                do {
                    entryList.add(entry);
                    entry.next();
                } while (entry != null);
            }
        }

        // 覆盖旧引用
        if (newTable.length > 0) {
            table = newTable;
        }

        // 所谓的重新hash就是重新put Entry到HashMap
        for (Entry<K, V> entry : entryList) {
            put(entry.getKey(), entry.getValue());
        }
    }

    // hash函数
    private int hash(K k) {
        int hashCode = k.hashCode();
        hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
        return hashCode ^ (hashCode >>> 7) ^ (hashCode >>> 4);
    }
}
