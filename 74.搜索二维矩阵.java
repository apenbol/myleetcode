/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)return false;
        int left=0,right=matrix.length*matrix[0].length-1;
        if(right==-1)return false;

        while(left<right)
        {int mid=(left+right)/2;
            if(matrix[mid/matrix[0].length][mid%matrix[0].length]<target)left=mid+1;
            else right=mid;
        }
        if(matrix[left/matrix[0].length][left%matrix[0].length]!=target)return false;
        else return true;
    }
}

