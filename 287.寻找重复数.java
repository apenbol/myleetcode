/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */
class Solution {
    //因为不能更改原数组 所以下面不行
    // public int findDuplicate(int[] nums) {
    //     int n=nums.length-1;
    //     for (int i = 0; i < nums.length; i++) {
    //         if(nums[nums[i]-1]>n)return nums[i];
    //         else nums[nums[i]%n-1]=nums[i]+n;
    //     }
    //     return 0;
    // }
    public int findDuplicate(int[] nums) {
        int n=nums.lenth-1;
        int left=1,right=n;//注意着left right 是数值不是坐标
      while(left<right)
      {
          int mid=(left+right)/2;
          int cnt=0;
          for(int num:nums){
              if(num<=mid)cnt++;
          }
          if(cnt<=mid)left=mid+1;
          else right=mid;
        }
        return left;
    }
    
}

