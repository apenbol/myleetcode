/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
//recursion
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return !(root!=null)||isSymmetric(root.left, root.right);
    }
    public boolean isSymmetric(TreeNode left,TreeNode right)
    {
        if(!(left!= null)||!(right != null))return !(left != null)&&!(right != null);
        if(left.val==right.val){
            return isSymmetric(left.right, right.left)
                    &&isSymmetric(left.left, right.right);
        }
        return false;
    }
}



//iterate 左子树中序遍历，右子树反中序遍历
class Solution{
    public boolean isSymmetric(TreeNode root){
         Stack<TreeNode> stackLeft = new Stack<>();
         Stack<TreeNode> stackRight = new Stack<>();
         TreeNode curl=root;
         TreeNode curr=root;
         while(curl!=null||!(stackLeft.isEmpty()))
         {
             while(curl!=null&&curr!=null){
                stackLeft.push(curl);
                 stackRight.push(curr);
                curl=curl.left;
                curr=curr.right;
               
             }
             //保证数量相等
             if(curl != null || curr != null) return false;
             if(!stackLeft.isEmpty()&&!stackRight.isEmpty()){
                 curl=stackLeft.pop();
                 curr=stackRight.pop();
                 if(curl.val!=curr.val)return false;
                 curl=curl.right;
                 curr=curr.left;
             }
             //下面没必要再判断栈的大小了  因为上面已经保证数量相等了
            //  if((!stackLeft.isEmpty()||!stackRight.isEmpty())
            //  && !(!stackLeft.isEmpty() && !stackRight.isEmpty())) return false;
         }
         return true;
    }
}

