package com.heyh.valid.io.serialize;

import com.heyh.valid.io.serialize.model.Serialize;

import java.io.*;
import java.util.Arrays;

public class DoSerialize {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ByteArrayOutputStream buffer = new ByteArrayOutputStream(); // 输出流字节数组

        try(ObjectOutputStream output = new ObjectOutputStream(buffer)) {
            // 写入int
            output.writeInt(123);
            // 写入String
            output.writeUTF("Hello");
            // 写入Object
            Serialize serialize = null;
//            serialize= new Serialize(1, "zhangsan", "hebei");
            output.writeObject(serialize);
        }

        System.out.println(Arrays.toString(buffer.toByteArray()));

        /**************************反序列化***********************/
        ByteArrayInputStream bufferin = new ByteArrayInputStream(buffer.toByteArray());
        ObjectInputStream input = new ObjectInputStream(bufferin);

        int readInt = input.readInt();
        String readUTF = input.readUTF();
        Serialize readObject = (Serialize) input.readObject();

        System.out.println("readInt: " + readInt);
        System.out.println("readUTF: " + readUTF);
        System.out.println("readObject: " + readObject.getId() + ", " + readObject.getName());
    }

}