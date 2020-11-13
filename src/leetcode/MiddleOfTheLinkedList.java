package leetcode;

/**
 * 876. 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *
 *
 * 提示：
 *
 * 给定链表的结点数介于 1 和 100 之间。
 */
public class MiddleOfTheLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    /**
     * 我的解法：快慢指针，快指针一次走两个，慢指针一次走一个。
     *          当快指针到达末尾时，慢指针所指向的节点即是中间节点
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    class Solution {
        public ListNode middleNode(ListNode head) {
            if(head.next == null) return head;
            ListNode slow,fast;
            slow = head;
            fast = head;

            while((fast.next != null) && (fast.next.next != null)){
                slow = slow.next;
                fast = fast.next.next;
            }

            if(fast.next == null) return slow;
            else return slow.next;
        }
    }
}
