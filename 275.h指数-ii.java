/*
 * @lc app=leetcode.cn id=275 lang=java
 *
 * [275] H指数 II
 */
class Solution {
    public int hIndex(int[] citations) {
        int length=citations.length;
        int left=0, right=length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if((length-mid)<=citations[mid]){//这里注意 往左逼近 往右合规
                right=mid;
            }else left=mid+1;
        }
        if(length==0||(length-left)>citations[left]) return 0;
        return Math.min(length-left,citations[left]);
    }
}

