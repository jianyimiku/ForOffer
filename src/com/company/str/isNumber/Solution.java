package com.company.str.isNumber;

/**
 * 20- 表示数值的字符
 * 空格 + 小数 或者 整数 + (可选)e/E + 空格
 *
 * "+1."
 */
class Solution {
    public boolean isNumber(String s) {
        // 去除两边的空格
        s = trim(s);
        // 为空
        if (s == null || s.length() == 0) {
            return false;
        }
        return false;
    }

    public String trim(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right && s.charAt(left) == ' ') {
            left++;
        }
        while (left < right && s.charAt(right) == ' ') {
            right--;
        }
        return s.substring(left, right + 1);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.trim("        ");
    }
}