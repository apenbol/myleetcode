import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
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
// way1
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathp = new ArrayList(10);
        List<TreeNode> pathq = new ArrayList(10);
        dfs(root, p, pathp);
        dfs(root, q, pathq);
        TreeNode cur = null;
        for (int i = pathp.size()-1,j=pathq.size()-1; i >=0&&j>=0; i--,j--) {
            if(pathp.get(i)!=pathq.get(j)) break;
            else cur=pathp.get(i);
        }
        return cur;

    }
    public boolean dfs(TreeNode root,TreeNode p,List<TreeNode> path){
        if(root==null)return false;
        if(root==p){path.add(root);return true;}
        //注意看这里记录路径的方法
        if(dfs(root.left,p,path)||dfs(root.right,p,path)) {
            path.add(root);
            return true;
        }
        return false;
    }
}



//way2  巧妙
// root 的值等于 p 的值或者 q 的值
// 这种时候直接返回 root 这个 node 就好了。
// root 的左边、右边都返回了一个node
// 这种时候也是直接返回 root 就好了。
// root 的右边或者左边返回了一个node， 另一边的返回值是空的。
// 这种时候返回右边或者左边那个不是空的的node。
// 如果左边、右边的返回值都是空的
// 这就只好返回空的值了。
// （这个感觉应该放在最前面）如果连 root 都是空的话
// 也要返回空指针，这个应该是这一条路走到底的情况了
// class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root,p,q);

    }
    public TreeNode dfs(TreeNode root, TreeNode p,TreeNode q) {
        if (root == null)
            return null;
        if (root == p||root == q) {
            
            return root;
        }
        TreeNode left =  dfs(root.left, p, q) ;
        TreeNode right =dfs(root.right, p, q);
        if(left!=null&&right!=null) return root;
        if(left!=null)return left;
        if(right!=null)return right;
        return null;
        

       
    }
}

