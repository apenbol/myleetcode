

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root!=null)queue.offer(root);
        int size =queue.size();
        List<Integer> childlist = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode treenode = queue.poll();
            childlist.add(treenode.val);
            if(treenode.left!=null)
            queue.offer(treenode.left);
            if (treenode.right != null)
            queue.offer(treenode.right);
            size--;
            if(size==0){
                size = queue.size();
                list.add(childlist);
                childlist = new ArrayList<>();
            }
        }
        return list;
    }
}

