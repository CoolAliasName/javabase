#### HashMap的数据结构理解

**内部结构**

第一层为数组，数组里面存放了多个Entry，Entry是一个存放key,value的对象

第二层结构为单链表，数组内每个Entry都会往下连着一串Entry，组成一个单链表

```
HashMap
Entry<K, V> ---> hash函数
                    |
                HashMap（
[Entry<K, V>, Entry<K, V>, Entry<K, V>....] 数组
        |
    Entry<K, V>
        |
    Entry<K, V>
        |
    Entry<K, V>
        |
      ......）
```

#### HashMap如何通过key获取数据
首先，传入的key进入hash运算，得到hashCode,然后以hashCode为索引查找第一层的数组，

若索引位置对应为空，返回null，

若不为空，那么就要遍历索引处Entry下对应的单链表，若有相同的key则返回对应Entry的value，没有则返回null

#### HashMap如何存储(put)key，value
首先HashMap存在容量大小，在存入key,value之前需要先确定当前容量是否已达到阀值，

**没达到阀值**

1、利用key通过hash算法得到hashCode

2、以hashCode为下标索引查找HashMap数组Entry[]
    若找不到Entry，
        那么就将传入key，value组成新Entry存入当前位置。
    若能找到Entry，
        因为数组中每一个Entry下都会连着一个单链表，所以此时需要做的就是遍历当前Entry对应的单链表，
            若没有Entry的key与传入的key相同
                此时需要"挤压"当前单链表，将新的Entry放到当前单链表的首位
            若有Entry的key与传入的key相同
                那么就更新旧Entry的value值

&nbsp;
**达到阀值**

    1、进行扩容，修改HashMap中定义容量大小的变量

    2、如何扩容
        a. 将原有数组用一个更大的数组替换掉，定义一个空白的大数组
        b. 定义一个List集合临时存放Entry<K, V>
        c. 遍历HashMap的旧数组，遍历数组中Entry同时也要遍历其下对应单链表的Entry，全部放入到List中
        d. 旧数组中数据全部取出放入List后，用新的数组将其替换
        d. 然后遍历List，调用put()方法将List中的Entry<K, V>存入新的大数组中。