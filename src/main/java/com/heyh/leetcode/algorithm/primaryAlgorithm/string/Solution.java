package com.heyh.leetcode.algorithm.primaryAlgorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串
 */
public class Solution {

    /*
     * 反转字符串
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     *
     * 示例 1：
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     * @param s
     */
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[s.length - 1- i];
            s[s.length - 1 - i] = s[i];
            s[i] = temp;
        }
    }

    /*
     * 整数反转
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     * 输入: 123
     * 输出: 321
     *
     * 示例 2:
     * 输入: -123
     * 输出: -321
     *
     * 示例 3:
     * 输入: 120
     * 输出: 21
     * @param x
     * @return
     */
    public int reverse(int x) {
        String rtn = "";
        int result = 0;
        int abs = Math.abs(x);
        while (abs / 10 > 0) {
            if (abs % 10 != 0 || !rtn.equals("")) {
                rtn = rtn + abs % 10;
            }
            abs = abs / 10;
        }
        rtn += abs;
        if (x < 0) {
            rtn = "-" + rtn;
        }
        try {
            result = Integer.parseInt(rtn);
        } catch (NumberFormatException e) {
            result = 0;
        }
        return result;
    }

    /*
     * 字符串中的第一个唯一字符
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     *
     * 案例:
     * s = "leetcode"
     * 返回 0.
     * s = "loveleetcode",
     * 返回 2.
     *
     * 注意事项：您可以假定该字符串只包含小写字母。
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        /**
         * 第一次遍历字符串，将所有字符存储到哈希中，记录每个字符出现到次数
         * 第二次遍历字符串，通过哈希找到出现次数大于1到字符返回。
         */
        Map<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hash.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }

    /*
     * 有效的字母异位词
     * 判断两个字符串包含的字符以及字符出现的次数是否相同
     *
     * 示例 1:
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     *
     * 示例 2:
     * 输入: s = "rat", t = "car"
     * 输出: false
     *
     * 说明: 你可以假设字符串只包含小写字母。
     * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     */
    /*public boolean isAnagram(String s, String t) {
        if (!s.equals(t)) {
            if (s.length() < t.length()) {
                String temp;
                temp = s;
                s = t;
                t = temp;
            }
            Map<Character, Integer> hash1 = new HashMap<>();
            Map<Character, Integer> hash2 = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                hash1.put(s.charAt(i), hash1.getOrDefault(s.charAt(i), 0) + 1);
            }
            for (int i = 0; i < t.length(); i++) {
                hash2.put(t.charAt(i), hash2.getOrDefault(t.charAt(i), 0) + 1);
            }
            for (int i = 0; i < s.length(); i++) {
                char charS = s.charAt(i);
                Integer intS = hash1.get(charS);
                Integer intT = hash2.get(charS);
                if (intT == null || !intS.equals(intT)) {
                    return false;
                }
            }
        }
        return true;
    }*/
    public boolean isAnagram(String s, String t) {
        /**
         * 哈希处理
         * 与上面注释的解法不同之处是，只把一个字符串放入了哈希之中，遍历第二个字符串时完成了算法
         *
         */
        if (!s.equals(t)) {
            if (s.length() > t.length()) {
                String temp;
                temp = s;
                s = t;
                t = temp;
            }
            Map<Character, Integer> hash = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                hash.put(s.charAt(i), hash.getOrDefault(s.charAt(i), 0) + 1);
            }
            for (int i = 0; i < t.length(); i++) {
                char charT = t.charAt(i);
                Integer intS = hash.get(charT);
                if (intS != null && intS > 0) {
                    hash.put(charT, intS - 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }


    /*
     * 验证回文字符串 --- 从左往右读 或 从右往左读 字符串一样
     *
     * 示例 1:
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     *
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        /**
         * 双指针法，左右指针同时移动
         * 去掉不满足题意的字符，进行左右指针位置元素匹配。
         */
        if (!s.equals("")) {
            int left = 0; // 左指针
            int right = s.length() - 1; // 右指针

            while (left < right) {
                char c1 = s.charAt(left);
                char c2 = s.charAt(right);

                while (left < right && (c1 < '0' || c1 > '9') && (c1 < 'a' || c1 > 'z') && (c1 < 'A' || c1 > 'Z')) {
                    left++;
                    c1 = s.charAt(left);
                }
                while (left < right && (c2 < '0' || c2 > '9') && (c2 < 'a' || c2 > 'z') && (c2 < 'A' || c2 > 'Z')) {
                    right--;
                    c2 = s.charAt(right);
                }

                if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    /*
     * 字符串转换整数 (atoi)
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，
     * 则直接将其与之后连续的数字字符组合起来，形成整数。该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
     *
     * 说明：假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     *
     * 示例 1:
     * 输入: "42"
     * 输出: 42
     *
     * 示例 2:
     * 输入: "   -42"
     * 输出: -42
     * 解释: 第一个非空白字符为 '-', 它是一个负号。
     * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     *
     * 示例 3:
     * 输入: "4193 with words"
     * 输出: 4193
     * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
     *
     * 示例 4:
     * 输入: "words and 987"
     * 输出: 0
     * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。因此无法执行有效的转换。
     *
     * 示例 5:
     * 输入: "-91283472332"
     * 输出: -2147483648
     * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。因此返回 INT_MIN (−231) 。
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        /**
         * 提取出三个关键点，空字符、'-' '+'字符、数字字符
         * 1、循环遍历一次字符串，组成待转换 rtn
         * 2、将 rtn 转换为整型返回
         */
        int result = 0;
        if (!str.equals("")) {
            int index = 0;
            String rtn = "";
            while (index < str.length()) { // 找出符号与连续数字
                char c = str.charAt(index);
                if (c >= '0' && c <= '9') {
                    rtn += str.charAt(index);
                } else if (c == '-' || c == '+') {
                    if (rtn.equals("")) {
                        rtn += str.charAt(index);
                    } else {
                        break;
                    }
                } else if (c == ' ') {
                    if (!rtn.equals("")) {
                        break;
                    }
                } else {
                    break;
                }
                index++;
            }

            // 整型转换
            if (!rtn.equals("")) {
                try {
                    if (rtn.length() == 1 && (rtn.charAt(0) == '-' || rtn.charAt(0) == '+')) {
                        result = 0;
                    } else {
                        result = Integer.parseInt(rtn);
                    }
                } catch (NumberFormatException e) {
                    if (rtn.charAt(0) == '-') {
                        result = Integer.MIN_VALUE;
                    } else {
                        result = Integer.MAX_VALUE;
                    }
                }
            }
        }
        return result;
    }

    /*
     * 实现 strStr()
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     *
     * 示例 1:
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     *
     * 示例 2:
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     *
     * 说明：当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     * string.index(""); 返回的是 0，因此我们这里对 空字符串 的匹配处理也是返回 0.
     * @param haystack 文本字符串
     * @param needle 目标字符串
     * @return
     */
    public int strStr(String haystack, String needle) {
        /**
         * 暴力法，两层循环遍历两个字符串，时间复杂度 O(n2)，空间复杂度 O(1)，通常使用空间换时间，这种 n2 时间复杂度的算法一般不太棒
         */
        /*if (!needle.equals("")) {
            int M = haystack.length();
            int N = needle.length();
            for (int i = 0; i < M - N + 1; i++) {
                int j;
                for (j = 0; j < N; j++) {
                    char h = haystack.charAt(i + j);
                    char n = needle.charAt(j);
                    if (h != n) {
                        break;
                    }
                }
                if (j == N) return i;
            }
            return -1;
        }
        return 0;*/

        /**
         * K M P 算法，动态规划
         * 1、通过 needle 目标字符串构建 dp 数组（确定有限状态自动机），时间复杂度：O（M）
         * 2、借助 dp 查找 haystack 匹配 needle 的字符串，时间复杂度：O（N）
         */
        if (!needle.equals("")) {
            int M = needle.length();
            int N = haystack.length();

            // 构建状态转移图，其结构为二维数组，每一行记录的是一个目标字符串字符的状态
            int[][] dp = new int[M][256];
            int x = 0; // 影子状态
            dp[0][needle.charAt(0)] = 1; // 定义状态1，将目标字符串的第一个字符定义为状态1
            for (int i = 1; i < M; i++) { //外层循环用来更新状态，因为我们状态 1 已经定义好，所以从状态 1 开始
                for (int j = 0; j < 256; j++) {
                    if (needle.charAt(i) == j)
                        dp[i][j] = i + 1; // 当前目标字符串字符对应的状态
                    else
                        dp[i][j] = dp[x][j]; // 影子状态，用于回退，当前状态当前字符不能进入下一阶段状态，就需要通过影子状态记录的进行回退。
                }
                x = dp[x][needle.charAt(i)]; // 更新影子状态，影子状态记录在以前状态跟当前相同字符出现的位置。
            }

            // 查找文本字符串 haystack，匹配目标字符串 needle
            int status = 0;
            for (int i = 0; i < N; i++) {
                status = dp[status][haystack.charAt(i)];
                if (status == M) {
                    return i - M + 1;
                }
            }

            return -1;
        }
        return 0;
    }

    /*
     * 报数
     * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 被读作  "one 1"  ("一个一") , 即 11。
     * 11 被读作 "two 1s" ("两个一"）, 即 21。
     * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     *
     * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
     * 注意：整数顺序将表示为一个字符串。
     *
     * 示例 1:
     * 输入: 1
     * 输出: "1"
     *
     * 示例 2:
     * 输入: 4
     * 输出: "1211"
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        /**
         * 递归
         */
        if (n == 1) {
            return "1";
        } else {
            return nextStr(countAndSay(n - 1));
        }

        /**
         * 循环
         */
        /*String rtn = "1";
        for (int i = 1; i < n; i++) {
            rtn = nextStr(rtn);
        }
        return rtn;*/
    }

    /**
     * 核心算法，通过当前字符串算出下一个报数的字符串
     * @param str
     * @return
     */
    public String nextStr(String str) {
        int count = 0; // 计数器
        char last = ' '; // 字符串中上一个字符
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) { // 遍历当前报数字符串
            char current = str.charAt(i);
            if (last != ' ' && current != last) { // 如果当前字符与上一个字符相同，计数器 +1
                sb.append(count).append(last);
                count = 0;
            }
            last = current;
            count++;
        }
        sb.append(count).append(last);
        return sb.toString();
    }

    /**
     * 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀，如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     *
     * 示例 2:
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     *
     * 说明：所有输入只包含小写字母 a-z 。
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        String rtn = "";

        return rtn;
    }

}