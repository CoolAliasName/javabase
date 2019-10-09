package com.heyh.valid.io.serialize;

import com.heyh.valid.io.serialize.FileSerialize;
import com.heyh.valid.io.serialize.model.Serialize;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class SerialzieTest {

    // 文件写入
    /*@Test
    public void writeFile() {
        File file = new File("/Users/heyh/test/obj.txt");
        try {
            Serialize serialize = new Serialize(1002, "lisi", "hunan");
            FileSerialize.writeObject(file, serialize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("OK");
    }*/

    // 文件读取 自己序列化自己读取
    @Test
    public void readFile() {
//        File file = new File("~/test/obj.txt"); // 必须是文件全路径名
        File file = new File("/Users/heyh/test/obj.txt");
        try {
            Serialize serialize;
            serialize = (Serialize) FileSerialize.readObject(file);
            System.out.println("文件读取成功！--- id: " + serialize.getId() + ", name: " + serialize.getName());
            System.out.println("serialVersionUID: " + serialize.getNoSerialize());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*****************************成员变量序列化*************************/

    // 测试成员变量没实现序列化时对象能否正常序列化
    /*@Test
    public void writeFileNoSerialzie() {
        File file = new File("/Users/heyh/test/obj.txt");
        try {
            Serialize serialize = new Serialize(1002, "lisi", "hunan");
            System.out.println("no-serialzie, id: " + serialize.getNoSerialize().getId());
            FileSerialize.writeObject(file, serialize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("OK");
    }*/

    // 文件读取 测试成员变量没实现序列化时对象能否正常序列化
    @Test
    public void readFileNoSeria() {
        File file = new File("/Users/heyh/test/obj.txt");
        try {
            /*Serialize seria = (Serialize) FileSerialize.readObject(file);
            System.out.println("文件读取成功！--- " + seria + ", addr: " + seria.getAddr());
            System.out.println("seria, no-seria: " + seria.getNoSerialize());*/
            Serialize serialize = FileSerialize.readObject(file);
            System.out.println(serialize);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 测试父类没有默认无参构造起能否成功序列化
    @Test
    public void writeFileNoSerialzie() {
        File file = new File("/Users/heyh/test/obj.txt");
        try {
            Serialize serialize = new Serialize(101, 201, "xixi");
            System.out.println("no-serialzie, id: " + serialize.getNoSerialize().getId());
            FileSerialize.writeObject(file, serialize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("OK");
    }

    // 测试手动序列化成员变量
    @Test
    public void writeFileSerializeNoSerialzie() {
        File file = new File("/Users/heyh/test/obj.txt");
        try {
            Serialize serialize = new Serialize(301, 3101, "xixi");
            System.out.println("no-serialzie, id: " + serialize.getNoSerialize().getId());
            FileSerialize.writeObject(file, serialize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("OK");
    }

    /*******************网上案例*******************/
    // A端序列化
    /*public void SerialTest() {
        Serial serial1 = new Serial(1,"song");
        System.out.println("Object Serial"+serial1);
        try {
            FileOutputStream fos = new FileOutputStream("serialTest.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(serial1);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // B端序列化
    public void DeserialTest() {
        Serial serial2 ;
        try {
            FileInputStream fis = new FileInputStream("serialTest.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            serial2 = (Serial)ois.readObject();
            ois.close();
            System.out.println("Object Deserial"+serial2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/

}