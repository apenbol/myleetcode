/*
 * @lc app=leetcode.cn id=98 lang=c
 *
 * [98] 验证二叉搜索树
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

#include <stdio.h>
bool dfs(struct TreeNode *,int,int);
bool isValidBST(struct TreeNode* root){
    if (!root )
    {
        return true;
    }
    int childmax,childmin;
   return dfs(root,childmin,childmax);
}
bool dfs(struct TreeNode *root, int &min, int &max){
    min = max = root.val;

    if(root->left){
        int childmin,childmax;
        dfs(root->left,childmin,childmax );
        if(childmax >= root.val)return false;
        min=min(childmin,min);

    }
    if (root->right)
    {
        int childmin, childmax;
        dfs(root->right, childmin, childmax);
        if (childmin <= root.val)
            return false;
        max = max(childmax, min);
    }
    return true;
    
}
