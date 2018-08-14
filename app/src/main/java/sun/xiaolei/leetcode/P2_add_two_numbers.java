package sun.xiaolei.leetcode;

import sun.xiaolei.leetcode.t.ListNode;
import sun.xiaolei.leetcode.t.Util;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:两数之和
 * <p>
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class P2_add_two_numbers {

    public static void main(String[] args) {

//        int[] arr1 = {2,4,3};
//        int[] arr2 = {5,6,4};

//        int[] arr1 = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
//        int[] arr2 = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9};

//        int[] arr1 = {1, 8};
//        int[] arr2 = {0};

        int[] arr1 = {5};
        int[] arr2 = {5};


        ListNode ln3 = addTwoNumbers(Util.arr2ListNode(arr1), Util.arr2ListNode(arr2));
        System.out.println(ln3.toString());


    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = null;
        boolean isAdd1 = false;//需要进位的情况
        while (l1 != null || l2 != null || isAdd1) {
            int a1 = l1 == null ? 0 : l1.val;
            int a2 = l2 == null ? 0 : l2.val;
            int t = isAdd1 ? 1 : 0;
            int nodeVal = a1 + a2 + t >= 10 ? a1 + a2 + t - 10 : a1 + a2 + t;
            isAdd1 = a1 + a2 + t >= 10;
            System.out.println(nodeVal);

            if (node == null) {
                node = new ListNode(nodeVal);
            } else {
                setValue(node, nodeVal);
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return node;
    }

    public static void setValue(ListNode node, int value) {
        if (node.next == null) {
            node.next = new ListNode(value);
        } else {
            setValue(node.next, value);
        }
    }

    /**
     * 时间复杂度：O(max(m,n))，假设 m 和 n 分别表示 l1 和 l2 的长度，上面的算法最多重复 max(m,n) 次。
     * 空间复杂度：O(max(m,n))， 新列表的长度最多为 max(m,n)+1。
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbersO(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


}
