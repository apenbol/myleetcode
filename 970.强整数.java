import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=970 lang=java
 *
 * [970] 强整数
 */
class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> list=new ArrayList<>();
        Set<Integer> hashSet=new HashSet<>();
        for (int sum1=1; sum1 <= bound; sum1*=x) {
            for (int sum2=1;sum1+sum2<=bound;sum2*=y) {
                hashSet.add(sum1+sum2);
                if(y==1)break;
            }
            if(x==1)break;
        }
        return new ArrayList<Integer>(hashSet);

    }
}

