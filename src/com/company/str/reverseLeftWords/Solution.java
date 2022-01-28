package com.company.str.reverseLeftWords;

/**
 * 58 - 左旋转字符串
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * <p>
 * 1 <= k < s.length <= 10000
 */
class Solution {
    public static String reverseLeftWords(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        int left = 0;
        int right = k;

        while (right < s.length()) {
            stringBuilder.append(s.charAt(right++));
        }

        while (left < k) {
            stringBuilder.append(s.charAt(left++));
        }

        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
    }
}