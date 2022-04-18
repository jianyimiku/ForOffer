package com.company.tree.二叉搜索树的后序遍历序列;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        // 找到后续中第一个大于根节点的点
        int m = p;
        // 判断右子树的节点是不是都大于根节点
        while (postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}