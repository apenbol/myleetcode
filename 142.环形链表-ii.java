/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode a=head,b=head;
        if (head==null) {
            return null;
        }
        boolean flag=false;
        //注意下面判断条件
        while (a.next!=null&&b.next!=null&&b.next.next!=null) {
            a=a.next;
            b=b.next.next;
            if (a==b) {
                a=head;
                flag=true; //用来判断结束循环条件
                break;
            }
            
        }
        if (!flag) {
            return null;
        }else{
            a=head;
            while (a!=b) {
                a=a.next;
                b=b.next;
            }
            return a;
        }
        
        
    }
}

