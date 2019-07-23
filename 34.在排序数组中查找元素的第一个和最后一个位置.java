/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int left=0,right=nums.length-1;
        
        int[]temp=new int[2];
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]<target)left=mid+1;
            else right=mid;
        }
        if(nums.length==0||nums[left]!=target)return new int[]{-1,-1};
        temp[0]=left;
        
         left=0;right=nums.length-1;
        while(left<right){
            int mid=(left+right+1)/2;
          
            if(nums[mid]>target)right=mid-1;
            else left=mid;
        }
        temp[1]=left;
        return temp;
    
    }
}

