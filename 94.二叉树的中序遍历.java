/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
//iterate
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode cur=root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>(10);
        while(cur!=null||!stack.isEmpty())
        {
            while(cur!=null)
            {
                stack.push(cur);
                cur=cur.left;
            }
            if(!stack.isEmpty()){}
            {
                cur=stack.pop();
                list.add(cur.val);
                cur=cur.right;
            }
        }
        return list;
    }
}
//recursion
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        inorderTraversal(root,list);
        return list;
    }
    public void inorderTraversal(TreeNode root,List list){
        if(root==null)return;
        inorderTraversal(root.left,list);
        list.add(root.val);
        inorderTraversal(root.right,list);
    }
}

