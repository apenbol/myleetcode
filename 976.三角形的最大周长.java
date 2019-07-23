import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=976 lang=java
 *
 * [976] 三角形的最大周长
 */
class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A); //注意这里需要证明下 可以用反正法证明排序后一定是相邻的三个数周长最大
        int max=0;
        for (int i = 2; i < A.length; i++) {
            boolean flag=A[i-2]+A[i-1]>A[i]&&Math.abs(A[i-2]-A[i-1])<A[i]
                            ||A[i-2]+A[i]>A[i-1]&&Math.abs(A[i]-A[i-2])<A[i-1]
                            ||A[i]+A[i-1]>A[i-2]&&Math.abs(A[i]-A[i-1])<A[i-2];
            if(flag){
                max=Math.max(max, A[i-2]+A[i-1]+A[i]);
            }
        }
        return max;

    }
}

