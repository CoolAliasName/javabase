package com.heyh.jvm.classLoad.loadingOrder;

import com.heyh.jvm.classLoad.classLoadOrder.Son;
import org.junit.Test;

public class LoadingTest {

    @Test
    public void testClassOrder() {
        System.out.println("爸爸的岁数：" + Son.factor);
    }

    @Test
    public void testClassAndObjOrder() {
        new com.heyh.jvm.classLoad.classAndObjLoadOrder.Son();
    }

}
