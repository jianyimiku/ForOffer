package com.company.tree.isSubStructure;

import com.company.tree.TreeNode;

/**
 * 树的子结构
 * <p>
 * 判断B是不是树A的一个子结构
 */
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 当为空树的时候 为false
        if (A == null || B == null) {
            return false;
        }
        // 判断以A为当前节点开始比较是否符合子结构 比较左右两边
        return isSame(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }


    public boolean isSame(TreeNode A, TreeNode B) {
        // A B都为空的时候表示true 比较玩了
        if (A == null && B == null) {
            return true;
        }

        // 当A为空 B不为空的时候 肯定不等
        if (A == null) {
            return false;
        }

        // B为空表示B已经比较玩了 返回true
        if (B == null) {
            return true;
        }

        // 值不相等返回false
        if (A.val != B.val) {
            return false;
        }

        return isSame(A.left, B.left) && isSame(A.right, B.right);
    }
}