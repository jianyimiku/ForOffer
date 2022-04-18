package com.company.tree.二叉搜索树的最近公共祖先;

import com.company.tree.TreeNode;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        /**
         * 保证P是较小值
         */
        if(p.val > q.val){
            return lowestCommonAncestor(root, q, p);
        }

        if(p.val <= root.val && q.val >= root.val){
            return root;
        }else if(q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}