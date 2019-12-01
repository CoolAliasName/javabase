package com.heyh.leetcode.algorithm.primaryAlgorithm.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestSolution {

    /*
        获取控制台键盘输入
            Scanner sc = new Scanner(System.in);
            System.out.println(“请输入你的姓名：”);
            String name = sc.nextLine();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(“请输入你的姓名：”);
            String str = br.readLine();
         */

    int[] arr = new int[]{1, 3, 5, 4};
    Solution solution = new Solution();

    // 从排序数组中删除重复项
    @Test
    public void removeDuplicates() {
        arr = new int[]{1, 1, 2, 2, 3, 4, 5, 5};
        System.out.println("arr.length: " + solution.removeDuplicates(arr));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 买卖股票的最佳时机 II
    @Test
    public void maxProfit() {
//        arr = new int[]{7,1,5,3,6,4};
//        arr = new int[]{1, 2, 3, 4 ,5};
        arr = new int[]{1, 9, 6, 9, 1, 7, 1, 1, 5, 9, 9, 9};
        int price = solution.maxProfit(arr);
        System.out.println(price);
    }

    // 旋转数组
    @Test
    public void rotate() {
        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        solution.rotate(arr, 3);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 存在重复
    @Test
    public void containsDuplicate() {
//        arr = new int[]{1, 2, 3, 1, 4, 5};
        arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution.containsDuplicate(arr));
    }

    // 只出现一次的数字
    @Test
    public void singleNumber() {
        arr = new int[]{3, 1, 3, 2, 4, 1, 2};
        System.out.println(solution.singleNumber(arr));
    }

    // 两个数组的交集 II
    @Test
    public void intersect() {
        int[] arr1 = new int[]{4, 4, 9, 5};
        int[] arr2 = new int[]{9, 4, 9, 8, 4};

        int[] intersect = solution.intersect(arr2, arr1);
        systemArr(intersect);
    }

    // 加一
    @Test
    public void plusOne() {
        arr = new int[]{8, 9, 9};
        systemArr(arr);
        int[] plusOne = solution.plusOne(arr);
        systemArr(plusOne);
    }

    // 移动零
    @Test
    public void moveZeroes() {
        arr = new int[]{0, 3, 1, 0 ,9};
        solution.moveZeroes(arr);
        systemArr(arr);
    }

    // 两数之和
    @Test
    public void twoSum() {
        arr = new int[]{3, 2, 4};
        int[] twoSum = solution.twoSum(arr, 6);
        systemArr(twoSum);
    }

    // 旋转图像
    @Test
    public void rotateMax() {
        int[][] dex = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        systemArr(dex);
        solution.rotate(dex);
        System.out.println("-------------------");
        systemArr(dex);
    }

    @Test
    public void rotateOther() {
//        int[][] dex = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] dex = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        systemArr(dex);
        solution.rotateOther(dex);
        System.out.println("-------------------");
        systemArr(dex);
    }

    // 打印数组
    public void systemArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    // 打印二维数组
    public void systemArr(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            int[] arr = nums[i];
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > 9) {
                    System.out.print(arr[j] + " ");
                } else {
                    System.out.print(arr[j] + "  ");
                }
            }
            System.out.println();
        }
    }

    @Test
    public void hashMap() {
        Map<Integer, Integer> map = new HashMap<>();
//        map.put(3, 1);
        System.out.println("3: " + map.get(3));
    }

    @Test
    public void arr() {
        int[] a1 = new int[]{1 ,2};
        int[] a2 = new int[]{1 ,2};
        if (Arrays.equals(a1, a2))
            System.out.println(true);
        else
            System.out.println(false);
    }

}