package com.heyh.valid.sort;

import org.junit.Test;

public class SortTest {

    int[] arr = new int[]{1, 2, 14, 1, 4, 10, 22, 8, 10};

//    int[] arr = new int[]{11, 2, 14, 1, 4, 10, 22, 8, 10};

//    int[] arr = new int[]{9, 2, 3, 4, 1, 0};

    // 冒泡排序
    @Test
    public void testBubbleSort() {
        BubbleSort.sort(arr);
        systemArr();
    }

    // 选择排序
    @Test
    public void testSelectSort() {
        SelectSort.sort(arr);
        systemArr();
    }

    // 快速排序
    @Test
    public void quickArr() {
        arr = new int[]{1, 3, 9, 8};
        systemArr();
        QuickSort.sort(arr, 0, arr.length - 1);
        systemArr();
    }

    public void systemArr() {
        for (int i = 0; i < this.arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
