package com.heyh.valid.desginpattern.singleton;

import com.heyh.valid.designpattern.singleton.MySingleTon;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MySingleTonTest {

    /**
     * 单例模式多聚合根测试
     *
     * 测试结果：聚合根设计成单例模式，可以保证聚合根的唯一性
     * 聚合根内创建聚合根的方法永远都是返回的同一个实例，有且只能有一个聚合根实例存在
     * 存在的问题，如果一个聚合根需要同时处理两个实例怎么办，单例模式似乎无法处理
     *
     * 现在能想象到的同一聚合根多实例的场景：
     *  * 批量删除/修改。现在需要批量删除一部分数据，但是呢又需要对删除的数据进行判断，这时判断涉及到了数据库操作，
     *    因此批量删除这个方法是放在聚合根外部的，这时判断是否需要走聚合根，判断依据为我们是否需要多数据进行操作，
     *    如果不要那么直接通过json形式处理。
     */
    @Test
    public void test1() {
        List<MySingleTon> list = new ArrayList<>();

        MySingleTon mySingleTon = MySingleTon.getInstance("zhangsan", "1001");
        list.add(mySingleTon);
        System.out.println(mySingleTon.toString());

        MySingleTon mySingleTon1 = MySingleTon.getInstance();
        list.add(mySingleTon1);
        System.out.println(mySingleTon1.toString());

        MySingleTon mySingleTon2 = MySingleTon.getInstance("lisi", "1002");
        list.add(mySingleTon2);
        System.out.println(mySingleTon2.toString());

        mySingleTon2.changeName("lisi");

        this.forearch(list);

    }

    // 遍历集合
    public void forearch(List<MySingleTon> list) {
        System.out.println("-------------------------");
        for (MySingleTon mySingleTon: list) {
            System.out.println(mySingleTon.toString());
        }
    }

}
