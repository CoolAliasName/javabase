package com.heyh.valid.sort;

/**
 * 冒泡排序
 *
 * 通过比较相邻两个数的大小，每次比较过后将大数放后面小数放前面，这样一次数组遍历就能得到数组最大数并放置在末尾，
 * 下次遍历数组时只需遍历 n - 1 个数组元素。
 *
 * 最好情况是遍历一下数组，移动后完成排序，时间复杂度为 O(n)，空间复杂度为常量 O(1)
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int temp;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}