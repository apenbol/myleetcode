/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */
class Solution {
    public int mySqrt(int x) {
        long left=0,right=x;
        while (left<right) {
            long mid=(left+right)/2;
            System.out.println(mid);

            if (mid*mid==x||mid*mid<x&&(mid+1)*(mid+1)>x) {
                    return (int)mid;
            }else{
                if(mid*mid<x)left=mid+1;
                else right=mid;
            }
        }
        return (int)left;
}}

