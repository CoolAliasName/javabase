package com.heyh.leetcode.algorithm.primaryAlgorithm.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 数组问题解决方案
 */
public class Solution {

    /**
     * 从排序数组中删除重复项
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * 解析：题目要求的空间复杂度为 O(1)，所以不能新建一个数组，只能是在原数组基础上移动数据。
     *      因此返回值是去重后的元素个数，数组元素分为两部分，从第一位开始的是无重复元素数组，重复元素被仍在后面。
     *
     * 算法：双指针替换，在原有数组的基础上修改，慢指针指向与新指针不重复的元素，每次指向后移一位，快指针遍历数组
     * @param nums 有序数组
     * @return
     */
    public int removeDuplicates(int[] nums) {
        // 双指针法 i 是慢指针，j 是快指针
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
                // 1, 1, 2, 2, 3, 4, 5, 5
            }
        }
        return i + 1;
    }

    /**
     * 买卖股票的最佳时机 II
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 示例 1:
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     *
     * 算法：峰顶 - 峰谷 时间复杂度 O(n)，空间复杂度O(1) 需要常量的空间
     * 一次遍历，遇到峰谷买入，遇到峰顶卖出
     * @param prices 一组股票价格
     * @return
     */
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 0;
        int i = 0;
        int maxProfit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            buy = prices[i];
            System.out.println("第 " + (i + 1) + "天买入，价格为：" + buy + "，当前资产：" + (maxProfit - buy));
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            sell = prices[i];
            maxProfit += sell - buy;
            System.out.println("第 " + (i + 1) + "天卖出，价格为：" + sell + "，当前资产：" + maxProfit);
        }
        return maxProfit;
    }

    /**
     * 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        // 蠢办法
        /*for (int i = 0; i < k; i++) {
            int a = nums[0];
            int b;
            for (int j = 1; j < nums.length; j++) {
                b = nums[j];
                nums[j] = a;
                a = b;
            }
            nums[0] = a;
        }*/

        /**
         * 神仙操作 环状替换法 数组长度 n，旋转次数 k
         * 假设要求旋转 k 次，那么需要算出数组实际需要移动次数，k = k%n (对k取余，因为存在 k > n)
         *
         * 遍历 --- L1
         * 从数组第一个元素开始，将它移动到 +k 后到索引位置，然后将原 +k 位置的元素移动到 +k +k 到位置，循环 +k 移动直到重新返回开始位置。
         *
         * 这样移动数组存在两种情况：
         *  1.  n%k ！= 0，这种情况下，数组执行一次 L1 后，会遍历到数组中每一个元素返回初始位置，数组旋转完成
         *  2.  n%k == 0，这种情况下，数组执行一次 L1 后，返回初始位置时，不会遍历到数组每一个元素，这样一次 L1 就不够了，
         *      需要将初始索引 + 1再次执行 L1 遍历移动数组元素。那么这种情况下需要执行多少次 L1 呢？
         *      我们可以通过计数（count）的方式，没遍历移动一次元素 count +1，当 count == n 时，说明所有元素移动完毕，循环结束。
         *
         * 这种算法由于对所有元素都只遍历了一次，所以时间复杂度为 O(n)，没有产生新的数组，所以空间复杂度为常量 O(1)
         *
         */
        int n = nums.length; // 数组长度
        k = k % n; // 数组元素需要移动的真正位数
        int count = 0; // 计数器，记录移动元素个数
        int start; // L1 遍历初始索引
        for (start = 0; count < n; start++) { // 外层循环代表需要执行几次 L1
            int current = start; // L1 遍历指针当前指向位置
            int value = nums[current]; // 当前指针指向位置元素
            do {
                int next = (current + k) % n; // 当前指针元素将要移动位置的索引
                int temp = nums[next]; // 临时指针，保存当前元素移动目标位置上的旧元素值
                nums[next] = value; // 移动当前元素
                value = temp; // 为下次移动做准备，下次移动，temp中保存的旧值将会是那次移动的当前value值。
                current = next;
                count++;
            } while (start != current);
        }
    }

    /**
     * 存在重复
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     *
     * 示例 1:
     * 输入: [1,2,3,1]
     * 输出: true
     *
     * 示例 2:
     * 输入: [1,2,3,4]
     * 输出: false
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        // 蠢办法
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;



//        return true;
    }

}