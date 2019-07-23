/*
 * @lc app=leetcode.cn id=969 lang=java
 *
 * [969] 煎饼排序
 */
class Solution {
    public void reverse(int[]a,int length){
        int []b=Arrays.copyOfRange(a,0,length);
        for (int i = 0; i < length; i++) {
            a[i]=b[length-1-i];
        }
       

    }
    public List<Integer> pancakeSort(int[] A) {
        List<Integer>list=new ArrayList();
        int n=A.length;
        for (int i = n; i >0; i--) {
            
            if(A[i-1]!=i)
                {
                    for (int j = i-2; j >=0; j--) {
                        if(A[j]==i&&j==0){reverse(A,i);
                            list.add(i);
                            break;
                        }
                        if(A[j]==i&&j!=0){reverse(A,j+1);
                            list.add(j+1);
                        }
                }
        }
        // Collections.reverse(list);
        return list;
    }
}

