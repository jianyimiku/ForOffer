package com.company.str.firstUniqChar;

import java.util.HashMap;
import java.util.Set;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * <p>
 * 输入：s = "abaccdeff"
 * 输出：'b'
 */
class Solution {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), i);
            } else {
                hashMap.put(s.charAt(i), -1);
            }
        }
        int minIndex = Integer.MAX_VALUE;
        Set<Character> characters = hashMap.keySet();
        for (Character character : characters) {
            if (hashMap.get(character) != -1) {
                minIndex = Math.min(hashMap.get(character), minIndex);
            }
        }

        return minIndex != Integer.MAX_VALUE ? s.charAt(minIndex) : ' ';
    }
}