package com.heyh.collection.hashMap;

/**
 * 定义一个接口，对外暴露快速存取的方法
 *
 * 内部定义接口 Entry
 * @param <K>
 * @param <V>
 */
public interface MyMap<K, V> {

    public V put(K k, V v);
    public V get(K k);

    interface Entry<K, V> {
        public K getKey();
        public V getValue();
    }

}
