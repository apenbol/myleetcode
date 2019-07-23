/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        if (head == null || m == n)
            return head;

        int i=0;
        ListNode cur=dummy;
        while (i<m-1) {
            cur=cur.next;
            i++;

        }


        ListNode bak=cur;//第m-1个
        ListNode prev=cur.next;//第m个

        cur=cur.next.next; //第m+1个
        i+=2;//m+1
        while(i<=n){
            ListNode after=cur.next;
            cur.next=prev;
            prev=cur;
            cur=after;
            i++;
        }
        
        bak.next.next=cur;
        bak.next=prev;
        return dummy.next;

    }
}

