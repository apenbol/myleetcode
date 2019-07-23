import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */
class Solution {
    public int[] sortedSquares(int[] A) {
        int pos=0;
        boolean flag=false;
        for (int i = 0; i < A.length; i++) {
            if(A[i]>=0&&!flag){
                pos=i;
                flag=true;
            }
            A[i]=A[i]*A[i];
            
        }
        int [] res=new int[A.length];
        int i=pos-1;int j=pos;
        int temp=0;
        while(i>=0&&j<A.length){
            if(A[i]<A[j]) res[temp++]=A[i--];
            else 
                res[temp++] = A[j++];
        }
        while(i>=0) {
            res[temp++] = A[i--];}
         while (j < A.length) {
            res[temp++] = A[j++];
        }
        return res;

    }
}

