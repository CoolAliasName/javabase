package com.heyh.valid.sort;

/**
 * 选择排序
 * <p>
 * 选择排序第一次遍历数组所有元素找出数组中的最小（大）值，然后放到数组首位，
 * 接下来的每次遍历数组都会找到当前遍历最小（大）值，依次往后放。
 * <p>
 * 这种排序方式不分情况好坏，不论数据如何分布，时间复杂度总是 O(n2)，空间复杂度为 O(1)，平均复杂度为 O(n2)
 */
public class SelectSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[i]; // 当前遍历最小值
            int index = i; // 最小值索引
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < temp) {
                    temp = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

}
