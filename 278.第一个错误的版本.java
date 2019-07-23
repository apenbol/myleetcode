/*
 * @lc app=leetcode.cn id=278 lang=java
 *
 * [278] 第一个错误的版本
 */
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long left=1,right=n;
        while(left<right)
        {
            long mid=(left+right)/2;  //一般是这里会溢出
            if(isBadVersion((int)mid)){ //注意这里的类型转换
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return (int)left;
    }
}

