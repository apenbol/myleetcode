/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         if (head==null) {
//             return null;
            
//         }
//         if(head.next==null)return head;
//         ListNode temp=reverseList(head.next);
//         head.next.next=head;
//         head.next=null;
//         return temp;
//     }
// }
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode cur=head;
        while (cur!=null) {
            ListNode after=cur.next;
            cur.next=prev;
            prev=cur;
            cur=after;
        }
        return prev;
}
}

