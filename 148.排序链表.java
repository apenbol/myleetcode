/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    public ListNode sortList(ListNode head) {
        if (head==null) {
            return null;
        }
        ListNode slow=head,fast=head;
        while (slow!=null&&fast.next!=null&&fast.next.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=slow.next;
        slow.next=null;
        if (slow!=head) {
            return merge(sortList(head), sortList(temp));
        }else{
            if (temp!=null&&temp.next!=null) {
                return merge(slow, sortList(temp));
            }
            return merge(slow, temp);
        }
        
        
    }
    public ListNode merge(ListNode list1,ListNode list2){
        ListNode dummy=new ListNode(0);
        if (list1!=null&&list2!=null) {
            if (list1.val<=list2.val) {
                dummy.next=merge(list1.next,list2);
            }else dummy.next=merge(list1,list2.next);
            
        }else{
            if (list1==null) {
                dummy.next=list2;
            }else dummy.next=list1;
        }
        return dummy.next;

    }
}

