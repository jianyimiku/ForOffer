package com.company.tree.levelOrder;


import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * [3,9,20,15,7]
 * <p>
 * 广度优先搜索 借助队列
 */
class Solution {
    List<Integer> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedBlockingQueue<>();

    public int[] levelOrder(TreeNode root) {
        // 当根部节点为空的时候 返回0
        if (root == null) {
            return new int[0];
        }
        queue.offer(root);
        // 队列不为空的时候
        while (!queue.isEmpty()) {
            // 弹出队列队头节点
            TreeNode treeNode = queue.poll();
            res.add(treeNode.val);
            // 如果有左右孩子就加入队列
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }


    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrderReturnList(TreeNode root) {
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode poll = queue.poll();
                res.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            result.add(res);
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