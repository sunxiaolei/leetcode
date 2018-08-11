package sun.xiaolei.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

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


        ListNode ln3 = addTwoNumbers(arr2Node(arr1), arr2Node(arr2));
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

    public static ListNode arr2Node(int[] arr) {
        ListNode node = null;
        for (int i = 0; i < arr.length; i++) {
            if (node == null) {
                node = new ListNode(arr[i]);
            } else {
                setValue(node, arr[i]);
            }
        }
        return node;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            String str = "[";
            ListNode node = this;
            while (node != null) {
                str = str + node.val + ",";
                node = node.next;
            }
            str = str + "]";
            return str;
        }
    }
}
