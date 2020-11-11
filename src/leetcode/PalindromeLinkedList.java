package leetcode;

import java.util.ArrayList;
import java.util.List;
/*
234. 回文链表
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
 */
public class PalindromeLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    //方法一，使用数组列表，时间复杂度为O(N),空间复杂度为O(N)
    public boolean isPalindrome1(ListNode head) {
        List<Integer> arr = new ArrayList<Integer>();
        while(head != null){
            arr.add(head.val);
            head = head.next;
        }
        int first = 0,last = arr.size() - 1;
        while(first < last){
            if(!arr.get(first).equals(arr.get(last))) return false;
            first++;
            last--;
        }
        return true;
    }

    //方法二，将链表分为两段，逆转后半段再进行比较,时间复杂度为O(N),空间复杂度为O(1)
    public boolean isPalindrome(ListNode head) {
        if(head ==null || head.next == null) return true;

        ListNode first = findHeadLastNode(head);
        ListNode second = reverse(first.next);

        ListNode t1 = head,t2 = second;
        boolean flag = true;
        while(flag && t2 != null){
            if(t1.val != t2.val) flag = false;
            t1 = t1.next;
            t2 = t2.next;
        }

        return flag;
    }

    private ListNode reverse(ListNode head){
        ListNode old = head,pre = head;
        ListNode n = null;
        while(pre != null){
            pre = pre.next;
            old.next = n;
            n = old;
            old = pre;
        }
        return n;
    }

    private ListNode findHeadLastNode(ListNode head){
        ListNode fast = head;
        ListNode low = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            low = low.next;
        }
        return low;
    }
}
