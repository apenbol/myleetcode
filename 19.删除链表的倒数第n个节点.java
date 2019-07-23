/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first=head,second=head;
        for (int i = 0; i < n; i++) {
            first=first.next;

        }
        while(first!=null&&first.next!=null){
            first=first.next;
            second=second.next;            
        }
        if (second.next == null && n == 1)
            return null;
        if (first==null) {
            return head.next;
            
        }
        if(second.next!=null)
        second.next=second.next.next;
        return head;
    }
}

