/*
 * @lc app=leetcode.cn id=978 lang=java
 *
 * [978] 最长湍流子数组
 */
class Solution {
//注意写贪心的时候一定先想好在写 不然缝缝补补很难受
    public int maxTurbulenceSize(int[] A) {
        if (A.length < 2) {
            return A.length;
        }
        int sign = 0;
        int ans = 0;
        int begin = 0;
        for (int i = 1; i < A.length; i++) {
            if(sign!=0){
            if(A[i]==A[i-1]){ans=Math.max(ans,i-begin);sign=0;
                System.out.println(ans);
                continue;}
            if(A[i]-A[i-1]>0&&sign==-1||(A[i]-A[i-1]<0&&sign==1) ) {sign=-sign;continue;}
            else {
                ans=Math.max(ans,i-begin);
                System.out.println(A[i]+" "+i+" "+begin);
                System.out.println(sign);
                sign=0;
                i--;
                continue;
                }
            }
            else{
                sign = A[i] > A[i-1]? 1:-1;
                if(A[i] == A[i - 1]){sign=0;
                    ans = Math.max(ans, 1); // 处理只有两个且相同；
                    begin=i;
                }
                else begin=i-1;
            }
        }
        return Math.max(ans,A.length-begin);//处理数组后部分全符合的情况
    }
}

