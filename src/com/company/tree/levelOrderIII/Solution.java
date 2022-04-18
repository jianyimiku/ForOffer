package com.company.tree.levelOrderIII;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
class Solution {
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        boolean isNative = true;

        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            LinkedList<Integer> list = new LinkedList<>();

            if (isNative) {
                for (int i = 0; i < currentSize; i++) {
                    TreeNode poll = queue.poll();
                    list.add(poll.val);
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }

                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
                isNative = false;
                result.add(list);
            } else {
                for (int i = 0; i < currentSize; i++) {
                    TreeNode poll = queue.poll();
                    list.addFirst(poll.val);
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }

                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
                isNative = true;
                result.add(list);
            }
        }

        return result;
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}