package com.heyh.leetcode.algorithm.primaryAlgorithm.array;

import org.junit.Test;

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

    int[] arr = null;
    Solution solution = new Solution();

    /**
     * 从排序数组中删除重复项
     */
    @Test
    public void testRemoveDuplicates() {
        arr = new int[]{1, 1, 2, 2, 3, 4, 5, 5};
        System.out.println("arr.length: " + solution.removeDuplicates(arr));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 买卖股票的最佳时机 II
     */
    @Test
    public void testMaxProfit() {

//        arr = new int[]{7,1,5,3,6,4};
//        arr = new int[]{1, 2, 3, 4 ,5};
        arr = new int[]{1,9,6,9,1,7,1,1,5,9,9,9};
        int price = solution.maxProfit(arr);
        System.out.println(price);
    }

    /**
     * 旋转数组
     */
    @Test
    public void testRotate() {
        arr = new int[]{1, 2, 3, 4 ,5, 6, 7};
        solution.rotate(arr, 3);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    @Test
    public void testContainsDuplicate() {
        arr = new int[]{1, 2, 3, 1, 4, 5};
//        arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution.containsDuplicate(arr));
    }

}
