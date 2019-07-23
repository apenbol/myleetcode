/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */
class Solution {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        if(right==-1)return -1;
        int mid=(left+right)/2;//还可以是int mid=(left+right+1)/2; 不重要
        while(left<right){
            
            if(nums[mid]>nums[right]){
                if(nums[left]<=target&&nums[mid]>=target)right=mid;
                else left=mid+1;
                 mid=(left+right)/2; //根据区间划分不同更新mid值 才不会陷入死循环
            }
            else {
                if(nums[mid]<=target&&nums[right]>=target)left=mid;
                else right=mid-1;
                 mid=(left+right+1)/2;//根据区间划分不同更新mid值 才不会陷入死循环
            }
        }
        if(nums[left]!=target)return -1;
        return left;
    }
}

