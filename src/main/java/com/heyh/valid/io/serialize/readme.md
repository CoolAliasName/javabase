## Java序列化

序列化通常应用在持久化和网络数据传输中，将JVM中的Java对象序列化成字节数组传递到JVM外部。

java中提供了一种默认的序列化方式，即实现 `Serializable` 接口。

本次样例中有对 Serialzable 默认实现的简单分析，同时也手动实现了序列化。

这里参考了 ArrayList 中 elementData 这个 Object[] 数组，因为这个数据的序列化就是手动的。

> ArrayList（简称 al） 中手动序列化 elementData（简称 ed） 是因为 ed 中是会预留一些空位，
这跟 al 的扩容机制有关，所以直接序列化这个 ed 会浪费内存，al 通过手动遍历 ed 中每个元素对其单独序列化从而
实现的这个 ed 手动序列化。