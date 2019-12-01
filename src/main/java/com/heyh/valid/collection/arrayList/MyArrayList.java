package com.heyh.valid.collection.arrayList;

import java.util.*;

public class MyArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable {

    private static final long serialVersionUID = 8683452581122192189L; // 版本号

    transient Object[] elementData; // ArrayList底层数据结构为对象数组，存放实际对象，被标记为 transient 表示不会被序列化

    /**
     * 当ArrayList构造函数显示当指定数组长度为0时，将EMPTY_ELEMENTDATA赋值给elementData数组
     */
    private final static Object[] EMPTY_ELEMENTDATA = {};

    /**
     * 当ArrayList构造函数没有指定数组长度时，ArrayList内部使用当数组为 DEFAULTCAPACITY_EMPTY_ELEMENTDATA
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private static final int DEFAULT_CAPACITY = 10; // 构造函数没指定数组大小时，默认数组大小为 10

    private int size; // 实际 ArrayList 中存放元素的个数，默认是 0

    private final static int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8; // ArrayList中对象数组的最大容量

    /**
     * 无参构造函数
     * 若创建ArrayList时没有指定大小，则ArrayList内部实现数组elementData指向内存块常量池中的DEFAULTCAPACITY_EMPTY_ELEMENTDATA
     */
    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * 带大小的构造方法
     *
     * @param initCapacity
     */
    public MyArrayList(int initCapacity) {
        if (initCapacity > 0) {
            elementData = new Object[initCapacity];
        } else if (initCapacity == 0) {
            elementData = EMPTY_ELEMENTDATA;
        } else if (initCapacity < 0) {
            throw new IllegalArgumentException("Illegal capacity: " + initCapacity);
        }
    }

    /**
     * 传入集合的构造方法
     *
     * @param c
     */
    public MyArrayList(Collection<? extends E> c) {
        // 1、将 collection 转化为数组
        elementData = c.toArray();
        // 2、对数组大小进行判断
        if ((size = elementData.length) != 0) { // 传入的 collection 为非空集合
            if (elementData.getClass() != Object[].class) { // collection转换的数组是否是Object类型的
                elementData = Arrays.copyOf(elementData, size, Object[].class); // 若数组不是Object类型的就复制一份新的Object[]
            }
        } else { // 集合大小为空，设置实现数组为空
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    /**
     * 指定下标索引位置存放元素
     *
     * @param index
     * @param element
     * @return
     */
    public E set(int index, E element) {
        rangeCheck(index); // 检查索引是否有效
        // 旧值
        E oldValue = (E) elementData[index];
        // 新值
        elementData[index] = element;
        return oldValue;
    }

    /**
     * 添加元素
     * 第一步：判断当前ArrayList的容量是否够用，不够用需要扩容
     * 第二步：将传入的元素放入到element数组指定的位置
     * 第三步：将ArrayList的实际元素个数 +1
     *
     * @param e
     * @return
     */
    public boolean add(E e) {
        // 确保ArrayList执行这次新增操作容量够用
        enSureCapacityInternal(size + 1);
        // 将元素放入数组
        elementData[size++] = e;
        return true;
    }

    /**
     * 确定当前操作需要的ArrayList的最小容量
     * 如果数组为空则固定扩容10，否则就最小容量就是当前元素个数+1
     *
     * @param minCapacity ArrayList实际存放元素个数 +1，表示当前执行新增操作所需要的最小容量
     */
    public void enSureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) { // 判断当前元素数组是否为空
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity); // 若数组为空表示当前ArrayList需要初始化大小，默认大小10
        }
        // 确定容量
        enSureExplicitCapacity(minCapacity);
    }

    /**
     * 判断当前容量是否够用，不够需要执行扩容
     *
     * @param minCapacity ArrayList实际存放元素个数 +1，表示当前执行新增操作所需要的最小容量
     */
    public void enSureExplicitCapacity(int minCapacity) {
        // 结构性修改+1，记录当前数组结构修改次数
        modCount++;

        if (minCapacity - elementData.length > 0) { // 判断当前数组大小是否满足最小容量要求
            // 扩容
            grow(minCapacity);
        }
    }

    /**
     * 扩容
     *
     * @param minCapacity
     */
    public void grow(int minCapacity) {
        int oldCapacity = elementData.length; // 旧容量
        int newCapacity = oldCapacity + (oldCapacity >> 1); // 新容量为旧容量的 1.5 倍。>>表示位运算左移一位，相当于除2
        if (newCapacity < minCapacity)
            newCapacity = minCapacity; // 如果新容量小于当前新增操作要求的最小容量，则新容量为minCapacity
        if (newCapacity > MAX_ARRAY_SIZE)

        /*
        拷贝扩容
            新建一个长度为 newCapacity 的数组，循环遍历旧数组将元素放入到新数组对应的位置，完成后返回新数组
         */
            elementData = Arrays.copyOf(elementData, newCapacity);
    }

    /**
     * 最大容量上限
     *
     * @return
     */
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    /**
     * 检验下标索引
     *
     * @param index
     */
    public void rangeCheck(int index) {
        if (index > size)
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return (E) elementData[index];
    }
}