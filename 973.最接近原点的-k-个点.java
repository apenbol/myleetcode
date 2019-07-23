/*
 * @lc app=leetcode.cn id=973 lang=java
 *
 * [973] 最接近原点的 K 个点
 */

import java.util.*;
class Solution {
    public int[][] kClosest(int[][] points, int K) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(K,new Comparator<int []>(){ //大顶堆，容量11
            @Override
            public int compare(int [] i1,int [] i2){
                return (sqrts(i2)-sqrts(i1));
            }
        });

        for (int i = 0; i < points.length; i++) {
            
            if (maxHeap.size()<K){
                maxHeap.offer(points[i]);
            }
            else {
                if (sqrts(points[i])<sqrts(maxHeap.peek())) {
                    maxHeap.poll();

                    maxHeap.offer(points[i]);

                }else continue;
            }} 
            int [][] res=new int[K][2];
                for (int i = 0; i < K; i++) {
                    res[i]=maxHeap.poll();
                }
            return res;
        }
    

    public int sqrts(int[]point){
        return (point[0]*point[0]+point[1]*point[1]);
    }
}

