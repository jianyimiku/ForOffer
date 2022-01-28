package com.company.str.replaceSpace;

import java.util.Arrays;

/**
 * 05 - 替换空格
 */
class Solution {
    public static String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }
}