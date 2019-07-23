/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int n=1;
        ListNode cur=head;
        if(head==null)return head;
        while(cur.next!=null){
            n++;
            cur=cur.next;
        }
        k%=n;
        if(k==0)return head;
        cur.next=head;


        cur=head;
        for (int i = 0; i < n-k-1; i++) {
            cur=cur.next;
            
        }

        head=cur.next;
        cur.next=null;
        return head;
    }
}

