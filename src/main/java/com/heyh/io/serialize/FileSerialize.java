package com.heyh.io.serialize;

import com.heyh.io.serialize.model.NoSerialize;
import com.heyh.io.serialize.model.Serialize;

import java.io.*;

public class FileSerialize {

    // 定义方法把对象的信息写到硬盘上 ---> 对象的序列化
    public static void writeObject(File file, Serialize serialize) throws IOException {
        // 创建文件字节输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        // ObjectOutputStream负责把 Java 对象写入文件字节流
        // 这里写入到 Java 对象必须是实现了 Serializable 接口的对象
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(serialize);

        /**
         * serialize的成员变量noSerialize没有实现序列化，且通过transient关键字 JVM 也不会主动去序列化它
         * 现在，我们手动序列化这个成员变量，通过序列化它的属性来侧面实现序列化，并不是序列化noSerialize本身
         */
        NoSerialize noSerialize = serialize.getNoSerialize();
        if (noSerialize == null) {
            noSerialize = new NoSerialize();
        }
        objectOutputStream.writeObject(noSerialize.getId());
        /*********************************************************/

        System.out.println("文件流写入完毕");

        // 对象写入到流后需要将资源关闭，ObjectOutputStream.close内部将outputStream对象资源释放流，所以
        // 只需关闭ObjectOutputStream即可。
        objectOutputStream.close();
    }

    // 定义方法把文件存储的对象信息读取出来 ---> 对象的反序列化
    public static Serialize readObject(File file) throws IOException, ClassNotFoundException {
        // 创建文件字节输入流对象
        FileInputStream fileInputStream = new FileInputStream(file);

        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Serialize serialize = (Serialize) objectInputStream.readObject();

        // objectInputStream中应该存了写入了两份 object，这里将 noSerialize 的 id 读取出来
        int id = (int) objectInputStream.readObject();
        NoSerialize noSerialize = new NoSerialize(id);
        serialize.setNoSerialize(noSerialize);

        return serialize;
    }

}
