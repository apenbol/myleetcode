/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<right)
        {
            int mid=(left+right)/2;
            if(nums[mid]<nums[mid+1]){//此情况下 右边绝对有峰值
                left=mid+1;
            }else right=mid;
        }
        return left;
        
    }
}

