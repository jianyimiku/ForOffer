package com.company.minstack;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * 第二个栈用来存储当前的最小值
 */
class MinStack {
    Stack<Integer> var1;
    Stack<Integer> var2;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        var1 = new Stack<>();
        var2 = new Stack<>();
    }

    public void push(int x) {
        // push的时候需要观察当前的元素是否比var2中的元素小 小则进栈
        var1.add(x);

        if (var2.isEmpty()) {
            var2.push(x);
        } else if (x <= var2.peek()) {
            var2.push(x);
        }
    }

    public void pop() {
        // 判断推出的是否和最小值相等 如果是 那么最小值也要推出
        if (!var1.isEmpty()) {
            if (var1.peek().equals(var2.peek())) {
                var1.pop();
                var2.pop();
            } else {
                var1.pop();
            }
        }
    }

    public int top() {
        return !var1.isEmpty() ? var1.peek() : -1;
    }

    public int min() {
        return !var2.isEmpty() ? var2.peek() : -1;
    }
}
