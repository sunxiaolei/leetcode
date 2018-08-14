package sun.xiaolei.leetcode.t;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
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
        str = str.substring(0, str.length() - 1) + "]";
        return str;
    }
}
