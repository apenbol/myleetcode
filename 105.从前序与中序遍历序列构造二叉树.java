/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer>  hashmap = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            hashmap.put(inorder[i],i);
        }
        return build(preorder,inorder,hashmap,0,preorder.length-1,0,inorder.length-1);
    }
    //可以看到是dfs
    public TreeNode build(int[] preorder,int[] inorder,Map<Integer,Integer> hashmap,int preorderBegin,int preorderEnd,int inorderBegin,int inorderEnd){
        if(preorderBegin>preorderEnd)return null;
        System.out.println(preorderBegin+" "+preorderEnd);
        TreeNode root = new TreeNode(preorder[preorderBegin]);
        int k=hashmap.get(preorder[preorderBegin]);
            k=k-inorderBegin;
        root.left=build(preorder,inorder,hashmap,preorderBegin+1, preorderBegin+k,inorderBegin, //注意这是preorderBegin+k
                inorderBegin+k-1);
        root.right = build(preorder, inorder, hashmap, preorderBegin+k + 1, preorderEnd,
                inorderBegin+k+1, inorderEnd);
        return root;
    }
}

