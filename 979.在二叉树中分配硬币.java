/*
 * @lc app=leetcode.cn id=979 lang=java
 *
 * [979] 在二叉树中分配硬币
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int ans=0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root){
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
  
        ans+=Math.abs(left+right+root.val-1);
        return (left+right+root.val-1);
    }
}

