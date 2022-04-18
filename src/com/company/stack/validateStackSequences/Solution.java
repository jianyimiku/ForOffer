package com.company.stack.validateStackSequences;

import java.util.Arrays;
import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * <p>
 * pushed = [1,2,3,4,5], popped = [4,5,3,2,1]  true
 * pushed = [1,2,3,4,5], popped = [4,3,5,1,2] false
 * <p>
 * <p>
 * 模拟题
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        if (pushed.length == 0) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < pushed.length && j < popped.length) {
            // 栈顶是否相等
            if (stack.isEmpty()) {
                stack.push(pushed[i++]);
                continue;
            }
            if (popped[j] == stack.peek()) {
                stack.pop();
                j++;
            } else {
                stack.push(pushed[i++]);
            }
        }

        while (j < popped.length) {
            if (stack.isEmpty()) {
                return false;
            }
            if (stack.peek() == popped[j]) {
                stack.pop();
                j++;
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{0};
        int[] poped = new int[]{0};
        Solution solution = new Solution();
        System.out.println(solution.validateStackSequences(pushed, poped));
    }
}