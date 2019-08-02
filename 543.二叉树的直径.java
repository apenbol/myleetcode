/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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
    int max=0; //注意这么写是因为java无法传引用，这样可能会涉及到状态
    public int diameterOfBinaryTree(TreeNode root) {
         dfs(root);
         return max;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return -1;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(max,left+right+2);//注意从这为2时 空节点要为-1  当 这里为0时 空节点就为0
        return Math.max(left,right)+1;

    }
}

