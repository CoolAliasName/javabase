package com.heyh.valid.jvm.classLoad.loadingOrder;

import com.heyh.valid.jvm.classLoad.classLoadOrder.Son;
import org.junit.Test;

public class LoadingTest {

    @Test
    public void testClassOrder() {
        System.out.println("爸爸的岁数：" + Son.factor);
    }

    @Test
    public void testClassAndObjOrder() {
        new Son();
    }

}
