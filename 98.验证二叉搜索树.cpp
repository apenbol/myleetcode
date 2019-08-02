/*
 * @lc app=leetcode.cn id=98 lang=cpp
 *
 * [98] 验证二叉搜索树
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        if (!root)
        {
            return true;
        }
        int childmax, childmin;
        return dfs(root, childmin, childmax);
    }
    bool dfs(struct TreeNode *root, int &pmin, int &pmax)
    {
        pmin = pmax = root->val;

        if (root->left)
        {
            int childmin, childmax;
            if (!dfs(root->left, childmin, childmax))
            {
                return false;
            }
            if (childmax >= root->val)
                return false;
            pmin = min(childmin, pmin);
        }
        if (root->right)
        {
            int childmin, childmax;

            if (!dfs(root->right, childmin, childmax))
            {
                return false;
            }
                        
            if (childmin <= root->val)
                return false;
            pmax = max(childmax, pmax);
        }
        return true;
    }
};
