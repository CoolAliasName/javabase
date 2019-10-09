package com.heyh.valid.sort;

/**
 * 快速排序
 */
public class QuickSort {

    public static void sort(int[] arr, int start, int end) {

        // 递归需要设置退出条件，否则会死循环
        if (start > end) {
            return;
        }

        int flag = arr[start]; // 基准数
        int left = start; // 左侧指针
        int right = end; // 右侧指针
        int temp; // 临时指针

        while (left < right) {
            // && 逻辑与，具有短路功能， left < right 为 false 的话，后面 arr[right] >= flag不会执行
            // 右侧指针移动找小于基准数的元素。必须带上条件 left < right，当右指针向左移动到左指针指向位置时，需要停下。
            while (left < right && arr[right] >= flag) {
                right--;
            }

            // 左侧指针移动找大于基准数的元素。必须带上条件 left < right，当左指针向右移动到右指针指向位置时，需要停下。
            while (left < right && arr[left] <= flag) {
                left++;
            }

            // 当左右指针都找到符合资格要求的元素后，互相交换元素
            temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
        }

        // 左右指针移动到同一位置 right = left，此时将这一位置元素与基准数互换
        arr[start] = arr[left];
        arr[left] = flag;

        // 完成一次移动，此时所有元素安装基准数被分为两部分，左侧都比基准数小，右侧都比基准数大
        // 左侧递归执行此方法，将左侧所有元素按照该方式排序
        sort(arr, start, right - 1);
        // 右侧递归执行此方法，将右侧所有元素按照该方式排序
        sort(arr, left + 1, end);
    }

    //    public static void sort(int[] arr,int start,int end){
//        int i,j,temp,t;
//        if(start>end){
//            return;
//        }
//        i=start;
//        j=end;
//        //temp就是基准位
//        temp = arr[start];
//
//        while (i<j) {
//            //先看右边，依次往左递减
//            while (temp<=arr[j]&&i<j) {
//                j--;
//            }
//            //再看左边，依次往右递增
//            while (temp>=arr[i]&&i<j) {
//                i++;
//            }
//            //如果满足条件则交换
//            if (i<j) {
//                t = arr[j];
//                arr[j] = arr[i];
//                arr[i] = t;
//            }
//
//        }
//        //最后将基准为与i和j相等位置的数字交换
//        arr[start] = arr[i];
//        arr[i] = temp;
//        //递归调用左半数组
//        sort(arr, start, j-1);
//        //递归调用右半数组
//        sort(arr, j+1, end);
//    }

}