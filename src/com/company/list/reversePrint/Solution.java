package com.company.list.reversePrint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 06 - 从尾巴到头打印链表
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        getNode(list, head);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    public void getNode(List<Integer> list, ListNode node) {
        if (node == null) {
            return;
        }

        getNode(list, node.next);
        list.add(node.val);
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }
}