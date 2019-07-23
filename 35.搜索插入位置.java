/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while (left<right) {
            int mid=(left+right)/2;
            if (nums[mid]<target) {left=mid+1;
            }
            else right=mid;
        }
        if(nums[left]<target) return left+1;
        return left;
    }
}

