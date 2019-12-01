package com.heyh.leetcode.algorithm.primaryAlgorithm.array;

import com.heyh.valid.sort.QuickSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 数组问题解决方案
 */
public class Solution {

    /**
     * 从排序数组中删除重复项
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * 解析：题目要求的空间复杂度为 O(1)，所以不能新建一个数组，只能是在原数组基础上移动数据。
     * 因此返回值是去重后的元素个数，数组元素分为两部分，从第一位开始的是无重复元素数组，重复元素被仍在后面。
     * <p>
     * 算法：双指针替换，在原有数组的基础上修改，慢指针指向与新指针不重复的元素，每次指向后移一位，快指针遍历数组
     *
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
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * <p>
     * 算法：峰顶 - 峰谷 时间复杂度 O(n)，空间复杂度O(1) 需要常量的空间
     * 一次遍历，遇到峰谷买入，遇到峰顶卖出
     *
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
     *
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
     * <p>
     * 示例 1:
     * 输入: [1,2,3,1]
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: [1,2,3,4]
     * 输出: false
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        // 蠢办法
        /*for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }*/


        /**
         * 通过数组排序进行查找，但是改变了数组本身，若有需求提出可以先复制数组再排序
         * 这里使用的排序是 快速排序，时间复杂度为 O(nlogn)，扫描查重的复杂度为 O(n)
         * 因此这个算法主要由排序这一块决定
         */
        QuickSort.sort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }

    /**
     * 只出现一次的数字
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * <p>
     * 示例 2:
     * 输入: [4,1,2,1,2]
     * 输出: 4
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {

        // 1、参考上面存在重复的两种解法。

        /**
         * 2、位异或运算
         * 运算规则是：两个数转为二进制，然后从高位开始比较，如果相同则为0，不相同则为1。
         *
         * 由题意所知数组中只出现一次的元素有且仅有一个
         * 将整个数组元素进行 位异或 运算，最终留下的只有那唯一的一个数。
         * 时间复杂度 O(n)，空间复杂度 O(1)
         */
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp = temp ^ nums[i];
        }
        return temp;
    }

    /**
     * 两个数组的交集 II
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 说明：
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * 我们可以不考虑输出结果的顺序。
     * <p>
     * 示例 1:
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        // 1、蠢办法，时间复杂度 O(n2)，nums1.length必须大于nums2.length，否则运行失败
        /*int big = nums1.length;
        int small = nums2.length;
        for (int i = 0; i < small; i++) {
            int temp = nums2[i];
            for (int j = 0; j < big; j++) {
                if (temp == nums1[j]) {
                    list.add(temp);
                    break;
                }
            }
        }*/

        /**
         * 2、使用哈希表，将nums1放入哈希表，放入过程中记录元素出现的次数
         * 然后遍历nums2查找哈希表，将哈希表中与nums2相同的元素放入集合list中，然后将list转为数组返回
         */
        /*Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i: nums1) { // 将nums1数组元素放入哈希表，元素值为key，出现次数为value
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        for (int i: nums2) {
            if (map.containsKey(i) && map.get(i) != 0) {
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }*/

        /**
         * 3、通过排序算法，将两个数组排序后，定义两个指针分别遍历两个数组。
         */
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0, p2 = 0;

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                list.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            }
        }

        int[] rtnNums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            rtnNums[i] = list.get(i);
        }
        return rtnNums;
    }

    /**
     * 加一
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * <p>
     * 示例 2:
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        // 整数数组组成一个整数，个位数+1后，重新拆成个位整数组成的整形数组
        // 存在两种情况：
        // （1）全是9组成的数组，在个位数+1后长度也+1了，
        // （2）数组不全是9，个位数+1后长度不变。

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) { // 若某一位 +1 不等于10 表示无须进位，直接返回数组
                return digits;
            }
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }

    /**
     * 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 示例:
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 0 1
     * 说明:必须在原数组上操作，不能拷贝额外的数组。尽量减少操作次数。
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int zero = 0;
        // 第一步，移动非零数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
                continue;
            }
            nums[i - zero] = nums[i];
        }

        // 第二步，补零
        if (zero != 0) {
            for (int i = nums.length - zero; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }

    /**
     * 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        // 蠢办法两层循环嵌套，一个元素一个元素遍历

        // good idea 使用哈希只需要遍历数组两次
        // 第一次，将数组遍历一边放入哈希
        Map<Integer, Integer> hash = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], i);
        }
        // 第二次，遍历数组，查看数组当前元素是否跟哈希对应的元素值对应的目标元素（target-当前值）是否存在哈希中
        for (int i = 0; i < nums.length; i++) {
            int complete = target - nums[i];
            // 需要判断从哈希中找到的complete是否是数组当前元素本身，存在 target=6, {3,2,4}类似的情况
            if (hash.containsKey(complete) && hash.get(complete) != i) {
                return new int[]{i, hash.get(complete)};
            }
        }
        throw new IllegalArgumentException("找不到符合题意的元素....");
    }

    /**
     * 有效的数独
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     * 1. 数字 1-9 在每一行只能出现一次。
     * 2. 数字 1-9 在每一列只能出现一次。
     * 3. 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     *
     * 示例 1:
     * 输入:
     * [
     *   ["5","3",".",".","7",".",".",".","."],
     *   ["6",".",".","1","9","5",".",".","."],
     *   [".","9","8",".",".",".",".","6","."],
     *   ["8",".",".",".","6",".",".",".","3"],
     *   ["4",".",".","8",".","3",".",".","1"],
     *   ["7",".",".",".","2",".",".",".","6"],
     *   [".","6",".",".",".",".","2","8","."],
     *   [".",".",".","4","1","9",".",".","5"],
     *   [".",".",".",".","8",".",".","7","9"]
     * ]
     * 输出: true
     *
     * 示例 2:
     * 输入:
     * [
     *   ["8","3",".",".","7",".",".",".","."],
     *   ["6",".",".","1","9","5",".",".","."],
     *   [".","9","8",".",".",".",".","6","."],
     *   ["8",".",".",".","6",".",".",".","3"],
     *   ["4",".",".","8",".","3",".",".","1"],
     *   ["7",".",".",".","2",".",".",".","6"],
     *   [".","6",".",".",".",".","2","8","."],
     *   [".",".",".","4","1","9",".",".","5"],
     *   [".",".",".",".","8",".",".","7","9"]
     * ]
     * 输出: false
     * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
     *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
     *
     * 说明:
     * * 一个有效的数独（部分已被填充）不一定是可解的。
     * * 只需要根据以上规则，验证已经填入的数字是否有效即可。
     * * 给定数独序列只包含数字 1-9 和字符 '.' 。
     * * 给定数独永远是 9x9 形式的。
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        // 思路：使用哈希，按题意需要判断三种情况，即 行、列、子数独
        // 时间复杂度: O(1) 因为只对81个单元格遍历了一次, 空间复杂度: O(1)，因为是单元格数量固定所以空间复杂度也是1
        // 因为是二维数组，需要两层循环才能将数组遍历一次，board[i][j]
        // 遍历每一个数组元素的同时，通过哈希判断是否有重复，行列的好判断，这里子数独需要特殊处理
        // 我们将整个大数独分为9个小数独，从上往下从左往右一次为 0～8，因此我们定义了9个哈希来存放这9个数独元素
        // 我们需要定位到整个元素应该出现在哪一个数独哈希中，即通过行列算出 borad_index.
        HashMap<Integer,Integer>[] rows = new HashMap[9];
        HashMap<Integer,Integer>[] columns = new HashMap[9];
        HashMap<Integer,Integer>[] borads = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap();
            columns[i] = new HashMap();
            borads[i] = new HashMap();
        }

        for (int i = 0; i < 9; i++) { // 行
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j]; // 当前二维数组元素
                if (ch != '.') {
                    int temp = (int) ch;
                    int borad_index = i / 3 * 3 + j / 3; // 当前元素位于子数独哈希数组的下标索引

                    // map.getOrDefault(key, defaultValue)
                    // 含义为，若map中key存在，则返回key，不存在则返回默认是defaultValue
                    // 在这里使用是为了记录temp在哈希中出现的次数，之前使用过类似的
                    rows[i].put(temp, rows[i].getOrDefault(temp, 0) + 1);
                    /**-------下面关于columns的处理与被注释的语句含义相同-------*/
                    //columns[j].put(temp, columns[j].getOrDefault(temp, 0) + 1);
                    Integer col = columns[j].get(temp);
                    if (col != null) {
                        col++;
                    } else {
                        col = 1;
                    }
                    columns[j].put(temp, col);
                    /**--------------------------------------------------*/
                    borads[borad_index].put(temp, borads[borad_index].getOrDefault(temp, 0) + 1);

                    // 判断 temp 在三个哈希中是否重复出现
                    if (rows[i].get(temp) > 1 ||  columns[j].get(temp) > 1 || borads[borad_index].get(temp) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 旋转图像
     * 给定一个 n × n 的二维矩阵表示一个图像。
     * 将图像顺时针旋转 90 度。
     * 说明：你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     *
     * 示例 1:
     * 给定 matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     *
     * 示例 2:
     * 给定 matrix =
     * [
     *   [ 5, 1, 9,11],
     *   [ 2, 4, 8,10],
     *   [13, 3, 6, 7],
     *   [15,14,12,16]
     * ],
     * [1, 1], [1, 2], [1, 3], [1, 4]
     * [1, 4], [2, 4], [3, 4], [4, 4]
     *
     * [3, 1], [3, 2], [3, 3], [3, 4]
     * [1, 2], [2, 2], [3, 2], [4, 2]
     *
     * [0, 0], [4 - (0 + 1), 0]
     * [0, 1], [4 - (1 + 1), 0]
     * [0, 2], [4 - (2 + 1), 0]
     * [0, 3], [4 - (3 + 1), 0]
     *
     * [1, 0], [4 - (0 + 1), 1]
     *
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [15, 13, 2, 5],
     *   [14, 3, 4, 1],
     *   [12, 6, 8, 9],
     *   [16, 7,10,11]
     * ]
     * [3, 1], [2, 3]
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length; // 二维数组行数
        // 将二维数组元素全部放入哈希数组，一列数对应一个哈希
        HashMap<Integer, Integer>[] columns= new HashMap[n];
        for (int i = 0; i < n; i++) {
            columns[i] = new HashMap<>();
        }
        for (int i = 0; i < n; i++) { // i 代表行，j 代表列
            for (int j = 0; j < n; j++) {
                columns[j].put(i, matrix[i][j]);
            }
        }

        // 开始旋转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 当前位置元素被放在哈希数组的哪个哈希中
                int column_index = i;
                int temp = columns[column_index].get(n - (j + 1));
                matrix[i][j] = temp;
            }
        }
    }

    /**
     * 旋转图像，n为二维数组长度
     * 不使用哈希存储，直接旋转数组，数组每一个元素移动后出现的位置我们都能得到，那么一次移动4个回到原点，
     * 思路：
     *      按一行元素从左往右遍历素，一次移动能得到四个元素的准确位置，
     *          整行全列遍历只需要遍历一半的数，因为剩下一半在前一半移动过程中已摆好
     *              这里需要注意，n 为偶数时列遍历一半元素；n 为奇数时，列遍历 n - n / 2  个元素.
     *      一行遍历结束，换行继续遍历，此时换行也分两种情况：
     *          若 n 为偶数，换行数为 n - n / 2，
     *          若 n 为奇数，换行数为 n - n / 2 - n % 2.
     * @param matrix
     */
    public void rotateOther(int[][] matrix) {
        // 若为奇数二维数组，如: 3x3，那么行遍历可以 -1，因为
        for (int i = 0; i < matrix.length - matrix.length / 2 - matrix.length % 2; i++) { // 行索引
            for (int j = 0; j < matrix.length - matrix.length / 2; j++) { // 列索引
                int n = matrix.length; // 行数
                int next_i = i;
                int next_j = j;
                int current = matrix[i][j]; // 当前数组元素
                do {
                    int temp_i = next_i;
                    next_i = next_j; // 移动目标行索引
                    next_j = n - (temp_i + 1); // 移动目标列索引
                    int next = matrix[next_i][next_j];
                    int temp = next; // 临时指针
                    matrix[next_i][next_j] = current;
                    current = temp; // 下次循环开始
                } while (!(i == next_i && j == next_j));
            }
        }
    }

}