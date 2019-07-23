/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        if (head==null) {return null;
            
        }
       if(head.next!=null){
        ListNode temp= head.next.next;
        head.next.next = head;
        head = head.next;

        head.next.next=swapPairs(temp);
       }
       return head;
    }
}

