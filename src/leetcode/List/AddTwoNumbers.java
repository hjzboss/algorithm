package leetcode.List;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    /*
    我的解法：遍历两个链表，每个节点相加，如果大于10则产生一个进位。
    执行用时：2 ms，在所有 Java 提交中击败了99.92%的用户
    内存消耗：38.9 MB,在所有 Java 提交中击败了52.08%的用户
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = new ListNode(0);
        ListNode t = head;
        int remainder, quotient = 0;

        //同时遍历两个链表，值相加并产生进位加到下一个新节点上
        while (l1 != null && l2 != null) {
            remainder = (l1.val + l2.val + quotient) % 10;
            t.next = new ListNode(remainder);
            quotient = (l1.val + l2.val + quotient) / 10;
            t = t.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        //如果两个两个链表都遍历完，就检查最后一位是否有进位，有就创建一个新节点
        if (l1 == null && l2 == null && quotient == 1) {
            t.next = new ListNode(1);
        }

        //如果有一个链表不为空，则链表的值与进位相加，继续运算
        ListNode t1 = l1, t2 = l2;
        while (t1 != null) {
            t1.val += quotient;
            //如果小于10，则停止进位
            if (t1.val < 10) {
                t.next = l1;
                break;
            }
            //大于10，向下一个进位
            else {
                t1.val -= 10;
                quotient = 1;
                //如果到达链表末尾，则创立一个新节点
                if (t1.next == null) {
                    t1.next = new ListNode(quotient);
                    t.next = l1;
                    break;
                }
                t1 = t1.next;
            }
        }

        while (t2 != null) {
            t2.val += quotient;
            if (t2.val < 10) {
                t.next = l2;
                break;
            } else {
                t2.val -= 10;
                quotient = 1;
                if (t2.next == null) {
                    t2.next = new ListNode(quotient);
                    t.next = l2;
                    break;
                }
                t2 = t2.next;
            }
        }

        return head.next;
    }

    /**
     * 改良版解法：将后面判断l1与l2是否为空的循环都合并到前面相加的循环中
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
