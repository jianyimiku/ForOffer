package com.company.cqueue;

import java.util.Stack;

/**
 * 09- 用两个栈实现队列
 * <p>
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 队列 -> 先进先出
 * 栈 -> 先进后出
 */
class CQueue {
    Stack<Integer> var1;
    Stack<Integer> var2;

    public CQueue() {
        var1 = new Stack<>();
        var2 = new Stack<>();
    }

    public void appendTail(int value) {
        // 把var2中的都倒入var1中
        while (!var2.isEmpty()) {
            var1.add(var2.pop());
        }
        // 添加新元素
        var1.add(value);
    }

    public int deleteHead() {
        while (!var1.isEmpty()) {
            var2.add(var1.pop());
        }
        return !var2.isEmpty() ? var2.pop() : -1;
    }
}